package com.appl3.cpst3.domain.dto;

import lombok.Getter; // lombok에서 자동 생성되는 getter 메소드를 사용하기 위한 어노테이션을 가져옴
import lombok.NoArgsConstructor; // 파라미터가 없는 생성자를 생성하기 위한 어노테이션을 가져옴
import lombok.Setter; // lombok에서 자동 생성되는 setter 메소드를 사용하기 위한 어노테이션을 가져옴

@Getter // 클래스의 모든 필드에 대한 getter 메소드를 자동으로 생성하는 어노테이션
@Setter // 클래스의 모든 필드에 대한 setter 메소드를 자동으로 생성하는 어노테이션
@NoArgsConstructor // 파라미터가 없는 생성자를 자동으로 생성하는 어노테이션
public class LoginRequest {

	private String loginId; // 로그인 아이디를 나타내는 필드
    private String password; // 비밀번호를 나타내는 필드
	
    private String studentCode; // 학번
    private String passwd; // 비밀번호

    // Getter와 Setter 메서드
    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}

