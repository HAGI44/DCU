package com.sugangbk.rest.service;

import com.sugangbk.rest.entity.Department;
import com.sugangbk.rest.exception.exception.DuplicatedEntityException;
import com.sugangbk.rest.repository.DepartmentRepository;
import com.sugangbk.rest.service.dto.CreateDepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public Department create(CreateDepartmentDTO createDepartmentDTO){
        if(isDuplicatedDepartment(createDepartmentDTO.getCode()))
            throw new DuplicatedEntityException("학과 코드가 중복됩니다");

        Department department = modelMapper.map(createDepartmentDTO, Department.class);
        return departmentRepository.save(department);
    }

    public void inactive(Department department){
        department.setActivated(false);
    }

    private boolean isDuplicatedDepartment(Integer code) {
        return departmentRepository.findAllByCode(code).stream()
                .filter(Department::getActivated)
                .anyMatch(e -> e.getCode().equals(code));
    }
}
