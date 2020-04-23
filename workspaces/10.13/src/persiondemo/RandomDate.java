package persiondemo;

import java.util.Calendar;


public class RandomDate {
    public static void main(String[] args) {
//        �������һ��1997-1-1 00��00��00 ��2017-1-1 00��00��00 ֮�������
        //�������ʱ��ķ�Χ
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.set(1997, Calendar.JANUARY, 1, 0, 0, 0);
        endDate.set(2017, Calendar.JANUARY, 1, 0, 0, 0);
        Calendar calendar = getRandomDate(startDate, endDate);
        System.out.println(calendar.getTime());
    }

    public static Calendar getRandomDate(Calendar startDate, Calendar endDate) {
        long timeInMillis1 = startDate.getTimeInMillis();
        long timeInMillis2 = endDate.getTimeInMillis();
        long random = (long) ((timeInMillis2 - timeInMillis1) * Math.random());
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTimeInMillis(timeInMillis1 + random);
        return calendar3;
    }


}
