package com.zhuxl.component.log.service.impl;

import com.zhuxl.component.log.entity.LogDO;
import com.zhuxl.component.log.service.LogService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogServiceImpl implements LogService {


    public void info(LogDO logDO) {

    }

    public void info(String logId, String logType, String operType, String logLevel, String userId, String ip, String url, String content, Date createTime) {

    }
}
