package com.pandaria.farmland.biz.service;

import com.pandaria.farmland.biz.AppConstants;
import com.pandaria.farmland.biz.component.exception.RecordNotFoundException;
import com.pandaria.farmland.biz.entity.Task;
import com.pandaria.farmland.biz.mapper.TaskMapper;
import com.pandaria.farmland.biz.mapper.SequenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskMapper mapper;

    @Autowired
    private SequenceMapper sequenceMapper;

    public Task start(Task task) {
        if (task == null) {
            return null;
        }

        int id = sequenceMapper.getIdFor(AppConstants.DOMAIN_TASK_NAME);
        task.setId(id);
        if (mapper.insert(task) > 0) {
            return task;
        } else {
            throw new RecordNotFoundException();
        }
    }

    public Task getTaskInfo(int id) {
        if (id <= 0) {
            throw new RecordNotFoundException();
        }
        Task task = mapper.query(id);
        return task;
    }

    public int updateTaskInfo(Task task) {
        if (task == null) {
            throw new RecordNotFoundException();
        }
        int result = mapper.update(task);
        return result;
    }

    public int updateTaskStatusCode(Task task) {
        if (task == null) {
            throw new RecordNotFoundException();
        }
        int result = mapper.updateStatusCode(task);
        return result;
    }
}
