package com.ltsh.admin.insert.data;

import com.ltsh.admin.BaseDaoTest;
import com.ltsh.admin.mvc.cms.category.CmsCategoryDao;
import com.ltsh.admin.mvc.sys.menu.SysMenu;
import com.ltsh.admin.mvc.sys.user.SysUser;
import com.ltsh.admin.mvc.sys.user.SysUserDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 初始化最初数据
 * Created by fengjianzhong on 2017/12/12.
 */
public class InitData extends BaseDaoTest {
    @Test
    public void admin(){
        //插入管理员
        sysUserDao.executeUpdate("INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin', null, '管理员', 'admin1', 'admin1', 'admin1', 'admin1', null, null, null, 'admin1', 'admin1', '1', '1', '2017-06-15', 'admin1', 'admin1', '2017-06-15 15:26:54', '2017-06-15 15:26:54', null, null)");

    }



}
