package com.zhuxl.component.log.service;

import com.zhuxl.component.log.entity.LogDO;

import java.util.Date;

/**
 * @author zhuxl
 */
public interface LogService {
    void info(LogDO logDO);

    void info(String logId, String logType, String operType, String logLevel, String userId, String ip, String url, String content, Date createTime);

}
