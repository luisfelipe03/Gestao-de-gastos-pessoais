package br.com.gestorfinanceiro.services.impl;

import br.com.gestorfinanceiro.models.UserEntity;
import br.com.gestorfinanceiro.repositories.UserRepository;
import br.com.gestorfinanceiro.services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) { // Injeção via construtor
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity register(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity login(String email, String password) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}