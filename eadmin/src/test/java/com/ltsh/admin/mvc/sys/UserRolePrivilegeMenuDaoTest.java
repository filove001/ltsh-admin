package com.ltsh.admin.mvc.sys;

import com.fjz.util.Maps;
import com.ltsh.admin.mvc.sys.menu.SysMenu;
import com.ltsh.admin.mvc.sys.menu.SysMenuDao;
import com.ltsh.admin.mvc.sys.privilege.SysPrivilege;
import com.ltsh.admin.mvc.sys.privilege.SysPrivilegeDao;
import com.ltsh.admin.mvc.sys.role.SysRole;
import com.ltsh.admin.mvc.sys.role.SysRoleDao;
import com.ltsh.admin.mvc.sys.user.SysUser;
import com.ltsh.admin.mvc.sys.user.SysUserDao;
import com.ltsh.admin.mvc.sys.user.role.SysUserRole;
import com.ltsh.admin.mvc.sys.user.role.SysUserRoleDao;
import org.beetl.sql.core.SQLManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRolePrivilegeMenuDaoTest {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Autowired
	private SysPrivilegeDao sysPrivilegeDao;
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	SQLManager sqlManager;

	@Test
	public void testInsertT() {
        List<Map> mapList=sqlManager.execute("show table status",Map.class,null);
        SysMenu sysMenu= createMenu(0,"系统管理","#",1,1);
        sqlManager.insert(sysMenu,true);
        for (Map m: mapList) {//为所有的表添加一个对应的菜单和增删改菜单
            String name = m.get("name").toString();
            String comment = m.get("comment").toString().replace("表","");
            if(name.split("_").length==2){
//                SysMenu menu=new SysMenu();
//                menu.setHref(name.replace("_","/"));
                inisertMenu(sqlManager,sysMenu.getId(),comment,"/"+name.replace("_","/"));
            }
        }
        String name="admin";
        SysRole sysRole = insertSysRole();//增加一个管理员的角色
        SysUser sysUser=insertSysUser(name,1);//增加一个管理员用户
        SysUserRole s=new SysUserRole();
        s.setRoleId(sysRole.getId());
        s.setUserId(sysUser.getId());
        sysUserRoleDao.insert(s);               //为管理员用户赋予管理员权限
        List<SysMenu> sysMenus = sysMenuDao.all();
        for (SysMenu m:sysMenus){               //为管理员角色赋予 所有的菜单权限
            SysPrivilege p=new SysPrivilege();
            p.setAccess(SysMenu.tableName);
            p.setAccessValue(m.getId()+"");
            p.setMaster(SysRole.tableName);
            p.setMasterValue(sysRole.getId()+"");
            sysPrivilegeDao.insert(p);
        }

    }

    private SysRole insertSysRole() {
        SysRole sysRole=new SysRole();
        sysRole.setName("全部");
        sysRole.setCode("all");
        sysRole.setStatus(1);
        sysRole.setCreateBy(sysRole.getName());
        sysRole.setCreateDate(new Date());
        sysRoleDao.insert(sysRole,true);
        return sysRole;
    }

    private static void  inisertMenu(SQLManager sqlManager,Integer pid,String name,String href){
        SysMenu sysMenu= createMenu(pid,name,href+"/index",1,2);
        sqlManager.insert(sysMenu,true);
        System.out.println(sysMenu.getId());
        Map<String,Object> map= Maps.newMap(new String[]{"list","save","update","delete","add","edit"}, new Object[]{"查询","增加","修改","删除","增加页面","修改页面"});
        for (Map.Entry<String,Object> e: map.entrySet()) {
            sqlManager.insert(createMenu(sysMenu.getId(),e.getValue().toString(),href+"/"+e.getKey(),2,3));
        }
    }
    private static SysMenu createMenu(Integer pid, String name, String href,int type,int level){
        SysMenu sysMenu=new SysMenu();
        sysMenu.setName(name);
        sysMenu.setCreateDate(new Date());
        sysMenu.setHref(href);
        sysMenu.setType(type);
        sysMenu.setLevel(level);
        sysMenu.setIcon(null);
        sysMenu.setStatus(1);
        sysMenu.setParentId(pid);
//        sysMenu.setPermission(table.modelName+":"+button);
//        sysMenu.setPid(pMenu.getId());
//        sysMenu.setId(SysMenuAutoIds.getId());
        return sysMenu;
    }
	public SysUser insertSysUser(String name,int i){
		SysUser entity=new SysUser();
		entity.setId(1);
		entity.setLoginName(name);
		entity.setPassword(name);
		entity.setName(name+i);
		entity.setTel(name+i);
		entity.setPhone(name+i);
		entity.setAddress(name+i);
		entity.setEmail(name+i);
		entity.setIdcard(name+i);
		entity.setZip(name+i);
		entity.setStatus(1);
		entity.setSex(1);
		entity.setBirth(new java.util.Date());
		entity.setRemarks(name+i);
		entity.setCreateBy(name+i);
		entity.setCreateDate(new java.util.Date());
		entity.setLastLoginTime(new java.util.Date());
		sysUserDao.insert(entity,true);
		return entity;
	}
}
