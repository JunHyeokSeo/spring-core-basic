package me.junhyeokseo.springcorebasic;

import me.junhyeokseo.springcorebasic.member.Grade;
import me.junhyeokseo.springcorebasic.member.Member;
import me.junhyeokseo.springcorebasic.member.MemberService;
import me.junhyeokseo.springcorebasic.member.MemberServiceImpl;

public class MemberApp {
	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();

		Member member = new Member(1L, "memberA", Grade.VIP);

		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("findMember = " + findMember.getName());
	}
}
