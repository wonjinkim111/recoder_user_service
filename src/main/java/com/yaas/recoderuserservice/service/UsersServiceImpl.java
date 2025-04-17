package com.yaas.recoderuserservice.service;

import com.yaas.recoderuserservice.dto.MenteesDto;
import com.yaas.recoderuserservice.dto.MentorsDto;
import com.yaas.recoderuserservice.dto.UsersDto;
import com.yaas.recoderuserservice.entity.Users;
import com.yaas.recoderuserservice.repository.IMenteeMapper;
import com.yaas.recoderuserservice.repository.IMentorMapper;
import com.yaas.recoderuserservice.repository.IUserMapper;
import com.yaas.recoderuserservice.service.IUsersService;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UsersServiceImpl implements IUsersService {
    private static final Logger log = LoggerFactory.getLogger(com.yaas.recoderuserservice.service.UsersServiceImpl.class);

    IUserMapper mapper;

    IMentorMapper iMentorMapper;

    IMenteeMapper iMenteeMapper;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsersServiceImpl(IUserMapper mapper, IMentorMapper iMentorMapper, IMenteeMapper iMenteeMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.mapper = mapper;
        this.iMentorMapper = iMentorMapper;
        this.iMenteeMapper = iMenteeMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UsersDto signUpUser(UsersDto usersDto) {
        usersDto.setEncryptedPassword(this.bCryptPasswordEncoder.encode(usersDto.getEncryptedPassword()));
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Users userEntity = (Users)modelMapper.map(usersDto, Users.class);
        this.mapper.signUpUser(userEntity);
        UsersDto returnValue = (UsersDto)modelMapper.map(userEntity, UsersDto.class);
        return returnValue;
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users userEntity = this.mapper.findByEmail(email);
        System.out.println("▶▶ DB에서 찾은 사용자: " + userEntity);
        if (userEntity == null)
            throw new UsernameNotFoundException("정보를 찾을 수 없습니다.");
        return (UserDetails)new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true, new ArrayList());
    }

    public UsersDto getUserDetailsByEmail(String email) {
        Users userEntity = this.mapper.findByEmail(email);
        if (userEntity == null)
            throw new UsernameNotFoundException(email);
        return (UsersDto)(new ModelMapper()).map(userEntity, UsersDto.class);
    }

    public UsersDto confirmUser(String email, String encryptedPassword) throws UsernameNotFoundException {
        ModelMapper modelMapper = new ModelMapper();
        Users userEntity = this.mapper.findByEmail(email);
        MentorsDto forMentorId = this.iMentorMapper.findByUserId(userEntity.getUserId());
        MenteesDto forMenteeId = this.iMenteeMapper.findByUserIdMentee(userEntity.getUserId());
        if (forMentorId == null) {
            userEntity.setMentorId(0L);
            System.out.println("멘토 아이디 없어요!!!");
        } else {
            userEntity.setMentorId(forMentorId.getMentorId());
            System.out.println("멘토 아이디 있어요!!!" + forMentorId.getMentorId());
        }
        if (forMenteeId == null) {
            userEntity.setMenteeId(0L);
        } else {
            userEntity.setMenteeId(forMenteeId.getMenteeId());
        }
        if (this.bCryptPasswordEncoder.matches(encryptedPassword, userEntity.getEncryptedPassword()))
            return (UsersDto)modelMapper.map(userEntity, UsersDto.class);
        return null;
    }

    public UsersDto getUserById(@PathVariable long userId) {
        Users userEntity = this.mapper.getUserById(userId);
        MentorsDto mentorsDto = this.iMentorMapper.findByUserId(userId);
        MenteesDto menteesDto = this.iMenteeMapper.findByUserIdMentee(userId);
        if (userEntity == null)
            log.info(String.format("not exists use : %s", new Object[] { Long.valueOf(userId) }));
        if (mentorsDto != null) {
            userEntity.setMentorNickname(mentorsDto.getMentorNickname());
        } else {
            userEntity.setMentorNickname("null");
        }
        if (menteesDto != null) {
            userEntity.setMenteeNickname(menteesDto.getMenteeNickname());
        } else {
            userEntity.setMenteeNickname("null");
        }
        return (UsersDto)(new ModelMapper()).map(userEntity, UsersDto.class);
    }

    public int deleteUser(@PathVariable long userId) {
        int deleteUser = this.mapper.deleteUser(userId);
        return deleteUser;
    }
}
