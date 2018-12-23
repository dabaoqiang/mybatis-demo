package com.xxq.rest.mybatis.demo.newLife.mapper;

import com.xxq.rest.mybatis.demo.newLife.entity.Test;

/**
 * @author xiaoqiang
 * @Title: TestMapper
 * @ProjectName mybatis-demo
 * @Description: TODO
 * @date 2018-12-21 23:54
 */
public interface TestMapper {
    Test selectByPrimaryKey(Integer userId);
}
