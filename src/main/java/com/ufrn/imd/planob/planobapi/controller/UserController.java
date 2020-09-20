package com.ufrn.imd.planob.planobapi.controller;

import com.ufrn.imd.planob.planobapi.exception.ResourceNotFoundException;
import com.ufrn.imd.planob.planobapi.model.User;
import com.ufrn.imd.planob.planobapi.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return repository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
    }

    @PostMapping("/save")
    public User newUser(@RequestBody User user) {
        if (repository.findById(user.getLogin()).isEmpty())
            return repository.save(user);
        else throw new ResourceNotFoundException("User with id " + user.getLogin() + " already exists");

    }

    @PutMapping("/save")
    public User updateUser(@RequestBody User requestUser) {
        return repository.findById(requestUser.getLogin()).map(foundUser -> {
            foundUser.setLogin(requestUser.getLogin());
            foundUser.setKeyphrase(requestUser.getKeyphrase());
            foundUser.setName(requestUser.getName());
            return repository.save(foundUser);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + requestUser.getLogin()));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        return repository.findById(userId).map(user -> {
            repository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
    }

}
