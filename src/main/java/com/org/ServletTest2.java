package com.org;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Wang Hao
 * @since 2022/7/6 10:40
 */
@WebServlet("/servlet2")
public class ServletTest2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        String value;
        while ((value = reader.readLine()) != null) {
            resp.getWriter().write(value);
        }
        reader.close();
    }
}
