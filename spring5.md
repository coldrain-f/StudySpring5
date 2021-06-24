모든 메이븐 프로젝트는 프로젝트의 루트 폴더에 pom.xml 파일을 갖는다.

pom.xml은 메이븐 프로젝트에 대한 설정 정보를 관리하는 파일로서

프로젝트에서 필요로 하는 의존 모듈이나 플러그인 등에 대한 설정을 담는다.

메이븐은 한 개의 모듈을 아티팩트라는 단위로 관리한다.

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.0.2.RELEASE</version>
    </dependency>
</dependencies>
```

메이븐 프로젝트의 소스 코드를 컴파일하고 실행할 때 사용할 클래스 패스에

spring-context-5.0.2.RELEASE.jar 파일을 추가한다는 것을 의미한다.

(아티팩트이름-버전.jar)



의존(Dependency)이란?

한 클래스가 다른 클래스의 메서드를 실행할 때 이를 `의존`한다고 표현한다.

의존은 변경에 의해 영향을 받는 관계를 의미한다.

MemberDao의 insert()메서드의 이름을 insertMember()로 변경하면 이 메서드를 사용하는 MemberRegisterService 클래스의 소스 코드도 함께 변경된다. 이렇게 변경에 따른 영향이 전파되는 관계를 의존한다고 표현한다.



1.

→ A가 변경되었을 때, A를 사용하고 있는 B의 소스 코드도 같이 변경되어야 한다면 B가 A를 의존한다고 한다.

2.

→ B가 A의 메서드를 실행하고 있다면 B가 A를 의존한다고 한다.



의존 주입(Dependency Injection)이란?

의존하는 객체를 직접 생성하는 대신 의존 객체를 전달받는 방식을 사용한다.

 