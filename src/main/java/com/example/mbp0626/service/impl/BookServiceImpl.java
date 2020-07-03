package com.example.mbp0626.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.mbp0626.bean.Book;
import com.example.mbp0626.dao.BookDao;
import com.example.mbp0626.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zx
 * @since 2020-06-27
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao,Book> implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public Book getBookByName(String name) {
        return bookDao.getBookByName(name);
    }
}
