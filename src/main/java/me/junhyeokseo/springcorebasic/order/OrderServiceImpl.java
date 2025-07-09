package me.junhyeokseo.springcorebasic.order;

import me.junhyeokseo.springcorebasic.discount.DiscountPolicy;
import me.junhyeokseo.springcorebasic.discount.FixDiscountPolicy;
import me.junhyeokseo.springcorebasic.member.Member;
import me.junhyeokseo.springcorebasic.member.MemberRepository;
import me.junhyeokseo.springcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
	private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
}
