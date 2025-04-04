package com.yaas.recoderuserservice.service;

import com.yaas.recoderuserservice.dto.MenteesDto;
import com.yaas.recoderuserservice.dto.NicknameDto;
import com.yaas.recoderuserservice.entity.Mentees;
import com.yaas.recoderuserservice.repository.IMenteeMapper;
import com.yaas.recoderuserservice.service.IMenteeService;
import com.yaas.recoderuserservice.service.IUsersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MenteeServiceImpl implements IMenteeService {
    private static final Logger log = LoggerFactory.getLogger(com.yaas.recoderuserservice.service.MenteeServiceImpl.class);

    IMenteeMapper iMenteeMapper;

    private IUsersService userService;

    @Autowired
    public MenteeServiceImpl(IMenteeMapper iMenteeMapper, IUsersService userService) {
        this.iMenteeMapper = iMenteeMapper;
        this.userService = userService;
    }

    public MenteesDto findByUserIdMentee(@PathVariable long userId) {
        MenteesDto menteeEntity = this.iMenteeMapper.findByUserIdMentee(userId);
        return menteeEntity;
    }

    public MenteesDto createMentee(MenteesDto menteesDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Mentees menteesEntity = (Mentees)modelMapper.map(menteesDto, Mentees.class);
        this.iMenteeMapper.createMentee(menteesEntity);
        MenteesDto returnValue = (MenteesDto)modelMapper.map(menteesEntity, MenteesDto.class);
        return returnValue;
    }

    public NicknameDto getMenteeNickname(long menteeId) {
        NicknameDto menteeNickname = this.iMenteeMapper.getMenteeNickname(menteeId);
        if (menteeNickname == null)
            log.info(String.format("not exists %s", new Object[] { Long.valueOf(menteeId) }));
        return menteeNickname;
    }

    public int updateMenteeRoomId(long menteeId, long roomId) {
        int updateMenteeRoomId = this.iMenteeMapper.updateMenteeRoomId(menteeId, roomId);
        return updateMenteeRoomId;
    }

    public int enrollReview(long menteeId, long roomId) {
        int result = this.iMenteeMapper.enrollReview(menteeId, roomId);
        return result;
    }
}
