package com.rivergame.fvgm.model.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminPageVo {
    private int curPage = 1;

    private int pageSize = 10;

    private Map<String, Object> queryParam;

    private int maxPage;

    private List list;

    private long count;
    private int curCount;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        if (curPage > 1)
            this.curPage = curPage;
    }

    public int getPageStart() {
        return (curPage - 1) * pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 1) {
            this.pageSize = pageSize;
        }
    }

    public Integer getLimitSize() {
        return Integer.valueOf(pageSize);
    }

    public long getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public Map<String, Object> getQueryParam() {
        if (queryParam == null)
            queryParam = new HashMap();
        return queryParam;
    }

    public void setQueryParam(Map<String, Object> queryParam) {
        this.queryParam = queryParam;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
        if (list != null)
            curCount = list.size();
    }

    public long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = (count == null ? 0L : count.longValue());
        maxPage = ((int) (count.longValue() % pageSize == 0L ? count.longValue() / pageSize : count.longValue() / pageSize + 1L));
    }

    public int getCurCount() {
        return curCount;
    }

    public void setCurCount(int curCount) {
        this.curCount = curCount;
    }

    public void addQueryPram(String name, Object value) {
        if (queryParam == null)
            queryParam = new HashMap();
        queryParam.put(name, value);
    }
}
