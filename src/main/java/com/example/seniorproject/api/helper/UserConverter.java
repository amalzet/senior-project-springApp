package com.example.seniorproject.api.helper;

import com.example.seniorproject.api.model.User;
import com.example.seniorproject.service.model.UserEntity;

public class UserConverter {

    public static User toDTO(UserEntity from) {
        return User.builder()
                .id(from.getId())
                .userName(from.getUserName())
                .password(from.getPassword())
                .build();
    }

    public static UserEntity fromDTO(User from) {
        return UserEntity.builder()
                .id(from.getId())
                .userName(from.getUserName())
                .password(from.getPassword())
                .build();
    }
}
