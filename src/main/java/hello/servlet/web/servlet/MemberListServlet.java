package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("    <meta charset=\"UTF-8\">");
        out.write("    <title>Title</title>");
        out.write("</head>");
        out.write("<body>");
        out.write("<a href=\"/index.html\">메인</a>");
        out.write("<table>");
        out.write("    <thead>");
        out.write("    <th>id</th>");
        out.write("    <th>username</th>");
        out.write("    <th>age</th>");
        out.write("    </thead>");
        out.write("    <tbody>");

        for (Member member : members) {
            out.write("    <tr>");
            out.write("<td>" + member.getId() + "</td>");
            out.write("<td>" + member.getUserName() + "</td>");
            out.write("<td>" + member.getAge() + "</td>");
            out.write("    </tr>");
        }
        out.write("    </tbody>");
        out.write("</table>");

        out.write("</body>");
        out.write("</html>");
    }
}
