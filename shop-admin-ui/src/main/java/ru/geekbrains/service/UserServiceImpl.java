package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.controllers.repr.UserRepr;
import ru.geekbrains.persist.model.User;
import ru.geekbrains.persist.repo.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(UserRepr userRepr) {
        User user = new User();
        user.setId(userRepr.getId());
        user.setUsername(userRepr.getUsername());
        if (userRepr.getPassword().equalsIgnoreCase(userRepr.getMatchingPassword())) {
            user.setPassword(passwordEncoder.encode(userRepr.getPassword()));
        } else return;
        user.setEmail(userRepr.getEmail());
        user.setFirstName(userRepr.getFirstName());
        user.setLastName(userRepr.getLastName());
        user.setRoles(userRepr.getRoles());
        userRepository.save(user);
    }

    @Override
    public List<UserRepr> findAll() {
        return userRepository.findAll().stream()
                .map(UserRepr::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserRepr> findById(Long id) {
        return userRepository.findById(id).map(UserRepr::new);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
