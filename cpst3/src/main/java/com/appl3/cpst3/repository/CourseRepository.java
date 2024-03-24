package com.appl3.cpst3.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.appl3.cpst3.domain.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // 전공에 해당하는 강의 조회하는 기능
    @Query("SELECT c FROM Course c WHERE c.major = :major")
    List<Course> findByMajor(@Param("major") String major);

    // 강의 이름을 입력받아 입력받은 과목을 조회하는 기능
    List<Course> findByName(String name);

    // 수업 요일과 수업 시작 시간을 선택해 해당 시간에 해당하는 강의를 조회하는 기능
    @Query("SELECT c FROM Course c WHERE c.day = :day AND c.timeStart = :timeStart")
    List<Course> findByDayAndTime(@Param("day") String day, @Param("timeStart") String timeStart);
}
