package com.example.meeting_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeetingRequestDTO { //미팅 생성 요청
    private String name;
    private String description;
    private Integer maxParticipants;
    private Long meetingHostId; // 미팅을 생성하는 유저의 ID
}

