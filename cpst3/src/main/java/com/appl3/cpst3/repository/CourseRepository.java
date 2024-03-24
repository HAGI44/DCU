package com.appl3.cpst3.repository; // 이 패키지는 com.appl3.cpst3.repository로 정의됨

import java.util.List; // 리스트를 사용하기 위한 import문
import org.springframework.data.jpa.repository.JpaRepository; // JpaRepository를 사용하기 위한 import문
import org.springframework.data.jpa.repository.Query; // 쿼리 어노테이션을 사용하기 위한 import문
import org.springframework.data.repository.query.Param; // 파라미터를 사용하기 위한 import문
import com.appl3.cpst3.domain.entity.Course; // Course 엔티티를 사용하기 위한 import문

public interface CourseRepository extends JpaRepository<Course, Long> { // Course 엔티티에 대한 JpaRepository를 상속하는 CourseRepository 인터페이스

    // 전공에 해당하는 강의를 조회하는 메소드
    @Query("SELECT c FROM Course c WHERE c.major = :major") // JPQL 쿼리를 사용하여 전공에 해당하는 강의를 조회
    List<Course> findByMajor(@Param("major") String major); // major 파라미터를 받아 해당 전공에 해당하는 강의를 조회하는 메소드

    // 강의 이름을 입력받아 해당 과목을 조회하는 메소드
    List<Course> findByName(String name); // 강의 이름을 받아 해당 과목을 조회하는 메소드

    // 수업 요일과 수업 시작 시간을 선택하여 해당 시간에 해당하는 강의를 조회하는 메소드
    @Query("SELECT c FROM Course c WHERE c.day = :day AND c.timeStart = :timeStart") // JPQL 쿼리를 사용하여 요일과 시간에 해당하는 강의를 조회
    List<Course> findByDayAndTime(@Param("day") String day, @Param("timeStart") String timeStart); // day와 timeStart 파라미터를 받아 해당 요일과 시간에 해당하는 강의를 조회하는 메소드
}
