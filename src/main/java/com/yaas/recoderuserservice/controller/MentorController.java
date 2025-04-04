package com.yaas.recoderuserservice.controller;

import com.yaas.recoderuserservice.dto.CrMenteesDto;
import com.yaas.recoderuserservice.dto.MentorNicknameDto;
import com.yaas.recoderuserservice.dto.MentorsDto;
import com.yaas.recoderuserservice.entity.Mentors;
import com.yaas.recoderuserservice.model.CreateMentorResponseModel;
import com.yaas.recoderuserservice.model.ResultResponseModel;
import com.yaas.recoderuserservice.service.IMentorService;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/users/mentor"})
public class MentorController {
    private static final Logger log = LoggerFactory.getLogger(com.yaas.recoderuserservice.controller.MentorController.class);

    IMentorService iMentorService;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public MentorController(IMentorService iMentorService) {
        this.iMentorService = iMentorService;
    }

    @PostMapping({"/{userId}"})
    public ResponseEntity<CreateMentorResponseModel> createMentor(@RequestBody Mentors mentors, @PathVariable long userId) {
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        MentorsDto mentorsDto = (MentorsDto)this.modelMapper.map(mentors, MentorsDto.class);
        mentorsDto.setUserId(userId);
        MentorsDto createMentor = this.iMentorService.createMentor(mentorsDto);
        CreateMentorResponseModel returnValue = (CreateMentorResponseModel)this.modelMapper.map(createMentor, CreateMentorResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

    @GetMapping({"/mentees/{roomId}"})
    @ResponseBody
    public List<CrMenteesDto> getMenteeNickname(@PathVariable long roomId) {
        List<CrMenteesDto> returnValue = new ArrayList<>();
        List<CrMenteesDto> mentorRoom = this.iMentorService.getMenteeNicknames(roomId);
        if (mentorRoom == null || mentorRoom.isEmpty())
            return returnValue;
        Type listType = new TypeToken<List<CrMenteesDto>>() {}.getType();
        returnValue = new ModelMapper().map(mentorRoom, listType);
        log.info("Returning " + returnValue.size() + " mentee list");
        return returnValue;
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<ResultResponseModel> deleteMentee(@RequestParam long menteeId, @RequestParam long roomId) {
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        long deleteResult = this.iMentorService.deleteMentee(menteeId, roomId);
        ResultResponseModel sReturnValue = (ResultResponseModel)this.modelMapper.map(Long.valueOf(menteeId), ResultResponseModel.class);
        ResultResponseModel fReturnValue = (ResultResponseModel)this.modelMapper.map(Integer.valueOf(0), ResultResponseModel.class);
        if (deleteResult == 1L)
            return ResponseEntity.status(HttpStatus.CREATED).body(sReturnValue);
        return ResponseEntity.status(HttpStatus.CREATED).body(fReturnValue);
    }

    @GetMapping({"/{mentorId}"})
    @ResponseBody
    public MentorsDto getMentorByMentorId(@PathVariable long MentorId) {
        MentorsDto mentorDto = this.iMentorService.getMentorByMentorId(MentorId);
        return mentorDto;
    }

    @GetMapping({"/nickname"})
    @ResponseBody
    public MentorNicknameDto getMentorNickname(@RequestParam long mentorId) {
        MentorNicknameDto nickname = this.iMentorService.getMentorNickname(mentorId);
        return nickname;
    }
}
