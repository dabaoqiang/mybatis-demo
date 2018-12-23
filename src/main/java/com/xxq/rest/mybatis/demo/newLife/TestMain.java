package com.xxq.rest.mybatis.demo.newLife;

import com.xxq.rest.mybatis.demo.newLife.config.XQConfiguration;
import com.xxq.rest.mybatis.demo.newLife.entity.Test;
import com.xxq.rest.mybatis.demo.newLife.executor.XQSimpleExecutor;
import com.xxq.rest.mybatis.demo.newLife.mapper.TestMapper;
import com.xxq.rest.mybatis.demo.newLife.session.XQSqlsession;

/**
 * @author xiaoqiang
 * @Title: Entry
 * @ProjectName mybatis-demo
 * @Description: TODO
 * @date 2018-12-22 00:14
 */
public class TestMain {


    public static void main(String[] args) {
        XQSqlsession xqSqlsession = new XQSqlsession(new XQConfiguration(), new XQSimpleExecutor());
        TestMapper mapper = xqSqlsession.getMapper(TestMapper.class, xqSqlsession);
        Test test = (Test) mapper.selectByPrimaryKey(1);
        System.out.println(test.toString());
    }


}
