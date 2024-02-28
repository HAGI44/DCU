package com.appl.cpst.controllerAdvice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class LoginControllerAdvice {

    @ModelAttribute
    public void addModel(Model model, HttpServletRequest request) {
        String requestUri = request.getRequestURI();

        if (requestUri.contains("api")) {
            return;
        }

        if(requestUri.contains("session-login")) {
        	model.addAttribute("loginType", "session-login");
            model.addAttribute("pageName", "세션 로그인");
        }
    }
}
