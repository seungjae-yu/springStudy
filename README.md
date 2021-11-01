# springStudy
스프링 공부 / 2개의 큰 프로젝트로 구성
1. src/main/java
2. core

# 1. src/main/java (spring)
spring 5 framework 책을 보고 공부한 내용

# 2. core 프로젝트 (spring boot)
공부한 내용 토대로 실습코드 짜보면서 공부

---
* IoC (Inversion of Control)
 기존 프로그램은 클라이언트 구현 객체가 스스로 필요한 구현 객체를 생성하고, 연결하고, 실행함 -> 구현 객체가 프로그램의 제어 흐름을 스스로 제어  
 AppConfig를 사용해서 구현 객체는 자신의 로직을 실행하는 역할만 담당, 프로그램 제어 흐름은 AppConfig가 가져감.  
 ServiceImpl은 필요한 인터페이스를 호출하지만 어떤 구현객체가 실행될지는 모름  
 -> 프로그램의 제어 흐름을 직접 제어하는게 아니라 외부에서 관리 > IoC  
 
```c
   public class AppConfig {

      public MemberService memberService() {
          return new MemberServiceImpl(memberRepository());
      }

      public OrderService orderService(){
          return new OrderServiceImpl(memberRepository(), discountPolicy());
      }

      public MemberRepository memberRepository() {
          return new MemoryMemberRepository();
      }

      public DiscountPolicy discountPolicy() {
          //return new FixDiscountPolicy();
          //만약 Fixed -> Rate로 바꾸면 여기만 바꾸면된다!
          return new RateDiscountPolicy();
      }
      
   }
   
```

사용하는 코드에서는  
AppConfig appConfig = new AppConfig();  
MemberService memberService = appConfig.memberService(); 해서 가져옴

프레임워크 vs 라이브러리
* 프레임워크가 내가 작성한 코드를 제어하고, 대신 실행하면 프레임워크 (JUnit)
* 반면, 내가 작성한 코드가 직접 제어의 흐름을 담당하면 프레임워크가 아니라 라이브러리

---

* DI (Dependency Injection)  
 1. 정적인 클래스 의존관계  
 -> ex) OrderServiceImpl은 MemberRepository랑 DiscountPolicy에 의존  
 2. 실행시점에 결정되는 동적인 객체(인스턴스) 의존관계  
  **애플리케이션 실행시점(런타임)에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 실제 의존관계 연결  
  ==> 이것을 의존관계 주입(DI)라고 한다.**
 
