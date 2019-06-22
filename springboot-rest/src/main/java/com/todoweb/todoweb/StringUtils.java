/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.todoweb;

/**
 *
 * @author PDP_Shiva
 */
public class StringUtils {

    public static Boolean isNullOrEmpty(String string) {
        return (null == string || string.length() <= 0);
    }
}
