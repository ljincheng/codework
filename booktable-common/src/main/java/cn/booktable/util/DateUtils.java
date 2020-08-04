package cn.booktable.util;
import cn.booktable.exception.BusinessException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ljc
 */
public class DateUtils {

    private static String defaultDatePattern = "yyyy-MM-dd";
    public final static DateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 获得默认的 date pattern
     */
    public static String getDatePattern(){
        return defaultDatePattern;
    }

    /**
     * 返回预设Format的当前日期字符串
     */
    public static String getToday(){
        Date today = new Date();
        return format(today);
    }

    /**
     * 使用预设Format格式化Date成字符串
     */
    public static String format(Date date){
        return date == null ? " " : format(date, getDatePattern());
    }

    /**
     * 使用参数Format格式化Date成字符串
     */
    public static String format(Date date, String pattern) {
        return date == null ? " " : new SimpleDateFormat(pattern).format(date);
    }

    public static String format(Date date, String pattern,Locale locale) {
        return date == null ? " " : new SimpleDateFormat(pattern, locale).format(date);
    }

    /**
     * 使用预设格式将字符串转为Date
     */
    public static Date parse(String strDate) {
        return StringUtils.isEmpty(strDate) ? null : parse(strDate, getDatePattern());

    }

    /**
     * 使用参数Format将字符串转为Date
     */
    public static Date parse(String strDate, String pattern) {
        try {
            return StringUtils.isEmpty(strDate) ? null : new SimpleDateFormat(pattern).parse(strDate);
        }catch (ParseException e) {
            throw new BusinessException(e);
        }
    }

    /**
     * 在日期上增加数个整月
     */
    public static Date addMonth(Date date, int n){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    public static Date addDay(Date date, int n){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, n);
        return cal.getTime();
    }

