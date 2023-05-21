package c5ng.springbeginner.service;

import c5ng.springbeginner.domain.Member;
import c5ng.springbeginner.repository.MemberRepository;
import c5ng.springbeginner.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } /* 외부에서 repository를 줌 DI */

    /* 회원 가입 */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원 X
        vaildateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /* 전체 회원 조회 */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
