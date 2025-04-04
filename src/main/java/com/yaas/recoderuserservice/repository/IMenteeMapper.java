package com.yaas.recoderuserservice.repository;

import com.yaas.recoderuserservice.dto.MenteesDto;
import com.yaas.recoderuserservice.dto.NicknameDto;
import com.yaas.recoderuserservice.entity.Mentees;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IMenteeMapper {
    MenteesDto findByUserIdMentee(long paramLong);

    int createMentee(Mentees paramMentees);

    NicknameDto getMenteeNickname(long paramLong);

    int updateMenteeRoomId(long paramLong1, long paramLong2);

    int enrollReview(long paramLong1, long paramLong2);
}
