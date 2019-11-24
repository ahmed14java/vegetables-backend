package com.backend.resource;

import com.backend.dto.UserDTO;
import com.backend.dto.signUp.RegisterDTO;
import com.backend.enums.RoleTypes;
import com.backend.model.Role;
import com.backend.repository.RoleRepository;
import com.backend.response.UserResponse;
import com.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign-up")
public class SignupResource {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping
    public ResponseEntity<UserResponse> signUp(@RequestBody RegisterDTO registerDTO) {
        ModelMapper mapper = new ModelMapper();
        UserDTO userDTO = mapper.map(registerDTO, UserDTO.class);
        Role role = roleRepository.findByName(RoleTypes.ROLE_USER);
        if (role != null)
            userDTO.getRoles().add(role);
        userDTO.setEncryptedPassword("test");
        userDTO.setUserId("testUserId");
        UserDTO userCreated = userService.createUser(userDTO);
        UserResponse userResponse = mapper.map(userCreated, UserResponse.class);
        return ResponseEntity.ok().body(userResponse);
    }
}
