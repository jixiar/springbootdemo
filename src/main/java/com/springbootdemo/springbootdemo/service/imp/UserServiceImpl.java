package com.springbootdemo.springbootdemo.service.imp;

import com.springbootdemo.springbootdemo.domain.User;
import com.springbootdemo.springbootdemo.dto.UserDTO;
import com.springbootdemo.springbootdemo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("load service UserServiceImpl");
    }

    @Value("${user.count}")
    private Integer maxNum;

    @Override
    public List<UserDTO> getUsers() {
        return getUserList();
    }

    private List<UserDTO> getUserList() {
        List<UserDTO> list = new ArrayList<>();
        for (int i = 1; i <= maxNum; i++) {
            User user = new User();
            user.setUserId(i);
            user.setUserName("tom"+i);
            user.setAddress("address"+i);
            user.setPhoneNo(1892311312L);

            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user,userDTO);
            list.add(userDTO);
        }
        return list;
    }

}
