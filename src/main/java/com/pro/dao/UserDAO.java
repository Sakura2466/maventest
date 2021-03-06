package com.pro.dao;

import com.pro.Util.JDBCUtils;
import com.pro.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Wang Hao
 * @since 2022/7/6 19:45
 */
public class UserDAO {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user 包含用户全部数据
     */
    public User login(User loginUser){
        try {
            String sql = "select * from user where username= ? and password= ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
