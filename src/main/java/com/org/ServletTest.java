package com.org;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wang Hao
 * @since 2022/7/5 23:01
 */
@WebServlet("/servlet")
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain;charset=utf-8");
        StringBuffer requestURL = req.getRequestURL();
        resp.getWriter().write("请求url为："+requestURL);
    }
}
