package me.junhyeokseo.springcorebasic.discount;

import me.junhyeokseo.springcorebasic.member.Grade;
import me.junhyeokseo.springcorebasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
	private final int discountPercent = 10;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP)
			return price * discountPercent / 100;
		return 0;
	}
}
