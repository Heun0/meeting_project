package com.example.meeting_project.service;

import com.example.meeting_project.dto.MeetingRequestDTO;
import com.example.meeting_project.dto.MeetingResponseDTO;
import com.example.meeting_project.dto.UserRequestDTO;
import com.example.meeting_project.dto.UserResponseDTO;
import com.example.meeting_project.entity.Meeting;
import com.example.meeting_project.entity.User;
import com.example.meeting_project.repository.MeetingRepository;
import com.example.meeting_project.repository.UserRepository;
import com.example.meeting_project.util.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MeetingService {
    private final MeetingRepository meetingRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;


    @Transactional
    public MeetingResponseDTO registerMeeting(MeetingRequestDTO meetingRequestDTO, String token) {


        if (meetingRepository.findByName(meetingRequestDTO.getName()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 모임입니다.");
        }
        Meeting meeting = new Meeting();
        meeting.setName(meetingRequestDTO.getName());
        meeting.setDescription(meetingRequestDTO.getDescription());
        meeting.setMaxParticipants(meetingRequestDTO.getMaxParticipants());
        meeting.setCurrentParticipants(1);

        Long hostId = jwtUtil.validateToken(token);
        User meetingHost = userRepository.findById(hostId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다"));

        meeting.setMeetingHost(meetingHost);


        Meeting savedMeeting = meetingRepository.save(meeting);


        return new MeetingResponseDTO(savedMeeting);
    }

    @Transactional(readOnly = true)
    public List<MeetingResponseDTO> getAllMeetings() {
        List<Meeting> meetings = meetingRepository.findAll();
        return meetings.stream()
                .map(MeetingResponseDTO::new)
                .collect(Collectors.toList());
    }


}

