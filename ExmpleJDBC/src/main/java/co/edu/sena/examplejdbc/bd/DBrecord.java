/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import static co.edu.sena.examplejdbc.bd.DBConnection.connection;
import co.edu.sena.examplejdbc.model.Record;
import static co.edu.sena.examplejdbc.bd.DBConnection.statement;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Key;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *fecha: 20/3/2025
 * @author rojas
 * objetivo: permite consultas y transacciones en la tabla record.
 */
public class DBrecord  extends DBConnection {
     public void insert(Record record) {
        try {
            connect();
            String sql = "INSERT INTO record (date_record, start_time, end_time, employee_id, key_id, status) VALUES (?, ?, ?, ?, ?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,record.getDateRecord());
            preparedStatement.setString(2,record.getStartTime());
            preparedStatement.setString(3,record.getEndTime());
            preparedStatement.setLong(4, record.getEmployeeId().getDocument()); // FK EMPLOYEE
            preparedStatement.setInt(5, record.getKeyId().getId()); // FK KEY
            preparedStatement.setString(6, record.getStatus());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al insertar registro" + e.getMessage());
        } finally {
            disconnect();
        }
    }
     
     public void update(Record record) {
        try {
            connect();
            String sql = "update record set  date_record = ?, start_time = ?, end_time = ?, employee_id = ?, key_id = ?, "
                    + "status = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,record.getDateRecord());
            preparedStatement.setString(2,record.getStartTime());
            preparedStatement.setString(3,record.getEndTime());
            preparedStatement.setLong(4,record.getEmployeeId().getDocument());
            preparedStatement.setInt(5, record.getKeyId().getId());
            preparedStatement.setString(6,record.getStatus());
            preparedStatement.setInt(7,record.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al actualizar registro " + e.getMessage());
        } finally {
            disconnect();
        }
    }
     
     public void delete(int id) {
        try {
            connect();
            String sql = "delete from record where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
              } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al eliminar registro " + e.getMessage());
        } finally {
            disconnect();
        }
    }
               
     
     public List<Record> findAll() {
        List<Record> records = new ArrayList<>();
        DBEmployee dbe = new DBEmployee();
        DBKey dbk = new DBKey();
        try {
            connect();
            String sql = "select * from record";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Record record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setDateRecord(resultSet.getString("date_record"));
                record.setStartTime(resultSet.getString("start_time"));
                record.setEndTime(resultSet.getString("end_time"));
                record.setStatus(resultSet.getString("status"));
                //FK de employee
                Employee employee = dbe.findById(resultSet.getInt("employee_id"));
                record.setEmployeeId(employee);
                //FK de key
                Key key = dbk.findById(resultSet.getInt("key_id"));
                record.setKeyId(key);
                records.add(record);
            }
              } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar registro" + e.getMessage());
        } finally {
            disconnect();
        }
        return records;

    }
public Record findById(int id) {
        Record record = null;
        DBEmployee dbe = new DBEmployee();
        DBKey dbk = new DBKey();

        try {
            connect();
            String sql = "select * from record where id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                record= new Record();
                record.setId(resultSet.getInt("id"));
                record.setDateRecord(resultSet.getString("date_record"));
                record.setStartTime(resultSet.getString("start_time"));
                record.setEndTime(resultSet.getString("end_time"));
                record.setStatus(resultSet.getString("status"));
                //FK
                Employee employee = dbe.findById(resultSet.getInt("employee_id"));
                record.setEmployeeId(employee);
                //FK de key
                Key key = dbk.findById(resultSet.getInt("key_id"));
                record.setKeyId(key);
                
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar empleado" + e.getMessage());
        } finally {
            disconnect();
        }
        return record;
    }
 }
