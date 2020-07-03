package com.example.mbp0626.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zx
 * @since 2020-06-27
 */
//@Getter
//@Setter
//@ToString(exclude = "id",includeFieldNames = false)
//@AllArgsConstructor
@NoArgsConstructor
//@Value
@Data
@TableName("book")
public class Book implements Serializable{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String author;

    private String price;

    @TableLogic
    private Integer status;

    public Book(Integer id, String name, String author, String price, Integer status) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.status = status;
    }
}