    public static String getLastDayOfMonth(String year, String month){
        Calendar cal = Calendar.getInstance();
        // 年
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        // 月，因为Calendar里的月是从0开始，所以要-1
        cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        // 日，设为一号
        cal.set(Calendar.DATE, 1);
        // 月份加一，得到下个月的一号
        cal.add(Calendar.MONTH, 1);
        // 下一个月减一为本月最后一天
        cal.add(Calendar.DATE, -1);
        return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));// 获得月末是几号
    }

    /**
     * 获取日期部分
     * @param dateTime
     * @return
     * @throws ParseException
     */
    @Deprecated
    public static Date getDay(Date dateTime)
    {
        try{
            Date date = YYYY_MM_DD.parse(YYYY_MM_DD.format(dateTime));//
            return date;
            //return  DateFormatUtil.getDateFormat(defaultDatePattern).parse( DateFormatUtil.getDateFormat(defaultDatePattern).format(dateTime));
        }catch (ParseException e) {
            throw new BusinessException(e);
        }
    }

    public static Date getDate(String year, String month, String day)
    {
        String result = year + "-" + (month.length() == 1 ? ("0" + month) : month) + "-"
                + (day.length()==1?("0" + day):day);
        return parse(result);
    }

    public static String getMonthDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return (cal.get(Calendar.MONTH)+1)+"月"+cal.get(Calendar.DATE)+"日";
    }

    //当前时间加N天
    public static String getThirtDate(int n){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, n);
        return cal.get(Calendar.YEAR)+"年"+(cal.get(Calendar.MONTH)+1)+"月"+cal.get(Calendar.DATE)+"日";
    }
    //指定时间加N天
    public static String getAddNDate(Date date, int n){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, n);
        return format(cal.getTime(), getDatePattern());
    }
    //购买日期+3个月，是否小于当前日期(即持有超过3个月)
    public static boolean compare3Month(Long time, String dateStr, int month) {

        Calendar cal = Calendar.getInstance();
        Date startTime = new Date(time);
        cal.setTime(startTime);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, month);
        Date endTime = cal.getTime();
        if (endTime.getTime()<=parse(dateStr).getTime()){
            return true;
        }else{
            return false;
        }

    }
    //到期日期-3天，是否大于当前日期(即到期时间的前3天之前)
    public static boolean compare3Days(Long time, String dateStr, int days) throws ParseException{
        Calendar cal = Calendar.getInstance();
        Date startTime = new Date(time);
        cal.setTime(startTime);
        cal.add(Calendar.DAY_OF_MONTH, days);
        Date endTime = cal.getTime();
        if(endTime.getTime() >= parse(dateStr).getTime()){
            return true;
        }else{
            return false;
        }
    }
    //购买是否到期
    public static boolean isComingEnd(Long time, String dateStr) throws ParseException{
        Date startTime = new Date(time);
        if (startTime.getTime() < parse(dateStr).getTime()){
            return true;
        }else{
            return false;
        }
    }

    //购买是否到期
    public static boolean isComingEnd(String dateStr) throws ParseException{
        Date startTime = new Date();
        if (startTime.getTime() < parse(dateStr).getTime()){
            return false;
        }else{
            return true;
        }
    }

    public static String getTime2String(){
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dd = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
        return dd;
    }

    public static String lPadString(String name,int length){
        int aa = name.length();
        if (aa<length){
            StringBuffer sb = new StringBuffer();
            for (int a=0;a<(length-aa);a++){
                sb.append("0");
            }
            sb.append(name);
            return sb.toString();
        }else{
            return name;
        }
    }


    /**
     * 获取相差天数
     * @param
     * @return
     */
    public static int getDiffByDay(Date fDate,Date oDate){

        if (null == fDate || null == oDate) {

            return -1;

        }
        long intervalMilli = oDate.getTime() - fDate.getTime();

        return (int) (intervalMilli / (24 * 60 * 60 * 1000));

    }

    /**
     *
     * getDiffDaysByDay:获取两者时间相差的天数，忽略时分秒. <br>
     *
     * @author xiezbmf
     * Date:2016年11月29日上午11:04:16 <br>
     * @param fDate 开始时间
     * @param oDate 结束时间
     * @return int -1为出现异常
     */
    public static int getDiffDaysByDay(Date fDate,Date oDate){

        if (null == fDate || null == oDate) {
            return -1;
        }
        SimpleDateFormat df = new SimpleDateFormat(defaultDatePattern);
        String d1 = df.format(fDate);
        String d2 = df.format(oDate);

        Calendar c1= Calendar.getInstance();
        Calendar c2= Calendar.getInstance();
        try {
            c1.setTime(df.parse(d1));
            c2.setTime(df.parse(d2));
        } catch (ParseException e) {
            return -1;
        }

        return getDiffByDay(c1.getTime(),c2.getTime());

    }


    /**
     * 获取相差数 , 已分钟为单位
     * @param
     * @return
     */
    public static int getDiffByMin(Date fDate,Date oDate){

        if (null == fDate || null == oDate) {

            return -1;

        }
        long intervalMilli = oDate.getTime() - fDate.getTime();

        return (int) (intervalMilli / (60000 ));

    }

    /**
     * 获取两个日期之间的月份差的绝对值
     * @param start
     * @param end
     * @return
     */
    public static int getDiffByMonth(Date start,Date end){
        if(start==null || end==null){
            return 0;
        }

        int days=getDiffByDay(start,end);

        int months= Math.abs((int)(days/30));
        return months;
    }

    public static int getDiffBySeconds(Date fDate,Date oDate){

        long intervalMilli = oDate.getTime() - fDate.getTime();

        return (int) (intervalMilli / 1000 );

    }

    public static int getIntervalDays(Date fDate, Date oDate) {


        if(null ==fDate || null==oDate){
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fDate);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);

        long time1 = cal.getTimeInMillis();
        cal.setTime(oDate);

        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);

        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        return  (int) between_days;

    }
    //获取当前时间(小时)
    public static int getCurrentHours(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int hours = cal.get(Calendar.HOUR_OF_DAY);
        return hours;
    }



    /**
     * 获取时间差
     * @param date1 需要比较的日期
     * @param date2 被比较的日期
     * @param stype 0为多少天，1为多少个月，2为多少年
     * @return
     * @author: chenzhpmf
     */
    public static int compareDate(String date1, String date2, int stype) {
        int n = 0;

        String[] u = { "天", "月", "年" };
        String formatStyle = stype == 1 ? "yyyy-MM" : "yyyy-MM-dd";

        date2 = date2 == null ? getToday() : date2;

        DateFormat df = new SimpleDateFormat(formatStyle);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(date1));
            c2.setTime(df.parse(date2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果
            n++;
            if (stype == 1) {
                c1.add(Calendar.MONTH, 1); // 比较月份，月份+1
            } else {
                c1.add(Calendar.DATE, 1); // 比较天数，日期+1
            }
        }

        n = n - 1;

        if (stype == 2) {
            n = (int) n / 365;
        }

        System.out.println(date1 + " -- " + date2 + " 相差多少" + u[stype] + ":" + n);
        return n;
    }


    public static boolean isCurrOfExpDate(String startTime,String endTime){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long currTime = new Date().getTime();
        try {
            if (currTime < df.parse(startTime).getTime()
                    || currTime > df.parse(endTime).getTime()) {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     *
     * @Description: 是否为同一天
     * @param day1
     * @param day2
     * @return
     * @author: zhangjhmf
     * @date 2015-11-6 下午4:05:41
     */
    public static boolean isSameDay(Date day1, Date day2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ds1 = sdf.format(day1);
        String ds2 = sdf.format(day2);
        if (ds1.equals(ds2)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @Description: day1 早于 day2 true   反之 false
     * @param day1
     * @param day2
     * @return
     * @author: zhangjhmf
     * @throws ParseException
     * @date 2015-11-6 下午4:30:52
     */
    public static boolean isBefore(Date day1, Date day2)  {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date ds1 =sdf.parse(sdf.format(day1));
            Date ds2 =sdf.parse(sdf.format(day2));
            return ds1.before(ds2);
        }catch (ParseException e) {
            throw new BusinessException(e);
        }
    }

    /**
     * 提前一天 （返回参照日的提前一天）<br>
     * 举例：<br>
     * =============================================<br>
     * 参照日期		｜		使用日期	｜		返回日期				<br>
     * =============================================<br>
     * 2017-01-01	｜	2017-02-01	｜	2017-01-31	<br>
     * 2017-01-01	｜	2017-03-01	｜	2017-02-28	<br>
     * 2017-01-01	｜	2017-04-01	｜	2017-03-31	<br>
     * 2017-01-01	｜	2017-05-01	｜	2017-04-30	<br>
     * 2017-01-01	｜	2017-06-01	｜	2017-05-31	<br>
     * =============================================<br>
     * @param referenceDate 参照日期
     * @param startDate 使用日期
     * @return
     * @author ljc
     */
    public static Date oneDayInAdvance(Date referenceDate,Date startDate)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(referenceDate);
        int dayOfMonth= cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(startDate);
        int dayOfMonthRepayDate= cal.get(Calendar.DAY_OF_MONTH);
        if(dayOfMonth<=dayOfMonthRepayDate)
        {
            return addDay(startDate, -1);
        }
        return startDate;
    }

    /**
     *
     * getMonthFirstDay:获取当月第一天的开始. <br>
     *
     * @author xiezbmf
     * @Date 2017年11月13日上午10:40:10 <br>
     * @param yearMonth
     * @return yyyy-MM-01 00:00:00
     */
    public static String getMonthFirstDay(String yearMonth){
        if(StringUtils.isEmpty(yearMonth)||yearMonth.length()!=6){
            return null;
        }
        String year = yearMonth.substring(0,4);
        String month = yearMonth.substring(4, 6);
        String day = "01";
        String ymdHms = year+"-"+month+"-"+day+" 00:00:00";
        return ymdHms;
    }

    /**
     *
     * getMonthLastDay:获取当月最后一天的最后一秒. <br>
     *
     * @author xiezbmf
     * @Date 2017年11月13日上午10:40:43 <br>
     * @param yearMonth
     * @return yyyy-MM-dd 23:59:59
     */
    public static String getMonthLastDay(String yearMonth){
        if(StringUtils.isEmpty(yearMonth)||yearMonth.length()!=6){
            return null;
        }
        String year = yearMonth.substring(0,4);
        String month = yearMonth.substring(4, 6);
        String day = DateUtils.getLastDayOfMonth(year, month);
        String ymdHms = year+"-"+month+"-"+day+" 23:59:59";
        return ymdHms;
    }

    /**
     * 取得当前日期（只有日期，没有时间，或者可以说是时间为0点0分0秒）
     *
     * @return
     * @throws ParseException
     */
    public static Date getCurrentDate() throws ParseException {
        Date date = new Date();
        date = YYYY_MM_DD.parse(YYYY_MM_DD.format(date));//
        return date;
    }


    public static boolean isYYYYMMDDFormat(String dateStr)
    {
        Pattern p = Pattern.compile("^\\d{4}(\\-)\\d{2}\\1\\d{2}$");
        Matcher m = p.matcher(dateStr);
        boolean b = m.matches();
        return b;
    }

    public static boolean isHHmmFormat(String dateStr)
    {
        Pattern p = Pattern.compile("^\\d{2}(\\:)\\d{2}$");
        Matcher m = p.matcher(dateStr);
        boolean b = m.matches();
        return b;
    }
}
