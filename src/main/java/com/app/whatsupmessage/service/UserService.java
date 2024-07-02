package com.app.whatsupmessage.service;

import com.app.whatsupmessage.dto.LoginDto;
import com.app.whatsupmessage.dto.UserDto;
import com.app.whatsupmessage.entity.Users;
import com.app.whatsupmessage.response.LoginResponse;

public interface UserService {
     Users saveUser(UserDto dto);

    LoginResponse login(LoginDto dto);


}
