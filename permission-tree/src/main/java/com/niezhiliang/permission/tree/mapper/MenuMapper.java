package com.niezhiliang.permission.tree.mapper;

import java.util.List;

import com.niezhiliang.permission.tree.entity.MenuTree;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuMapper {
    List<MenuTree> getMenus(@Param(value = "roleId") Integer roleId);
}