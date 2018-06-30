package com.zhuxl.common.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseEntity extends AbstractIdSerializable {
    private Date gmtCreate;

    private Date gmtModified;


}
