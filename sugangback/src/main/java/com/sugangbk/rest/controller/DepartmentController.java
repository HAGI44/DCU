package com.sugangbk.rest.controller;

import com.sugangbk.rest.aop.annotation.PermitAdmin;
import com.sugangbk.rest.controller.request.CreateDepartmentRequest;
import com.sugangbk.rest.controller.response.DepartmentListResponse;
import com.sugangbk.rest.entity.Department;
import com.sugangbk.rest.exception.exception.NoExistEntityException;
import com.sugangbk.rest.repository.DepartmentRepository;
import com.sugangbk.rest.service.DepartmentService;
import com.sugangbk.rest.service.dto.CreateDepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
@Transactional
public class DepartmentController {

    private final DepartmentService departmentService;

    private final DepartmentRepository departmentRepository;

    private final ModelMapper modelMapper;

    @PermitAdmin
    @PostMapping("/create")
    public void createDepartment(@RequestBody @Valid CreateDepartmentRequest createDepartmentRequest) {
        CreateDepartmentDTO createDepartmentDTO =
                modelMapper.map(createDepartmentRequest, CreateDepartmentDTO.class);

        departmentService.create(createDepartmentDTO);
    }

    @PermitAdmin
    @PostMapping("/inactivate")
    @Valid
    public void inactivateDepartment(@RequestParam @NotNull Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(NoExistEntityException::new);

        departmentService.inactive(department);
    }

    @PostMapping("/list")
    public ResponseEntity<DepartmentListResponse> departmentList() {
        List<Department> departments = departmentRepository.findAll().stream()
                .filter(Department::getActivated)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new DepartmentListResponse(departments));
    }
}
