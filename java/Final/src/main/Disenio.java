package main;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Disenio {
    
    JPanel panel=new JPanel();
    MouseListener mouse =new MouseListener();
    String dep[]={"Seleccione","Gerente","Administrativo","Planta"};
    JButton volver=new JButton();
    JButton guardar=new JButton();
    JButton calcular=new JButton();
    JButton limpiar=new JButton();
    //COMPONENTES
    JButton b1=new JButton();
    JButton b2=new JButton();
    JButton b3=new JButton();
    JButton b4=new JButton();
    JTextField txcedula=new JTextField();
    JTextField txnombre=new JTextField();
    JTextField txapellido=new JTextField();
    JTextField txcelular=new JTextField();
    JComboBox box=new JComboBox<String>(dep);
    String Departamento;
    String Genero;
    JTextField txdireccion=new JTextField();
    JTextField txtelefono=new JTextField();
    JTextField txemail=new JTextField();
    JTextField txsalarioBase=new JTextField();
    JTextField txhora=new JTextField();
    JTextField txdiurno=new JTextField();
    JTextField txnoche=new JTextField();
    JTextField txhed=new JTextField();
    JTextField txhen=new JTextField();
    JTextField txsubsidio=new JTextField();
    JTextField txsalario=new JTextField();
    JLabel lbsalarioBase;
    JLabel lbhora;
    JLabel lbdiurno;
    JLabel lbnoche;
    JLabel lbhed;
    JLabel lbhen;
    JLabel lbsubsidio;
    JLabel lbsalario;
    String Trabaja="true";

    Font fuente=new Font("Arial", Font.ITALIC, 15);

    public Disenio(){
        JLabel title=new JLabel("INGRESAR EMPLEADO");
        title.setLayout(null);
        title.setBounds(275,0,250,50);
        title.setFont(new Font("Arial", Font.ITALIC, 22));
        title.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        title.setBackground(Color.CYAN);
        title.setOpaque(true);
        panel.add(title);

        JLabel lbcedula=new JLabel("CEDULA:");
        Default1(lbcedula);
        lbcedula.setBounds(20,75,100,20);
        
        txcedula=new JTextField();
        txcedula.setLayout(null);
        txcedula.setBounds(120,75,140,20);
        panel.add(txcedula);

        JLabel lbnombre=new JLabel("NOMBRES:");
        Default1(lbnombre);
        lbnombre.setBounds(20,120,100,20);

        txnombre=new JTextField();
        txnombre.setLayout(null);
        txnombre.setBounds(120,120,140,20);
        panel.add(txnombre);

        JLabel lbapellido=new JLabel("APELLIDOS:");
        Default1(lbapellido);
        lbapellido.setBounds(20,175,100,20);

        txapellido=new JTextField();
        txapellido.setLayout(null);
        txapellido.setBounds(120,175,140,20);
        panel.add(txapellido);

        JLabel lbcelular=new JLabel("CELULAR:");
        Default1(lbcelular);
        lbcelular.setBounds(20,220,100,20);

        txcelular=new JTextField();
        txcelular.setLayout(null);
        txcelular.setBounds(120,220,140,20);
        panel.add(txcelular);

        JLabel lbdepartamento=new JLabel("DEPARTAMENTO:");
        Default1(lbdepartamento);
        lbdepartamento.setBounds(350,75,150,20);

        Evento_combo combo=new Evento_combo();
        box.setFont(fuente);
        box.setLayout(null);
        box.setBounds(500,75,150,20);
        box.addActionListener(combo);
        panel.add(box);

        JLabel lbgenero=new JLabel("GENERO:");
        Default1(lbgenero);
        lbgenero.setBounds(20,275,100,20);
        
        b1=new JButton("F");
        b1.setBorder(new EmptyBorder(0,0,0,0));
        b1.setLayout(null);
        b1.setBounds(120,275,20,20);
        b1.addMouseListener(mouse);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(b1);
        
        b2=new JButton("M");
        b2.setBorder(new EmptyBorder(0,0,0,0));
        b2.setLayout(null);
        b2.setBounds(140,275,20,20);
        b2.addMouseListener(mouse);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(b2);

        JLabel lbdireccion=new JLabel("DIRECCIÓN:");
        Default1(lbdireccion);
        lbdireccion.setBounds(350,150,100,20);

        txdireccion=new JTextField();
        txdireccion.setLayout(null);
        txdireccion.setBounds(450,150,200,20);
        panel.add(txdireccion);
        
        JLabel lbtelefono=new JLabel("TELEFONO:");
        Default1(lbtelefono);
        lbtelefono.setBounds(350,205,100,20);

        txtelefono=new JTextField();
        txtelefono.setLayout(null);
        txtelefono.setBounds(450,205,200,20);
        panel.add(txtelefono);

        JLabel lbemail=new JLabel("EMAL:");
        Default1(lbemail);
        lbemail.setBounds(350,260,100,20);

        txemail=new JTextField();
        txemail.setLayout(null);
        txemail.setBounds(450,260,200,20);
        panel.add(txemail);

        lbsalarioBase=new JLabel("SALARIO BASE:");
        Default1(lbsalarioBase);
        lbsalarioBase.setBounds(200,315,130,20);

        txsalarioBase=new JTextField();
        txsalarioBase.setLayout(null);
        txsalarioBase.setBounds(330,315,130,20);
        panel.add(txsalarioBase);

        lbhora=new JLabel("VALOR HORA:");
        Default1(lbhora);
        lbhora.setBounds(20,370,110,20);

        txhora=new JTextField();
        txhora.setLayout(null);
        txhora.setBounds(130,370,100,20);
        txhora.setEditable(false);
        panel.add(txhora);

        lbdiurno=new JLabel("HORAS EXTRA DIURNOS:");
        Default1(lbdiurno);
        lbdiurno.setBounds(20,425,190,20);

        txdiurno=new JTextField();
        txdiurno.setLayout(null);
        txdiurno.setBounds(210,425,100,20);
        panel.add(txdiurno);

        lbnoche=new JLabel("HORAS EXTRA NOCHES:");
        Default1(lbnoche);
        lbnoche.setBounds(20,480,190,20);

        txnoche=new JTextField();
        txnoche.setLayout(null);
        txnoche.setBounds(210,480,100,20);
        panel.add(txnoche);

        lbhed=new JLabel("H.E.D:");
        Default1(lbhed);
        lbhed.setBounds(350,425,50,20);

        txhed=new JTextField();
        txhed.setLayout(null);
        txhed.setBounds(400,425,150,20);
        txhed.setEditable(false);
        panel.add(txhed);

        lbhen=new JLabel("H.E.N:");
        Default1(lbhen);
        lbhen.setBounds(350,480,50,20);

        txhen=new JTextField();
        txhen.setLayout(null);
        txhen.setBounds(400,480,150,20);
        txhen.setEditable(false);
        panel.add(txhen);

        lbsubsidio=new JLabel("SUBSIDIO DE TRANSPORTE:");
        Default1(lbsubsidio);
        lbsubsidio.setBounds(100,535,220,20);

        txsubsidio=new JTextField();
        txsubsidio.setLayout(null);
        txsubsidio.setBounds(320,535,150,20);
        txsubsidio.setEditable(false);
        txsubsidio.setText("106454");
        panel.add(txsubsidio);

        lbsalario=new JLabel("SALARIO:");
        Default1(lbsalario);
        lbsalario.setBounds(100,590,100,20);

        txsalario=new JTextField();
        txsalario.setLayout(null);
        txsalario.setBounds(200,590,100,20);
        txsalario.setEditable(false);
        panel.add(txsalario);

        JLabel Trabaja=new JLabel("TRABAJA ACTUALMENTE?");
        Default1(Trabaja);
        Trabaja.setBounds(500,315,200,20);

        b3=new JButton("SI");
        b3.setBorder(new EmptyBorder(0,0,0,0));
        b3.setLayout(null);
        b3.setBounds(570,335,30,30);
        b3.addMouseListener(mouse);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(b3);

        b4=new JButton("NO");
        b4.setBorder(new EmptyBorder(0,0,0,0));
        b4.setLayout(null);
        b4.setBounds(600,335,30,30);
        b4.addMouseListener(mouse);
        b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(b4);

        

    }

    class Evento_combo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Departamento=(String)box.getSelectedItem();
        }
    }

    public void Default1(JLabel e){
        e.setLayout(null);
        e.setFont(fuente);
        panel.add(e);
    }


    class MouseListener extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            if(e.getSource()==b1){
                b1.setBackground(Color.LIGHT_GRAY);
                b2.setBackground(null);
                Genero="Femenino";
            }
            if(e.getSource()==b2){
                b2.setBackground(Color.LIGHT_GRAY);
                b1.setBackground(null);
                Genero="Masculino";
            }
            if(e.getSource()==b3){
                b3.setBackground(Color.LIGHT_GRAY);
                b4.setBackground(null);
                lbsalarioBase.setVisible(true);
                txsalarioBase.setVisible(true);
                lbhora.setVisible(true);
                txhora.setVisible(true);
                lbhed.setVisible(true);
                txhed.setVisible(true);
                lbhen.setVisible(true);
                txhen.setVisible(true);
                lbsalario.setVisible(true);
                txsalario.setVisible(true);
                lbsubsidio.setVisible(true);
                txsubsidio.setVisible(true);
                lbdiurno.setVisible(true);
                txdiurno.setVisible(true);
                lbnoche.setVisible(true);
                txnoche.setVisible(true);
                Trabaja="true";
            }
            if(e.getSource()==b4){
                b4.setBackground(Color.LIGHT_GRAY);
                b3.setBackground(null);
                lbsalarioBase.setVisible(false);
                txsalarioBase.setVisible(false);
                lbhora.setVisible(false);
                txhora.setVisible(false);
                lbhed.setVisible(false);
                txhed.setVisible(false);
                lbhen.setVisible(false);
                txhen.setVisible(false);
                lbsalario.setVisible(false);
                txsalario.setVisible(false);
                lbsubsidio.setVisible(false);
                txsubsidio.setVisible(false);
                lbdiurno.setVisible(false);
                txdiurno.setVisible(false);
                lbnoche.setVisible(false);
                txnoche.setVisible(false);
                Trabaja="false";
            }
        }
    }

}
