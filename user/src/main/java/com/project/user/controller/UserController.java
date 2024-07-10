package com.project.user.controller;

import com.project.user.handler.UserNotFoundException;
import com.project.user.model.User;
import com.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public User saveUser(@RequestBody User user){
        return  userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id,@RequestBody User user){

        User updatedUser = userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));

        updatedUser.setName(user.getName());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setEmail(user.getEmail());

        return userRepository.save(updatedUser);

    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id")Long id){
        if (!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }

        userRepository.deleteById(id);

        return "User with id "+id+" has been deleted success.";
    }



}
