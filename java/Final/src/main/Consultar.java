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

public class Consultar extends Disenio{
    JFrame ventana=new JFrame();
    
    MouseListener mouseIng=new MouseListener();

    List<Empleado> Serial=new ArrayList<Empleado>(){};
    
    public Consultar(){
    
        Disenio dis=new Disenio();
    
        volver=new JButton("VOLVER");
        volver.setLayout(null);
        volver.setBounds(550,640,200,50);
        volver.addMouseListener(mouseIng);
        volver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon image1=new ImageIcon(getClass().getResource("./../img/volver.jpg"));
        ImageIcon imagen=new ImageIcon(image1.getImage().getScaledInstance(volver.getWidth()-10, volver.getHeight(), Image.SCALE_DEFAULT ) );
        volver.setIcon(imagen);
        volver.setBorder(null);
        panel.add(volver);
    
        //DISEÑO
        ventana.setContentPane(panel);
        ventana.setLayout(null);
        ventana.setSize(800,750);
        ventana.setUndecorated(true);
    
        //DEFAULT
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String cedula=JOptionPane.showInputDialog(null, "DIGITE LA CEDULA QUE DESEA CONSULTAR:");

        txcedula.setEditable(false);
        txnombre.setEditable(false);
        txapellido.setEditable(false);
        txcelular.setEditable(false);
        txdireccion.setEditable(false);
        txtelefono.setEditable(false);
        txemail.setEditable(false);
        txsalarioBase.setEditable(false);
        txhora.setEditable(false);
        txdiurno.setEditable(false);
        txnoche.setEditable(false);
        txhed.setEditable(false);
        txhen.setEditable(false);
        txsubsidio.setEditable(false);
        txsalario.setEditable(false);

        Deserializar();
    
        int selector=-1;

        for(int i=0;i<Serial.size();i++){

            if(Serial.get(i).getCedula().equals(cedula)){
                selector=i;
            }

        }

        if(selector==-1){
            JOptionPane.showMessageDialog(null, "EMPLEADO NO ENCONTRADO!");
        }else{
            txcedula.setText(Serial.get(selector).getCedula());
            txnombre.setText(Serial.get(selector).getNombre());
            txapellido.setText(Serial.get(selector).getApellido());
            txcelular.setText(Serial.get(selector).getCelular());
            txdireccion.setText(Serial.get(selector).getDireccion());
            txtelefono.setText(Serial.get(selector).getTelefono());
            txemail.setText(Serial.get(selector).getEmail());
            txsalarioBase.setText(Serial.get(selector).getSalarioBase());
            txhora.setText(Serial.get(selector).getHora());
            txdiurno.setText(Serial.get(selector).getDiurno());
            txnoche.setText(Serial.get(selector).getNoche());
            txhed.setText(Serial.get(selector).getHed());
            txhen.setText(Serial.get(selector).getHen());
            txsubsidio.setText(Serial.get(selector).getSubsidio());
            txsalario.setText(Serial.get(selector).getSalario());

            if(Serial.get(selector).getGenero().equals("Femenino")){
                b1.setBackground(Color.LIGHT_GRAY);
            }
            if(Serial.get(selector).getGenero().equals("Masculino")){
                b2.setBackground(Color.LIGHT_GRAY);
            }
            if(Serial.get(selector).getDepartamento().equals("Gerente")){
                box.setSelectedIndex(2);
            }
            if(Serial.get(selector).getDepartamento().equals("Administrativo")){
                box.setSelectedIndex(3);
            }
            if(Serial.get(selector).getDepartamento().equals("Planta")){
                box.setSelectedIndex(4);
            }
            if(Serial.get(selector).getTrabaja().equals("true")){
                b3.setBackground(Color.LIGHT_GRAY);
            }
            if(Serial.get(selector).getTrabaja().equals("false")){
                b4.setBackground(Color.LIGHT_GRAY);
            }
            
        }

    }
    class MouseListener extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            if(e.getSource()==volver){
                Menu menu=new Menu();
                menu.Componentes();
                ventana.setVisible(false);
            }
        }
    }

    Gson gson=new Gson();

    public void Deserializar(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("./Empleados.json"));
    
            Type listType=new TypeToken<List<Empleado>>(){}.getType();
    
            Serial=gson.fromJson(br, listType);
    
    
        } catch (FileNotFoundException e) {
        }
    }

}
