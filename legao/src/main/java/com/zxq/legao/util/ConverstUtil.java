package com.zxq.legao.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ConverstUtil {
    //转换成list
    public static List<String> stringToList(String text, String[] studentField) {
        if (text == null) {
            return null;
        }
        //去除左右[]
        String removeStr = StringUtils.strip(text, "[]");
        String[] textArry = removeStr.split(",");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < textArry.length; i++) {

            list.add(studentField[new Integer(textArry[i])]);


        }
        return list;

    }

    //取出list中的空格
    public static String strToDBStr(List<String> strForm) {
        if (strForm == null) {
            return null;
        }
        //去除左右[]
        List<String> list = new ArrayList<>();
        String aimStr = "";
        for (int i = 0; i < strForm.size(); i++) {
            if (i != strForm.size() - 1) {
                aimStr += strForm.get(i) + ",";
            } else {
                aimStr += strForm.get(i);
            }


        }
        return "[" + aimStr + "]";

    }

}
