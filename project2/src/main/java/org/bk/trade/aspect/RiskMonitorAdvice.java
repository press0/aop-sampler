package org.bk.trade.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RiskMonitorAdvice {

    private static Logger logger = LoggerFactory.getLogger(RiskMonitorAdvice.class);

    public void beforeMethod(JoinPoint joinpoint) {
    	logger.info("--------------------------------------------------------------------------------------");
        logger.info("before method: {}", joinpoint.getSignature().toShortString());
    }
    
    public Object aroundMethod(ProceedingJoinPoint joinpoint) {
        try {
        	String methodName = joinpoint.getSignature().toShortString();
            long start = System.nanoTime();
            Object result = joinpoint.proceed();
            long end = System.nanoTime();
            logger.info(String.format("%s took %d ns", methodName, (end - start)));
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    public void afterMethod(JoinPoint joinpoint) {
        logger.info("after method: {}", joinpoint.getSignature().toShortString());
    }    
        
}