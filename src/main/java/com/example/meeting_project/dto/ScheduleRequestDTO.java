package com.example.meeting_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequestDTO {
    private String name;
    private LocalDateTime date;
    private String location;
    private Long meetingId; // 일정이 속한 미팅 ID
    private Long scheduleHostId; // 일정 주최자 ID
}
