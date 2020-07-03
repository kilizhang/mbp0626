package com.example.mbp0626.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mbp0626.bean.User;
import com.example.mbp0626.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//MyBatis-Plus的QueryWrapper条件构造器
@RestController
@RequestMapping("/qw")
public class UserControllerqw {

    @Autowired
    UserService userService;

    /* *
     * @Description MP扩展演示
     * @Author zx
     * @CreateTime 2020/6/26 21:25
     * @Param  []
     * @Return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping("/getInfoListPlus")
    public Map<String, Object> getInfoListPage() {
        //初始化返回类
        Map<String, Object> result = new HashMap<>();
        //查询年龄等于18岁的user
        //等价SQL: SELECT id,name,age,email FROM user WHERE age = 18
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.lambda().eq(User::getAge, 18);
        List<User> UserList1 = userService.list(queryWrapper1);
        result.put("userAge18", UserList1);
        //查询年龄大于5岁的学生且小于等于18岁的user
        //等价SQL: SELECT id,name,age,email FROM user WHERE age > 5 AND age <= 18
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.lambda().gt(User::getAge, 5);
        queryWrapper2.lambda().le(User::getAge, 18);
        List<User> UserList2 = userService.list(queryWrapper2);
        result.put("userAge5", UserList2);
        //模糊查询email字段带有"1234"的数据,并按照年龄降序
        //等价SQL: SELECT id,name,age,email FROM user WHERE email LIKE '%1234%' ORDER BY age DESC
        QueryWrapper<User> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.lambda().like(User::getEmail, "1234");
        queryWrapper3.lambda().orderByDesc(User::getAge);
        List<User> UserList3 = userService.list(queryWrapper3);
        result.put("userAgeSkill", UserList3);
        //模糊查询名字带有"2"或者年龄大于18的user
        //等价SQL: SELECT id,name,age,skill,evaluate,fraction FROM user_info WHERE name LIKE '%2%' OR age > 18
        QueryWrapper<User> queryWrapper4 = new QueryWrapper<>();
        queryWrapper4.lambda().like(User::getName, "2");
        queryWrapper4.lambda().or().gt(User::getAge, 18);
        List<User> UserList4 = userService.list(queryWrapper4);
        result.put("userOr", UserList4);
        //查询emial不为null的user,并且分页
        //等价SQL: SELECT id,name,age,email FROM user_info WHERE email IS NOT NULL LIMIT 0,5
        IPage<User> page = new Page<>();
        page.setCurrent(1);
        page.setSize(5);
        QueryWrapper<User> queryWrapper5 = new QueryWrapper<>();
        queryWrapper5.lambda().isNotNull(User::getEmail);
        page = userService.page(page, queryWrapper5);
        result.put("userPage", page);
        return result;
    }

    /* *
     * @Description 自定义SQL
     * @Author zx
     * @CreateTime 2020/6/26 21:31
     * @Param
     * @Return
     */
    @RequestMapping("/getUserByAge")
    public IPage<User> getUserByAge() {
        IPage<User> page = new Page<>();
        page.setSize(2);
        page.setCurrent(1);
        page = userService.selectUserByAge(page, 20);
        return page;
    }
}
