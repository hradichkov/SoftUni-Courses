package com.example.xmlexercise.services;

import com.example.xmlexercise.domain.dtos.users.ExportSellersDTO;
import com.example.xmlexercise.domain.dtos.users.ExportUserWithSoldProductsDTO;
import com.example.xmlexercise.domain.entities.User;
import com.example.xmlexercise.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    @Transactional
    public ExportSellersDTO findAllWithSoldProducts() {
        List<User> users = this.userRepository.findAllWithSoldProducts();

        List<ExportUserWithSoldProductsDTO> dtos = users.stream()
                .map(user -> this.mapper.map(user, ExportUserWithSoldProductsDTO.class))
                .collect(Collectors.toList());

        return new ExportSellersDTO(dtos);
    }
}
