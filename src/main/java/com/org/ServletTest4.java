package com.org;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author Wang Hao
 * @since 2022/7/6 13:58
 */
@WebServlet("/servlet4")
public class ServletTest4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain;charset=utf-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String string : strings) {
            String[] strings1 = parameterMap.get(string);
            resp.getWriter().println(string);
            for (String s : strings1) {
                resp.getWriter().println(s);
            }
            resp.getWriter().println("-------");
        }
    }
}
