package com.zhuxl.common.request;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class PageQueryRequest {
    private Integer pageNum = 1;

    private Integer pageSize = 12;

    private Map<String, String> sortMap = new HashMap<String, String>();

    private Map<String, Object> filterMap = new HashMap<String, Object>();

    public void setFilterMap(Map<String, Object> filterMap) {
        try {
            filterMap.entrySet().stream().forEach(param -> {
                if (param.getValue() != null) {
                    this.filterMap.put(param.getKey(), param.getValue());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
