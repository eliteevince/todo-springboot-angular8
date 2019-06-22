/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.todoweb;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Meet
 */
public class DateTimeUtils {

    public static String milisecondToFormatedDate(Long time) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY hh:mm a");
        return format.format(new Date(time));
    }
}
