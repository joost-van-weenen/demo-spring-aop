package com.example.demo.aspects;

import com.example.demo.ignite.IgniteException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NestedCheckedException;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class IgniteExceptionUnwrappingAspect {
    private static Logger log = LoggerFactory.getLogger(IgniteExceptionUnwrappingAspect.class);


    @Pointcut("within(com.example.demo.ignite.IgniteBrugRepository)")
    public void allIgniteRepositoriesPointCut() {
        // Reusable pointcut expression
    }

    @Around("allIgniteRepositoriesPointCut()")
//    @Around("within(com.example.demo.ignite.IgniteBrugRepository)") // Same as using the allIgniterepositoriesPointCut() name
    public void unwrap(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            log.info("==== BEFORE CALLING CONTROLLER ===");
            joinPoint.proceed();
            log.info("==== AFTER CALLING CONTROLLER ===");
        } catch (IgniteException ex) {
            log.info("==== IN CATCH ===");

            //            log.info("Found Exception", ex);
            Throwable cause = NestedExceptionUtils.getMostSpecificCause(ex);
            log.info("Unwrap exception {} => {}", ex.getClass().getName(), cause.getClass().getName());
            throw cause;
        } finally {
            log.info("==== IN FINALLY ===");

        }


    }
}
