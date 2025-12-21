package com.sampurna.UserManagementAPI.service;

import com.sampurna.UserManagementAPI.dto.CreateUserRequest;
import com.sampurna.UserManagementAPI.dto.UserResponse;
import com.sampurna.UserManagementAPI.exception.UserNotFoundException;
import com.sampurna.UserManagementAPI.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    private Long id = 0L;
    final HashMap<Long, User> map = new HashMap<>();
    public UserResponse createUser(CreateUserRequest request){
        id++;
        User user = new User(id, request.getName(), request.getEmail());
        map.put(id, user);
        return new UserResponse(id, request.getName(), request.getEmail());
    }

    public UserResponse getUserById(Long id){
        if (map.containsKey(id)){
            User user = map.get(id);
            return new UserResponse(user.getId(), user.getName(), user.getEmail());
        }
        else {
            throw new UserNotFoundException(id);
        }
    }

    public List<UserResponse> getAllUser(){
        List<UserResponse> users = new ArrayList<>();
        for(User user : map.values()){
            users.add(new UserResponse(user.getId(), user.getName(), user.getEmail()));
        }
        return users;
    }
}
