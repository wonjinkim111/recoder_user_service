package com.yaas.recoderuserservice.service;

import com.yaas.recoderuserservice.dto.UsersDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUsersService extends UserDetailsService {
    UsersDto signUpUser(UsersDto paramUsersDto);

    UsersDto getUserDetailsByEmail(String paramString);

    UsersDto confirmUser(String paramString1, String paramString2);

    UsersDto getUserById(long paramLong);

    int deleteUser(long paramLong);
}
