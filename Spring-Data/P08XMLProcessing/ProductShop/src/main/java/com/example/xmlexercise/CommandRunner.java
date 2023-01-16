package com.example.xmlexercise;

import com.example.xmlexercise.domain.dtos.products.ExportProductsInRangeDTO;
import com.example.xmlexercise.domain.dtos.users.ExportSellersDTO;
import com.example.xmlexercise.services.ProductService;
import com.example.xmlexercise.services.SeedService;
import com.example.xmlexercise.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Component
public class CommandRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;

    public CommandRunner(SeedService seedService, ProductService productService, UserService userService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
//    this.seedService.seedAll();

//        this.productsInRange();

        this.findUsersWithSoldProducts();
    }

    private void findUsersWithSoldProducts() throws JAXBException {
        ExportSellersDTO result = this.userService.findAllWithSoldProducts();

        JAXBContext context = JAXBContext.newInstance(ExportSellersDTO.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(result, System.out);
    }

    private void productsInRange() throws JAXBException {
        ExportProductsInRangeDTO inRange = this.productService.getInRange(500, 1000);

        JAXBContext context = JAXBContext.newInstance(ExportProductsInRangeDTO.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(inRange, System.out);
    }
}
