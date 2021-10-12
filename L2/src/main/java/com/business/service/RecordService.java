package com.business.service;

import com.business.model.Record;
import com.business.util.Category;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RecordService {
    private static List<Record> repository = new ArrayList<>();
    private static String defaultCategory;

    private static RecordService singleInstance = null;

    public static RecordService RecordService(){
        if (singleInstance == null) {
            singleInstance = new RecordService();
        }
        return singleInstance;
    }

    public boolean addRecord(HttpServletRequest request){
        if(request.getParameter("key") == null || request.getParameter("value") == null){
            return false;
        }

        repository.add(new Record(request, defaultCategory));
        return true;
    }

    public List<Record> getRecords(){
        return repository;
    }

    public List<Record> getRecords(Category category){
        List<Record> recordList = new ArrayList<>();
        for(Record record: repository){
            if(category == record.getCategory()){
                recordList.add(record);
            }
        }
        return  recordList;
    }

    public void setDefaultCategory(String def){
        defaultCategory = def;
    }
}
