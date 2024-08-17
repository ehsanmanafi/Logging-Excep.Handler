package corp.spgc.mineralwater.logging.definition.pointCut;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointCut {
    @Pointcut("execution(* corp.spgc.mineralwater.service.PersonnelService.*(..))")
    public void personnelServicePointCut() {}

    @Pointcut("execution(* corp.spgc.mineralwater.service.AllocationService.*(..))")
    public void allocationServicePointCut() {}

    @Pointcut("execution(* corp.spgc.mineralwater.service.ReservationService.*(..))")
    public void reservationServicePointCut() {}

    @Pointcut("execution(* corp.spgc.mineralwater.service.ScheduleService.*(..))")
    public void scheduleServicePointCut() {}

    @Pointcut("personnelServicePointCut() || allocationServicePointCut() || " +
              "reservationServicePointCut() || scheduleServicePointCut()")
    public void allServicesPointCut(){}

    @Pointcut("@annotation(corp.spgc.mineralwater.logging.definition.annotation.LoggingSomeData)")
    public void LoggingSomeDataPointCut(){}
}
