package com.example.mobitech.service;

import com.example.mobitech.model.dtos.OrderInfoDTO;
import com.example.mobitech.model.entity.Order;
import com.example.mobitech.model.entity.User;
import com.example.mobitech.repository.OrderRepository;
import com.example.mobitech.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<OrderInfoDTO> getAllOrders() {
        return this.orderRepository.findAll()
                .stream()
                .map(o -> modelMapper.map(o, OrderInfoDTO.class)).toList();
    }

    @Transactional
    public void deleteOldOrders() {
        LocalDate currentDate = LocalDate.now();
        LocalDate oldDate = currentDate.minus(1, ChronoUnit.YEARS);
        List<Order> orderToDelete = this.orderRepository.findOrderByDateOfOrderBefore(oldDate);

        orderToDelete.forEach(order -> {
            User user = this.userRepository.findByUsername(order.getClient().getUsername())
                    .orElseThrow(() -> new Error("User not found!"));
            user.getOrders().remove(order);

            this.orderRepository.deleteById(order.getId());
        });
    }
}
