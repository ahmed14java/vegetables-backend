package com.backend.service.impl;

import com.backend.dto.UserDTO;
import com.backend.model.User;
import com.backend.repository.UserRepository;
import com.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDTO, User.class);
        UserDTO userSaved = mapper.map(userRepository.save(user), UserDTO.class);
        return userSaved;
    }
}
