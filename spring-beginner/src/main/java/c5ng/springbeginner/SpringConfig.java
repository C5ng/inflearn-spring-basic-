package c5ng.springbeginner;

import c5ng.springbeginner.repository.MemberRepository;
import c5ng.springbeginner.repository.MemoryMemberRepository;
import c5ng.springbeginner.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    /* 직접 빈을 등록하는 방법 */

//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
