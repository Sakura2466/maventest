package com.pro.web.servlet;

import com.pro.dao.UserDAO;
import com.pro.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Wang Hao
 * @since 2022/7/7 15:11
 */
@WebServlet("/loginServlet")
public class LoginSerlvet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDAO ud = new UserDAO();
        User user = ud.login(loginUser);

        if (user == null) {
            req.getRequestDispatcher("failServlet").forward(req, resp);
        } else {
            req.setAttribute("user", user);
            req.getRequestDispatcher("successServlet").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
