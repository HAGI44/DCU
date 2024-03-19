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
        // 여기서는 수강신청이 완료된 과목을 조회하는 로직을 구현합니다.
        // 예를 들어, 수강신청 상태를 확인하여 완료된 수강신청들을 가져올 수 있습니다.
        // 여기에서는 간단히 수강신청이 완료된 것으로 가정하여 모든 Enrollment을 반환합니다.
        // 만약 수강신청 상태를 확인하여 완료된 수강신청만을 가져오는 로직이 있다면 그에 맞게 수정하면 됩니다.
        return enrollmentRepository.findAll();
    }
}
