package logging.aspect;

import logging.annotations.Loggable;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Aspect
public class LoggableAspect {

    @Pointcut("execution(* *(..))")
    private void pointcut() {
    }

    @Around("pointcut() && @annotation(loggable)")
    public Object around(ProceedingJoinPoint joinPoint, Loggable loggable) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        int argsCount = joinPoint.getArgs().length;

        if(!loggable.message().equals("")) {
            log.info("");
            log.info(loggable.message());
        }

        String args = "";

        if(argsCount > 0) {
            args = "incoming arguments count: " + argsCount;

            if (loggable.logArguments()) {
                args = Stream.of(joinPoint.getArgs())
                        .map(a -> a != null ? a.toString() : "null")
                        .collect(Collectors.joining(", "));
            }
        }

        log.info("Invoked: \t\t" + method.getName() + "(" + args + "), " + method.getDeclaringClass().getSimpleName() + ".java");

        return joinPoint.proceed();
    }

    @AfterReturning(pointcut = "pointcut() && @annotation(loggable)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Loggable loggable, Object result){

        if (null != result && loggable.logReturnedInfo())
            log.info("returned:\t\t"  + joinPoint.getSignature().getName() +
                    "(..)\t\tvalue:  " + result + ", type: " + result.getClass().getSimpleName() +"\n");
    }


}