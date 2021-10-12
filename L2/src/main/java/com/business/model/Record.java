package com.business.model;

import com.business.util.Category;

import javax.servlet.http.HttpServletRequest;

public class Record {
    private Category category;
    private String value;
    private String key;

    public Record(HttpServletRequest request, String defaultCategory){
        this.value = request.getParameter("value");
        this.key = request.getParameter("key");
        if(request.getParameter("category") != null){
            this.category = Category.fromString(request.getParameter("category"));
        }else{
            this.category = Category.fromString(defaultCategory);
        }
    }

    public Category getCategory() {
        return category;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Record{" +
                "category=" + category +
                ", value='" + value + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
