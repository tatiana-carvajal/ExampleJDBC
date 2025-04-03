/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import static co.edu.sena.examplejdbc.bd.DBConnection.connection;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.EmployeeType;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicol
 */
public class DBEmployee extends DBConnection{
    
    public void insert(Employee employee)
    {
        try 
        {
            connect();
            String sql = "insert into employee values(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, employee.getDocument());
            preparedStatement.setString(2, employee.getFullname());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setInt(5, employee.getEmployeeType().getId());
            //
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } 
        
        catch (SQLException e)
        {
            MessageUtils.showErrorMessage("Error al insertar tipo de empleado  " + e.getMessage());
        }
        
        finally
        {
            disconnect();
        }
    }
    
    public void update (Employee employee)
    {
            try 
            {
                connect();
                String sql = "UPDATE `employee` SET fullname = ?, address = ?, phone = ?, type_id = ? WHERE document = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, employee.getFullname()); // Actualizar el nombre completo
                preparedStatement.setString(2, employee.getAddress());  // Actualizar la dirección
                preparedStatement.setString(3, employee.getPhone());    // Actualizar el teléfono
                preparedStatement.setInt(4, employee.getEmployeeType().getId()); // Actualizar el tipo de empleado (asumiendo que EmployeeType tiene un método getDescript)
                preparedStatement.setLong(5, employee.getDocument());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } 
            catch (SQLException e) 
                
            {
                MessageUtils.showErrorMessage("Error al actualizar empleado  " + e.getMessage());
            }
            finally
                
            {
                disconnect();
            }
    }
            
    public void delete(Long document) {
        try 
        {
            connect();       
            String sql = "DELETE FROM `employee` WHERE document = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, document);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e)
        {
            MessageUtils.showErrorMessage("Error al eliminar el empleado " + e.getMessage());
        } 
        finally 
        {
            disconnect();
        }          
    }
    public List<Employee> findAll() {
    List<Employee> results = new ArrayList<>();
    DBEmployeeType dbet = new DBEmployeeType();

    try {
        connect();
        String sql = "SELECT * FROM employee";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setDocument(resultSet.getLong("document"));
            employee.setFullname(resultSet.getString("fullname"));
            employee.setAddress(resultSet.getString("address"));
            employee.setPhone(resultSet.getString("phone"));

            // FK (Foreign Key)
            EmployeeType employeeType = dbet.findById(resultSet.getInt("type_id"));
            employee.setEmployeeType(employeeType);
            results.add(employee);
        }

        resultSet.close();
    } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar el empleado " + e.getMessage());
    } finally {
        disconnect();
    }

    return results;
}            
    public Employee findById(long document) {
    Employee employee = null;
    DBEmployeeType dbet = new DBEmployeeType();

    try {
        connect();
        String sql = "SELECT * FROM employee WHERE document = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, document);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            employee = new Employee();
            employee.setDocument(resultSet.getLong("document"));
            employee.setFullname(resultSet.getString("fullname"));
            employee.setAddress(resultSet.getString("address"));
            employee.setPhone(resultSet.getString("phone"));

            // FK (Foreign Key)
            EmployeeType employeeType = dbet.findById(resultSet.getInt("type_id"));
            employee.setEmployeeType(employeeType);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar por id el empleado " + e.getMessage());
            
    } finally {
        disconnect();
    }

    return employee;
}
            
}
