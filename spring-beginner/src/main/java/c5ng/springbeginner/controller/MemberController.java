package c5ng.springbeginner.controller;

import c5ng.springbeginner.domain.Member;
import c5ng.springbeginner.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller /* Spring Container가 @Controller Annotaion이 있는 클래스를 객체로 생성하여 관리한다. */
public class MemberController {

    private final MemberService memberService;
    /* private final MemberService memberService = new MemberService();
     * 만약 위와 같이 new로 생성한다면 다른 클래스에서 new로 계속 생성 시 많은 인스턴스가 생성 된다. */

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    /* 생성자를 생성하여 @Autowired 어노테이션을 사용하면 memberService를 스프링 컨테이너에서 가져와 연결 시켜줌 */

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }
}
