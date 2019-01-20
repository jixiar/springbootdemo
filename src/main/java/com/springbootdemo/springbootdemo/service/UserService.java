package com.springbootdemo.springbootdemo.service;

import com.springbootdemo.springbootdemo.domain.User;
import com.springbootdemo.springbootdemo.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

}
