package com.bookmytable.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.widget.DatePicker;
import android.widget.TimePicker;

/**
 * Created by Pranit on 11/17/13.
 */
public class Conversions {

    public static Calendar getCalendarFromDateTimePicker(DatePicker datePicker, TimePicker timePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute);

        return calendar;
    }
    
    public static String printDateTime(Calendar calendar) {
	SimpleDateFormat format = new SimpleDateFormat("E, MMM d, HH:mma");
	return format.format(calendar.getTime());
    }
}
