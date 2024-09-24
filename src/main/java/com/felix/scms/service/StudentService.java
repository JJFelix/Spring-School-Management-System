package com.felix.scms.service;

import java.util.List;

import com.felix.scms.dto.StudentDTO;
import com.felix.scms.dto.StudentSaveDTO;
import com.felix.scms.dto.StudentUpdateDTO;

public interface StudentService {

    String addStudent(StudentSaveDTO studentSaveDTO);

    List<StudentDTO> getAllStudents();

    String updateStudent(StudentUpdateDTO studentUpdateDTO);

    boolean deleteStudent(int id);

}
