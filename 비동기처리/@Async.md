# @Async 

spring에서 Async, 즉 비동기 기능을 사용하는 방법

- @EnableAsync로 비동기 기능을 활성화
- 비동기로 동작을 원하는 메서드(public 메서드)에 @Async 어노테이션을 붙여준다.

위 두가지 행위로 spring에서 비동기 기능을 구현 할 수 있다.



- @EnableAsync: spring의 메서드의 비동기 기능을 활성화 해준다.

- ThreadPoolTaskExecutor로 비동기로 호출하는 Thread 대한 설정을 한다.
  - corePoolSize: 기본적으로 실행을 대기하고 있는 Thread의 갯수
  - MaxPoolSize: 동시 동작하는, 최대 Thread 갯수
  - QueueCapacity: MaxPoolSize를 초과하는 요청이 Thread 생성 요청시 해당 내용을 Queue에 저장하게 되고, 사용할수 있는 Thread 여유 자리가 발생하면 하나씩 꺼내져서 동작하게 된다.
  - ThreadNamePefix: spring이 생성하는 쓰레드의 접두사를 지정한다.



