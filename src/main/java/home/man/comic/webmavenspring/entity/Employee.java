/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.man.comic.webmavenspring.entity;

/**
 *
 * @author andrey-man
 */
import java.util.Date;
 
public class Employee {
 
    private Long empId;
    private String empNo;
    private String empName;
    private Date hireDate;
 
    public Employee() {
 
    }
 
    public Employee(Long empId, String empNo,
            String empName, Date hireDate) {
        this.empId = empId;
        this.empNo = empNo;
        this.empName = empName;
        this.hireDate = hireDate;
    }
 
    public Long getEmpId() {
        return empId;
    }
 
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
 
    public String getEmpNo() {
        return empNo;
    }
 
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
 
    public String getEmpName() {
        return empName;
    }
 
    public void setEmpName(String empName) {
        this.empName = empName;
    }
 
    public Date getHireDate() {
        return hireDate;
    }
 
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
     
}