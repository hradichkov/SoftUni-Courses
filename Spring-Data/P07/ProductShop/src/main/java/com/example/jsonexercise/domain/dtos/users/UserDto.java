package com.example.jsonexercise.domain.dtos.users;

import com.example.jsonexercise.domain.dtos.products.ProductBasicInfoDto;
import com.example.jsonexercise.domain.dtos.products.ProductDto;
import com.example.jsonexercise.domain.dtos.products.ProductsSoldWithCountDto;
import com.example.jsonexercise.domain.entities.Product;
import com.example.jsonexercise.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String firstName;

    private String lastName;

    private Integer age;

    private Set<ProductDto> sellingProducts;

    private Set<ProductDto> boughtProducts;

    private Set<UserDto> friends;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public UsersWithProductsDto toUsersWithProductsDto() {
        return new UsersWithProductsDto(firstName, lastName, age, toProductsSoldWithCountDto());
    }

    public ProductsSoldWithCountDto toProductsSoldWithCountDto() {
        return new ProductsSoldWithCountDto(sellingProducts
                .stream()
                .map(this::toProductBasicInfoDto)
                .collect(Collectors.toList()));
    }

    public ProductBasicInfoDto toProductBasicInfoDto(ProductDto productDto) {
        return new ProductBasicInfoDto(productDto.getName(), productDto.getPrice());
    }
}
