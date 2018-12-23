package com.xxq.rest.mybatis.demo.newLife.mappe.proxy;

import com.xxq.rest.mybatis.demo.newLife.session.XQSqlsession;
import com.xxq.rest.mybatis.demo.newLife.config.XQConfiguration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xiaoqiang
 * @Title: XQMapperProxy
 * @ProjectName mybatis-demo
 * @Description: TODO
 * @date 2018-12-21 23:41
 */
public class XQMapperProxy implements InvocationHandler {

    private XQSqlsession sqlSession;

    public XQMapperProxy(XQSqlsession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(XQConfiguration.TestMapperXml.nameSpace)) {
            String sql = XQConfiguration.TestMapperXml.methodSqlMapping.get(method.getName());
            return sqlSession.selectOne(sql, String.valueOf(args[0]));
        }
        return method.invoke(this,args);
    }
}
