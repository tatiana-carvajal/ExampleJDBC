/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.DBEmployeeType;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.util.List;

/**
 *
 * @author Nicol
 */
public class TestEmployee {
public static void main(String[] args) {
        DBEmployee dbe = new DBEmployee();
        DBEmployeeType dbet = new DBEmployeeType();
        
        //insertar
        EmployeeType employeeType = dbet.findById(1);
        Employee employee = new Employee (1117012959, "ELSA BROSON", "Av 5a","310", employeeType);
        //dbe.insert(employee);
        
        //modificar
        employee.setFullname("ELTON TITO");
        employeeType = dbet.findById(2);
        employee.setEmployeeType(employeeType);
        //dbe.update(employee);
        //eliminar
        //dbe.delete(1117012959);
        //consultar todos
        List<Employee> employees = dbe.findAll();
        for (Employee e : employees) {
            System.out.println("document: " + e.getDocument() + " fullname: " + e.getFullname() + 
                                " adress: " + e.getAddress() + " phone: " + e.getPhone() +
                                " type: " + e.getEmployeeType().getDescript());
        }
}
}