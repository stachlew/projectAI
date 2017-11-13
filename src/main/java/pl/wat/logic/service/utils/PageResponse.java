package pl.wat.logic.service.utils;

import java.util.List;

public class PageResponse<T> {
    public int pageNo;
    public int pageCount;
    public int elementsCount;
    public List<T> value;
}
