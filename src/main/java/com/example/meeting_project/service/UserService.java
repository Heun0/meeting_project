package com.example.meeting_project.service;

import com.example.meeting_project.dto.UserRequestDTO;
import com.example.meeting_project.dto.UserResponseDTO;
import com.example.meeting_project.entity.User;
import com.example.meeting_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

//    @Transactional
//    public User resisterUser(UserRequestDTO userRequestDTO){
//        //이메일 중복 검사
////        if(userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()){
////            throw new IllegalAccessException("이미 존재하는 이메일입니다.");
////        }
////
//
//        //DTO -> 엔티티
//        User user = new User();
//        user.setName(userRequestDTO.getName());
//        user.setEmail(userRequestDTO.getEmail());
//        user.setPassword(userRequestDTO.getPassword()); //비밀번호 해싱 필요
//
//        User newUser = userRepository.save(user);
//
//        UserResponseDTO responseDTO = new UserResponseDTO();
//        responseDTO.setId(newUser.getId());
//        responseDTO.setEmail(newUser.getEmail());
//        responseDTO.setName(newUser.getName());
//
//        return new User();
//    }

    @Transactional
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        // 1. 이메일 중복 검사
        if (userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        // 2. DTO -> 엔티티 변환
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword()); // TODO: 비밀번호 해싱 필요

        // 3. 저장
        User savedUser = userRepository.save(user);

        // 4. 엔티티 -> DTO 변환 후 반환
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(savedUser.getId());
        responseDTO.setName(savedUser.getName());
        responseDTO.setEmail(savedUser.getEmail());

        return responseDTO;
    }



}
