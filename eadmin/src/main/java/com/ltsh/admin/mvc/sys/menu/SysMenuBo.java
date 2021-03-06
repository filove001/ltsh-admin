package com.ltsh.admin.mvc.sys.menu;

import com.ltsh.admin.util.Beans;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * sys_menu bo 菜单
 *
 * @author fjz
 */
public class SysMenuBo extends SysMenu {
    public List<SysMenuBo> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenuBo> children) {
        this.children = children;
    }

    private List<SysMenuBo> children = new ArrayList<>();
    //是否选中
    private Boolean checked;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public static void foreach(List<SysMenuBo> bos, Consumer<SysMenuBo> action) {
        for (SysMenuBo bo : bos) {
            action.accept(bo);
            foreach(bo.getChildren(),action);
        }
    }

    /**
     * SysMenu 转为 SysMenuBo
     *
     * @param sysMenu
     * @return
     */
    public static SysMenuBo getSysMenuBo(SysMenu sysMenu) {
        SysMenuBo bo = new SysMenuBo();
        Beans.copyProperties(sysMenu, bo);
        return bo;
    }

    /**
     * 把list变成tree
     *
     * @param nodeList
     * @return
     */
    public static List<SysMenuBo> getSysMenuBos(List<SysMenuBo> nodeList) {
        List<SysMenuBo> ztree = new ArrayList<>();
        for (SysMenuBo node1 : nodeList) {//taskDTOList 是数据库获取的List列表数据或者来自其他数据源的List
            boolean mark = false;
            for (SysMenuBo node2 : nodeList) {
                if (node1.getParentId() != null && node1.getParentId().equals(node2.getId())) {
                    mark = true;
                    if (node2.getChildren() == null)
                        node2.setChildren(new ArrayList<SysMenuBo>());
                    node2.getChildren().add(node1);
                    break;
                }
            }
            if (!mark) {
                ztree.add(node1);
            }
        }
        return ztree;
    }
}
