package org.shanzhaozhen.springsecurity.param;

import java.util.ArrayList;
import java.util.List;

public class MenuChild {

    private Integer id;

    private String menu;

    private String url;

    private List<MenuChild> menuChildList;

    public MenuChild(Integer id, String menu, String url) {
        this.id = id;
        this.menu = menu;
        this.url = url;
        this.menuChildList = new ArrayList<MenuChild>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuChild> getMenuChildList() {
        return menuChildList;
    }

    public void setMenuChildList(List<MenuChild> menuChildList) {
        this.menuChildList = menuChildList;
    }
}
