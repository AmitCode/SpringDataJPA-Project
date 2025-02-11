package com.springDataJPA.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Locale;
//@Entity-> if we are using this annotation table name will be class name.
@Entity//Combination of @Entity + @Table
@Table(name = "StudentDetails",uniqueConstraints={@UniqueConstraint(name="id_unique",columnNames ="studentId")})
//schema="" we can use it in table for defining schema or table name.
//uniqueConstraints(name="id_unique",column ="id")unique Constraints key Name="PK Name" column ="Column name which will be "pk

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    @Column(name = "StudentFirstName",nullable = false,length = 300)
    private String studentFName;
    @Column(name = "StudentMiddleName",nullable = false,length = 300)
    private String studentMName;
    @Column(name = "StudentLastName",nullable = false,length = 300)
    private String studentLName;
    private String studentAge;
    private String studentAddress;
    private String studentDOB;
    @CreationTimestamp
    private LocalDateTime creationData;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedTime;

    public LocalDateTime getCreationData() {
        return creationData;
    }

    public void setCreationData(LocalDateTime creationData) {
        this.creationData = creationData;
    }

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentFName() {
        return studentFName;
    }

    public void setStudentFName(String studentFName) {
        this.studentFName = studentFName;
    }

    public String getStudentMName() {
        return studentMName;
    }

    public void setStudentMName(String studentMName) {
        this.studentMName = studentMName;
    }

    public String getStudentLName() {
        return studentLName;
    }

    public void setStudentLName(String studentLName) {
        this.studentLName = studentLName;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(String studentDOB) {
        this.studentDOB = studentDOB;
    }

//    public LocalDateTime getInsertDate() {
//        return insertDate;
//    }
//
//    public void setInsertDate(LocalDateTime insertDate) {
//        this.insertDate = insertDate;
//    }
//
//    public LocalDateTime getLastUpdatedDate() {
//        return lastUpdatedDate;
//    }
//
//    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
//        this.lastUpdatedDate = lastUpdatedDate;
//    }

//    private LocalDateTime insertDate;
//    private LocalDateTime lastUpdatedDate;
}
