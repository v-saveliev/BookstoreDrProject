package org.bookstore.app.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class ParametersLogger {
    private Logger logger = Logger.getLogger(this.getClass());

    @Before("@annotation(LoggerMark)")
    public void beforeMarkedMethods(JoinPoint joinPoint) {
        List<Object> argsList = Arrays.asList(joinPoint.getArgs());
        logger.info("the called method \"" + joinPoint.getSignature().toShortString()
                + "\" has arguments value:\n" + argsList.toString());
    }


}
