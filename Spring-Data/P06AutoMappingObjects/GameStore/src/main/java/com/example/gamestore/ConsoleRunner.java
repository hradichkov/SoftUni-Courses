package com.example.gamestore;

import com.example.gamestore.services.game.GameService;
import com.example.gamestore.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.example.gamestore.constants.Commands.*;
import static com.example.gamestore.constants.Validations.COMMAND_NOT_FOUND_MESSAGE;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public ConsoleRunner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] data = input.split("\\|");
            String command = data[0];

            String output = switch (command) {
                case REGISTER_USER -> userService.registerUser(data);
                case LOGIN_USER -> userService.loginUser(data);
                case LOGOUT_USER -> userService.logoutUser();
                case ADD_GAME -> gameService.addGame(data);

                default -> COMMAND_NOT_FOUND_MESSAGE;
            };

            System.out.println(output);
            input = scanner.nextLine();
        }
    }
}
