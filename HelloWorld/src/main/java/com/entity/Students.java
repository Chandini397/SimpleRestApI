package com.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class Students {

    private List<StudentEntity> studentEntityList;

    public List<StudentEntity> getStudentEntityList() {
        if (studentEntityList == null) {
            studentEntityList  = new ArrayList<>();
        }
        return studentEntityList;
    }

    public void setStudentEntityList(List<StudentEntity> studentEntityList) {
        this.studentEntityList = studentEntityList;
    }
}
