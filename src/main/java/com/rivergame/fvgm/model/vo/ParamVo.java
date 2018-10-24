package com.rivergame.fvgm.model.vo;

import java.util.HashMap;
import java.util.Map;

public class ParamVo {
    private Map<String, Object> queryParam;

    public Map<String, Object> getQueryParam() {
        if (queryParam == null)
            queryParam = new HashMap();
        return queryParam;
    }

    public void setQueryParam(Map<String, Object> queryParam) {
        this.queryParam = queryParam;
    }

    public void addQueryPram(String name, Object value) {
        if (queryParam == null)
            queryParam = new HashMap();
        queryParam.put(name, value);
    }
}
