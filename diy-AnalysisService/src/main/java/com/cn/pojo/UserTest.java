package com.cn.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author
 * @date
 * @email
 */
@Data
@Entity  // 该注解声明一个实体类，与数据库中的表对应
public class UserTest {

    @Id   // 表明id
    @GeneratedValue   //  自动生成
    private Long id ;

    private String name ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
