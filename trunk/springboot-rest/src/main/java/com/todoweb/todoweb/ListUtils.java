/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.todoweb;

import java.util.List;

/**
 *
 * @author PDP_Shiva
 */
public class ListUtils {

    public static Boolean isNullOrEmpty(List list) {
        return (null == list || list.isEmpty());
    }
}
