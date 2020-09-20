package com.ufrn.imd.planob.planobapi.service;

import com.ufrn.imd.planob.planobapi.model.User;
import com.ufrn.imd.planob.planobapi.repository.UserRepositoryJPA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepositoryJPA repository;

    public UserService(UserRepositoryJPA repository) {
        this.repository = repository;
    }

    public Optional<User> findById(String id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = false)
    public User save(User user) {
        return repository.save(user);
    }

    @Transactional(readOnly = false)
    public void delete(User user) {
        repository.delete(user);
    }
}
