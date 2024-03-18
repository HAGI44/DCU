package com.appl3.cpst3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appl3.cpst3.domain.entity.Enrollment;
import com.appl3.cpst3.repository.EnrollmentRepository;
import java.util.List;

@Service
public class ResultService {
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public ResultService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    // 수강신청이 완료된 과목을 조회하는 메서드
    public List<Enrollment> getCompletedEnrollments() {
        // 여기서 필요한 로직을 구현하여 수강신청이 완료된 과목을 조회합니다.
        // 예를 들어, 수강신청 상태를 확인하여 완료된 수강신청들을 가져올 수 있습니다.
        // 이 예시에서는 단순히 모든 수강신청 정보를 조회하는 것으로 대체합니다.
        return enrollmentRepository.findAll();
    }
}
