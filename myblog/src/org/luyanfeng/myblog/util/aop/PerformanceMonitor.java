package org.luyanfeng.myblog.util.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceMonitor {
	
	
	public Object methodMonitor(ProceedingJoinPoint pjp ) throws Throwable{
		Object proceed = null;
		System.out.println("********开始处理 类"+pjp.getTarget()+"*******");
		proceed = pjp.proceed(pjp.getArgs());
		System.out.println(" 方法 "+pjp.getSignature().getName()+" return : "+ proceed);
		System.out.println("********处理完成 类"+pjp.getTarget()+"********");
		return proceed;
	}

}
