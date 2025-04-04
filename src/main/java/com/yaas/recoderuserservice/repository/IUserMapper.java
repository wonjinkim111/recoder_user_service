package com.yaas.recoderuserservice.repository;

import com.yaas.recoderuserservice.entity.Users;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IUserMapper {
    int signUpUser(Users paramUsers);

    Users findByEmail(String paramString);

    Users confirmUser(String paramString1, String paramString2);

    Users getUserById(long paramLong);

    int deleteUser(long paramLong);

    int updateUser(Users paramUsers);

    int updateUserType(Map<String, Object> paramMap);
}
