package com.pandaria.farmland.biz.controller;

import com.pandaria.farmland.biz.entity.Task;
import com.pandaria.farmland.biz.service.TaskService;
import com.pandaria.farmland.weixin.entity.DefaultResponse;
import com.pandaria.farmland.weixin.entity.ResponseStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api("任务管理接口")
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @RequestMapping(value = "/v1", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "任务生成接口", notes = "任务提交管理页面接口，将填写任务信息保存")
    public @ResponseBody DefaultResponse<Task> start(@RequestBody Task task) {
        DefaultResponse<Task> response = null;
        if (task == null) {
            response = new DefaultResponse<Task>(ResponseStatus.FAILURE, null);
        } else {
            response = new DefaultResponse<Task>(ResponseStatus.SUCCESS, service.start(task));
        }
        return response;
    }

    @RequestMapping(value = "/{id}/v1", method = {RequestMethod.POST, RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "任务查询接口", notes = "查询任务详细信息，返回已登记任务信息")
    public @ResponseBody DefaultResponse<Task> queryTaskInfo(@PathVariable("id") int id) {
        DefaultResponse<Task> response = null;
        if (id < 0) {
            response = new DefaultResponse<Task>(ResponseStatus.FAILURE, null);
        } else {
            response = new DefaultResponse<>(ResponseStatus.SUCCESS, service.getTaskInfo(id));
        }
        return response;
    }

    @RequestMapping(value = "/update/v1", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "任务信息更新接口", notes = "任务在任务修改页面提交后保存更新后的任务信息")
    public @ResponseBody DefaultResponse<Task> updateTaskInfo(@RequestBody Task task) {
        DefaultResponse<Task> response = null;
        if (task != null && service.updateTaskInfo(task) > 0) {
            response = new DefaultResponse<Task>(ResponseStatus.SUCCESS, task);
        } else if (task == null) {
            response = new DefaultResponse<Task>(ResponseStatus.FAILURE, null);
        }
        return response;
    }

    @RequestMapping(value = "/updateStatus/{id}/{statusCode}/v1", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "任务信息更新接口", notes = "任务在任务修改页面提交后保存更新后的任务信息")
    public @ResponseBody DefaultResponse<Task> updateTaskStatus(@PathVariable("id") int id, @PathVariable("statusCode") int statusCode) {
        DefaultResponse<Task> response = null;
        Task task = new Task();
        task.setId(id);
        task.setStatusCode(statusCode);
        if (id > 0 && service.updateTaskStatusCode(task) > 0) {
            response = new DefaultResponse<Task>(ResponseStatus.SUCCESS, task);
        } else if (task == null) {
            response = new DefaultResponse<Task>(ResponseStatus.FAILURE, null);
        }
        return response;
    }
}
