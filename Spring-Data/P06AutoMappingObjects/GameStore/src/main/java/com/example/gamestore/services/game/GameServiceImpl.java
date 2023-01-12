package com.example.gamestore.services.game;

import com.example.gamestore.domain.dtos.GameDTO;
import com.example.gamestore.domain.entities.Game;
import com.example.gamestore.repository.GameRepository;
import com.example.gamestore.services.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;
    private UserService userService;
    private final ModelMapper modelMapper = new ModelMapper();

    public GameServiceImpl(GameRepository gameRepository, UserService userService) {
        this.gameRepository = gameRepository;
        this.userService = userService;
    }

    @Override
    public String addGame(String[] args) {
        if (this.userService.getLoggedInUser().getAdmin() != null && this.userService.getLoggedInUser().getAdmin()) {
            String title = args[1];
            BigDecimal price = new BigDecimal(args[2]);
            float size = Float.parseFloat(args[3]);
            String trailer = args[4];
            String imageURL = args[5];
            String description = args[6];
            LocalDate releaseDate = LocalDate.now();

            GameDTO gameDTO = new GameDTO(title, price, size, trailer, imageURL, description, releaseDate);

            Game gameToSave = gameDTO.toGame();

            this.gameRepository.save(gameToSave);

            return "Added " + title;
        }
        return "User must be admin";
    }

    @Override
    public String editGame(String[] args) {
        return null;
    }

    @Override
    public String deleteGame(long id) {
        return null;
    }
}
