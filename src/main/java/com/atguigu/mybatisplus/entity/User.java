package com.atguigu.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 尚硅谷 Mr.Gao
 * @Date: 2021/09/07/19:01
 * @Description:
 */
@Data
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;

//    @TableField(fill = FieldFill.INSERT)
//    private Date createTime;
//    @TableField(fill = FieldFill.INSERT_UPDATE)
//    private Date updateTime;
//
//    @Version
//    @TableField(fill = FieldFill.INSERT)
//    private Integer version;
//
//    @TableLogic
//    @TableField(fill = FieldFill.INSERT)
//    private Integer deleted;
}
