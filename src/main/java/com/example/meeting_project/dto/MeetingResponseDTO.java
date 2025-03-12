package com.example.meeting_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeetingResponseDTO { //미팅 조회 응답
    private Long id;
    private String name;
    private String description;
    private Integer currentParticipants;
}
