package com.entity.DAO;

import com.entity.StudentEntity;
import com.entity.Students;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentDAO {

    private Students list = new Students();

    public Students getStudentInfo()
    {
        return list;
    }

    public String addStudent(StudentEntity students)
    {
        int size = list.getStudentEntityList().size();
        list.getStudentEntityList().add(students);
        if(list.getStudentEntityList().size() > size){
            return "Inserted new student record";
        }
        return "Failed to insert new student record";
    }

    public String deleteStudent(Integer id)
    {
        for ( StudentEntity s:list.getStudentEntityList())
        {
          if(s.getId().equals(id)){
              list.getStudentEntityList().remove(s);
              return "Student record is deleted";
          }
        }
        return "Student record is not present in the list";
    }

    public String updateStudent(String name, Integer id)
    {
        for ( StudentEntity s:list.getStudentEntityList())
        {
            if(s.getId().equals(id)){
                s.setFirstName(name);
                return "Student record is updated";
            }
        }
        return "Student record not found to update";
    }
}
