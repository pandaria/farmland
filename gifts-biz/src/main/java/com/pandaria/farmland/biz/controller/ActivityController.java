package com.pandaria.farmland.biz.controller;

import com.pandaria.farmland.biz.entity.Activity;
import com.pandaria.farmland.biz.service.ActivityService;
import com.pandaria.farmland.weixin.entity.DefaultResponse;
import com.pandaria.farmland.weixin.entity.ResponseStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api("活动管理接口")
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService service;

    @RequestMapping(value = "/v1", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "活动生成接口", notes = "活动提交管理页面接口，将填写活动信息保存")
    public @ResponseBody DefaultResponse<Activity> start(@RequestBody Activity activity) {
        DefaultResponse<Activity> response = null;
        if (activity == null) {
            response = new DefaultResponse<Activity>(ResponseStatus.FAILURE, null);
        } else {
            response = new DefaultResponse<Activity>(ResponseStatus.SUCCESS, service.start(activity));
        }
        return response;
    }

    @RequestMapping(value = "/{id}/v1", method = {RequestMethod.POST, RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "活动查询接口", notes = "查询活动详细信息，返回已登记活动信息")
    public @ResponseBody DefaultResponse<Activity> queryActivityInfo(@PathVariable("id") int id) {
        DefaultResponse<Activity> response = null;
        if (id < 0) {
            response = new DefaultResponse<Activity>(ResponseStatus.FAILURE, null);
        } else {
            response = new DefaultResponse<>(ResponseStatus.SUCCESS, service.getActivityInfo(id));
        }
        return response;
    }

    @RequestMapping(value = "/update/v1", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ApiOperation(value = "活动信息更新接口", notes = "活动在活动修改页面提交后保存更新后的活动信息")
    public @ResponseBody DefaultResponse<Activity> updateActivityInfo(@RequestBody Activity activity) {
        DefaultResponse<Activity> response = null;
        if (activity != null && service.updateActivityInfo(activity) > 0) {
            response = new DefaultResponse<Activity>(ResponseStatus.SUCCESS, activity);
        } else if (activity == null) {
            response = new DefaultResponse<Activity>(ResponseStatus.FAILURE, null);
        }
        return response;
    }
}
