package com.appl3.cpst3.domain.entity; // 이 패키지는 com.appl3.cpst3.domain.entity로 정의됨

import lombok.AllArgsConstructor; // 모든 인자를 받는 생성자를 자동으로 생성하기 위한 어노테이션을 가져옴
import lombok.Builder; // 빌더 패턴을 사용하기 위한 어노테이션을 가져옴
import lombok.Getter; // 클래스의 모든 필드에 대한 게터 메소드를 자동으로 생성하기 위한 어노테이션을 가져옴
import lombok.NoArgsConstructor; // 파라미터가 없는 생성자를 자동으로 생성하기 위한 어노테이션을 가져옴
import lombok.Setter; // 클래스의 모든 필드에 대한 세터 메소드를 자동으로 생성하기 위한 어노테이션을 가져옴

import jakarta.persistence.Entity; // JPA 엔티티임을 나타내기 위한 어노테이션을 가져옴
import jakarta.persistence.GeneratedValue; // 자동 생성된 값의 생성 전략을 지정하기 위한 어노테이션을 가져옴
import jakarta.persistence.GenerationType; // 엔티티의 기본 키를 생성하는 전략을 지정하기 위한 열거형을 가져옴
import jakarta.persistence.Id; // 엔티티의 기본 키를 지정하기 위한 어노테이션을 가져옴

@Entity // JPA 엔티티임을 나타내는 어노테이션
@Builder // 빌더 패턴을 사용할 수 있도록 하는 어노테이션
@Getter // 클래스의 모든 필드에 대한 게터 메소드를 자동으로 생성하는 어노테이션
@Setter // 클래스의 모든 필드에 대한 세터 메소드를 자동으로 생성하는 어노테이션
@NoArgsConstructor // 파라미터가 없는 생성자를 자동으로 생성하는 어노테이션
@AllArgsConstructor // 모든 인자를 받는 생성자를 자동으로 생성하는 어노테이션
public class Enrollment { // 수강신청 정보를 나타내는 엔티티 클래스

    @Id // 엔티티의 기본 키를 지정하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 엔티티의 기본 키 값을 자동으로 생성하는 전략을 지정하는 어노테이션
    private Long id; // 수강신청 정보의 식별자로 사용되는 필드

    private String studentCode; // 학생 코드 (FK)를 나타내는 필드
    private String courseCode; // 강의 코드 (FK)를 나타내는 필드
    private int mileageBet; // 학생이 베팅한 마일리지를 나타내는 필드
    
    // 생성자 추가
    public Enrollment(String studentCode, String courseCode, int mileageBet) {
        this.studentCode = studentCode;
        this.courseCode = courseCode;
        this.mileageBet = mileageBet;
    }
    
    // 각 필드의 게터와 세터는 롬복을 사용하여 자동 생성됨
}
