package ch03.assembler;

import ch03.spring.ChangePasswordService;
import ch03.spring.MemberDao;
import ch03.spring.MemberRegisterService;
import lombok.Getter;

@Getter
public class Assembler {

    private MemberDao memberDao;
    private MemberRegisterService memberRegisterService;
    private ChangePasswordService changePasswordService;

    public Assembler() {
        memberDao = new MemberDao();
        memberRegisterService = new MemberRegisterService(memberDao);
        changePasswordService = new ChangePasswordService();
        changePasswordService.setMemberDao(memberDao);
    }


}
