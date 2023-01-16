package com.example.xmlexercise.services;

import com.example.xmlexercise.domain.dtos.products.ExportProductsInRangeDTO;
import com.example.xmlexercise.domain.dtos.products.ProductWithAttributesDTO;
import com.example.xmlexercise.domain.entities.Product;
import com.example.xmlexercise.domain.entities.User;
import com.example.xmlexercise.repositories.ProductRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;
    private final TypeMap<Product, ProductWithAttributesDTO> productToDtoMapping;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.mapper = new ModelMapper();

        Converter<User, String> userToFullNameConverter =
                context -> context.getSource() == null ? null : context.getSource().getFullName();

        TypeMap<Product, ProductWithAttributesDTO> typeMap =
                this.mapper.createTypeMap(Product.class, ProductWithAttributesDTO.class);

        this.productToDtoMapping = typeMap.addMappings(map ->
                map.using(userToFullNameConverter)
                        .map(Product::getSeller, ProductWithAttributesDTO::setSeller));

        this.mapper.addConverter(userToFullNameConverter);
    }

    @Override
    public ExportProductsInRangeDTO getInRange(float from, float to) {
        BigDecimal rangeFrom = BigDecimal.valueOf(from);
        BigDecimal rangeTo = BigDecimal.valueOf(to);

        List<Product> products = this.productRepository.
                findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(rangeFrom, rangeTo);

        List<ProductWithAttributesDTO> dtos = products.stream()
                .map(this.productToDtoMapping::map)
                .collect(Collectors.toList());

        return new ExportProductsInRangeDTO(dtos);
    }
}
