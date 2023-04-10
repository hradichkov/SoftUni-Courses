package com.example.mobitech.service;

import com.example.mobitech.model.dtos.OrderInfoDTO;
import com.example.mobitech.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    public List<OrderInfoDTO> getAllOrders() {
        return this.orderRepository.findAll()
                .stream()
                .map(o -> modelMapper.map(o, OrderInfoDTO.class)).toList();
    }
}
