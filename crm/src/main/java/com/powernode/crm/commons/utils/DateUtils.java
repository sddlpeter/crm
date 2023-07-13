package com.powernode.crm.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 对date类型进行处理
 */
public class DateUtils {
    public static String formatDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
