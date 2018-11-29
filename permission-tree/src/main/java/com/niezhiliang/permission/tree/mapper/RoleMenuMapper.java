package com.niezhiliang.permission.tree.mapper;


import com.niezhiliang.permission.tree.entity.MenuTree;
import com.niezhiliang.permission.tree.entity.RoleMenuInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMenuMapper {

    List<RoleMenuInfo> getRoleInfo();

}