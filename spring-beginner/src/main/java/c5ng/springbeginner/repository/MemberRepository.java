package c5ng.springbeginner.repository;

import c5ng.springbeginner.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); /* Optional = null 처리 */
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
