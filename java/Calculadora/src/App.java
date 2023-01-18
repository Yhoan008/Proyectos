import javax.swing.*;
import java.awt.*;

public class App extends JFrame{

    JPanel panel;

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;


    public App(){
        super.setTitle("CALCULADORA");
        Container contenedor=getContentPane();

        JTextField tx=new JTextField();
        tx.setPreferredSize(new Dimension(100,35));
        tx.setHorizontalAlignment(tx.RIGHT);
        tx.setFont(new Font("Calibri",3,20));

        GridLayout mGridLayout = new GridLayout(5,4,3,3);
        panel=new JPanel();
        panel.setLayout(mGridLayout);

        b1=new JButton("C");
        b2=new JButton("/");
        b3=new JButton("*");
        b4=new JButton("-");
        b5=new JButton("9");
        b6=new JButton("8");
        b7=new JButton("7");
        b8=new JButton("+");
        b9=new JButton("4");
        b10=new JButton("5");
        b11=new JButton("6");
        b12=new JButton("π");
        b13=new JButton("1");
        b14=new JButton("2");
        b15=new JButton("3");
        b16=new JButton("e");
        b17=new JButton("0");
        b18=new JButton("1/x");
        b19=new JButton(".");
        b20=new JButton("=");

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(b10);
        panel.add(b11);
        panel.add(b12);
        panel.add(b13);
        panel.add(b14);
        panel.add(b15);
        panel.add(b16);
        panel.add(b17);
        panel.add(b18);
        panel.add(b19);
        panel.add(b20);


        contenedor.add(tx,BorderLayout.PAGE_START);
        contenedor.add(panel,BorderLayout.CENTER);
        setSize(300,300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        App app=new App();
    }
}
