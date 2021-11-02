package spring.core.member;

public interface MemberSerivce {
    //회원 가입, 회원 조회

    void join(Member member);

    Member findMember(Long memberId);

}
