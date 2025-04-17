package com.yaas.recoderuserservice.controller;

import com.yaas.recoderuserservice.dto.UsersDto;
import com.yaas.recoderuserservice.entity.Users;
import com.yaas.recoderuserservice.model.CreateUserResponseModel;
import com.yaas.recoderuserservice.model.LoginRequestModel;
import com.yaas.recoderuserservice.model.ResultResponseModel;
import com.yaas.recoderuserservice.service.IUsersService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(
	    origins = "http://192.168.1.10:30080", 
	    allowedHeaders = "*", 
	    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE}
	)
@RestController
@RequestMapping({"/users"})
public class UsersController {
    IUsersService service;

    @Autowired
    Environment env;
 
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UsersController(IUsersService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody Users user) {
    	System.out.println(">>> 사용자 요청: " + user.toString());
    	System.out.println(">>> 입력 비밀번호: " + user.getEncryptedPassword());
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UsersDto usersDto = (UsersDto)this.modelMapper.map(user, UsersDto.class);
        UsersDto createDto = this.service.signUpUser(usersDto);
        CreateUserResponseModel returnValue = (CreateUserResponseModel)this.modelMapper.map(createDto, CreateUserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

    @PostMapping({"/login"})
    public ResponseEntity loginUser(@RequestBody LoginRequestModel loginRequestModel, HttpServletResponse response) {
        UsersDto userDto = this.service.confirmUser(loginRequestModel.getEmail(), loginRequestModel.getEncryptedPassword());
        if (userDto != null) {
            Map<String, Object> map = new HashMap<>();
            String token = Jwts.builder()
            	    .setSubject(String.valueOf(userDto.getUserId()))  // ✅ 여기 수정!
            	    .setHeader(map)
            	    .setExpiration(new Date(System.currentTimeMillis() + 3600000L))
            	    .signWith(SignatureAlgorithm.HS512, this.env.getProperty("token.secret"))
            	    .compact();
            LinkedMultiValueMap linkedMultiValueMap = new LinkedMultiValueMap();
            linkedMultiValueMap.add("userId", userDto.getUserId());
            linkedMultiValueMap.add("token", token);
            linkedMultiValueMap.add("mentorId", userDto.getMentorId());
            linkedMultiValueMap.add("menteeId", userDto.getMenteeId());
            return new ResponseEntity((MultiValueMap)linkedMultiValueMap, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping({"/{userId}"})
    public ResponseEntity<CreateUserResponseModel> getUserById(@PathVariable long userId) {
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UsersDto usersDto = this.service.getUserById(userId);
        CreateUserResponseModel returnValue = (CreateUserResponseModel)this.modelMapper.map(usersDto, CreateUserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

    @DeleteMapping({"/{userId}"})
    @ResponseBody
    public ResponseEntity<ResultResponseModel> deleteUser(@PathVariable long userId) {
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        long deleteResult = this.service.deleteUser(userId);
        ResultResponseModel sReturnValue = (ResultResponseModel)this.modelMapper.map(Long.valueOf(userId), ResultResponseModel.class);
        ResultResponseModel fReturnValue = (ResultResponseModel)this.modelMapper.map(Integer.valueOf(0), ResultResponseModel.class);
        if (deleteResult == 1L)
            return ResponseEntity.status(HttpStatus.CREATED).body(sReturnValue);
        return ResponseEntity.status(HttpStatus.CREATED).body(fReturnValue);
    }
}
