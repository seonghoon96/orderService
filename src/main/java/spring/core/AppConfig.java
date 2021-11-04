package spring.core;

import spring.core.discount.DiscountPolicy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.discount.RateDiscountPolicy;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;


/*

 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
 AppConfig는 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입해준다.

 */

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();  // 고정 할인 적용
        return new RateDiscountPolicy(); // 정율 할인 적용
    }

}

