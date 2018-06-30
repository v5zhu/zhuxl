package com.zhuxl.component.log.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel(value = "日志记录对象", description = "用于存储日志信息")
public class LogDO {
    @ApiModelProperty(value = "日志主键", name = "logId", notes = "形如:201806291200050001")
    private String logId;

    @ApiModelProperty(value = "日志分类", name = "logType", notes = "日志分类")
    private String logType;

    @ApiModelProperty(value = "操作类型", name = "operType", notes = "新增:ADD;修改:MOD;删除:DEL;查看:QUERY")
    private String operType;

    @ApiModelProperty(value = "日志级别", name = "logLevel", notes = "日志级别")
    private Integer logLevel;

    @ApiModelProperty(value = "操作人", name = "userId", notes = "执行该操作的人")
    private String userId;

    @ApiModelProperty(value = "IP地址", name = "ip", notes = "操作所处IP地址")
    private String ip;

    @ApiModelProperty(value = "请求URL", name = "url", notes = "请求URL完整路径")
    private String url;

    @ApiModelProperty(value = "日志记录内容", name = "content", notes = "日志记录内容")
    private String content;

    @ApiModelProperty(value = "日志记录时间", name = "createTime", notes = "日志记录时间")
    private Date createTime;

}
