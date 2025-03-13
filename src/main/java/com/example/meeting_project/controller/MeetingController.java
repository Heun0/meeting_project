package com.example.meeting_project.controller;

import com.example.meeting_project.dto.MeetingRequestDTO;
import com.example.meeting_project.dto.MeetingResponseDTO;
import com.example.meeting_project.dto.UserResponseDTO;
import com.example.meeting_project.entity.Meeting;
import com.example.meeting_project.service.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/meetings")
@RestController
public class MeetingController {
    private final MeetingService meetingService;
    @PostMapping
    public ResponseEntity<MeetingResponseDTO> registerMeeting(@RequestBody MeetingRequestDTO meetingRequestDTO, @RequestHeader("Authorization")String token){
        MeetingResponseDTO registeredMeeting = meetingService.registerMeeting(meetingRequestDTO, token.replace("Bearer ", ""));
        return ResponseEntity.ok(registeredMeeting);
    }

    @GetMapping
    public ResponseEntity<List<MeetingResponseDTO>> getMeetings() {
        List<MeetingResponseDTO> meetings = meetingService.getAllMeetings();
        return ResponseEntity.ok(meetings);
    }





}
