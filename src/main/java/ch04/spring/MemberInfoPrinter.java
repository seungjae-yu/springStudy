package ch04.spring;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Autowired
    public void setMemberPrinter(MemberPrinter memberPrinter) {
        this.memberPrinter = memberPrinter;
    }

    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if(member == null) {
            System.out.println("no data");
        }

        memberPrinter.print(member);
        System.out.println();
    }
}
