package com.example.meeting_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="meetings")
@Getter
@Setter
@NoArgsConstructor
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true) //미팅 이름이 겹치지 않도록
    private String name; // 미팅 이름

    @Column(nullable = false)
    private String description; // 미팅에 대한 설명

    @Column(name="max_participants",nullable = false)
    private Integer maxParticipants; //미팅 최대 참가자 수

    @Column(name="current_participants",nullable=false, columnDefinition = "INT DEFAULT 1")
    private Integer currentParticipants; //미팅 현재 참가자 수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="meeting_host",nullable = false)
    private User meetingHost; // 미팅 주최자 (유저 ID나 이메일 등을 참조할 수 있음)

    @ManyToMany(mappedBy = "meetings")
    private Set<User> users; // 미팅에 참여한 유저들

    @OneToMany(mappedBy = "meeting")
    private Set<Schedule> schedules; // 해당 미팅의 스케줄들



}