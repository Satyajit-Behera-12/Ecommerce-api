package com.EcommerceApplication.Service;



import com.EcommerceApplication.Entity.User;
import com.EcommerceApplication.Dto.UserDTO;

import java.util.List;

public interface UserService {

    User createUser(UserDTO userDTO);

    List<User> getAllUsers();
}
