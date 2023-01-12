package com.example.gamestore.constants;

import com.example.gamestore.domain.dtos.GameDTO;

public enum Validations {
    ;

    public static final String EMAIL_PATTERN = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,63})$";
    public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
    public static final String EMAIL_NOT_VALID_MESSAGE = "Incorrect email.";
    public static final String PASSWORD_OR_USERNAME_NOT_VALID_MESSAGE = "Incorrect username / password";
    public static final String PASSWORD_MISS_MATCH_MESSAGE = "Passwords doesnt match";
    public static final String COMMAND_NOT_FOUND_MESSAGE = "Command not found";
}
