package com.example.seniorproject.service;

import com.example.seniorproject.service.model.GreenHouseLimitsEntity;
import com.example.seniorproject.service.model.ResponseEntity;
import com.example.seniorproject.service.model.UserEntity;
import com.example.seniorproject.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public ResponseEntity addUser(UserEntity userEntity) {
        ResponseEntity responseEntity = new ResponseEntity();
        UserEntity userExistsByUserName = userRepository.findByUserName(userEntity.getUserName());
        Optional<UserEntity> userExitsById = userRepository.findById(userEntity.getId());
        UserEntity idToCheck = userExitsById.orElse(null);
        if (userExistsByUserName == null && idToCheck == null) {
            userRepository.save(userEntity);
            responseEntity.setUserAdded(true);
            return responseEntity;
        }
        responseEntity.setUserAdded(false);
        return responseEntity;
    }

    @Override
    public UserEntity getUserByUserName(String userName) {
        Optional<UserEntity> greenHouseLimitsEntity = Optional.ofNullable(userRepository.findByUserName(userName));
        return greenHouseLimitsEntity.orElse(null);
    }
}