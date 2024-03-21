package com.appl3.cpst3.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentCode; // 학생 코드 (PK, FK)
    private String idNumber; // 학생 식별 번호
    private String name; // 학생 이름
    private String major; // 주전공
    private String doubleMajor; // 복수전공
    private int grade; // 학년
    private int term; // 학기
    private int numCourses; // 수강한 과목 수
    private boolean preGraduation; // 졸업예정자
    private boolean excellent; // 성적우수자 여부
    private boolean doubleMajorcheck; // 복수전공자 여부

 // 성적우수자 여부 반환
    public boolean isExcellent() {
        return this.excellent;
    }

    // 복수전공자 여부 반환
    public boolean isDoubleMajorcheck() {
        return this.doubleMajorcheck;
    }

    // 졸업예정자 여부 반환
    public boolean isPreGraduation() {
        return this.preGraduation;
    }
    
    private int admissionYear; // 개설년도
    private int admissionSemester; // 개설학기
    private int acquiredCredits; // 취득기준 학점
    private boolean academicWarning; // 학사경고
    private int remainingCredits; // 남은학점
    private int additionalCredits; // 추가된 수강가능 학점
    private int totalCredits; // 수강가능 학점
    private int appliedCredits; // 신청학점
    private int remainingMileage; // 잔여 마일리지
    private int appliedMileage; // 신청 마일리지
    
    // 개설년도에 대한 getter 메서드
    public int getAdmissionYear() {
        return admissionYear;
    }

    // 개설년도에 대한 setter 메서드
    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    // 개설학기에 대한 getter 메서드
    public int getAdmissionSemester() {
        return admissionSemester;
    }

    // 개설학기에 대한 setter 메서드
    public void setAdmissionSemester(int admissionSemester) {
        this.admissionSemester = admissionSemester;
    }

    // 취득기준 학점에 대한 getter 메서드
    public int getAcquiredCredits() {
        return acquiredCredits;
    }

    // 취득기준 학점에 대한 setter 메서드
    public void setAcquiredCredits(int acquiredCredits) {
        this.acquiredCredits = acquiredCredits;
    }

    // 학사경고 여부에 대한 getter 메서드
    public boolean isAcademicWarning() {
        return academicWarning;
    }

    // 학사경고 여부에 대한 setter 메서드
    public void setAcademicWarning(boolean academicWarning) {
        this.academicWarning = academicWarning;
    }

    // 남은학점에 대한 getter 메서드
    public int getRemainingCredits() {
        return remainingCredits;
    }

    // 남은학점에 대한 setter 메서드
    public void setRemainingCredits(int remainingCredits) {
        this.remainingCredits = remainingCredits;
    }

    // 추가된 수강가능 학점에 대한 getter 메서드
    public int getAdditionalCredits() {
        return additionalCredits;
    }

    // 추가된 수강가능 학점에 대한 setter 메서드
    public void setAdditionalCredits(int additionalCredits) {
        this.additionalCredits = additionalCredits;
    }

    // 수강가능 학점에 대한 getter 메서드
    public int getTotalCredits() {
        return totalCredits;
    }

    // 수강가능 학점에 대한 setter 메서드
    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    // 신청학점에 대한 getter 메서드
    public int getAppliedCredits() {
        return appliedCredits;
    }

    // 신청학점에 대한 setter 메서드
    public void setAppliedCredits(int appliedCredits) {
        this.appliedCredits = appliedCredits;
    }

    // 잔여 마일리지에 대한 getter 메서드
    public int getRemainingMileage() {
        return remainingMileage;
    }

    // 잔여 마일리지에 대한 setter 메서드
    public void setRemainingMileage(int remainingMileage) {
        this.remainingMileage = remainingMileage;
    }

    // 신청 마일리지에 대한 getter 메서드
    public int getAppliedMileage() {
        return appliedMileage;
    }

    // 신청 마일리지에 대한 setter 메서드
    public void setAppliedMileage(int appliedMileage) {
        this.appliedMileage = appliedMileage;
    }
}
