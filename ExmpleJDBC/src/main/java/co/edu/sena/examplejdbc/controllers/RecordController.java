/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.bd.DBrecord;
import co.edu.sena.examplejdbc.model.Record;
import java.util.List;

/**
 *
 * @author Nicol
 */
public class RecordController implements IRecordController {

    private DBrecord dbr = new DBrecord();
    
    @Override
    public void insert(Record record) throws Exception {
        if(record == null)
        {
            throw new Exception("El registro es nulo");
        }
        
        if("".equals(record.getDateRecord()))
        {
            throw new Exception("La fecha es obligatoria");
        }
        
        if("".equals(record.getStartTime()))
        {
            throw new Exception("La hora de inicio es obligatoria");
        }
        
        if("".equals(record.getEndTime()))
        {
            throw new Exception("La hora de fin es obligatoria");
        }
        
        if(record.getEmployeeId() == null)
        {
            throw new Exception("El empleado es obligatorio");
        }
        
        if(record.getKeyId() == null)
        {
            throw new Exception("La llave es obligatoria");
        }
        
        if("".equals(record.getStatus()))
        {
            throw new Exception("El estado es obligatorio");
        }
        
        //insertar 
        dbr.insert(record);
    }

    @Override
    public void update(Record record) throws Exception {
        if(record == null)
        {
            throw new Exception("El registro es nulo");
        }

        if(record.getId() == 0)
        {
            throw new Exception("El Id es obligatorio");
        }
        
        if("".equals(record.getDateRecord()))
        {
            throw new Exception("La fecha es obligatoria");
        }
        
        if("".equals(record.getStartTime()))
        {
            throw new Exception("La hora de inicio es obligatoria");
        }
        
        if("".equals(record.getEndTime()))
        {
            throw new Exception("La hora de fin es obligatoria");
        }
        
        if(record.getEmployeeId() == null)
        {
            throw new Exception("El empleado es obligatorio");
        }
        
        if(record.getKeyId() == null)
        {
            throw new Exception("El id es obligatorio");
        }
        
        if("".equals(record.getStatus()))
        {
            throw new Exception("El estado es obligatorio");
        }
        
        //consultar si el registro existe en la bd
        Record recordExist = dbr.findById(record.getId());
        if(recordExist == null)
        {
            throw new Exception("El registro no existe");
        }
        
        //actualizar      
        dbr.update(record);
    }

    @Override
    public void delete(int id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El Id es obligatorio");
        }
        
        //consultar si el registro existe en la bd
        Record recordExist = dbr.findById(id);
        if(recordExist == null)
        {
            throw new Exception("El registro no existe");
        }
        
        //eliminar
        dbr.delete(id);
    }

    @Override
    public List<Record> findAll() throws Exception {
        return dbr.findAll();
    }

    @Override
    public Record findById(int id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Record record = dbr.findById(id);
        if(record == null)
        {
            throw new Exception("No se encontró el registro con ID: " + id);
        }
        
        return record;
    }
}
