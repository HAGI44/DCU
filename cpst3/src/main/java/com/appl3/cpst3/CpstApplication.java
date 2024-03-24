package com.appl3.cpst3; // 이 패키지는 com.appl3.cpst3로 정의되어 있음

import org.springframework.boot.SpringApplication; // Spring Boot 애플리케이션을 시작하는 데 사용되는 클래스를 가져옴
import org.springframework.boot.autoconfigure.SpringBootApplication; // Spring Boot 애플리케이션의 자동 구성을 활성화하는 데 사용되는 어노테이션을 가져옴

@SpringBootApplication // 이 어노테이션은 Spring Boot 애플리케이션의 주요 구성 요소 중 하나인 자동 구성을 활성화함
public class CpstApplication {

    public static void main(String[] args) { // 메인 메소드 - Java 애플리케이션의 시작점
        SpringApplication.run(CpstApplication.class, args); // Spring Boot 애플리케이션을 시작하는 메소드. CpstApplication 클래스를 기반으로 애플리케이션을 실행함
    }

}
