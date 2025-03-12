package com.example.meeting_project.repository;

import com.example.meeting_project.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    //미팅에 속한 일정 리스트 가져오기
    List<Schedule> findByMeeting_Id(Long meetingId);

    //특정 유저가 생성한 일정 리스트 가져오기
    List<Schedule> findByScheduleHost_Id(Long userId);
}
