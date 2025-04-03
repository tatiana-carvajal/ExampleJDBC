/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.model;

/**
 *
 * @author Nicol
 */
public class Record {
    private int id;
    private String dateRecord;
    private String startTime;
    private String endTime;
    private Employee employeeId;
    private Key keyId;
    private String status;

    public Record() {
    }

    public Record(int id, String dateRecord, String startTime, String endTime, Employee employeeId, Key keyId, String status) {
        this.id = id;
        this.dateRecord = dateRecord;
        this.startTime = startTime;
        this.endTime = endTime;
        this.employeeId = employeeId;
        this.keyId = keyId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateRecord() {
        return dateRecord;
    }

    public void setDateRecord(String dateRecord) {
        this.dateRecord = dateRecord;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Key getKeyId() {
        return keyId;
    }

    public void setKeyId(Key keyId) {
        this.keyId = keyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}

    