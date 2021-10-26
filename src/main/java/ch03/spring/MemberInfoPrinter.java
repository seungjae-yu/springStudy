package ch03.spring;

import lombok.Setter;

@Setter
public class MemberInfoPrinter {

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
