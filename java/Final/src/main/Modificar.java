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

public class Modificar extends Disenio{

    JFrame ventana=new JFrame();
    
    MouseListener mouseIng=new MouseListener();
    
    int selector=-1;
    List<Empleado> Serial=new ArrayList<Empleado>(){};
    
    public Modificar(){
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

        String cedula=JOptionPane.showInputDialog(null, "DIGITE LA CEDULA QUE DESEA MODIFICAR:");

        Deserializar();


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
            if(e.getSource()==guardar){
                asignar();
                Serializar();
            }
            if(e.getSource()==calcular){
                Calcular();
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
    
    public void Serializar(){

        if (cedula.equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese un usuario valido");

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
        
        
    }
    
    String cedula;
    String nombre;
    String apellido;
    String celular;
    String direccion;
    String telefono;
    String email;
    String salarioBase;
    String hora;
    String diurno;
    String noche;
    String hed;
    String hen;
    String subsidio;
    String salario;
    
    
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



        Serial.get(selector).setCedula(cedula);
        Serial.get(selector).setNombre(nombre);
        Serial.get(selector).setApellido(apellido);
        Serial.get(selector).setCelular(celular);
        Serial.get(selector).setDireccion(direccion);
        Serial.get(selector).setTelefono(telefono);
        Serial.get(selector).setDepartamento((String)box.getSelectedItem());
        Serial.get(selector).setTrabaja(Trabaja);
        Serial.get(selector).setGenero(Genero);
        Serial.get(selector).setEmail(email);
        Serial.get(selector).setSalarioBase(salarioBase);
        Serial.get(selector).setHora(hora);
        Serial.get(selector).setDiurno(diurno);
        Serial.get(selector).setNoche(noche);
        Serial.get(selector).setHed(hed);
        Serial.get(selector).setHen(hen);
        Serial.get(selector).setSubsidio(subsidio);
        Serial.get(selector).setSalario(salario);
    }
    
    Gson gson=new GsonBuilder().setPrettyPrinting().create();

    public void Deserializar(){
        try {
            BufferedReader br=new BufferedReader(new FileReader("./Empleados.json"));
    
            Type listType=new TypeToken<List<Empleado>>(){}.getType();
    
            Serial=gson.fromJson(br, listType);
    
    
        } catch (FileNotFoundException e) {
        }
    }

}
