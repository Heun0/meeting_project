package com.example.meeting_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO { //회원 정보 조회 시 사용(비밀번호는 제외)
    private Long id;
    private String name;
    private String email;
}
