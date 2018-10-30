package com.ltsh.admin;

import com.fjz.util.Jsons;
import com.fjz.util.MavenFiles;
import com.fjz.util.Props;
import com.ltsh.admin.config.DbConfig;
import com.ltsh.admin.mvc.cms.category.CmsCategoryDao;
import com.ltsh.admin.mvc.sys.menu.SysMenuDao;
import com.ltsh.admin.mvc.sys.privilege.SysPrivilegeDao;
import com.ltsh.admin.mvc.sys.role.SysRoleDao;
import com.ltsh.admin.mvc.sys.user.SysUser;
import com.ltsh.admin.mvc.sys.user.SysUserDao;
import com.ltsh.admin.mvc.sys.user.role.SysUserRoleDao;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.ext.DebugInterceptor;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fengjianzhong on 2017/12/9.
 */
public class BaseDaoTest {
    public static SQLManager sqlManager;
    public static SysUserDao sysUserDao;
    public static SysRoleDao sysRoleDao;
    public static SysUserRoleDao sysUserRoleDao;
    public static SysPrivilegeDao sysPrivilegeDao;
    public static SysMenuDao sysMenuDao;
    @BeforeClass
    public static void init(){
        Props.use(MavenFiles.getMavenClassPath().replace("test-classes","classes")+"application.properties");//读取配置文件
        String driver=Props.get("spring.datasource.driver-class-name");
        String url=Props.get("spring.datasource.url");
        String userName=Props.get("spring.datasource.username");
        String password=Props.get("spring.datasource.password");
//        System.out.println(MavenFiles.getMavenJavaSrcPath());
//        System.out.println(MavenFiles.getMavenJavaSrcPath(DbConfig.class));
        ConnectionSource source = ConnectionSourceHelper.getSimple(driver, url, userName, password);
        DBStyle mysql = new MySqlStyle();
// sql语句放在classpagth的/sql 目录下
        SQLLoader loader = new ClasspathLoader("/sql");
// 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的，
        UnderlinedNameConversion nc = new UnderlinedNameConversion();
// 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
        sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});
        sysUserDao=sqlManager.getMapper(SysUserDao.class);
        sysRoleDao=sqlManager.getMapper(SysRoleDao.class);
        sysUserRoleDao=sqlManager.getMapper(SysUserRoleDao.class);
        sysPrivilegeDao=sqlManager.getMapper(SysPrivilegeDao.class);
        sysMenuDao=sqlManager.getMapper(SysMenuDao.class);
    }
//    public static void main(String[] args){
//
//        // 这一部分需要参考mapper一章
//        SysUserDao dao = sqlManager.getMapper(SysUserDao.class);
//        PageQuery<SysUser> query=new PageQuery();
//        SysUser s= new SysUser();
//        s.setLoginName("admin");
//        query.setParas(s);
//        dao.page(query);
//        System.out.println(Jsons.toString(query));
////        System.out.println(Jsons.toString(dao.all()));
//    }
}
