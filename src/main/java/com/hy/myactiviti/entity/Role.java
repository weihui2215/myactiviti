package com.hy.myactiviti.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/11/28 16:35 </pre>
 *
 * @author hlu
 * @version 1.0
 * @since JDK 1.7
 */
@TableName("role")
public class Role {

    @TableId
    private Long id;
    private String role;
    private Long userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
