package com.example.mbp0626.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mbp0626.bean.Book;
import org.apache.ibatis.annotations.Param;

import java.util.Map;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zx
 * @since 2020-06-27
 */
public interface BookDao extends BaseMapper<Book> {

    Book getBookByName(@Param("name") String name);
}
