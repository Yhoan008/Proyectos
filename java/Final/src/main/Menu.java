package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menu{
    
    JFrame ventana=new JFrame();
    Fondo_Panel panel=new Fondo_Panel(); //DECLARACION DE PANEL
    JButton b1=new JButton();
    JButton b2=new JButton();
    JButton b3=new JButton();
    JButton b4=new JButton();
    JButton b5=new JButton();
    JButton b6=new JButton();


    //FONDO
    class Fondo_Panel extends JPanel{
        @Override
        public void paint(Graphics g){
            ImageIcon fondo=new ImageIcon(getClass().getResource("./../img/fondo.jpg"));
            g.drawImage(fondo.getImage(),0,0,getWidth(),getHeight(),this);

            setOpaque(false);
            super.paint(g);
        }
    }

    
    public Menu(){

        JLabel lb=new JLabel();
        lb.setBounds(70,-10,160,70);
        ImageIcon image0=new  ImageIcon(getClass().getResource("./../img/menu.png"));
        ImageIcon imagen=new ImageIcon(image0.getImage().getScaledInstance(lb.getWidth()-10, lb.getHeight(), Image.SCALE_DEFAULT) );
        lb.setIcon(imagen);
        panel.add(lb);

        int x,y;

        //ICONOS 
        JLabel in1=new JLabel();
        x=210;y=60;
        ImageIcon image7=new ImageIcon(getClass().getResource("./../img/icons/ingreso.png"));
        Iconos(in1,image7,x,y);

        JLabel in2=new JLabel();
        x=210;y=140;
        ImageIcon image8=new ImageIcon(getClass().getResource("./../img/icons/lupa.png"));
        Iconos(in2,image8,x,y);

        JLabel in3=new JLabel();
        x=210;y=220;
        ImageIcon image9=new ImageIcon(getClass().getResource("./../img/icons/cambio.png"));
        Iconos(in3,image9,x,y);

        JLabel in4=new JLabel();
        x=205;y=300;
        ImageIcon image10=new ImageIcon(getClass().getResource("./../img/icons/borrar.png"));
        Iconos(in4,image10,x,y);

        JLabel in5=new JLabel();
        x=190;y=380;
        ImageIcon image11=new ImageIcon(getClass().getResource("./../img/icons/lista.png"));
        Iconos(in5,image11,x,y);

        JLabel in6=new JLabel();
        x=195;y=460;
        ImageIcon image12=new ImageIcon(getClass().getResource("./../img/icons/salida.png"));
        Iconos(in6,image12,x,y);

        //BOTONES
        b1=new JButton("INGRESAR");
        b1.setBounds(80,60,140,50);
        ImageIcon image1=new ImageIcon(getClass().getResource("./../img/ingresar.png"));
        Botones(b1, image1);
        EventoIngresar ingresar=new EventoIngresar();
        b1.addMouseListener(ingresar);

        b2=new JButton("CONSULTAR");
        b2.setBounds(80,140,140,50);
        ImageIcon image2=new ImageIcon(getClass().getResource("./../img/consultar.png"));
        Botones(b2,image2);
        EventoConsultar consultar=new EventoConsultar();
        b2.addMouseListener(consultar);

        b3=new JButton("MODIFICAR");
        b3.setBounds(80,220,140,50);
        ImageIcon image3=new ImageIcon(getClass().getResource("./../img/modificar.png"));
        Botones(b3, image3);
        EventoModificar modificar=new EventoModificar();
        b3.addMouseListener(modificar);

        b4=new JButton("ELIMINAR");
        b4.setBounds(80,300,140,50);
        ImageIcon image4=new ImageIcon(getClass().getResource("./../img/eliminar.png"));
        Botones(b4, image4);
        EventoEliminar eliminar=new EventoEliminar();
        b4.addMouseListener(eliminar);

        b5=new JButton("LISTAR");
        b5.setBounds(110,380,90,50);
        ImageIcon image5=new ImageIcon(getClass().getResource("./../img/listar.png"));
        Botones(b5, image5);
        EventoListar listar=new  EventoListar();
        b5.addMouseListener(listar);
        
        b6=new JButton("SALIR");
        b6.setBounds(110,460,90,50);
        ImageIcon image6=new ImageIcon(getClass().getResource("./../img/salir.png"));
        Botones(b6,image6);
        EventoSalir salir=new EventoSalir();
        b6.addMouseListener(salir);

        
    }

//CONFIGURACION GENERAL ICONOS
    public void Iconos(JLabel lb,ImageIcon i,int x,int y){
        lb.setBounds(x,y,50,50);
        ImageIcon imagen=new ImageIcon(i.getImage().getScaledInstance(lb.getWidth()-10, lb.getHeight(), Image.SCALE_DEFAULT) );
        lb.setIcon(imagen);
        panel.add(lb);
    }
    
//EVENTOS DE MOUSE
    //INGRESAR
    class EventoIngresar extends MouseAdapter {
        public void mouseEntered(MouseEvent e){
            b1.setBorder(BorderFactory.createLineBorder(Color.black));
        }
        public void mouseClicked(MouseEvent e){
            Ingreso ingreso=new Ingreso();
            ventana.setVisible(false);
        }
        public void mouseExited(MouseEvent e){
            b1.setBorder(null);
        }
    }
    //CONSULTAR
    class EventoConsultar extends MouseAdapter {
        public void mouseEntered(MouseEvent e){
            b2.setBorder(BorderFactory.createLineBorder(Color.black));
        }
        public void mouseClicked(MouseEvent e){
            Consultar consultar=new Consultar();
            ventana.setVisible(false);
        }
        public void mouseExited(MouseEvent e){
            b2.setBorder(null);

        }
    }
    //MODIFICAR
    class EventoModificar extends MouseAdapter {
        public void mouseEntered(MouseEvent e){
            b3.setBorder(BorderFactory.createLineBorder(Color.black));
        }
        public void mouseClicked(MouseEvent e){
            Modificar modificar=new Modificar();
            ventana.setVisible(false);
        }
        public void mouseExited(MouseEvent e){
            b3.setBorder(null);

        }
    }
    //ELIMINAR
    class EventoEliminar extends MouseAdapter {
        public void mouseEntered(MouseEvent e){
            b4.setBorder(BorderFactory.createLineBorder(Color.black));
        }
        public void mouseClicked(MouseEvent e){
            Eliminar eliminar=new Eliminar();
        }
        public void mouseExited(MouseEvent e){
            b4.setBorder(null);

        }
    }
    //LISTAR
    class EventoListar extends MouseAdapter {
        public void mouseEntered(MouseEvent e){
            b5.setBorder(BorderFactory.createLineBorder(Color.black));
        }
        public void mouseClicked(MouseEvent e){
            Listar listar=new Listar();
            ventana.setVisible(false);
        }
        public void mouseExited(MouseEvent e){
            b5.setBorder(null);

        }
    }
    //SALIR
    class EventoSalir extends MouseAdapter{
        public void mouseEntered(MouseEvent e){
            b6.setBorder(BorderFactory.createLineBorder(Color.black));
        }
        public void mouseClicked(MouseEvent e){
            System.exit(0);
        }   
        public void mouseExited(MouseEvent e){
            b6.setBorder(null);
        } 
    }

    public void Botones(JButton e, ImageIcon image){
        //DISEÑO
        e.setLayout(null);
        e.setContentAreaFilled(false);
        e.setBorder(null);

        //ICONO
        ImageIcon imagen=new ImageIcon(image.getImage().getScaledInstance(e.getWidth()-10, e.getHeight(), Image.SCALE_DEFAULT) );
        e.setIcon(imagen);

        //ACCIONES
        e.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(e);
    }

    public void Componentes(){

        Menu menu=new Menu();

        //DISEÑO
        ventana.setContentPane(panel);
        ventana.setLayout(null);
        ventana.setSize(300,550);
        ventana.setUndecorated(true);

        //DEFAULT
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }

}

