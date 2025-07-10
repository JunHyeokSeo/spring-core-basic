package me.junhyeokseo.springcorebasic.order;

import me.junhyeokseo.springcorebasic.discount.DiscountPolicy;
import me.junhyeokseo.springcorebasic.member.Member;
import me.junhyeokseo.springcorebasic.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}
