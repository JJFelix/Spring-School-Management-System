package com.felix.scms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felix.scms.dto.StudentDTO;
import com.felix.scms.dto.StudentSaveDTO;
import com.felix.scms.dto.StudentUpdateDTO;
import com.felix.scms.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin
@RequestMapping("api/student")
public class StudentController { 
    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public List<StudentDTO> getAllStudents(){
        List<StudentDTO> allStudents = studentService.getAllStudents();
        return allStudents;
    }

    @PostMapping(path = "/add")
    public String addStudent(@RequestBody StudentSaveDTO studentSaveDTO){
        String studentname = studentService.addStudent(studentSaveDTO);
        return studentname;
    }

    @PutMapping(path = "/update")
    public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO){
        String studentname = studentService.updateStudent(studentUpdateDTO);
        return studentname;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value="id") int id){
        boolean deleteStudent = studentService.deleteStudent(id);
        return "Deleted Student";

    }

}
