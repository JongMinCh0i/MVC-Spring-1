package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
// name = 서블릿 이름 , urlPatterns = URL 매핑 : 이 둘은 서로 중복 되면 안된다.
// localhost:8080/hello 로 요청이 들어올 경우 (Servlet이 호출되면) 아래의 서비스 메서드가 자동으로 실행된다.
public class HelloServlet extends HttpServlet {
    @Override
    // Http 요청이 들어올 경우 was(web application server)가 , 서블릿 컨테이너가 request(요청), response(응답) 객체를 생성해서 서블릿에게 반환
    // 결국 HttpServletRequest, HttpServletResponse 모두 이 두 객체 들은 요청 메시지, 응답 메시지를 편리하게 사용하도록 도와주는 객체라는 것이다.
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // localhost:8080/hello?username=kim (쿼리 파라미터가 사용된 예시 : ?)
        // 검색을 위한 파라미터를 쉽게 파싱하여 해당 문자열을 참조변수에 저장하였다.
        // username = kim 확인

        // 처음과 같이 이렇게 프로그래머가 HTTP 요청 메시지를 직접 파싱해서 사용할 경우 번거로울 것이다.
        // 서블릿은 개발자가 HTTP 요청 메시지를 편리하게 사용할 수 있도록 대신 파싱하며 그 결과를 HttpServletRequest 에 담아서 제공한다.
        // 그외 기능들로는 임시 저장소(해당 HTTP 요청이 시작부터 끝날 때 까지 유지되는 임지 저장소 기능 ), 세션 관리 기능
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 값을 넣어서 http 응답 메세지에 데이터를 담아서 응답
        // 단순 메세지 반환
        // 인코딩은 utf-8 사용

        response.setContentType("text/plain"); // content type 즉 (인터넷에 전달되는 파일 포맷, 포맷 콘텐츠를 위한 2부분의 식별자) : 헤더 정보
        response.setCharacterEncoding("utf-8");// content type
        response.getWriter().write("hello " + username);
    }
}
