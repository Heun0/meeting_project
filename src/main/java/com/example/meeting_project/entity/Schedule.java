package com.example.meeting_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="schedules")
@Getter
@Setter
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // 일정 이름

    @Column(name="date", nullable = false)
    private LocalDateTime date; // 일정 날짜 및 시간 (예: "2025-03-12 14:00")

    @Column(nullable = false)
    private String location; // 일정 장소

    @ManyToOne
    @JoinColumn(name = "schedule_host", referencedColumnName = "id", nullable = false)
    private User scheduleHost; // 일정 주최자 (User 엔티티의 id와 연결됨)

    @ManyToOne
    @JoinColumn(name = "meeting_id", nullable = false)
    private Meeting meeting; //(해당 스케쥴이 속한 미팅)


    @ManyToMany(mappedBy = "schedules")
    private Set<User> users; // 스케줄에 참여한 유저들
}
