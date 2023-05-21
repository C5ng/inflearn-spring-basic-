package c5ng.springbeginner.repository;

import c5ng.springbeginner.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    /* 테스트들은 순서와 상관없이 작동 즉 설계 할 때 순서 상관없이 (의존관계 없이) 통과 할 수 있게 설계해야 한다. */
    MemoryMemberRepository repository = new MemoryMemberRepository();
    /* @Test Annotation을 적으면 바로 실행 가능
    * Assertions 클래스를 사용하면 테스트 가능 */

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    /* @AfterEach 메서드가 끝나고 실행되는 메서드 */

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByName("Spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
