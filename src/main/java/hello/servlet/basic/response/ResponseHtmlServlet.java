package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// HTTP 응답 데이터 - 단순 텍스트, html
@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Content-Type : text/html;charset=utf-8
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();

        // 자바 코드로 작성 되기에 switch 문을 사용하여 특정 사람일 경우 해당 html 을 랜더링 하는 것도 가능
        // HTTP 응답으로 HTML을 반환할 때는 content-type 을 text/html 로 지정해야 한다.

        writer.println("<html>");
        writer.println("<body>");
        writer.println("  <div>안녕? </div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}