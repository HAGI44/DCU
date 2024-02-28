package com.sugangbk.rest.aop;

import com.sugangbk.rest.exception.exception.NotAuthenticatedException;
import com.sugangbk.rest.session.SessionConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
@Aspect
public class LoginAdminSessionAuthenticator {

    private static final Logger log = LoggerFactory.getLogger(LoginAdminSessionAuthenticator.class);

    @Around("@annotation(com.sugangbk.rest.aop.annotation.PermitAdmin)")
    public Object doAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
        if(session == null || session.getAttribute(SessionConst.LOGIN_ADMIN) == null) {
            log.info("접근 거부");
            throw new NotAuthenticatedException();
        }
        return proceedingJoinPoint.proceed();
    }
}
