/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 *
 * @author Nicol
 */
public class KeyController implements IKeyController {

    private DBKey dbk = new DBKey();
    
    @Override
    public void insert(Key key) throws Exception {
        if(key == null)
        {
            throw new Exception("La llave es nula");
        }
        
        if("".equals(key.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(key.getRoom()))
        {
            throw new Exception("El nombre de la sala es obligatoria");
        }
        
        if(key.getCount() == 0)
        {
            throw new Exception("El conteo es obligatorio");
        }
        
        //insertar 
        dbk.insert(key);
    }

    @Override
    public void update(Key key) throws Exception {
        if(key == null)
        {
            throw new Exception("La llave es nula");
        }

        if(key.getId() == 0)
        {
            throw new Exception("El Id es obligatorio");
        }
        
        if("".equals(key.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(key.getRoom()))
        {
            throw new Exception("El nombre de la sala es obligatoria");
        }
        
        if(key.getCount() == 0)
        {
            throw new Exception("El conteo es obligatorio");
        }
        
        //consultar si la llave existe en la bd
        Key keyExist = dbk.findById(key.getId());
        if(keyExist == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //actualizar      
        dbk.update(key);
    }

    @Override
    public void delete(int id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El Id es obligatorio");
        }
        
        //consultar si la llave existe en la bd
        Key keyExist = dbk.findById(id);
        if(keyExist == null)
        {
            throw new Exception("La llave no existe");
        }
        
        //eliminar
        dbk.delete(id);
    }

    @Override
    public List<Key> findAll() throws Exception {
        return dbk.findAll();
    }

    @Override
    public Key findById(int id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        return dbk.findById(id);
    }
}