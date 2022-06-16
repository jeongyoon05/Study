# Dispatcher-Servlet

#### Dispatcher-Servlet(디스패처 서블릿) 이란?

디스패처 서블릿의 dispatch는 "보내다"라는 뜻을 가지고 있다.

`HTTP 프로토콜로 들어오는 모든 요청을 가장 먼저 받아 적합한 컨트롤러에 위임해주는 프론트 컨트롤러(Front Controller)` 라고 정의할수 있다.



자세히 설명하면 클라이언트로부터 어떤 요청이 오면 Tomcat(톰캣)과 같은 서블릿 컨테이너가 요청을 받게 된다. 

그리고 이 모든 요청을 프론트 컨트롤러인 디스패처 서블릿이 가장 먼저 받게 된다.

그러면 디스패처 서블릿은 공통적인 작업을 먼저 처리한 후에 해당 요청을 처리해야 하는 컨트롤러를 찾아서 작업을 위임한다.

![img](https://velog.velcdn.com/images%2Fseculoper235%2Fpost%2Fc404e755-454c-4b69-937b-d04ff3c0c69d%2F2%EC%B0%A8%20%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC%20%EA%B5%AC%EC%A1%B0.PNG)

#### Dispatcher-Servlet(디스패처 서블릿)의 장점

Spring MVC는 Dispatcher-Servlet이 등장함에 따라 web.xml의 역할을 상당히 축소시켜주었다.

과거에는 모든 서블릿을 URL매핑을 위해 web.xml에 모두 등록해주어야 했지만, `dispatcher-servlet이 해당 어플리케이션으로 모든 요청을 핸들링`해주고 공통 작업을 처리하면서 상당히 편리해졌다.

컨트롤러만 구현을 하면 디스패처 서블릿이 알아서 적합한 컨트롤러로 위임해 주는 구조가되었다.



#### Dispatcher-Servlet의 동작 방식

Dispatcher-Servlet의 처리 과정을 살펴보면 다음과 같다.

![image-20220616165148298](C:\Users\leeje\AppData\Roaming\Typora\typora-user-images\image-20220616165148298.png)

![image-20220616165254166](C:\Users\leeje\AppData\Roaming\Typora\typora-user-images\image-20220616165254166.png)