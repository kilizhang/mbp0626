package com.example.mbp0626.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mbp0626.bean.User;

public interface UserDao extends BaseMapper<User>{
    /* *
     * @Description 查询大于该年龄的用户
     * @Author zx
     * @CreateTime 2020/6/26 21:39
     * @Param  [page, age] page 分页参数
     * @Return IPage 分页数据
     */
    IPage<User> selectUserByAge(IPage<User> page,int age);


}
