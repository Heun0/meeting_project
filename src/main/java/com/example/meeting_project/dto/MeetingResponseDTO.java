package com.example.meeting_project.dto;

import com.example.meeting_project.entity.Meeting;
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
    private Integer currentParticipants; //현재 참가자 수
    private Long meetingHostId;

    public MeetingResponseDTO(Meeting meeting) {
        this.name = meeting.getName();
        this.description = meeting.getDescription();
        this.currentParticipants = meeting.getCurrentParticipants();
        this.meetingHostId = meeting.getMeetingHost().getId(); // User ID 설정
    }


}
