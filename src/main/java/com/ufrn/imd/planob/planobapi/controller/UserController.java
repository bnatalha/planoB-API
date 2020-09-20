package com.ufrn.imd.planob.planobapi.controller;

import com.ufrn.imd.planob.planobapi.exception.ResourceNotFoundException;
import com.ufrn.imd.planob.planobapi.model.User;
import com.ufrn.imd.planob.planobapi.repository.UserRepositoryJPA;
import com.ufrn.imd.planob.planobapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        User userToReturn = service.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        userToReturn.setKeyphrase("HIDDEN");
        return userToReturn;
    }

    @PostMapping("/save")
    public User newUser(@RequestBody User user) {
        if (service.findById(user.getLogin()).isEmpty())
            return service.save(user);
        else throw new ResourceNotFoundException("User with id " + user.getLogin() + " already exists");

    }

    @PutMapping("/save")
    public User updateUser(@RequestBody User requestUser) {
        return service.findById(requestUser.getLogin()).map(foundUser -> {
            foundUser.setLogin(requestUser.getLogin());
            foundUser.setKeyphrase(requestUser.getKeyphrase());
            foundUser.setName(requestUser.getName());
            return service.save(foundUser);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + requestUser.getLogin()));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        return service.findById(userId).map(user -> {
            service.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
    }

}
