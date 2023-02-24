package com.capstone.mini.petini.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.capstone.mini.petini.handlers.exceptions.InvalidDateException;

@Configuration
public class DateFormatUtil {
    @Autowired
    private SimpleDateFormat simpleDateFormat;

    public Date formatDateTimeNow() {
        Date now = new Date();
        try {
            return simpleDateFormat.parse(simpleDateFormat.format(now));
        } catch (ParseException e) {
            throw new InvalidDateException();
        }
    }

    // public int calculateAge(String dob) {
    // String formatDob =
    // this.formatGivenDateTimeToString(this.formatGivenDate(dob));
    // LocalDate birthdate = LocalDate.of(Integer.parseInt(formatDob.split("-")[0]),
    // Integer.parseInt(formatDob.split("-")[1]),
    // Integer.parseInt(formatDob.split("-")[2]));
    // LocalDate now = LocalDate.now();
    // return Period.between(birthdate, now).getYears();
    // }

    public Date formatGivenDate(String date) {
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw new InvalidDateException();
        }
    }

    public String formatDateTimeNowToString() {
        Date now = new Date();
        return simpleDateFormat.format(now);
    }

    public String formatGivenDateTimeToString(Date date) {
        return simpleDateFormat.format(date);
    }
}
