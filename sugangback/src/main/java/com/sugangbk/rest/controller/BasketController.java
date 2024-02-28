package com.sugangbk.rest.controller;

import com.sugangbk.rest.aop.annotation.PermitStudent;
import com.sugangbk.rest.entity.Basket;
import com.sugangbk.rest.entity.Course.Course;
import com.sugangbk.rest.entity.member.Student;
import com.sugangbk.rest.exception.exception.NoExistEntityException;
import com.sugangbk.rest.repository.BasketRepository;
import com.sugangbk.rest.repository.CourseRepository;
import com.sugangbk.rest.repository.StudentRepository;
import com.sugangbk.rest.service.BasketService;
import com.sugangbk.rest.session.SessionConst;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/basket")
@RequiredArgsConstructor
@Transactional
public class BasketController {

    private final BasketService basketService;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final BasketRepository basketRepository;

    @PermitStudent
    @PostMapping("/put")
    void putBasket(
            @Parameter(hidden = true) @SessionAttribute(name = SessionConst.LOGIN_STUDENT, required = false) Long studentId,
            @RequestParam Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(NoExistEntityException::new);
        Student student = studentRepository.findById(studentId).orElseThrow(NoExistEntityException::new);

        basketService.put(student, course);
    }

    @PermitStudent
    @PostMapping("/erase")
    void eraseBasket(@RequestParam Long basketId) {
        Basket basket = basketRepository.findById(basketId).orElseThrow();

        basketService.erase(basket);
    }
}
