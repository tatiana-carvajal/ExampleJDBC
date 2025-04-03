/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBrecord;
import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Record;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 *fecha: 20/3/2025
 * @author rojas
 * objetivo:  probar consultar/transacciones en la tabla employee
 */
public class TestRecord {
    public static void main(String[] args) {
          DBrecord dbr = new DBrecord();
          DBEmployee dbe = new DBEmployee();
          DBKey dbk = new DBKey();
    
    //insertar
          Employee employee = dbe.findById(1118);
          Key key= dbk.findById(4);
          Record record = new Record(0, "2025-03-25", "10:00", "10:10", employee, key, "ENTREGADO");
          dbr.insert(record);
          
   //actualizar
          Record  record1 = new Record(13, "2025-03-29", "07:00:00", "01:15:00", employee, key, "PENDIENTE");
           dbr.update(record1);
          
          //eliminar
          dbr.delete(14);
          
          //consultar todos
        List<Record> records = dbr.findAll();
        for(Record e : records){
            System.out.println("id: " + e.getId()
                    + " dateRecord: " + e.getDateRecord()
                    + " startTime: " + e.getStartTime()
                    + " endTime: " + e.getEndTime()
                    + " employeeId: " + e.getEmployeeId().getDocument()
                    + " keyId: " + e.getKeyId().getId()
                    + " status: " + e.getStatus());
                     }
          //consultar por id
            System.out.println("");
            Record record2 = dbr.findById(1);
            System.out.println("id: " + record2.getId() +
             "dateRecord: " + record2.getDateRecord()+
                    "startTime: " + record2.getStartTime()+ 
                    "endTime: " + record2.getEndTime()+
                    "employeeId: " + record2.getEmployeeId().getDocument()+ 
                    "keyId: " + record2.getKeyId().getId()+
                    "status: " + record2.getStatus());
    
    }
}