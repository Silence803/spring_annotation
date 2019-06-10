package com.example.demo.aop;

import com.example.demo.annotation.AuthCheck;
import com.example.demo.domain.Auth;
import com.example.demo.domain.ResponseBaseDTO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Creat by ZhangXueRong on 2019/6/10
 */
@Aspect
@Component
public class AuthCheckAspect {

    private static final Logger logger = LoggerFactory.getLogger(AuthCheck.class);

    @Around("@annotation(check)")
    public Object doAround(ProceedingJoinPoint joinPoint, AuthCheck check) throws Throwable {
        int[] auths = check.value();

        for (int auth:auths){
            if (auth == Auth.NEED_LOGIN){
                RequestAttributes ra = RequestContextHolder.getRequestAttributes();
                ServletRequestAttributes sra = (ServletRequestAttributes) ra;
                HttpServletRequest request = Objects.requireNonNull(sra).getRequest();
                logger.info("uri:{}", request.getRequestURI());
                HttpServletResponse response = sra.getResponse();
                if (request == null || response == null) {
                    return null;
                }
                String token = request.getHeader("ACCESS_TOKEN");
                if (StringUtils.isEmpty(token)) {
                    return new ResponseBaseDTO("400001", "请先登录", null, false);
                }
                response.setHeader("ACCESS_TOKEN", token);
            }
        }
        return joinPoint.proceed();
    }
}
