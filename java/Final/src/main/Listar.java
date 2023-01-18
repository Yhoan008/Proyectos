package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import com.google.gson.*;
import com.google.gson.reflect.*;
import java.lang.reflect.Type;

public class Listar{

    

    JFrame ventana=new JFrame();
    JPanel panel=new JPanel();
    
    List<Empleado> Serial=new ArrayList<Empleado>();
    Gson gson=new Gson();

    JTextField txfield[][]=new JTextField[Serial.size()][18];

    public Listar(){
        
        Deserializar();

        panel.setLayout(new GridLayout(18,Serial.size(),6,6));
        
        for(int i=0;i<Serial.size();i++){


            txfield[i][0]=new JTextField("Hola");
            txfield[i][1]=new JTextField("Hola");
            txfield[i][2]=new JTextField("Hola");
            txfield[i][3]=new JTextField("Hola");
            txfield[i][4]=new JTextField("Hola");
            txfield[i][5]=new JTextField("Hola");
            txfield[i][6]=new JTextField("Hola");
            txfield[i][7]=new JTextField("Hola");
            txfield[i][8]=new JTextField("Hola");
            txfield[i][9]=new JTextField("Hola");
            txfield[i][10]=new JTextField("Hola");
            txfield[i][11]=new JTextField("Hola");
            txfield[i][12]=new JTextField("Hola");
            txfield[i][13]=new JTextField("Hola");
            txfield[i][14]=new JTextField("Hola");
            txfield[i][15]=new JTextField("Hola");
            txfield[i][16]=new JTextField("Hola");
            txfield[i][17]=new JTextField("Hola");

            txfield[i][0].setText(Serial.get(i+1).getCedula());
            txfield[i][1].setText(Serial.get(i+1).getNombre());
            txfield[i][2].setText(Serial.get(i+1).getApellido());
            txfield[i][3].setText(Serial.get(i+1).getCelular());
            txfield[i][4].setText(Serial.get(i+1).getDepartamento());
            txfield[i][5].setText(Serial.get(i+1).getGenero());
            txfield[i][6].setText(Serial.get(i+1).getDireccion());
            txfield[i][7].setText(Serial.get(i+1).getTelefono());
            txfield[i][8].setText(Serial.get(i+1).getEmail());
            txfield[i][9].setText(Serial.get(i+1).getSalarioBase());
            txfield[i][10].setText(Serial.get(i+1).getHora());
            txfield[i][11].setText(Serial.get(i+1).getDiurno());
            txfield[i][12].setText(Serial.get(i+1).getNoche());
            txfield[i][13].setText(Serial.get(i+1).getHed());
            txfield[i][14].setText(Serial.get(i+1).getHen());
            txfield[i][15].setText(Serial.get(i+1).getSubsidio());
            txfield[i][16].setText(Serial.get(i+1).getSalario());
            txfield[i][17].setText(Serial.get(i+1).getTrabaja());

        }

        for(int i=0;i<Serial.size();i++){
            for(int j=0;j<18;j++){
                txfield[i][j].setEditable(false);
                panel.add(txfield[i][j]);
            }
        }
        
        
        ventana.setTitle("LISTAR EMPLEADOS");
        Container contenedor=ventana.getContentPane();
        contenedor.add(panel, BorderLayout.CENTER );
        ventana.setSize(800,500);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

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
