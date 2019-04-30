package org.huangzi.huangziframe.controller;

import org.huangzi.huangziframe.dto.UserInfoDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/4/27 11:21
 * @description:
 */
public class ListArrayTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String[] strings = list.toArray(new String[list.size()]);
    }

}
