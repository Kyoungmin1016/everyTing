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
		System.out.println("[BeforMehod] : �޼ҵ� ȣ�� ��");
		Signature sig = jp.getSignature();
		System.out.println("�޼ҵ� �̸�:"+sig.getName());
	}
	
	@AfterThrowing(value="execution(* org.tukorea.free.service.BoardService.*(..))", throwing="ex")
	public void afterThrowingMethod(Throwable ex) {
		System.out.println("[AfterThrowingMethod]: ���� �߻� ��");
		System.out.println("exception value="+ex.toString());
	}
}