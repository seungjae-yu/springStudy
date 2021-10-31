package ch07_aop;

import ch07_aop.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator cal = ctx.getBean("calculator", Calculator.class);
        long fiveFact = cal.factorial(5);
        System.out.println("fiveFact = " + fiveFact);
        System.out.println(cal.getClass().getName());
        ctx.close();

        System.out.println("My Test!!");
    }
}
