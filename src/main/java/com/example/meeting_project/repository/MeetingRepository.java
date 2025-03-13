package com.example.meeting_project.repository;

import com.example.meeting_project.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting,Long> {
    //특정 유저가 주최한 미팅 리스트 가져오기
    List<Meeting> findByMeetingHost_Id(Long userId);

    //미팅 이름으로 미팅 찾기
    Optional<Meeting> findByName(String name);
}
