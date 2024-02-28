package com.sugangbk.rest.controller;


import com.sugangbk.rest.aop.annotation.PermitAdmin;
import com.sugangbk.rest.aop.annotation.PermitAnyLogin;
import com.sugangbk.rest.controller.response.ClassroomListResponse;
import com.sugangbk.rest.entity.Classroom;
import com.sugangbk.rest.exception.exception.NoExistEntityException;
import com.sugangbk.rest.repository.ClassroomRepository;
import com.sugangbk.rest.service.ClassroomService;
import com.sugangbk.rest.service.dto.CreateClassroomDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/classroom")
@RequiredArgsConstructor
@Transactional
public class ClassroomController {

    private final ClassroomService classroomService;

    private final ClassroomRepository classroomRepository;

    @PermitAdmin
    @PostMapping("/create")
    @Valid
    public void createClassroom(
            @RequestParam @NotBlank String name,
            @RequestParam @NotNull Integer code){

        CreateClassroomDTO createClassroomDTO = CreateClassroomDTO.builder()
                .name(name)
                .code(code)
                .build();

        classroomService.create(createClassroomDTO);
    }

    @PermitAnyLogin
    @PostMapping("/inactivate")
    @Valid
    public void deleteClassroom(@RequestParam @NotNull Long classroomId){
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(NoExistEntityException::new);

        classroomService.inactivate(classroom);
    }

    @PostMapping("/list")
    ResponseEntity<ClassroomListResponse> classroomList() {
        final List<Classroom> classrooms = classroomRepository.findAllByActivatedTrue().stream()
                .collect(Collectors.toList());

        return ResponseEntity.ok(new ClassroomListResponse(classrooms));
    }
}
