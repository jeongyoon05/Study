# SQL 문법 정리

#### DDL(Data Definition Language)

- create
- alter
- drop
- truncate
- rename

#### DML(Data Manipulation Language)

- insert
- update
- delete
- select

#### DCL(Data Control Language)

- grant
- revoke

#### TCL(Transaction Control Language)

- commit
- rollback
- savepoint

---

#### Create

- 테이블 생성

  create table student (

  칼럼명 타입 조건(not null 등),
  칼럼명 타입 조건(not null 등),
  칼럼명 타입 조건(not null 등),

  PRIMARY KEY ~~ );

#### Insert

- 테이블에 데이터 삽입

  insert into student values(테이블에 맞는 데이터 양식);

#### Update

- 데이터 내용 수정

  update 테이블 set 컬럼 = '값' where 조건;

#### Delete

- 데이터 삭제

  delete from 테이블 where 조건;

#### Select

- 모든 컬럼 조회

  select * from student;

- 필요한 컬럼 조회

  select age, name from student;

#### select 문법 순서

1. select
2. from
3. where
4. group by
5. having
6. order by

 ***쿼리의 실행 순서는 from ▶ where ▶ group by ▶having ▶ select ▶ order by**

---

#### Where

- 컬럼 조회의 조건

  select * from student where id = 1;

- and, or 조건

  select * from student where sex='남자' and(or) address='서울'; 

- like 조건

  % 로 표현

  select * from student where name='김%';

#### Limit

- 조회 결과 행의 수 제한
  select * from student limit 1;

---

#### Group By

- 특정 컬럼 기준의 데이터 그룹핑

  select age from student group by age;

#### Order by

- 특정 칼럼 기준으로 정렬
- ASC : 오름차순 1 2 3 4 5
- DESC : 내림차순 5 4 3 2 1
  select * from student order by age desc;

#### Distinct

- 중복 행을 제거
  select distinct name from student;

---

#### Join

#### ![image-20220509230157946](C:\Users\leeje\AppData\Roaming\Typora\typora-user-images\image-20220509230157946.png)

#### INNER JOIN

> 일반적인 조인, A와 B 테이블의 조인에서 A와 B 테이블 모두에 있는 레코드만 조회한다.
>
> ```sql
> SELECT A.a, A.b, B.c 
> FROM A
> JOIN B
> ON B.a = A.c;
> ```

#### LEFT OUTER JOIN

>A와 B 테이블의 조인 상황에서 A테이블 기준으로 B테이블에 A테이블의 칼럼과 일치하는 조건이 없으면 B테이블의 칼럼은 NULL로 조회된다.
>
>```sql
>SELECT A.a, A.b, B.c 
>FROM A
>LEFT OUTER JOIN B
>ON B.a = A.c;
>```

#### RIGHT OUTER JOIN

> A와 B 테이블의 조인 상황에서 B테이블 기준으로 A테이블에 B테이블의 칼럼과 일치하는 조건이 없으면 A테이블의 칼럼은 NULL로 조회된다.
>
> ```sql
> SELECT A.a, A.b, B.c 
> FROM A
> RIGHT OUTER JOIN B
> ON B.a = A.c;
> ```

#### CROSS JOIN(Cartesian JOIN)

> 집합의 곱 개념으로
> A= {a, b, c, d} , B = {1, 2, 3} 일 때
> A CROSS JOIN B 는
> (a,1), (a, 2), (a,3), (b,1), (b,2), (b,3), (c, 1), (c,2), (c,3), (d, 1), (d, 2), (d,3)의 결과가 된다.
> 결과의 개수는 n(A) * n(B) 이다.
>
> ```sql
> SELECT A.a A.b B.c
> FROM A
> CROSS JOIN B;
> // 위 아래 쿼리의 결과는 같다.
> SELECT A.a, A.b, B.c
> FROM A, B;
> ```