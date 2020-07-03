package com.example.mbp0626.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@TableName("user")
@Data
//@Getter
//@Setter
//@ToString(exclude = {"id"},includeFieldNames = false)
//@Value
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor(staticName = "ahaha")
public class User {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
