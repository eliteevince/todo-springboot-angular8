/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.todoweb.proxy;

import com.todoweb.todoweb.DateTimeUtils;

/**
 *
 * @author PDP_Shiva
 */
public class ToDoProxy {

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the eventTimeMilis
     */
    public Long getEventTimeMilis() {
        return eventTimeMilis;
    }

    /**
     * @param eventTimeMilis the eventTimeMilis to set
     */
    public void setEventTimeMilis(Long eventTimeMilis) {
        this.eventTimeMilis = eventTimeMilis;
    }

    /**
     * @return the lastModified
     */
    public Long getLastModified() {
        return lastModified;
    }

    /**
     * @param lastModified the lastModified to set
     */
    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * @return the isRead
     */
    public Boolean getIsRead() {
        return isRead;
    }

    /**
     * @param isRead the isRead to set
     */
    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the eventTime
     */
    public String getEventTime() {
        return eventTime;
    }

    /**
     * @param eventTime the eventTime to set
     */
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }
    
    private Long id;
    private Long eventTimeMilis;
    private Long lastModified;
    private Boolean isRead;
    private String title;
    private String description;
    private String eventTime;
    
    public ToDoProxy() {
    }
    
    public ToDoProxy(Long id, String title, String description, Long eventTimeMilis, Long lastModified, Boolean isRead) {
        this.id = id;
        this.eventTimeMilis = eventTimeMilis;
        this.lastModified = lastModified;
        this.isRead = isRead;
        this.title = title;
        this.description = description;
        this.eventTime = DateTimeUtils.milisecondToFormatedDate(eventTimeMilis);
    }
    
}
