package hu.dpc.edu;

/**
 * Created by vrg on 19/10/16.
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class LoggerAspect {

    private static final Logger LOGGER = Logger.getLogger(LoggerAspect.class.getName());

    @Around("execution(* hu.dpc.edu.*.*(..))")
    public Object intercept(ProceedingJoinPoint joinPoint) throws Throwable {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info("Method called: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "(" + Arrays.toString(joinPoint.getArgs()) + ")");
        }
        return joinPoint.proceed();
    }
}
