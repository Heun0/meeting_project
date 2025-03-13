package com.example.meeting_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/meetings/{meetingId}/schedules")
@RestController
public class ScheduleController {

}
