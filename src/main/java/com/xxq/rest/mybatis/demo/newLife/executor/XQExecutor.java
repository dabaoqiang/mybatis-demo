package com.xxq.rest.mybatis.demo.newLife.executor;

/**
 * @author xiaoqiang
 * @Title: Executor
 * @ProjectName mybatis-demo
 * @Description: TODO
 * @date 2018-12-21 22:46
 */
public interface XQExecutor {
    public <T> T query(String statement, String parameter);

}
