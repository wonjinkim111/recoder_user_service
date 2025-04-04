package com.yaas.recoderuserservice.service;

import com.yaas.recoderuserservice.client.CodeReviewService;
import com.yaas.recoderuserservice.dto.CrMenteesDto;
import com.yaas.recoderuserservice.dto.MentorNicknameDto;
import com.yaas.recoderuserservice.dto.MentorsDto;
import com.yaas.recoderuserservice.entity.Mentors;
import com.yaas.recoderuserservice.entity.Users;
import com.yaas.recoderuserservice.model.CrMenteesResponseModel;
import com.yaas.recoderuserservice.repository.IMentorMapper;
import com.yaas.recoderuserservice.repository.IUserMapper;
import com.yaas.recoderuserservice.service.IMentorService;
import com.yaas.recoderuserservice.service.IUsersService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MentorServiceImpl implements IMentorService {
    private static final Logger log = LoggerFactory.getLogger(com.yaas.recoderuserservice.service.MentorServiceImpl.class);

    IMentorMapper iMentorMapper;

    IUserMapper iUserMapper;

    private IUsersService userService;

    Users usersEntity;

    CodeReviewService codeReviewService;

    @Autowired
    public MentorServiceImpl(IMentorMapper iMentorMapper, IUserMapper iUserMapper, IUsersService userService, CodeReviewService codeReviewService) {
        this.iMentorMapper = iMentorMapper;
        this.iUserMapper = iUserMapper;
        this.userService = userService;
        this.codeReviewService = codeReviewService;
    }

    public MentorsDto findByUserId(@PathVariable long userId) {
        MentorsDto mentorEntity = this.iMentorMapper.findByUserId(userId);
        return mentorEntity;
    }

    public MentorsDto createMentor(MentorsDto mentorsDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Mentors mentorsEntity = (Mentors)modelMapper.map(mentorsDto, Mentors.class);
        this.iMentorMapper.createMentor(mentorsEntity);
        MentorsDto returnValue = (MentorsDto)modelMapper.map(mentorsEntity, MentorsDto.class);
        Map<String, Object> type = new HashMap<>(2);
        type.put("type", Integer.valueOf(2));
        type.put("userId", Long.valueOf(returnValue.getUserId()));
        this.iUserMapper.updateUserType(type);
        return returnValue;
    }

    public int updateMentorInfo(Mentors mentors) {
        int updateMentor = this.iMentorMapper.updateMentorInfo(mentors);
        return updateMentor;
    }

    public List<CrMenteesDto> getMenteeNicknames(@PathVariable long roomId) {
        List<CrMenteesDto> crMenteesDtos = this.iMentorMapper.getMenteeNicknames(roomId);
        System.out.println("getMenteeNickname");
        if (crMenteesDtos == null)
            log.info(String.format("not exists %s", new Object[] { Long.valueOf(roomId) }));
        log.info(">>> Before calling code review microservice");
        for (int i = 0; i < crMenteesDtos.size(); i++) {
            Map<String, Long> crMenteesMap = new HashMap<>();
            crMenteesMap.put("roomId", Long.valueOf(((CrMenteesDto)crMenteesDtos.get(i)).getRoomId()));
            crMenteesMap.put("menteeId", Long.valueOf(((CrMenteesDto)crMenteesDtos.get(i)).getMenteeId()));
            CrMenteesResponseModel crMenteesList = this.codeReviewService.getCrMentees(crMenteesMap);
            ((CrMenteesDto)crMenteesDtos.get(i)).setReviewCount(crMenteesList.getReviewCount());
            ((CrMenteesDto)crMenteesDtos.get(i)).setReviewLanguage(crMenteesList.getReviewLanguage());
        }
        log.info(">>> After calling code review microservice");
        return crMenteesDtos;
    }

    public int deleteMentee(@PathVariable long menteeId, @PathVariable long roomId) {
        int deleteMentee = this.iMentorMapper.deleteMentee(menteeId, roomId);
        return deleteMentee;
    }

    public MentorsDto getMentorByMentorId(@PathVariable long mentorId) {
        Mentors mentorEntity = this.iMentorMapper.getMentorByMentorId(mentorId);
        if (mentorEntity == null)
            log.info(String.format("not exists use : %s", new Object[] { Long.valueOf(mentorId) }));
        return (MentorsDto)(new ModelMapper()).map(mentorEntity, MentorsDto.class);
    }

    public MentorNicknameDto getMentorNickname(long mentorId) {
        MentorNicknameDto mentorNickname = this.iMentorMapper.getMentorNickname(mentorId);
        if (mentorNickname == null)
            log.info(String.format("not exists %s", new Object[] { Long.valueOf(mentorId) }));
        return mentorNickname;
    }
}
