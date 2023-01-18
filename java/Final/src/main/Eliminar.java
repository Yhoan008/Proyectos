package main;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.List;
import com.google.gson.*;
import com.google.gson.reflect.*;
import java.lang.reflect.Type;

public class Eliminar{

    List<Empleado> Serial=new ArrayList<Empleado>();
    Gson gson=new GsonBuilder().setPrettyPrinting().create();

    public Eliminar(){
        Deserializar();

        String cedula=JOptionPane.showInputDialog(null, "DIGITE LA CEDULA QUE DESEA ELIMINAR");

        int selector=-1;

        for(int i=0;i<Serial.size();i++){

            if(Serial.get(i).getCedula().equals(cedula)){
                selector=i;
            }

        }

        Serial.remove(selector);

        Serializar();
    }

    public void Serializar(){

        String Json= gson.toJson(Serial);    
    
        try {
            BufferedWriter br=new BufferedWriter(new FileWriter("./Empleados.json"));
    
            br.write(Json);
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR ARCHIVO JSON");
        }

        JOptionPane.showMessageDialog(null, "EMPLEADO ELIMINADO!");

    }

    public void Deserializar(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("./Empleados.json"));
    
            Type listType=new TypeToken<List<Empleado>>(){}.getType();
    
            Serial=gson.fromJson(br, listType);
    
    
        } catch (FileNotFoundException e) {
        }
    }
    
}
