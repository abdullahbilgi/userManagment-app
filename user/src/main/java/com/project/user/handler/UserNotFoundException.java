package com.project.user.handler;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id) {
        super("Could not found the user with id: "+ id);
    }
}
