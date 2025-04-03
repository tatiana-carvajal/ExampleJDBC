/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.model.EmployeeType;
import java.util.List;

/**
 *
 * @author Nicol
 */
public interface IEmployeeTypeController {
    public void insert(EmployeeType employeeType)throws Exception;
    public void update (EmployeeType employeeType) throws Exception;
    public void delete (int id) throws Exception;
    public List<EmployeeType> findAll() throws Exception;
    public EmployeeType findById(int id) throws Exception;
}
