package com.appl3.cpst3.domain.entity; // 이 패키지는 com.appl3.cpst3.domain.entity로 정의됨

import lombok.AllArgsConstructor; // 모든 인자를 받는 생성자를 자동으로 생성하기 위한 어노테이션을 가져옴
import lombok.Getter; // 클래스의 모든 필드에 대한 게터 메소드를 자동으로 생성하기 위한 어노테이션을 가져옴
import lombok.NoArgsConstructor; // 파라미터가 없는 생성자를 자동으로 생성하기 위한 어노테이션을 가져옴
import lombok.Setter; // 클래스의 모든 필드에 대한 세터 메소드를 자동으로 생성하기 위한 어노테이션을 가져옴

import jakarta.persistence.Entity; // JPA 엔티티임을 나타내기 위한 어노테이션을 가져옴
import jakarta.persistence.GeneratedValue; // 자동 생성된 값의 생성 전략을 지정하기 위한 어노테이션을 가져옴
import jakarta.persistence.GenerationType; // 엔티티의 기본 키를 생성하는 전략을 지정하기 위한 열거형을 가져옴
import jakarta.persistence.Id; // 엔티티의 기본 키를 지정하기 위한 어노테이션을 가져옴

@Entity // JPA 엔티티임을 나타내는 어노테이션
@Getter // 클래스의 모든 필드에 대한 게터 메소드를 자동으로 생성하는 어노테이션
@Setter // 클래스의 모든 필드에 대한 세터 메소드를 자동으로 생성하는 어노테이션
@NoArgsConstructor // 파라미터가 없는 생성자를 자동으로 생성하는 어노테이션
@AllArgsConstructor // 모든 인자를 받는 생성자를 자동으로 생성하는 어노테이션
public class Student { // 학생 정보를 나타내는 엔티티 클래스

    @Id // 엔티티의 기본 키를 지정하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 엔티티의 기본 키 값을 자동으로 생성하는 전략을 지정하는 어노테이션
    private Long id; // 학생 정보의 식별자로 사용되는 필드

    private String studentCode; // 학생 코드를 나타내는 필드로, 주 키(PK) 및 외부 키(FK)로 사용된다.
    private String passwd; // 학생 비밀 번호를 나타내는 필드
    private String idNumber; // 학생 식별 번호를 나타내는 필드
    private String name; // 학생 이름을 나타내는 필드
    private String major; // 주전공을 나타내는 필드
    private String doubleMajor; // 복수전공을 나타내는 필드
    private int grade; // 학년을 나타내는 필드
    private int term; // 학기를 나타내는 필드
    private int numCourses; // 수강한 과목 수를 나타내는 필드
    private boolean preGraduation; // 졸업예정자 여부를 나타내는 필드
    private boolean excellent; // 성적우수자 여부를 나타내는 필드
    private boolean doubleMajorcheck; // 복수전공자 여부를 나타내는 필드

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
    
    private int admissionYear; // 개설년도를 나타내는 필드
    private int admissionSemester; // 개설학기를 나타내는 필드
    private int acquiredCredits; // 취득기준 학점을 나타내는 필드
    private boolean academicWarning; // 학사경고 여부를 나타내는 필드
    private int remainingCredits; // 남은학점을 나타내는 필드
    private int additionalCredits; // 추가된 수강가능 학점을 나타내는 필드
    private int totalCredits; // 수강가능 학점을 나타내는 필드
    private int appliedCredits; // 신청학점을 나타내는 필드
    private int remainingMileage; // 잔여 마일리지를 나타내는 필드
    private int appliedMileage; // 신청 마일리지를 나타내는 필드

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
