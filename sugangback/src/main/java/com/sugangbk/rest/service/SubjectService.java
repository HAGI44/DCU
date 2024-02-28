package com.sugangbk.rest.service;

import com.sugangbk.rest.entity.Subject;
import com.sugangbk.rest.exception.exception.DuplicatedEntityException;
import com.sugangbk.rest.repository.SubjectRepository;
import com.sugangbk.rest.service.dto.SubjectMakeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    public Subject make(SubjectMakeDTO subjectMakeDTO){
        if(isDuplicatedSubject(subjectMakeDTO.getCode()))
            throw new DuplicatedEntityException("과목코드가 중복됩니다");

        Subject subject = modelMapper.map(subjectMakeDTO, Subject.class);
        return subjectRepository.save(subject);
    }

    public void inactive(Subject subject){
        subject.setActivated(false);
    }

    private boolean isDuplicatedSubject(Integer code) {
        return subjectRepository.findAllByCode(code).stream()
                .filter(Subject::getActivated)
                .anyMatch(e -> e.getCode().equals(code));
    }
}
