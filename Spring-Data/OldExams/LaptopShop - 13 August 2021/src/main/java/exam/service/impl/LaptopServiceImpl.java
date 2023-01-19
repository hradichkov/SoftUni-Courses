package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.ImportLaptopsDTO;
import exam.model.entity.Customer;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.util.PathFiles;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LaptopServiceImpl implements LaptopService {

    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;

    private final ModelMapper modelMapper;
    private final Validator validator;
    private final Gson gson;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository, ModelMapper modelMapper, Validator validator, Gson gson) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;

        this.modelMapper = modelMapper;
        this.validator = validator;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(PathFiles.LAPTOPS_PATH);
    }

    @Override
    public String importLaptops() throws IOException {
        String json = this.readLaptopsFileContent();

        ImportLaptopsDTO[] importLaptopsDTOS =
                this.gson.fromJson(json, ImportLaptopsDTO[].class);

        return Arrays.stream(importLaptopsDTOS)
                .map(this::importLaptop)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String exportBestLaptops() {
//        •	Order Them by the cpu speed in descending order,
//                Then by the ram in descending order,
//        then by the storage in descending order
//    and finally by the MAC Address

        return this.laptopRepository
                .findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc()
                .stream()
                .map(Laptop::toString)
                .collect(Collectors.joining("\n"));
    }

    private String importLaptop(ImportLaptopsDTO dto) {
        Set<ConstraintViolation<ImportLaptopsDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid laptop";
        }

        Optional<Laptop> optCustomer =
                this.laptopRepository.findByMacAddress(dto.getMacAddress());

        if (optCustomer.isPresent()) {
            return "Invalid laptop";
        }

        Optional<Shop> shop = this.shopRepository.findByName(dto.getShop().getName());
        Laptop laptop = this.modelMapper.map(dto, Laptop.class);
        laptop.setShop(shop.get());

        this.laptopRepository.save(laptop);

        return "Successfully imported Laptop " +
                laptop.getMacAddress() + " " +
                laptop.getCpuSpeed() + " - " +
                laptop.getRam() + " - " +
                laptop.getStorage();
    }
}
