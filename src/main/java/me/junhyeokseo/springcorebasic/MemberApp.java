package me.junhyeokseo.springcorebasic;

import me.junhyeokseo.springcorebasic.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = ac.getBean("memberService", MemberService.class);

		Member member = new Member(1L, "memberA", Grade.VIP);

		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("findMember = " + findMember.getName());
	}
}
