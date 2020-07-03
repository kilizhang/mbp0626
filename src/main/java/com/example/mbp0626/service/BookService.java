package com.example.mbp0626.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mbp0626.bean.Book;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zx
 * @since 2020-06-27
 */
public interface BookService extends IService<Book> {

    Book getBookByName(String name);
}
