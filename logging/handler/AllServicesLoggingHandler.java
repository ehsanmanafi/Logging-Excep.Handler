package corp.spgc.mineralwater.logging.handler;

import corp.spgc.mineralwater.collection.LoggingData;
import corp.spgc.mineralwater.service.LoggingDataService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class AllServicesLoggingHandler {
    private final LoggingDataService loggingDataService;
    @Autowired
    public AllServicesLoggingHandler(LoggingDataService loggingDataService) {
        this.loggingDataService = loggingDataService;
    }

    @Around("corp.spgc.mineralwater.logging.definition.pointCut.ApplicationPointCut.allServicesPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    LocalDateTime startLocalDateTime = LocalDateTime.now();
    Object returnProceed = joinPoint.proceed();
    LocalDateTime endLocalDateTime = LocalDateTime.now();
    // implement logging Tool set
    loggingDataService.insertLoggingData(new LoggingData(null,joinPoint.toString(),
            "User Taken From Token",startLocalDateTime.toString(),endLocalDateTime.toString()));
    return returnProceed;
}
}
