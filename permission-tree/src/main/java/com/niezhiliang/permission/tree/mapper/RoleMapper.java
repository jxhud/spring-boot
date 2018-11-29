package com.niezhiliang.permission.tree.mapper;

import com.niezhiliang.permission.tree.domain.Role;
import com.niezhiliang.permission.tree.domain.RoleExample;
import java.util.List;

import com.niezhiliang.permission.tree.entity.RoleMenuInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<RoleMenuInfo> selectSubMenu(@Param("roleId") Integer roleId);
}