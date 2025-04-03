/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.utils;

import com.google.protobuf.TextFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author USUARIO
 */
public class ConvertirUtils {
    public static String dateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String result = dateFormat.format(date);
        return result;
    }
    
    public static Date stringToDate(String text) throws TextFormat.ParseException, ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(text);
        return date;
    }
    
    
    
}
