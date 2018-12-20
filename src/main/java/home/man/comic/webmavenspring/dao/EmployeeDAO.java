/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.man.comic.webmavenspring.dao;

/**
 *
 * @author andrey-man
 */
import home.man.comic.webmavenspring.entity.Employee;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 

import org.springframework.stereotype.Repository;
 
@Repository
public class EmployeeDAO {
 
    public List<Employee> getEmployees()  {
         
        Date hireDate1= Date.valueOf(LocalDate.parse("2000-12-11"));
        Employee e1= new Employee(1L, "E01", "Tom", hireDate1);
         
        Date hireDate2= Date.valueOf(LocalDate.parse("2001-12-21"));
        Employee e2= new Employee(2L, "E02", "Jerry", hireDate2);
         
        List<Employee> list= new ArrayList<Employee>();
        list.add(e1);
        list.add(e2);
        return list;        
    }    
     
}