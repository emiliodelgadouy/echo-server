package echoserver.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.stream.Collectors;

public class EchoServlet extends HttpServlet {


    private void log(HttpServletRequest request, String body) {
        System.out.println("###############################################################################");
        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println("URL - " + request.getRequestURI());
        System.out.println("Method - " + request.getMethod());
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println("Header Name - " + headerName + ", Value - " + request.getHeader(headerName));
        }
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            System.out.println("Parameter Name - " + paramName + ", Value - " + request.getParameter(paramName));
        }

        System.out.println("Body");
        System.out.println(body);
        System.out.println("###############################################################################");
    }

    private void dispath(HttpServletRequest req, HttpServletResponse resp, String verb) throws IOException {
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        this.log(req, body);
        PrintWriter writer = resp.getWriter();
        writer.println(body);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.dispath(req, resp, "GET");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.dispath(req, resp, "POST");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.dispath(req, resp, "DELETE");
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.dispath(req, resp, "HEAD");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.dispath(req, resp, "PUT");
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.dispath(req, resp, "OPTIONS");
    }

    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.dispath(req, resp, "TRACE");
    }


}