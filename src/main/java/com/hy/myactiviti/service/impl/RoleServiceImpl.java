package com.hy.myactiviti.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hy.myactiviti.entity.Role;
import com.hy.myactiviti.mapper.RoleMapper;
import com.hy.myactiviti.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
