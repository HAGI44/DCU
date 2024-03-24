package com.appl3.cpst3.service; // 이 서비스는 com.appl3.cpst3.service 패키지에 속합니다.

import com.appl3.cpst3.domain.entity.Student; // Student 엔티티를 사용하기 위한 import문
import org.springframework.stereotype.Service; // Service 어노테이션을 사용하기 위한 import문

@Service // Spring에 의해 관리되는 서비스 클래스임을 나타냄
public class CalculationService { // 계산 서비스 클래스

    // 학생 정보에서 마일리지를 계산하는 메서드
    public int calculateMileage(Student student) { // 학생의 정보를 받아 마일리지를 계산하는 메서드
        int baseMileage = 100; // 기본 마일리지
        int extraMileage = 0; // 추가 마일리지

        // 성적우수자나 복수전공자는 기본 마일리지에 10을 추가
        if (student.isExcellent() || student.isDoubleMajorcheck()) { // 학생이 성적우수자이거나 복수전공자인 경우
            extraMileage += 10; // 추가 마일리지에 10을 더함
        }

        return baseMileage + extraMileage; // 기본 마일리지와 추가 마일리지를 합하여 반환
    }

    // 학생 정보에서 수강 학점을 계산하는 메서드
    public int calculateCredits(Student student) { // 학생의 정보를 받아 수강 학점을 계산하는 메서드
        int baseCredits = 19; // 기본 수강 학점

        // 성적우수자나 복수전공자는 최대 수강 학점이 3점 늘어남
        if (student.isExcellent() || student.isDoubleMajorcheck()) { // 학생이 성적우수자이거나 복수전공자인 경우
            baseCredits += 3; // 기본 수강 학점에 3을 더함
        }

        return baseCredits; // 최종 수강 학점 반환
    }

    // 가산점을 계산하는 메서드
    public int calculateBonusPoints(Student student, boolean isFirstTimeTakingCourse, boolean isMajorRequired, int numberOfCoursesTakenThisSemester) { // 학생 정보와 각종 조건을 받아 가산점을 계산하는 메서드
        int bonusPoints = 0; // 가산점 초기화

        // 졸업 예정자에게는 40점 부여
        if (student.isPreGraduation()) { // 학생이 졸업 예정자인 경우
            bonusPoints += 40; // 가산점에 40을 더함
        }

        // 처음 수강하는 과목에게는 30점 부여
        if (isFirstTimeTakingCourse) { // 학생이 처음 수강하는 과목인 경우
            bonusPoints += 30; // 가산점에 30을 더함
        }

        // 전공 필수 또는 전공 선택 과목인 경우 20점 부여
        if (isMajorRequired) { // 과목이 전공 필수 또는 전공 선택인 경우
            bonusPoints += 20; // 가산점에 20을 더함
        }

        // 이번 학기에 수강한 과목 당 1점씩 최대 10점까지 부여
        bonusPoints += Math.min(numberOfCoursesTakenThisSemester, 10); // 학기에 수강한 과목 수와 10 중 작은 값을 가산점에 더함

        return bonusPoints; // 최종 가산점 반환
    }
}
