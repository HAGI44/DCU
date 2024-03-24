package com.appl3.cpst3.domain.entity; // 이 패키지는 com.appl3.cpst3.domain.entity로 정의됨

import lombok.AllArgsConstructor; // 모든 인자를 받는 생성자를 자동으로 생성하기 위한 어노테이션을 가져옴
import lombok.Builder; // 빌더 패턴을 사용할 수 있도록 하는 어노테이션을 가져옴
import lombok.Getter; // 클래스의 모든 필드에 대한 게터 메소드를 자동으로 생성하기 위한 어노테이션을 가져옴
import lombok.NoArgsConstructor; // 파라미터가 없는 생성자를 자동으로 생성하기 위한 어노테이션을 가져옴

import com.appl3.cpst3.domain.UserRole; // UserRole 열거형을 사용하기 위해 import문 추가

import jakarta.persistence.Entity; // JPA 엔티티임을 나타내기 위한 어노테이션을 가져옴
import jakarta.persistence.GeneratedValue; // 자동 생성된 값의 생성 전략을 지정하기 위한 어노테이션을 가져옴
import jakarta.persistence.GenerationType; // 엔티티의 기본 키를 생성하는 전략을 지정하기 위한 열거형을 가져옴
import jakarta.persistence.Id; // 엔티티의 기본 키를 지정하기 위한 어노테이션을 가져옴

@Entity // JPA 엔티티임을 나타내는 어노테이션
@Builder // 빌더 패턴을 사용할 수 있도록 하는 어노테이션
@Getter // 클래스의 모든 필드에 대한 게터 메소드를 자동으로 생성하는 어노테이션
@NoArgsConstructor // 파라미터가 없는 생성자를 자동으로 생성하는 어노테이션
@AllArgsConstructor // 모든 인자를 받는 생성자를 자동으로 생성하는 어노테이션
public class User { // 사용자 정보를 나타내는 엔티티 클래스

    @Id // 엔티티의 기본 키를 지정하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 엔티티의 기본 키 값을 자동으로 생성하는 전략을 지정하는 어노테이션
    private Long id; // 사용자 정보의 식별자로 사용되는 필드

    private String studentCode; // 학번을 나타내는 필드
    private String password; // 비밀번호를 나타내는 필드
    private String name; // 사용자의 이름을 나타내는 필드
    private UserRole role; // 사용자 역할을 나타내는 필드
}
