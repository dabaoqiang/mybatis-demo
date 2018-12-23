package com.xxq.rest.mybatis.demo.newLife.config;

import com.xxq.rest.mybatis.demo.newLife.mappe.proxy.XQMapperProxy;
import com.xxq.rest.mybatis.demo.newLife.session.XQSqlsession;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoqiang
 * @Title: XQConfiguration
 * @ProjectName mybatis-demo
 * @Description: TODO
 * @date 2018-12-21 22:48
 */
public class XQConfiguration {

    public <T> T getMapper(Class<T> clazz, XQSqlsession xqSqlsession) {
        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{clazz},
                new XQMapperProxy(xqSqlsession));
    }

    /**
     * xml解析语句
     */
    public static class TestMapperXml {

        public static final String nameSpace = "com.xxq.rest.mybatis.demo.newLife.mapper.TestMapper";

        public static final Map<String, String> methodSqlMapping = new HashMap<String, String>(1);

        static {
            methodSqlMapping.put("selectByPrimaryKey", "select * from bbt_interact_activity_ref where id=%d");
        }

    }
}
