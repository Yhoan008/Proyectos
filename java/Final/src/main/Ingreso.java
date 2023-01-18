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

public class Ingreso extends Disenio{

    JFrame ventana=new JFrame();
    
    MouseListener mouseIng=new MouseListener();
    
    public Ingreso(){
    
        Disenio dis=new Disenio();
        
        
        guardar=new JButton("GUARDAR");
        guardar.setLayout(null);
        guardar.setBounds(350,640,100,50);
        guardar.addMouseListener(mouseIng);
        guardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(guardar);
    
        calcular=new JButton("CALCULAR");
        calcular.setLayout(null);
        calcular.setBounds(200,640,100,50);
        calcular.addMouseListener(mouseIng);
        calcular.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(calcular);
    
        limpiar=new JButton("LIMPIAR");
        limpiar.setLayout(null);
        limpiar.setBounds(50,640,100,50);
        limpiar.addMouseListener(mouseIng);
        limpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(limpiar);
    
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
    
    }

    class MouseListener extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            if(e.getSource()==volver){
                Menu menu=new Menu();
                menu.Componentes();
                ventana.setVisible(false);
            }
            if(e.getSource()==guardar){
                asignar();
                Des();
                Ser();
            }
            if(e.getSource()==calcular){
                Calcular();
            }
            if(e.getSource()==limpiar){
                Limpiar();
            }
        }
    }
    
    
    String cedula;String nombre;String apellido;String celular;String direccion;String telefono;String email;String salarioBase;String hora;String diurno;String noche;String hed  ;String hen  ;String subsidio;String salario;

    public void asignar(){


        cedula=txcedula.getText();
        nombre=txnombre.getText();
        apellido=txapellido.getText();
        celular=txcelular.getText();
        //DEPARTAMENTO
        //GENERO
        direccion=txdireccion.getText();
        telefono=txtelefono.getText();
        email=txemail.getText();
        salarioBase=txsalarioBase.getText();
        hora=txhora.getText();
        diurno=txdiurno.getText();
        noche=txnoche.getText();
        hed=txhed.getText();  
        hen=txhen.getText();  
        subsidio =txsubsidio.getText();
        salario=txsalario.getText();
        //Trabaja
    }

    List<Empleado> Serial=new ArrayList<Empleado>();
    Gson gson=new GsonBuilder().setPrettyPrinting().create();

    public void Ser(){

        if (cedula.equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese un usuario valido");

        }else{

            boolean regis=false;

            for(int i=0;i<Serial.size();i++){
                if (Serial.get(i).getCedula().equals(cedula)){
                    JOptionPane.showMessageDialog(null, "USUARIO YA REGISTRADO!");
                    regis=true;
                }
                
            }

            if(regis!=true){
                Serial.add(
        
                    new Empleado(cedula, nombre, apellido, celular, Departamento, Genero, direccion, telefono, email, salarioBase, hora, diurno, noche, hed, hen, subsidio, salario,Trabaja)
        
                );
            }
        }
        
        Ordenar();
    
        String Json= gson.toJson(Serial);    
    
        try {
            BufferedWriter br=new BufferedWriter(new FileWriter("./Empleados.json"));
    
            br.write(Json);
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO CREAR ARCHIVO JSON");
        }

        JOptionPane.showMessageDialog(null, "EMPLEADO GUARDADO!");
        Limpiar();

    }
    
    public void Des(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("./Empleados.json"));
    
            Type listType=new TypeToken<List<Empleado>>(){}.getType();
    
            Serial=gson.fromJson(br, listType);
    
    
        } catch (FileNotFoundException e) {
        }

    }

    public void Ordenar(){

        int tm=Serial.size();

        for (int i=0;i<tm;i++){
            for (int j=i;j<tm;j++){

                int a=Integer.parseInt(Serial.get(i).getCedula());
                int b=Integer.parseInt(Serial.get(j).getCedula());
                
                String rep;

                if(a>b){

                    rep=Serial.get(i).getCedula();
                    Serial.get(i).setCedula(Serial.get(j).getCedula());
                    Serial.get(j).setCedula(rep);

                    rep=Serial.get(i).getNombre();
                    Serial.get(i).setNombre(Serial.get(j).getNombre());
                    Serial.get(j).setNombre(rep);

                    rep=Serial.get(i).getApellido();
                    Serial.get(i).setApellido(Serial.get(j).getApellido());
                    Serial.get(j).setApellido(rep);

                    rep=Serial.get(i).getCelular();
                    Serial.get(i).setCelular(Serial.get(j).getCelular());
                    Serial.get(j).setCelular(rep);

                    rep=Serial.get(i).getDepartamento();
                    Serial.get(i).setDepartamento(Serial.get(j).getDepartamento());
                    Serial.get(j).setDepartamento(rep);

                    rep=Serial.get(i).getGenero();
                    Serial.get(i).setGenero(Serial.get(j).getGenero());
                    Serial.get(j).setGenero(rep);

                    rep=Serial.get(i).getDireccion();
                    Serial.get(i).setDireccion(Serial.get(j).getDireccion());
                    Serial.get(j).setDireccion(rep);

                    rep=Serial.get(i).getTelefono();
                    Serial.get(i).setTelefono(Serial.get(j).getTelefono());
                    Serial.get(j).setTelefono(rep);

                    rep=Serial.get(i).getEmail();
                    Serial.get(i).setEmail(Serial.get(j).getEmail());
                    Serial.get(j).setEmail(rep);

                    rep=Serial.get(i).getSalarioBase();
                    Serial.get(i).setSalarioBase(Serial.get(j).getSalarioBase());
                    Serial.get(j).setSalarioBase(rep);

                    rep=Serial.get(i).getHora();
                    Serial.get(i).setHora(Serial.get(j).getHora());
                    Serial.get(j).setHora(rep);

                    rep=Serial.get(i).getDiurno();
                    Serial.get(i).setDiurno(Serial.get(j).getDiurno());
                    Serial.get(j).setDiurno(rep);

                    rep=Serial.get(i).getNoche();
                    Serial.get(i).setNoche(Serial.get(j).getNoche());
                    Serial.get(j).setNoche(rep);

                    rep=Serial.get(i).getHed();
                    Serial.get(i).setHed(Serial.get(j).getHed());
                    Serial.get(j).setHed(rep);

                    rep=Serial.get(i).getHen();
                    Serial.get(i).setHen(Serial.get(j).getHen());
                    Serial.get(j).setHen(rep);

                    rep=Serial.get(i).getSubsidio();
                    Serial.get(i).setSubsidio(Serial.get(j).getSubsidio());
                    Serial.get(j).setSubsidio(rep);

                    rep=Serial.get(i).getSalario();
                    Serial.get(i).setSalario(Serial.get(j).getSalario());
                    Serial.get(j).setSalario(rep);

                    rep=Serial.get(i).getTrabaja();
                    Serial.get(i).setTrabaja(Serial.get(j).getTrabaja());
                    Serial.get(j).setTrabaja(rep);


                }

            }
        }

    }
    
    public void Calcular(){
        float init=0;
        float intDiurno=0;
        float intNoche=0;
        float intSub=0;

        if( txsalarioBase.getText().equals("") || txdiurno.getText().equals("") || txnoche.getText().equals("") || txsubsidio.getText().equals("") ){
        }else{
            init=Integer.parseInt(txsalarioBase.getText());
            intDiurno =Integer.parseInt(txdiurno.getText());
            intNoche =Integer.parseInt(txnoche.getText());
            intSub=Integer.parseInt(txsubsidio.getText());
        }
        

        float intHora=init/30;
        
        txhora.setText( Float.toString(intHora));

        float inithed=intDiurno*intHora;
        float initHen=intNoche*(intHora+1);

        txhed.setText(Float.toString(inithed));
        txhen.setText(Float.toString(initHen));

        float Total=inithed+initHen+intSub+init;

        txsalario.setText(Float.toString(Total));

    }

    public void Limpiar(){
        txcedula.setText("");
        txnombre.setText("");
        txapellido.setText("");
        txcelular.setText("");
        box.setSelectedIndex(0);
        b1.setBackground(null);b2.setBackground(null);
        txdireccion.setText("");
        txtelefono.setText("");
        txemail.setText("");
        txsalarioBase.setText("");
        txhora.setText("");
        txdiurno.setText("");
        txnoche.setText("");
        txhed.setText("");  
        txhen.setText("");  
        txsubsidio.setText("");
        txsalario.setText("");
    }
}
