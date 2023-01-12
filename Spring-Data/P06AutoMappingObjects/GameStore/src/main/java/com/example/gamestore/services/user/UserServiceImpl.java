package com.example.gamestore.services.user;

import com.example.gamestore.domain.dtos.UserLoginDTO;
import com.example.gamestore.domain.dtos.UserRegisterDTO;
import com.example.gamestore.domain.entities.User;
import com.example.gamestore.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.gamestore.constants.Validations.PASSWORD_OR_USERNAME_NOT_VALID_MESSAGE;

@Service
public class UserServiceImpl implements UserService {

    private User loggedInUser;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String registerUser(String[] args) {
        String email = args[1];
        String password = args[2];
        String confirmPassword = args[3];
        String fullName = args[4];

        UserRegisterDTO userRegisterDTO;

        try {
            userRegisterDTO = new UserRegisterDTO(email, password, confirmPassword, fullName);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }


        User user = this.modelMapper.map(userRegisterDTO, User.class);

        if (userRepository.count() == 0) {
            user.setAdmin(true);
        }

        boolean doesUserExists = this.userRepository.findByEmail(userRegisterDTO.getEmail()).isPresent();

        if (doesUserExists) {
            // throw new IllegalArgumentException("Email already exists");
            return "Email already exists";
        }

        this.userRepository.save(user);

        return userRegisterDTO.successfulRegisterFormat();
    }

    @Override
    public String loginUser(String[] args) {
        String email = args[1];
        String password = args[2];

        UserLoginDTO userLogin = new UserLoginDTO(email, password);

        Optional<User> user = this.userRepository.findByEmail(userLogin.getEmail());

        if (user.isPresent() &&
                this.loggedInUser == null &&
                user.get().getPassword().equals(userLogin.getPassword())) {
            this.loggedInUser = user.get();
            return "Successfully logged in " + this.loggedInUser.getFullName();
        }

        return PASSWORD_OR_USERNAME_NOT_VALID_MESSAGE;
    }

    @Override
    public String logoutUser() {
        if (this.loggedInUser == null) {
            return "Cannot log out. No user was logged in.";
        }

        String output = "User " + this.loggedInUser.getFullName() + " successfully logged out";

        this.loggedInUser = null;

        return output;
    }

    @Override
    public User getLoggedInUser() {
        return this.loggedInUser;
    }
}
