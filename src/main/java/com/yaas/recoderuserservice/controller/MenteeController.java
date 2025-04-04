package com.yaas.recoderuserservice.controller;

import com.yaas.recoderuserservice.dto.MenteesDto;
import com.yaas.recoderuserservice.dto.NicknameDto;
import com.yaas.recoderuserservice.entity.Mentees;
import com.yaas.recoderuserservice.model.CreateMenteeResponseModel;
import com.yaas.recoderuserservice.service.IMenteeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/users/mentee"})
public class MenteeController {
    IMenteeService iMenteeService;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public MenteeController(IMenteeService iMenteeService) {
        this.iMenteeService = iMenteeService;
    }

    @PostMapping({"/{userId}"})
    public ResponseEntity<CreateMenteeResponseModel> createMentor(@RequestBody Mentees mentees, @PathVariable long userId) {
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        MenteesDto menteesDto = (MenteesDto)this.modelMapper.map(mentees, MenteesDto.class);
        menteesDto.setUserId(userId);
        MenteesDto createMentee = this.iMenteeService.createMentee(menteesDto);
        CreateMenteeResponseModel returnValue = (CreateMenteeResponseModel)this.modelMapper.map(createMentee, CreateMenteeResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

    @GetMapping({"/nickname"})
    @ResponseBody
    public NicknameDto getMenteeNickname(@RequestParam long menteeId) {
        NicknameDto nickname = this.iMenteeService.getMenteeNickname(menteeId);
        return nickname;
    }

    @PostMapping({"/enroll"})
    @ResponseBody
    public int enrollReview(@RequestParam long menteeId, @RequestParam long roomId) {
        System.out.println("insert " + menteeId);
        int result = this.iMenteeService.enrollReview(menteeId, roomId);
        return result;
    }
}
