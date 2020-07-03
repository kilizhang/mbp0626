package com.example.mbp0626.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mbp0626.bean.User;
import com.example.mbp0626.dao.UserDao;
import com.example.mbp0626.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Override
    public IPage<User> selectUserByAge(IPage<User> page, int age) {
        return this.baseMapper.selectUserByAge(page,age);
    }
}
