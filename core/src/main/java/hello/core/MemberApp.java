package hello.core;

import hello.core.config.AppConfig;
import hello.core.member.*;

public class MemberApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);

        Member findMember = memberService.findMember(member.getId());


    }
}
