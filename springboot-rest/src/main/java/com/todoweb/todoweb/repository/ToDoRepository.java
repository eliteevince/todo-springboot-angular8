/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.todoweb.repository;

import com.todoweb.todoweb.entity.Todos;
import com.todoweb.todoweb.proxy.ToDoProxy;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Meet
 */
public interface ToDoRepository extends JpaRepository<Todos, Long> {

    @Query("SELECT new com.todoweb.todoweb.proxy.ToDoProxy(td.id,td.title,td.description,td.eventTimeMilis,td.lastModified,td.isRead) FROM Todos td order by td.eventTimeMilis desc")
    public List<ToDoProxy> findToDoProxy();

}