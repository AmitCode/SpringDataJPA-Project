package com.springDataJPA.repositories;

import com.springDataJPA.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    public Student findByStudentFName(String name);
    public List<Student> findByStudentLName(String lName);
    public List<Student> findByStudentFNameAndStudentLName(String fName,String lName);
    public List<Student> findByStudentLNameOrStudentLName(String lName1,String lName2);
}
