package tn.esprit.kaddem.configuration;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before(" execution(* tn.esprit.kaddem.Services.ContratService.*(..)) ")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @After(" execution(* tn.esprit.kaddem.Services.*.*(..)) ")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method " + name + " : ");
    }
    @AfterReturning(" execution(* tn.esprit.kaddem.Services.*.*(..)) ")
    public void logMethodExitReturn(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("AfterReturning of method " + name + " : ");
    }
    @AfterThrowing(" execution(* tn.esprit.kaddem.Services.*.*(..)) ")
    public void logMethodExitThrowing(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("AfterThrowing of method " + name + " : ");
    }
}
