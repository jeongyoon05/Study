# Mockito

> Mock: 객체와 비슷하게 동작하지만 프로그래머가 직접 그 객체의 행동을 관리하는 객체

> Mockito: Mock객체를 쉽게 만들고 관리하고 검증할 수 있는 방법을 제공해주는 프레임워크



협업 혹은 외부 API를 사용해서 개발을 해야하는 경우가 많다. 

그런데 협업하는 다른 개발자가 해당 API를 아직 구현하지 않았거나 외부 API가 현재 제공되지 않는다면, 그래서 내가 필요한 데이터를 받지 못한다면 어떻게 해야할까? 

테스트 케이스를 작성할때는 어떻게 해야할까? 



Mock객체 만들기

Mock객체를 만드는 방법은메서드를 통한 방법과 어노테이션을 이용하는 방법이 있는데 하나씩 알아보자.



mock() 메서드를 이용해 만드는 방법

```java
MemberService memberService = Mockito.mock(MemberService.class);
StudyRepository studyRepository = mock(StrudyRepository.class);
```

=> Mockito 클래스는 static하게 선언해서 생략이 가능하다.



### Mock객체 Stubbing

Mock객체를 생성해준 것 까지는 좋지만, 말 그대로 빈 껍데기이기 때문에 실제로 메서드 호출을 하면 제대로 동작을 하지 않는다. 모든 Mock객체의 기본적인 행동은 다음과 같다.

- Null을 반환한다.
- Primitive 타입은 기본 Primitive 값을 반환한다.
- 콜렉션은 비어있는 콜렉션을 반환한다.
- void 메서드는 예외를 던지지 않고 아무런 일도 발생하지 않는다.



##### Method Stub

> : 기본 코드를 흉내내어 아직 기존 코드를 임시로 대치하는 역할을 수행함으로써 아직 구현되지 않았거나 의존성을 떨어트리고 독립적인 테스트를 수행해야 하는경우 이점을 가질 수 있다.
