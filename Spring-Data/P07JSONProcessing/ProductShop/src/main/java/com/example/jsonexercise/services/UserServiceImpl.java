package com.example.jsonexercise.services;

import com.example.jsonexercise.domain.dtos.users.UserDto;
import com.example.jsonexercise.domain.dtos.users.UsersWithProductsDto;
import com.example.jsonexercise.domain.dtos.users.UsersWithProductsWrapperDto;
import com.example.jsonexercise.domain.dtos.users.UsersWithSoldProductsDto;
import com.example.jsonexercise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.jsonexercise.constants.Paths.USERS_AND_PRODUCTS_JSON_PATH;
import static com.example.jsonexercise.constants.Paths.USERS_WITH_SOLD_PRODUCTS_JSON_PATH;
import static com.example.jsonexercise.constants.Utils.MODEL_MAPPER;
import static com.example.jsonexercise.constants.Utils.writeJsonIntoFile;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UsersWithSoldProductsDto> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName() throws IOException {
        List<UsersWithSoldProductsDto> users = this.userRepository.findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName()
                .orElseThrow(NoSuchElementException::new)
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UsersWithSoldProductsDto.class))
                .collect(Collectors.toList());

        writeJsonIntoFile(users, USERS_WITH_SOLD_PRODUCTS_JSON_PATH);
        return users;
    }

    @Override
    public UsersWithProductsWrapperDto usersAndProducts() throws IOException {
        List<UsersWithProductsDto> usersAndProducts = this.userRepository.findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName()
                .orElseThrow(NoSuchElementException::new)
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UserDto.class))
                .map(UserDto::toUsersWithProductsDto)
                .collect(Collectors.toList());

        UsersWithProductsWrapperDto usersWithProductsWrapperDto = new UsersWithProductsWrapperDto(usersAndProducts);

        writeJsonIntoFile(usersWithProductsWrapperDto, USERS_AND_PRODUCTS_JSON_PATH);
        return usersWithProductsWrapperDto;
    }
}
