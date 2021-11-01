package hello.core.member;

import static org.assertj.core.api.Assertions.*;

import hello.core.config.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void joinTest() {
        //1. Given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //2. When
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        //3. Then
        assertThat(findMember).isEqualTo(member);
    }

    /*
    * Test Code는
    * 1. given -> 변수 주어진거
    * 2. when -> 어떻게 했을때
    * 3. then -> 어떤걸 검증
    *
    * */


}