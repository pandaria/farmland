package com.pandaria.farmland.biz.service;

import com.pandaria.farmland.biz.AppConstants;
import com.pandaria.farmland.biz.component.exception.MandatoryFieldMissingException;
import com.pandaria.farmland.biz.component.exception.RecordAlreadyExistsException;
import com.pandaria.farmland.biz.component.exception.RecordNotFoundException;
import com.pandaria.farmland.biz.entity.Activity;
import com.pandaria.farmland.biz.mapper.ActivityMapper;
import com.pandaria.farmland.biz.mapper.SequenceMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.pandaria.farmland.biz.AppConstants.DOMAIN_CUSTOMER_NAME;

@Service
public class ActivityService {

    @Autowired
    private ActivityMapper mapper;

    @Autowired
    private SequenceMapper sequenceMapper;

    public Activity start(Activity activity) {
        if (activity == null) {
            return null;
        }

        int id = sequenceMapper.getIdFor(AppConstants.DOMAIN_ACTIVITY_NAME);
        activity.setId(id);
        if (mapper.insert(activity) > 0) {
            return activity;
        } else {
            throw new RecordNotFoundException();
        }
    }

    public Activity getActivityInfo(int id) {
        if (id <= 0) {
            throw new RecordNotFoundException();
        }
        Activity activity = mapper.query(id);
        return activity;
    }

    public int updateActivityInfo(Activity activity) {
        if (activity == null) {
            throw new RecordNotFoundException();
        }
        int result = mapper.update(activity);
        return result;
    }
}
