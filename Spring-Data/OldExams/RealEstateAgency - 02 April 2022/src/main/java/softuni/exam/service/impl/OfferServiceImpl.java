package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportOfferDTO;
import softuni.exam.models.dto.ImportOfferRootDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static softuni.exam.models.entity.ApartmentType.three_rooms;
import static softuni.exam.util.PathFiles.OFFERS_PATH;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;
    private final ModelMapper modelMapper;
    private final Validator validator;
    private final Unmarshaller unmarshaller;

    public OfferServiceImpl(OfferRepository offerRepository, AgentRepository agentRepository, ApartmentRepository apartmentRepository, ModelMapper modelMapper, Validator validator) throws JAXBException {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;

        this.modelMapper = modelMapper;
        this.validator = validator;

        JAXBContext context = JAXBContext.newInstance(ImportOfferRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(OFFERS_PATH);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        ImportOfferRootDTO importOfferRootDTO = (ImportOfferRootDTO) this.unmarshaller
                .unmarshal(new FileReader(OFFERS_PATH.toAbsolutePath().toString()));

        return importOfferRootDTO.getOffers()
                .stream()
                .map(this::importOffer)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String exportOffers() {
        return this.offerRepository
                .findByApartment_ApartmentTypeOrderByApartment_AreaDescPrice(three_rooms)
                .stream()
                .map(Offer::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importOffer(ImportOfferDTO dto) {
        Set<ConstraintViolation<ImportOfferDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid offer";
        }

        Optional<Agent> agent = this.agentRepository.findByFirstName(dto.getAgent().getName());

        if (agent.isEmpty()) {
            return "Invalid offer";
        }

        Optional<Apartment> apartment = this.apartmentRepository.findById(dto.getApartment().getId());

        Offer offer = this.modelMapper.map(dto, Offer.class);
        offer.setAgent(agent.get());
        offer.setApartment(apartment.get());

        this.offerRepository.save(offer);

        return String.format("Successfully imported offer %.2f", offer.getPrice());
    }
}
