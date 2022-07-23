package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    HTTP 요청 데이터 - GET 쿼리 파라미터

    GET - 쿼리 파라미터
    * /url?username=hello&age=20

    메시지 바디 없이, URL의 쿼리 파라미터에 데이터를 포함해서 전달 예) 검색, 필터, 페이징등에서 많이 사용하는 방식
    쿼리파라미터는 URL에 다음과 같이 ?를 시작으로 보낼 수 있다.추가 파라미터는 &로 구분하면 된다.
    1. 파라미터 전송 기능
    // 단일 파라미터
    http://localhost:8080/request-param?username=hello&age=20

    // 동일한 이름(key)의 다중 value
    http://localhost:8080/request-param?username=hello&age=20&username=kim
 */

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 쿼리 파라미터 조회] - start");

        // modern type
        request.getParameterNames().asIterator()
                // key 와 value 타입으로 paramName = key  || request.getParameter(key) = value;)
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));

        System.out.println("[전체 쿼리 파라미터 조회] - end");
        System.out.println();


        // request.getParameter("key");
        System.out.println("[단일 쿼리 파라미터 조회] - start");

        // username 키를 통해서 value 인 uesrname을 확인
        String username = request.getParameter("username");
        // age 키를 통해서 value 인 uesrname을 확인
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[단일 쿼리 파라미터 조회] - end");

        // request.getParameterValues("key");
        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }

        response.getWriter().write("ok");
    }
}

