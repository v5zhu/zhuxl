package com.zhuxl.common.entity;


import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhuxiaolong
 * @date 2018年1月30日11:07:39
 */
@Getter
@Setter
public abstract class BaseIdSerializable implements Serializable {

    private Long id;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
