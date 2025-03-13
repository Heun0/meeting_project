package com.example.meeting_project.repository;

import com.example.meeting_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //이메일로 유저 찾기
    Optional<User> findByEmail(String email);

//    //유저가 참여한 미팅 리스트 가져오기
//    List<User> findByMeetings_Id(Long meetingId);
//
//    //유저가 참여한 일정 리스트 가져오기
//    List<User> findBySchedules_Id(Long scheduleId);
}
