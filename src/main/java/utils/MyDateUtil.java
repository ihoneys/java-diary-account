/**
 * Lucas is learning Java
 *
 * @author Lucas
 * @date 2024/2/22
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateUtil {

    /**
     * 时间戳转时间
     */
    public static String stampToDate(long timestamp, String format) {
        String formatValue = format.isEmpty() ? "YYYY-MM-DD HH:mm:ss" : format;
//        SimpleDateFormat sdf = new SimpleDateFormat(formatValue);
//        return sdf.format(new Date(timeStamp));
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatValue);
        return dateFormat.format(new Date(timestamp));
    }

    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String time, String format){
        String formatValue = format.isEmpty() ? "YYYY-MM-DD HH:mm:ss" : format;
        SimpleDateFormat sdf = new SimpleDateFormat(formatValue);
        String stamp = "";
        if (!"".equals(time)) {//时间不为空
            try {
                stamp = String.valueOf(sdf.parse(time).getTime()/1000);
            } catch (Exception e) {
                System.out.println("参数为空！");
            }
        }else {    //时间为空
            long current_time = System.currentTimeMillis();  //获取当前时间
            stamp = String.valueOf(current_time/1000);
        }
        return stamp;
    }

}
