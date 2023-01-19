package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.ImportCustomersDTO;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;

    private final ModelMapper modelMapper;
    private final Validator validator;
    private final Gson gson;

    public CustomerServiceImpl(CustomerRepository customerRepository, TownRepository townRepository, ModelMapper modelMapper, Validator validator, Gson gson) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;

        this.modelMapper = modelMapper;
        this.validator = validator;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(PathFiles.CUSTOMERS_PATH);
    }

    @Override
    public String importCustomers() throws IOException {
        String json = this.readCustomersFileContent();

        ImportCustomersDTO[] importCustomersDTOs =
                this.gson.fromJson(json, ImportCustomersDTO[].class);

        return Arrays.stream(importCustomersDTOs)
                .map(this::importCustomer)
                .collect(Collectors.joining("\n"));
    }

    private String importCustomer(ImportCustomersDTO dto) {
        Set<ConstraintViolation<ImportCustomersDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid customer";
        }

        Optional<Customer> optCustomer =
                this.customerRepository.findByEmail(dto.getEmail());

        if (optCustomer.isPresent()) {
            return "Invalid customer";
        }

        Optional<Town> town = this.townRepository.findByName(dto.getTown().getName());
        Customer customer = this.modelMapper.map(dto, Customer.class);
        customer.setTown(town.get());

        this.customerRepository.save(customer);

        return "Successfully imported Customer " +
                customer.getFirstName() + " " +
                customer.getLastName() + " - " +
                customer.getEmail();
    }
}
