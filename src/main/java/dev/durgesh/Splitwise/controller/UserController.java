package dev.durgesh.Splitwise.controller;

import dev.durgesh.Splitwise.dto.UserRegistrationRequestDTO;
import dev.durgesh.Splitwise.entity.User;
import dev.durgesh.Splitwise.exception.UserRegistrationInvalidDataException;
import dev.durgesh.Splitwise.mapper.EntityDTOMapper;
import dev.durgesh.Splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserRegistrationRequestDTO userRegistrationRequestDTO){
        validateUserRegistrationRequestDTO(userRegistrationRequestDTO);
        User savedUser = userService.signup(
                userRegistrationRequestDTO.getName(),
                userRegistrationRequestDTO.getEmail(),
                userRegistrationRequestDTO.getPassword());
                return ResponseEntity.ok(EntityDTOMapper.toDTO(savedUser)
                );

    }

    private void validateUserRegistrationRequestDTO(UserRegistrationRequestDTO requestDTO){
        if(requestDTO.getEmail() == null ||
        requestDTO.getName() == null ||
        requestDTO.getPassword() == null){
            throw new UserRegistrationInvalidDataException("Invalid sign up data");
        }
    }
}
