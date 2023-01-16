package com.example.xmlexercise.services;

import com.example.xmlexercise.domain.dtos.users.ExportSellersDTO;

public interface UserService {

    ExportSellersDTO findAllWithSoldProducts();
}
