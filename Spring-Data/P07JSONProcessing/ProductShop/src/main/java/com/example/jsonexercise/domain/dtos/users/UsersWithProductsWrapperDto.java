package com.example.jsonexercise.domain.dtos.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UsersWithProductsWrapperDto {

    private Integer usersCount;

    private List<UsersWithProductsDto> users;

    public UsersWithProductsWrapperDto(List<UsersWithProductsDto> users) {
        this.users = users;
        this.usersCount = users.size();
    }
}
