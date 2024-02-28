package com.sugangbk.rest.controller;

import com.sugangbk.rest.aop.annotation.PermitAdmin;
import com.sugangbk.rest.controller.request.SubjectMakeRequest;
import com.sugangbk.rest.controller.response.SubjectListResponse;
import com.sugangbk.rest.entity.Subject;
import com.sugangbk.rest.exception.exception.NoExistEntityException;
import com.sugangbk.rest.repository.SubjectRepository;
import com.sugangbk.rest.service.SubjectService;
import com.sugangbk.rest.service.dto.SubjectMakeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/subject")
@RequiredArgsConstructor
@Transactional
public class SubjectRestController {

    private final SubjectService subjectService;

    private final SubjectRepository subjectRepository;

    @PermitAdmin
    @PostMapping("/make")
    void makeSubject(@RequestBody @Validated SubjectMakeRequest subjectMakeRequest) {

        SubjectMakeDTO subjectMakeDTO = SubjectMakeDTO.builder()
                .code(subjectMakeRequest.getCode())
                .name(subjectMakeRequest.getName())
                .credit(subjectMakeRequest.getCredit())
                .type(subjectMakeRequest.getType())
                .build();

        subjectService.make(subjectMakeDTO);
    }

    @PermitAdmin
    @PostMapping("/inactive")
    @Valid
    void inactiveSubject(@RequestParam @NotNull Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(NoExistEntityException::new);

        subjectService.inactive(subject);
    }

    @PostMapping("/list")
    ResponseEntity<SubjectListResponse> subjectList() {
        final List<Subject> subjects = subjectRepository.findAllByActivatedTrue();

        return ResponseEntity.ok(new SubjectListResponse(subjects));
    }
}
