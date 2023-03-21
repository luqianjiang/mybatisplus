package com.atguigu.mybatisplus.pojo;

import com.atguigu.mybatisplus.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 陆钱江
 * @create 2022-10-23 15:04
 */

@Data
//@TableName("t_user")
public class User {

    private Long id;
    private String userName;
    private Integer age;
    private String email;

    private SexEnum sex;

    @TableLogic
    private Integer isDeleted;
}
