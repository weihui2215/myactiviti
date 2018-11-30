package com.hy.myactiviti.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/11/27 18:56 </pre>
 *
 * @author hlu
 * @version 1.0
 * @since JDK 1.7
 */
@TableName("user")
public class AiaUser implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer level;
    private String username;
    private String password;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
