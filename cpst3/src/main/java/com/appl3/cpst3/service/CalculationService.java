package com.appl3.cpst3.service;

import com.appl3.cpst3.domain.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    // 학생 정보에서 마일리지를 계산하는 메서드
    public int calculateMileage(Student student) {
        int baseMileage = 100;
        int extraMileage = 0;
        
        // 성적우수자나 복수전공자는 기본 마일리지에 10을 추가
        if (student.isExcellent() || student.isDoubleMajor()) {
            extraMileage += 10;
        }
        
        return baseMileage + extraMileage;
    }

    // 학생 정보에서 수강 학점을 계산하는 메서드
    public int calculateCredits(Student student) {
        int baseCredits = 19;
        
        // 성적우수자나 복수전공자는 최대 수강 학점이 3점 늘어남
        if (student.isExcellent() || student.isDoubleMajor()) {
            baseCredits += 3;
        }
        
        return baseCredits;
    }

    // 가산점을 계산하는 메서드
    public int calculateBonusPoints(Student student, boolean isFirstTimeTakingCourse, boolean isMajorRequired, int numberOfCoursesTakenThisSemester) {
        int bonusPoints = 0;
        
        // 졸업 예정자에게는 40점 부여
        if (student.isPreGradu()) {
            bonusPoints += 40;
        }
        
        // 처음 수강하는 과목에게는 30점 부여
        if (isFirstTimeTakingCourse) {
            bonusPoints += 30;
        }
        
        // 전공 필수 또는 전공 선택 과목인 경우 20점 부여
        if (isMajorRequired) {
            bonusPoints += 20;
        }
        
        // 이번 학기에 수강한 과목 당 1점씩 최대 10점까지 부여
        bonusPoints += Math.min(numberOfCoursesTakenThisSemester, 10);
        
        return bonusPoints;
    }
}
