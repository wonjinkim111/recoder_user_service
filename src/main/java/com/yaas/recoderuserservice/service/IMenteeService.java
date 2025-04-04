package com.yaas.recoderuserservice.service;

import com.yaas.recoderuserservice.dto.MenteesDto;
import com.yaas.recoderuserservice.dto.NicknameDto;

public interface IMenteeService {
    MenteesDto findByUserIdMentee(long paramLong);

    MenteesDto createMentee(MenteesDto paramMenteesDto);

    NicknameDto getMenteeNickname(long paramLong);

    int updateMenteeRoomId(long paramLong1, long paramLong2);

    int enrollReview(long paramLong1, long paramLong2);
}
