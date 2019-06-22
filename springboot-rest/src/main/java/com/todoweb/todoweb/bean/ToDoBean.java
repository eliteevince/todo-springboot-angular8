/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoweb.todoweb.bean;

import com.todoweb.todoweb.ListUtils;
import com.todoweb.todoweb.StringUtils;
import com.todoweb.todoweb.entity.Todos;
import com.todoweb.todoweb.proxy.ToDoProxy;
import com.todoweb.todoweb.repository.ToDoRepository;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PDP_Shiva
 */
@Component
@Transactional
@Repository
public class ToDoBean {

    @Autowired
    private ToDoRepository toDoRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public String saveOrUpdate(ToDoProxy doProxy) {
        String title = doProxy.getTitle();
        String description = doProxy.getDescription();
        Long eventTimeMilis = doProxy.getEventTimeMilis();
        Boolean isRead = doProxy.getIsRead();
        String msg;
        Boolean isValid = !(StringUtils.isNullOrEmpty(title) || StringUtils.isNullOrEmpty(description)
                || null == eventTimeMilis || null == isRead);

        if (isValid) {
            Long id = doProxy.getId();
            Todos master;
            if (null != id) {
                Optional<Todos> findById = toDoRepository.findById(id);
                if (findById.isPresent()) {
                    master = findById.get();
                    msg = "ToDo Updated Successfully";
                } else {
                    return "Id Not Found";
                }
            } else {
                master = new Todos();
                msg = "ToDo Saved Successfully";
            }

            master.setTitle(title);
            master.setDescription(description);
            master.setEventTimeMilis(eventTimeMilis);
            master.setLastModified(System.currentTimeMillis());
            master.setIsRead(isRead);
            toDoRepository.saveAndFlush(master);
        } else {
            msg = "Form not fill properly";
        }
        return msg;
    }

    public List<ToDoProxy> getToDoList() {
        return toDoRepository.findToDoProxy();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String deleteToDo(List<Long> ids) {
        String msg;
        if (!ListUtils.isNullOrEmpty(ids)) {
            List<Todos> findAllById = toDoRepository.findAllById(ids);
            toDoRepository.deleteInBatch(findAllById);
            msg = "Todo Deleted";
        } else {
            msg = "Id must be required";
        }
        return msg;
    }
}
