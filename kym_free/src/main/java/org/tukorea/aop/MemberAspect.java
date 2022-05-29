package org.tukorea.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MemberAspect {
	
	@Before("execution(* org.tukorea.free.service.BoardService.*(..))")
	public void beforeMethod(JoinPoint jp) {
		System.out.println("[BeforMehod] : 메소드 호출 전");
		Signature sig = jp.getSignature();
		System.out.println("메소드 이름:"+sig.getName());
	}
	
	@AfterThrowing(value="execution(* org.tukorea.free.service.BoardService.*(..))", throwing="ex")
	public void afterThrowingMethod(Throwable ex) {
		System.out.println("[AfterThrowingMethod]: 예외 발생 후");
		System.out.println("exception value="+ex.toString());
	}
}