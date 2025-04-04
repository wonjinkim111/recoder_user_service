package com.yaas.recoderuserservice.service;

import com.yaas.recoderuserservice.dto.CrMenteesDto;
import com.yaas.recoderuserservice.dto.MentorNicknameDto;
import com.yaas.recoderuserservice.dto.MentorsDto;
import com.yaas.recoderuserservice.entity.Mentors;
import java.util.List;

public interface IMentorService {
    MentorsDto findByUserId(long paramLong);

    MentorsDto createMentor(MentorsDto paramMentorsDto);

    int updateMentorInfo(Mentors paramMentors);

    List<CrMenteesDto> getMenteeNicknames(long paramLong);

    int deleteMentee(long paramLong1, long paramLong2);

    MentorsDto getMentorByMentorId(long paramLong);

    MentorNicknameDto getMentorNickname(long paramLong);
}
