package com.springDataJPA.repositories;

import com.springDataJPA.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//This is use to loan all bean present in our project
@SpringBootTest
class StudentRepoTest {
    @Autowired
    private StudentRepo studentRepo;
    @Test
    void saveStudentDetails(){
        Student student = new Student();
        student.setStudentFName("Amit");
        student.setStudentMName("Kumar");
        student.setStudentLName("Pandey");
        student.setStudentDOB("05-07-2001");
        student.setStudentAge("25");
        student.setStudentAddress("Sector 45, Gurugram, Haryana");
        //Calling save method which belongs to JPARepository to save student details
        Student savedStudent = studentRepo.save(student);
        System.out.println("Saved student Details : " +savedStudent.toString());
    }

    @Test
    public void updateStudentDetails(){
        Student studentToUpdate = studentRepo.findById(1).get();
        studentToUpdate.setStudentAddress("Siddharth Nagar, Uttar Pradesh, India (272207)");
        studentToUpdate = studentRepo.save(studentToUpdate);
        System.out.println("Updated Student Details : " +studentToUpdate.toString());
    }


    @Test
    public void getStudentDtlById(){
        Student student = new Student();
        student = studentRepo.findById(52).get();
        System.out.println("Found Student Details : " +student.getStudentId());
    }


    @Test
    public void saveListOfStudentDetails(){
        Student student = new Student();
        student.setStudentFName("Shivam");
        student.setStudentMName("Kumar");
        student.setStudentLName("Pandey");
        student.setStudentDOB("05-07-2001");
        student.setStudentAge("25");
        student.setStudentAddress("Sector 45, Gurugram, Haryana");

        Student student1 = new Student();
        student1.setStudentFName("Rahul");
        student1.setStudentMName("");
        student1.setStudentLName("Yadav");
        student1.setStudentDOB("23-05-1987");
        student1.setStudentAge("45");
        student1.setStudentAddress("Sector 45, Gurugram, Haryana");

        List<Student> listOfStudents = studentRepo.saveAll(List.of(student1,student));
    }

    @Test
    public void getAllStudentDetails(){
        List<Student> students = new ArrayList<>();
        students = studentRepo.findAll();
        for(Student student : students){
            System.out.println("Student Id :" +student.getStudentId() + " Student Name : " +student.getStudentFName());
        }
    }

    @Test
    public void deleteStudentByStudent(){
        studentRepo.deleteById(52);
    }

    //In delete case hibernate first fire a select statement the file no of delete script based on the records
    @Test
    public void deleteStudent(){
        Student student = studentRepo.findById(152).get();
        studentRepo.delete(student);
    }


    @Test
    public void deleteListOfStudentById(){
        studentRepo.deleteAllById(List.of(203,204));
    }

    @Test
    public void deleteAllStudent(){
        studentRepo.deleteAll();
    }

    @Test
    public void countNoOfStudent(){
        System.out.println("No of students : " +studentRepo.count());
    }

    @Test
    public void isStudentExists(){
        System.out.println("Student with is exists : " +studentRepo.existsById(252));
        //Script for this : select count(*) from student_details s1_0 where s1_0.student_id=?
    }
}