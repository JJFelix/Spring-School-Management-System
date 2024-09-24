package com.felix.scms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", length = 11)
    private int studentid;

    @Column(name = "student_name", length = 45)
    private String studentname;

    @Column(name = "address", length = 60)
    private String address;

    @Column(name = "phone", length = 12)
    private String phone;

    // public Student() {

    // }

    // public Student(int studentid, String studentname, String address, String phone) {
    //     this.studentid = studentid;
    //     this.studentname = studentname;
    //     this.address = address;
    //     this.phone = phone;
    // }

    public Student(String studentname, String address, String phone) {
        this.studentname = studentname;
        this.address = address;
        this.phone = phone;
    }

    // public int getStudentid() {
    //     return studentid;
    // }

    // public void setStudentid(int studentid) {
    //     this.studentid = studentid;
    // }

    // public String getStudentname() {
    //     return studentname;
    // }

    // public void setStudentname(String studentname) {
    //     this.studentname = studentname;
    // }

    // public String getAddress() {
    //     return address;
    // }

    // public void setAddress(String address) {
    //     this.address = address;
    // }

    // public String getPhone() {
    //     return phone;
    // }

    // public void setPhone(String phone) {
    //     this.phone = phone;
    // }

    // @Override
    // public String toString() {
    //     return "Student [studentid=" + studentid +
    //             ", studentname=" + studentname +
    //             ", address="  + address +
    //             ", phone=" + phone +
    //             "]";
    // }

}
