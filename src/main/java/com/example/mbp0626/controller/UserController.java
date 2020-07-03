package com.example.mbp0626.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mbp0626.bean.User;
import com.example.mbp0626.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    HashMap<String,Object> map=new HashMap<>();
    
    /**
     * @Description 查询全部信息
     * @Author zx
     * @CreateTime 2020/6/26 16:40
     * @Param  []
     * @Return java.util.List<com.example.mbp0626.bean.User>
     */
    @RequestMapping("/getList")
    public List<User> getList(){
        List<User> list=userService.list();
        return list;
    }

    /* *
     * @Description 根据ID获取用户信息
     * @Author zx
     * @CreateTime 2020/6/26 16:43
     * @Param  [id]
     * @Return com.example.mbp0626.bean.User
     */
    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userService.getById(id);
        return user;
    }

    /* *
     * @Description 分页查询全部数据
     * @Author zx
     * @CreateTime 2020/6/26 16:43
     * @Param  []
     * @Return com.baomidou.mybatisplus.core.metadata.IPage<com.example.mbp0626.bean.User>
     */
    @RequestMapping("/getPage")
    public IPage<User> getUserListPage(){
        //需要在Config配置类中配置分页插件
        IPage<User> page=new Page<>();
        //当前页
        page.setCurrent(5);
        //每页条数
        page.setSize(1);
        page=userService.page(page);
        return page;
    }

    /* *
     * @Description 根据指定字段查询用户信息集合
     * @Author zx
     * @CreateTime 2020/6/26 17:02
     * @Param
     * @Return
     */
    @RequestMapping("/getListMap")
    public Collection<User> getListMap(){
        map.put("name","bb");
        List<User> users = userService.listByMap(map);
        return users;
    }

    /* *
     * @Description 新增用户信息
     * @Author zx
     * @CreateTime 2020/6/26 17:07
     * @Param  [user]
     * @Return java.util.Map
     */
    @RequestMapping("/save")
    public Map saveUser(User user){
        userService.save(user);
        map.put("info","success");
        map.put("user",user);
        //map.put("users",userService.list());
        return map;
    }
    /* *
     * @Description  批量新增用户信息
     * @Author zx
     * @CreateTime 2020/6/26 17:12
     * @Param  []
     * @Return java.util.Map
     */
    @RequestMapping("/saveUsers")
    public Map save(){
        User u1=new User();
        u1.setAge(11);
        u1.setName("user1");
        u1.setEmail("user1@1234.com");
        User u2=new User();
        u2.setAge(12);
        u2.setName("user2");
        u2.setEmail("user2@1234.com");
        //批量保存
        List<User> list=new ArrayList<>();
        list.add(u1);
        list.add(u2);
        map.put("users",list);
        userService.saveBatch(list);
        return map;
    }
        
    /* *
     * @Description 更新用户信息
     * @Author zx
     * @CreateTime 2020/6/26 17:23
     * @Param  [user]
     * @Return java.util.Map
     */
    @RequestMapping("/update")
    public Map update(User user){
        User u = userService.getById(user.getId());
        map.put("old",u);
        map.put("new",user);
        userService.updateById(user);
        return map;
    }

    /* *
     * @Description 新增或者更新用户信息
     * @Author zx
     * @CreateTime 2020/6/26 17:43
     * @Param  [user]
     * @Return java.util.Map
     */
    @RequestMapping("/saveOrUpdate")
    public Map saveOrUpdate(User user){
        //传入的实体类userInfoEntity中ID为null就会新增(ID自增)
        //实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
        if(userService.getById(user.getId())!=null){
            map.put("update",user);
        }else{
            map.put("insert",user);
        }
        userService.saveOrUpdate(user);
        return map;
    }

    /* *
     * @Description 根据ID删除用户信息
     * @Author zx
     * @CreateTime 2020/6/26 17:46
     * @Param  [id]
     * @Return void
     */
    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        userService.removeById(id);
    }

    /* *
     * @Description 根据ID批量删除用户信息
     * @Author zx
     * @CreateTime 2020/6/26 17:46
     * @Param  []
     * @Return void
     */
    @RequestMapping("/deleteInfoList")
    public void deleteInfoList(){
        List<String> list=new ArrayList<>();
        list.add("11");
        list.add("12");
        userService.removeByIds(list);
    }

    /* *
     * @Description 根据指定字段删除用户信息
     * @Author zx
     * @CreateTime 2020/6/26 17:48
     * @Param  []
     * @Return void
     */
    @RequestMapping("/deleteInfoMap")
    public void deleteInfoMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("age",9);
        map.put("name","1709");
        userService.removeByMap(map);
    }
}
