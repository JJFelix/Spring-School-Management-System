package com.felix.scms.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felix.scms.dto.StudentDTO;
import com.felix.scms.dto.StudentSaveDTO;
import com.felix.scms.dto.StudentUpdateDTO;
import com.felix.scms.entity.Student;
import com.felix.scms.repo.StudentRepo;
import com.felix.scms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> getStudents = studentRepo.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (Student student:getStudents){
            StudentDTO studentDTO = new StudentDTO(
                student.getStudentid(),
                student.getStudentname(),
                student.getAddress(),
                student.getPhone()
            );
            studentDTOList.add(studentDTO);
        }

        return studentDTOList;
    }

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {
        Student student = new Student(
            studentSaveDTO.getStudentname(),
            studentSaveDTO.getAddress(),
            studentSaveDTO.getPhone()
        );
         studentRepo.save(student);
        return "Student "+student.getStudentname() +" added successfully";
    }

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {
        if (studentRepo.existsById(studentUpdateDTO.getStudentid())){
            // Student student = studentRepo.getById(studentUpdateDTO.getStudentid());
            // student.setStudentname(studentUpdateDTO.getStudentname());
            // student.setAddress(studentUpdateDTO.getAddress());
            // student.setPhone(studentUpdateDTO.getPhone());

            Student student = studentRepo.getReferenceById(studentUpdateDTO.getStudentid());
            student.setStudentname(studentUpdateDTO.getStudentname());
            student.setAddress(studentUpdateDTO.getAddress());
            student.setPhone(studentUpdateDTO.getPhone());

            studentRepo.save(student);
            return "Student updated successfully";
        }else{ //better error handling required
            return "Student ID not found";
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
