package com.example.mobitech.service;

import com.example.mobitech.model.entity.Category;
import com.example.mobitech.model.entity.Role;
import com.example.mobitech.model.entity.User;
import com.example.mobitech.model.enums.CategoryEnum;
import com.example.mobitech.model.enums.UserRoleEnum;
import com.example.mobitech.repository.CategoryRepository;
import com.example.mobitech.repository.RoleRepository;
import com.example.mobitech.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InitService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PasswordEncoder passwordEncoder;
    private final String defaultPassword;

    @Autowired
    public InitService(RoleRepository roleRepository,
                       UserRepository userRepository,
                       CategoryRepository categoryRepository, PasswordEncoder passwordEncoder,
                       @Value("topsecret") String defaultPassword) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.passwordEncoder = passwordEncoder;
        this.defaultPassword = defaultPassword;
    }

    @PostConstruct
    public void init() {
        initRoles();
        initCategories();
        initUsers();
    }

    private void initRoles() {
        if (roleRepository.count() == 0) {
            var clientRole = new Role().setUserRole(UserRoleEnum.ADMIN);
            var adminRole = new Role().setUserRole(UserRoleEnum.USER);

            roleRepository.save(clientRole);
            roleRepository.save(adminRole);
        }
    }

    private void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryEnum.values())
                    .forEach(categoryName -> {
                        Category category = new Category();
                        category.setName(categoryName);
                        categoryRepository.save(category);
                    });
        }
    }

    private void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
            initNormalUser();
        }
    }

    private void initAdmin() {
        var adminUser = new User().
                setUsername("admin").
                setEmail("admin@example.com").
                setFirstName("Hristiqn").
                setLastName("Radichkov").
                setPassword(passwordEncoder.encode(defaultPassword)).
                setRoles(roleRepository.findByUserRole(UserRoleEnum.ADMIN));

        userRepository.save(adminUser);
    }

    private void initNormalUser() {
        var normalUser1 = new User().
                setUsername("ivan123").
                setEmail("ivan@example.com").
                setFirstName("Ivann").
                setLastName("Ivanov").
                setPassword(passwordEncoder.encode("topsecret")).
                setRoles(roleRepository.findByUserRole(UserRoleEnum.USER));

        var normalUser2 = new User().
                setUsername("stoqn").
                setEmail("stoqn@example.com").
                setFirstName("Stoqn").
                setLastName("Stoqnov").
                setPassword(passwordEncoder.encode("topsecret")).
                setRoles(roleRepository.findByUserRole(UserRoleEnum.USER));

        userRepository.save(normalUser1);
        userRepository.save(normalUser2);
    }
}
