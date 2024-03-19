package com.appl3.cpst3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.appl3.cpst3.domain.entity.Enrollment;
import com.appl3.cpst3.service.ResultService;
import java.util.List;

@RestController
public class ResultController {
    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    // 수강신청이 완료된 과목을 조회하는 컨트롤러 메서드
    @GetMapping("/completed-enrollments")
    public List<Enrollment> getCompletedEnrollments() {
        // ResultService를 통해 수강신청이 완료된 과목을 조회하고 반환합니다.
        return resultService.getCompletedEnrollments();
    }
}
