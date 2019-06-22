/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.todoweb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Meet
 */
@Entity
@Table(catalog = "todo_manager", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Todos.findAll", query = "SELECT t FROM Todos t")
    , @NamedQuery(name = "Todos.findById", query = "SELECT t FROM Todos t WHERE t.id = :id")
    , @NamedQuery(name = "Todos.findByTitle", query = "SELECT t FROM Todos t WHERE t.title = :title")
    , @NamedQuery(name = "Todos.findByEventTimeMilis", query = "SELECT t FROM Todos t WHERE t.eventTimeMilis = :eventTimeMilis")
    , @NamedQuery(name = "Todos.findByLastModified", query = "SELECT t FROM Todos t WHERE t.lastModified = :lastModified")
    , @NamedQuery(name = "Todos.findByIsRead", query = "SELECT t FROM Todos t WHERE t.isRead = :isRead")})
public class Todos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String title;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(nullable = false, length = 65535)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "event_time_milis", nullable = false)
    private Long eventTimeMilis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_modified", nullable = false)
    private Long lastModified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_read", nullable = false)
    private Boolean isRead;

    public Todos() {
    }

    public Todos(Long id) {
        this.id = id;
    }

    public Todos(Long id, String title, String description, Long eventTimeMilis, Long lastModified, Boolean isRead) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.eventTimeMilis = eventTimeMilis;
        this.lastModified = lastModified;
        this.isRead = isRead;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEventTimeMilis() {
        return eventTimeMilis;
    }

    public void setEventTimeMilis(Long eventTimeMilis) {
        this.eventTimeMilis = eventTimeMilis;
    }

    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Todos)) {
            return false;
        }
        Todos other = (Todos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.todoweb.todoweb.entity.Todos[ id=" + id + " ]";
    }
    
}
