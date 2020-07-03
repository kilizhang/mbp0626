package com.example.mbp0626.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mbp0626.bean.User;

public interface UserService extends IService<User> {

    IPage<User> selectUserByAge(IPage<User> page, int age);
}
