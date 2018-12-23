package com.xxq.rest.mybatis.demo.newLife.executor;


import com.xxq.rest.mybatis.demo.newLife.entity.Test;
import com.xxq.rest.mybatis.demo.newLife.executor.XQExecutor;

import java.sql.*;

/**
 * @author xiaoqiang
 * @Title: XQSimpleExecutor
 * @ProjectName mybatis-demo
 * @Description: TODO
 * @date 2018-12-22 00:09
 */
public class XQSimpleExecutor implements XQExecutor {

    @Override
    public <T> T query(String statement, String parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Test test = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://127.0.0.1:3306/bbt_promote?useUnicode=true&characterEncoding=UTF8";
            String user = "jusravimgdju";
            String pass = "Bbt_54321";
            connection = DriverManager.getConnection(url, user, pass);
            String sql = String.format(statement, Integer.parseInt(parameter));
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                test = new Test();
                test.setId(resultSet.getLong(1));
                test.setActivity_id(resultSet.getLong(2));
                test.setInteract_Id(resultSet.getLong(3));
                test.setCreate_time(resultSet.getDate(4));
                test.setModify_time(resultSet.getDate(5));
            }

        }catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if (null != preparedStatement) {
                    preparedStatement.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  (T)test;
    }
}
