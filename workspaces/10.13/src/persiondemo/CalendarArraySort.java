package persiondemo;

import java.util.Arrays;
import java.util.Calendar;

public class CalendarArraySort {
    public static void main(String[] args) {
//        ʹ��1970.1.1 00:00:00-2017.1.1 00:00:00��֮���������ڳ�ʼ��������
        //�������ʱ�䷶Χ
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.setTimeInMillis(0);
        endDate.set(2017, Calendar.JANUARY, 1, 0, 0, 0);
        //��ȡ����Ϊʮ����������
        Calendar[] calendars = getCalendarArray(startDate, endDate, 10);
//        ������Щ���ڵ�ʱ�������������
//        ���� 1988-1-21 12:33:22 �ͻ����� 1978-4-21 19:07:23 ǰ�棬��Ϊ����ʱ���С����Ȼ���ڸ���
        getCalendaSort(calendars);
        System.out.println(toString(calendars));
    }

    public static String toString(Calendar[] calendars) {
        String[] date = new String[calendars.length];
        for (int i = 0; i < calendars.length; i++) {
            date[i] = calendars[i].get(Calendar.YEAR) + "-" + calendars[i].get(Calendar.MONTH) + "-" +
                    calendars[i].get(Calendar.DAY_OF_MONTH) + " " + calendars[i].get(Calendar.HOUR_OF_DAY) + ":" +
                    calendars[i].get(Calendar.MINUTE) + ":" + calendars[i].get(Calendar.SECOND);
        }
        return Arrays.toString(date);
    }

    private static void getCalendaSort(Calendar[] calendars) {
        Calendar temp;
        for (int i = 0; i < calendars.length - 1; i++) {
            for (int j = i + 1; j < calendars.length; j++) {
                if (calendars[i].get(Calendar.HOUR_OF_DAY) == calendars[j].get(Calendar.HOUR_OF_DAY)) {
                    if (calendars[i].get(Calendar.MINUTE) == calendars[j].get(Calendar.MINUTE)) {
                        if (calendars[i].get(Calendar.SECOND) > calendars[j].get(Calendar.SECOND)) {
                            temp = calendars[i];
                            calendars[i] = calendars[j];
                            calendars[j] = temp;
                        }
                    } else {
                        if (calendars[i].get(Calendar.MINUTE) > calendars[j].get(Calendar.MINUTE)) {
                            temp = calendars[i];
                            calendars[i] = calendars[j];
                            calendars[j] = temp;
                        }
                    }
                } else {
                    if (calendars[i].get(Calendar.HOUR_OF_DAY) > calendars[j].get(Calendar.HOUR_OF_DAY)) {
                        temp = calendars[i];
                        calendars[i] = calendars[j];
                        calendars[j] = temp;
                    }
                }
            }
        }
    }

    private static Calendar[] getCalendarArray(Calendar startDate, Calendar endDate, int length) {
        Calendar[] calendars = new Calendar[length];
        for (int i = 0; i < length; i++) {
            calendars[i] = RandomDate.getRandomDate(startDate, endDate);
        }
        return calendars;
    }
}
