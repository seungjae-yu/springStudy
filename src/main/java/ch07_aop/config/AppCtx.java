package ch07_aop.config;

import ch07_aop.Calculator;
import ch07_aop.aspect.ExecTimeAspect;
import ch07_aop.RecCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
public class AppCtx {

    @Bean
    public ExecTimeAspect execTimeAspect() {
        return new ExecTimeAspect();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}
