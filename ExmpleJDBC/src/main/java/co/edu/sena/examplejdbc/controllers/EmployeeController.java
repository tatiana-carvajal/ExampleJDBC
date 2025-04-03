/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.model.Employee;
import java.util.List;

/**
 *
 * @author Nicol
 */
public class EmployeeController implements IEmployeeController {

    private DBEmployee dbe = new DBEmployee();
    
    @Override
    public void insert(Employee employee) throws Exception {
        if (employee == null)
        {
            throw new Exception("El empleado es nulo");
        }
        
        if(employee.getDocument() == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        if("".equals(employee.getFullname()))
        {
        throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(employee.getAddress()))
        {
        throw new Exception("La dirección es obligatoria");
        }
        
        if("".equals(employee.getPhone()))
        {
        throw new Exception("El telefono es obligatorio");
        }
        
        //FK
        if(employee.getEmployeeType() == null)
        {
            throw new Exception("El tipo de empleado es obligatorio");
        }
        
        //La PK no es auto incremental, se debe validar existencia del empleado
        Employee employeeExists = dbe.findById(employee.getDocument());
        if(employeeExists != null)
        {
            throw new Exception("Ya existe un empleado con ese documento");
        }
        
        dbe.insert(employee);
        
    }

    @Override
    public void update(Employee employee) throws Exception {
        if (employee == null)
        {
            throw new Exception("El empleado es nulo");
        }
        
        if(employee.getDocument() == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        if("".equals(employee.getFullname()))
        {
        throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(employee.getAddress()))
        {
        throw new Exception("La dirección es obligatoria");
        }
        
        if("".equals(employee.getPhone()))
        {
        throw new Exception("El telefono es obligatorio");
        }
        
        //FK
        if(employee.getEmployeeType() == null)
        {
            throw new Exception("El tipo de empleado es obligatorio");
        }
        
        Employee employeeExists = dbe.findById(employee.getDocument());
        if(employeeExists == null)
        {
            throw new Exception("No existe el empleado");
        }
        
        dbe.update(employee);       
    }

    @Override
    public void delete(Long document) throws Exception {
            
    if(document == 0)
    {
        throw new Exception ("El documento es obligatorio");
    }
    
    Employee employeeExists = dbe.findById(document);
    if(employeeExists == null)
    {
        throw new Exception("No existe un empleado con este documento");
    }
        dbe.delete(document);       
}

    @Override
    public List<Employee> findAll() throws Exception {
        return dbe.findAll();
    }

    @Override
    public Employee findById(long document) throws Exception {
        if(document == 0)
        {
            throw new Exception("El documento es obligatorio");
        }
        
        return dbe.findById(document);
        
    }
    
}
