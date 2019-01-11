package org.shanzhaozhen.springsecurity.utils;

import org.shanzhaozhen.springsecurity.bean.SysPermission;

import java.util.Comparator;

public class ComparatorUtils implements Comparator<SysPermission> {

    @Override
    public int compare(SysPermission o1, SysPermission o2) {
        if(o1.getOrder() == null || o2.getOrder() == null) {
            return 0;
        }
        if (o1.getOrder() > o2.getOrder()) {
            return 1;
        }
        else if (o1.getOrder() < o2.getOrder()) {
            return -1;
        }
        else {
            return 0;
        }
    }

}
