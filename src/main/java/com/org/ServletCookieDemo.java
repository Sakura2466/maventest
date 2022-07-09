package com.org;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Wang Hao
 * @since 2022/7/9 14:17
 */
@WebServlet("/ServletCookieDemo")
public class ServletCookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        resp.setContentType("text/html;charset=utf-8");
        Cookie coo = new Cookie("lastTime", time);
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastTime")) {
                    resp.getWriter().write("欢迎回来,您上次访问的时间为" + cookie.getValue());
                    coo.setValue(time);
                    resp.addCookie(coo);
                }
            }
        } else {
            resp.getWriter().write("欢迎访问!");
            resp.addCookie(coo);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
