package com.example.HelloWorld;

import com.entity.DAO.StudentDAO;
import com.entity.StudentEntity;
import com.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication(scanBasePackages={"com.entity.DAO"})
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDAO studentDao;

    public static void main(String[] args) {
        SpringApplication.run(StudentController.class, args);
           }

    @GetMapping(path = "/get",produces = "application/json")

    public Students getEmployees()
    {
        return studentDao.getStudentInfo();
    }

    @PostMapping(path = "/post", consumes = "application/json", produces = "application/json")

    public String addStudent(@RequestBody StudentEntity student)
   {
        Integer id = studentDao.getStudentInfo().getStudentEntityList().size()+1;
        student.setId(id);
        String result = studentDao.addStudent(student);

       return result;
    }

    @DeleteMapping(path = "/delete/{id}", consumes = "application/json", produces = "application/json")

    public String deleteStudent(@PathVariable String id) {
        String result = studentDao.deleteStudent(Integer.parseInt(id));
        return result;
    }

    @PutMapping(path = "/update/{firstName}/{id}", consumes = "application/json", produces = "application/json")

    public String updateStudent(@PathVariable String firstName, @PathVariable String id) {
        String result = studentDao.updateStudent(firstName , Integer.parseInt(id));
        return result;
    }
}
