package com.pro.Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Wang Hao
 * @since 2022/7/6 19:50
 */
public class JDBCUtils {

    private static DataSource ds;

    static {
        try {
            Properties properties = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }
    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
