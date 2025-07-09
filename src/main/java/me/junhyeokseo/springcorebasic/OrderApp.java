package me.junhyeokseo.springcorebasic;

import me.junhyeokseo.springcorebasic.member.Grade;
import me.junhyeokseo.springcorebasic.member.Member;
import me.junhyeokseo.springcorebasic.member.MemberService;
import me.junhyeokseo.springcorebasic.member.MemberServiceImpl;
import me.junhyeokseo.springcorebasic.order.Order;
import me.junhyeokseo.springcorebasic.order.OrderService;
import me.junhyeokseo.springcorebasic.order.OrderServiceImpl;

public class OrderApp {
	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		OrderService orderService = new OrderServiceImpl();

		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);

		System.out.println("order = " + order);
		System.out.println("order.calculatePrice() = " + order.calculatePrice());
	}
}
