package org.shanzhaozhen.springsecurity.param;

import java.util.List;

public class MenuRoot {

    private Integer id;

    private String name;

    private String url;

    private List<MenuChild> menuChildList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
