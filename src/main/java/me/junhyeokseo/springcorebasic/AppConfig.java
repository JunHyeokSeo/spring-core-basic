package me.junhyeokseo.springcorebasic;

import me.junhyeokseo.springcorebasic.discount.DiscountPolicy;
import me.junhyeokseo.springcorebasic.discount.RateDiscountPolicy;
import me.junhyeokseo.springcorebasic.member.MemberRepository;
import me.junhyeokseo.springcorebasic.member.MemberService;
import me.junhyeokseo.springcorebasic.member.MemberServiceImpl;
import me.junhyeokseo.springcorebasic.member.MemoryMemberRepository;
import me.junhyeokseo.springcorebasic.order.OrderService;
import me.junhyeokseo.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
	}
}
