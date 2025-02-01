package com.springDataJPA.repositories;

import com.springDataJPA.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JPAQueryMethodsTest {
    @Autowired
    private StudentRepo studentRepo;
    @Test
    //after findBy prefix the suffix must be same as column name.
    //Ex:- At the starting, I had created the method with name as findByName and i got an error because name column was not present in db
        // but when i created the method with findByStudentFName then will is working fine as the StudentFName column is present in db.
    void getStudentByName(){
        Student student1 = studentRepo.findByStudentFName("Amit");
        System.out.println("Student Name:"+student1.getStudentFName());
    }

    @Test
    void getStudentByLastName(){
        List<Student> listOfStudents = studentRepo.findByStudentLName("Pandey");
        for(Student student : listOfStudents){
            System.out.println("Student Name :" +student.getStudentFName());
        }
    }

    @Test
    void getStudentByFirstNameAndLastName(){
        List<Student> listOfStudents = studentRepo.findByStudentFNameAndStudentLName("Amit","Pandey");
        for(Student student : listOfStudents){
            System.out.println("Student Name :" +student.getStudentFName());
        }
    }

    @Test
    void getStudentByLastNameOrLastName(){
        List<Student> listOfStudents = studentRepo.findByStudentLNameOrStudentLName("Mishra","Pandey");
        for(Student student : listOfStudents){
            System.out.println("Student Name :" +student.getStudentFName());
        }
    }


}
