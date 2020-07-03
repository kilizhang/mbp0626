package com.example.mbp0626.controller;



import com.example.mbp0626.bean.Book;
import com.example.mbp0626.dao.BookDao;
import com.example.mbp0626.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zx
 * @since 2020-06-27
 */
@CacheConfig(cacheNames = "book_cache")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookDao bookDao;

    @Autowired
    BookService bookService;

    @RequestMapping("/list")
    public List<Book> getList(){
        return bookDao.selectList(null);
    }

    @RequestMapping("/add")
    public List<Book> addBook(Book book){
        bookDao.insert(book);
        return bookDao.selectList(null);
    }

    @CachePut(key="#book.id")
    @RequestMapping("/ub")
    public Book updateBook(Book book){
        bookDao.updateById(book);
        return bookDao.selectById(book.getId());
    }


    @CacheEvict(key="#id")
    @RequestMapping("/delete/{id}")
    public Map<String,Object> delete(@PathVariable("id") Integer id){
        Map<String,Object> map=new HashMap<>();
        if(bookService.getById(id)!=null){
            map.put("deleteInfo",bookService.getById(id));
            bookService.removeById(id);
            map.put("BookList",bookService.list());
        }else{
            map.put("deleteInfo","删除失败");
        }
        return map;
    }

//    @Cacheable(key="#id")
//    @RequestMapping("/{id}")
//    public Book getBookById(@PathVariable("id") Integer id){
//        Book book = bookService.getById(id);
//        System.out.println(book);
//        return book;
//    }

    @Cacheable(key="#name")
    @RequestMapping("/sbbn/{name}")
    public Map<String,Object> getBookByName(@PathVariable("name") String name){
        System.out.println(name);
        Map<String,Object> map=new HashMap<>();
        map.put("selectInfo",bookService.getBookByName(name));
        return map;
    }


}
