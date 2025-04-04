package com.yaas.recoderuserservice.repository;

import com.yaas.recoderuserservice.dto.CrMenteesDto;
import com.yaas.recoderuserservice.dto.MentorNicknameDto;
import com.yaas.recoderuserservice.dto.MentorsDto;
import com.yaas.recoderuserservice.entity.Mentors;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IMentorMapper {
    MentorsDto findByUserId(long paramLong);

    int createMentor(Mentors paramMentors);

    int updateMentorInfo(Mentors paramMentors);

    List<CrMenteesDto> getMenteeNicknames(long paramLong);

    int deleteMentee(long paramLong1, long paramLong2);

    Mentors getMentorByMentorId(long paramLong);

    MentorNicknameDto getMentorNickname(long paramLong);
}
