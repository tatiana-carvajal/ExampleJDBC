/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class TestKey {
    public static void main(String[] args) {
        DBKey dBKey = new DBKey();
        //insertar
        Key key = new Key(5, "BICENTENARIO AMBIENTE 05", "Sala 205", 2, "Llavero rojo");
        //dBKey.insert(key);
        
        //actualizar
        //key.setId(8);
        //key.setName("BICENTENARIO");
        //key.setObservation("Llavero verde");
        //dBKey.update(key);
        
        //eliminar
        //dBKey.delete(8);
        
        //consultar todos
        System.out.println("***************************************************+");
        List<Key> listKey = dBKey.findAll();
        for (Key e : listKey) {
            System.out.println("id: " + e.getId() + " name: " + e.getName() + " room: " + e.getRoom() +
                                " count: " + e.getCount() + " observation: " + e.getObservation());
        }
        
       //consultar por id
       System.out.println("***************************************************+");
       Key key2 = dBKey.findById(1);
       if(key2 != null)
       {
           System.out.println("id: " + key2.getId() + " name: " + key2.getName() + " room: " + key2.getRoom() +
                                " count: " + key2.getCount() + " observation: " + key2.getObservation());
       }
       else
       {
            System.out.println("No existe una llave con ese id");
       }
    }
    
}