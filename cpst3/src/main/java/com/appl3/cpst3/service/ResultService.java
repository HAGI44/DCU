package com.appl3.cpst3.service; // com.appl3.cpst3.service 패키지 정의

import org.springframework.beans.factory.annotation.Autowired; // Autowired 어노테이션을 사용하기 위한 import문
import org.springframework.stereotype.Service; // Service 어노테이션을 사용하기 위한 import문
import com.appl3.cpst3.domain.entity.Enrollment; // Enrollment 엔티티를 사용하기 위한 import문
import com.appl3.cpst3.repository.EnrollmentRepository; // EnrollmentRepository를 사용하기 위한 import문
import java.util.List; // List를 사용하기 위한 import문

@Service // Spring의 Service로 정의되는 클래스임을 나타내는 어노테이션
public class ResultService { // ResultService 클래스 선언

    private final EnrollmentRepository enrollmentRepository; // EnrollmentRepository 객체 선언

    @Autowired // 의존성 주입을 위한 Autowired 어노테이션
    public ResultService(EnrollmentRepository enrollmentRepository) { // ResultService 생성자
        this.enrollmentRepository = enrollmentRepository; // 생성자를 통해 주입된 EnrollmentRepository 객체를 초기화
    }

    // 수강신청이 완료된 과목을 조회하는 메서드
    public List<Enrollment> getCompletedEnrollments() { // 완료된 수강 신청 목록을 반환하는 메서드
        // 여기서는 수강신청이 완료된 과목을 조회하는 로직을 구현합니다.
        // 예를 들어, 수강신청 상태를 확인하여 완료된 수강신청들을 가져올 수 있습니다.
        // 여기에서는 간단히 수강신청이 완료된 것으로 가정하여 모든 Enrollment을 반환합니다.
        // 만약 수강신청 상태를 확인하여 완료된 수강신청만을 가져오는 로직이 있다면 그에 맞게 수정하면 됩니다.
        return enrollmentRepository.findAll(); // EnrollmentRepository를 통해 모든 Enrollment 객체를 조회하여 반환
    }
}
