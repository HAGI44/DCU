package com.sugangbk.rest.service;

import com.sugangbk.rest.entity.Basket;
import com.sugangbk.rest.entity.Course.Course;
import com.sugangbk.rest.entity.member.Student;
import com.sugangbk.rest.exception.exception.DuplicatedEntityException;
import com.sugangbk.rest.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BasketService {

    private final BasketRepository basketRepository;

    public Basket put(Student student, Course course) {
        if (isDuplicatedBasket(student, course))
            throw new DuplicatedEntityException();

        Basket basket = Basket.builder()
                .student(student)
                .course(course)
                .build();

        return basketRepository.save(basket);
    }

    private boolean isDuplicatedBasket(Student student, Course course) {
        return student.getBaskets().stream()
                .map(Basket::getCourse)
                .anyMatch(e -> e.getSubject().getCode().equals(course.getSubject().getCode())
                        && e.getProfessor().getId().equals(course.getProfessor().getId())
                        && e.getDivision().equals(course.getDivision()));
    }

    public void erase(Basket basket) {
        basketRepository.delete(basket);
        basketRepository.flush();
    }
}
