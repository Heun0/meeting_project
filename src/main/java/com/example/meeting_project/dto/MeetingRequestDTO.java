package com.example.meeting_project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
    private Integer maxParticipants; //최대참가자 수(생성시 설정)
    @Schema(hidden = true)
    private Long meetingHostId; // 미팅을 생성하는 유저의 ID
}

