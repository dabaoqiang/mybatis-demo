package com.xxq.rest.mybatis.demo.newLife.session;

import com.xxq.rest.mybatis.demo.newLife.config.XQConfiguration;
import com.xxq.rest.mybatis.demo.newLife.executor.XQExecutor;

/**
 * @author xiaoqiang
 * @Title: Sqlsession
 * @ProjectName mybatis-demo
 * @Description: TODO
 * @date 2018-12-21 22:45
 */
public class XQSqlsession {
    private XQConfiguration configuration;
    private XQExecutor executor;

    /**
     * 建立联系
     *
     * @param configuration
     * @param executor
     */
    public XQSqlsession(XQConfiguration configuration, XQExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    /**
     * getMapper
     *
     * @param clazz 传入一个calss类
     */
    public <T> T getMapper(Class<T> clazz,XQSqlsession xqSqlsession) {
        return (T) configuration.getMapper(clazz, xqSqlsession);
    }


    /**
     * @param statement sql语句
     * @param parameter sql参数
     */
    public <T> T selectOne(String statement, String parameter) {
        return executor.query(statement, parameter);
    }

}
