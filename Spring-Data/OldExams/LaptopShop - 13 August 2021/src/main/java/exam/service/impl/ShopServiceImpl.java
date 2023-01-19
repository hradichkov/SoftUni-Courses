package exam.service.impl;

import exam.model.dto.ImportShopDTO;
import exam.model.dto.ImportShopRootDTO;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.PathFiles;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final Validator validator;
    private final Unmarshaller unmarshaller;

    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository, ModelMapper modelMapper, Validator validator) throws JAXBException {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;

        this.modelMapper = modelMapper;
        this.validator = validator;

        JAXBContext context = JAXBContext.newInstance(ImportShopRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(PathFiles.SHOPS_PATH);
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        ImportShopRootDTO importShopRootDTO = (ImportShopRootDTO) this.unmarshaller
                .unmarshal(new FileReader(PathFiles.SHOPS_PATH.toAbsolutePath().toFile()));

        return importShopRootDTO.getShops()
                .stream()
                .map(this::importShop)
                .collect(Collectors.joining("\n"));
    }

    private String importShop(ImportShopDTO dto) {
        Set<ConstraintViolation<ImportShopDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid shop";
        }

        Optional<Shop> optShop = this.shopRepository.findByName(dto.getName());

        if (optShop.isPresent()) {
            return "Invalid shop";
        }

        Shop shop = this.modelMapper.map(dto, Shop.class);

        Optional<Town> town = this.townRepository.findByName(dto.getTown().getName());
        shop.setTown(town.get());
        this.shopRepository.save(shop);

        return "Successfully imported Shop " + shop.getName() + " - " + shop.getIncome();
    }
}
