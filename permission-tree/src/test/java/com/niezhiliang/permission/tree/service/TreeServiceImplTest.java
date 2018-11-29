package com.niezhiliang.permission.tree.service;

import com.niezhiliang.permission.tree.entity.MenuTree;
import com.niezhiliang.permission.tree.entity.RoleMenuInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/29 上午9:01
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TreeServiceImplTest {
    @Autowired
    private TreeService treeService;


    @Test
    public void testTree() {
        List<RoleMenuInfo> roleMenuInfo = treeService.getRoleMenu();
        System.out.println("");
    }

    @Test
    public void testTreeMenu() {
        List<MenuTree> menuTrees = treeService.getMenus(1);
        System.out.println("");
    }
}