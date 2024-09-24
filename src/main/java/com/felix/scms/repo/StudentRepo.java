package com.felix.scms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felix.scms.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
