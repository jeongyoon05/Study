# JPA - 영속성 관리 

1. ## 영속성 컨텍스트 기본 개념

   영속성 컨텍스트(Persistence Context)란 "엔티티를 영구 저장하는 환경"이라는 뜻이다. 엔티티 매니저로 엔티티를 저장하거나 조회하면 엔티티 매니저는 영속성 컨텍스트에서 엔티티를 보관하고 관리한다.

   `persist()` 메서드는 엔티티 매니저를 사용해서 회원 엔티티를 영속성 컨텍스트에 저장한다.

   

2. ## 엔티티 생명주기

   엔티티에는 4가지 상태가 존재하며 생명주기는 아래의 그림과 같다.

![entity-lifetime](https://github.com/walbatrossw/jpa-study/blob/master/docs/img/entity-lifetime.png?raw=true)

- 비영속(new/transient) : 영속성 컨텍스트와 관계가 없는 상태
- 영속(managed) : 영속성 컨텍스트에 저장된 상태
- 준영속(detached) : 영속성 컨텍스트에 저장되어있다가 분리된 상태
- 삭제(removed) : 삭제된 상태

### 2.1 비영속

엔티티 객체를 생성하여 순수한 객체의 상태이며 저장하지 않은 상태를 말한다. 따라서 영속성 컨텍스트나 데이터베이스와 관련 없다.

```java
// 객체 생성 : 비영속
Member member = new Member();
member.setId("1");
member.setUsername("hello")
```

### 2.2 영속

엔티티 매니저를 통해 앤티티를 영속성 컨텍스트에 저장한 상태

영속성 컨텍스트가 관리하는 엔티티를 영속상태라고 한다.

```java
// 저장 : 영속
entityManager.persist(member);
// 한건 조회 : 영속
entityManager.find("1");
//목록 조회 : 영속
List<Member> members = entityManager.createQuery("SELECT m FROM Member m", Member.class).getResultList();
```

### 2.3 준영속

영속성 컨텍스트가 관리하던 영속성 상태의 엔티티를 영속성 컨텍스트가 관리하지 않으면 준영속 상태가 된다.

특정 엔티티를 준영속으로 만들려면 아래 메서드를 호출하면 된다.

- `entityManager.detach() ` : 분리
- `entityManager.close()` : 영속성 컨텍스트 닫음
- `entityManager.clear()` : 영속성 컨텍스트 초기화

### 2.4 삭제

엔티티를 영속성 컨텍스트와 데이터베이스에서 제거 한다.

```java
entityManager.remove();
```

3. ## 영속성 컨텍스트 특징

영속성 컨텍스트의 특징은 아래와 같다.

- 영속성 컨텍스트는 엔티티를 식별자 값으로 구분한다 -> 엔티티에는 식별자 값이 존재해야 한다.
-  영속성 컨텍스트에 저장된 엔티티는 트랜잭션을 커밋하는 순간 데이터베이스에 반영된다. -> 플러시
- 영속성 컨텍스트 장점
  - 1차 캐시
  - 동일성 보장
  - 트랜잭션을 지원하는 쓰기 지연
  - 변경감지
  - 지연로딩