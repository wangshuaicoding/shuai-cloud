package com.shuai.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shuai.auth.domain.po.RolePrivilege;
import com.shuai.auth.mapper.RolePrivilegeMapper;
import com.shuai.auth.service.IRolePrivilegeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 账户、角色关联表 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2022-06-16
 */
@Service
public class RolePrivilegeServiceImpl extends ServiceImpl<RolePrivilegeMapper, RolePrivilege> implements IRolePrivilegeService {

    @Override
    public void removeByPrivilegeId(Long id) {
        remove(new QueryWrapper<RolePrivilege>().lambda().eq(RolePrivilege::getPrivilegeId, id));
    }

    @Override
    public void removeByRoleId(Long id) {
        remove(new QueryWrapper<RolePrivilege>().lambda().eq(RolePrivilege::getRoleId, id));
    }

    @Override
    public void deleteRolePrivileges(Long roleId, List<Long> privilegeIds) {
        remove(
                new LambdaQueryWrapper<RolePrivilege>()
                        .eq(RolePrivilege::getRoleId, roleId)
                        .in(RolePrivilege::getPrivilegeId, privilegeIds)
        );
    }
}
