package com.example.meeting_project.service;

import com.example.meeting_project.dto.UserRequestDTO;
import com.example.meeting_project.dto.UserResponseDTO;
import com.example.meeting_project.entity.User;
import com.example.meeting_project.repository.UserRepository;
import com.example.meeting_project.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Transactional
    public String register(String email, String password){
        if(userRepository.findByEmail(email).isPresent()){
            return "이미 존재하는 아이디입니다.";
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "회원가입 성공";
    }

    @Transactional
    public String login(String email, String password){
        Optional<User> userOptional = userRepository.findByEmail(email);

        if(userOptional.isEmpty()){
            return "존재하지 않는 아이디입니다.";
        }

        User user = userOptional.get();

        if(!user.getPassword().equals(password)){
            return "비밀번호가 일치하지 않습니다.";
        }

        //Jwt 토큰 발급
        String token = jwtUtil.generateToken(user.getId());
        return "로그인 성공, 토큰 : "+token;

    }

    @Transactional
    public void logout(String token){
        jwtUtil.invalidateToken(token);
    }


//========================================================================================
//    @Transactional
//    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
//        // 1. 이메일 중복 검사
//        if (userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()) {
//            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
//        }
//
//        // 2. DTO -> 엔티티 변환
//        User user = new User();
//        user.setName(userRequestDTO.getName());
//        user.setEmail(userRequestDTO.getEmail());
//        user.setPassword(userRequestDTO.getPassword()); // TODO: 비밀번호 해싱 필요
//
//        // 3. 저장
//        User savedUser = userRepository.save(user);
//
//        // 4. 엔티티 -> DTO 변환 후 반환
//        UserResponseDTO responseDTO = new UserResponseDTO();
//        responseDTO.setId(savedUser.getId());
//        responseDTO.setName(savedUser.getName());
//        responseDTO.setEmail(savedUser.getEmail());
//
//        return responseDTO;
//    }






}
