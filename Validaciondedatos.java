package practica2_2dos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


import javax.swing.JFrame;

public class Validaciondedatos extends JFrame{
    
    interfaz uso;
    
    public Validaciondedatos(){
        setSize(480,310);
//        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Opciones de Ordenamiento");
        setLocationRelativeTo(null);    
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);  
        
        JLabel ordertype = new JLabel("Tipo de Ordenamiento");
        ordertype.setFont(new Font("arial",Font.PLAIN,15));
        ordertype.setBounds(10,10,150,50);
        panel.add(ordertype);
        
        ButtonGroup bg = new ButtonGroup();
        JRadioButton c = new JRadioButton("Ascendente"); 
        c.setSelected(true);
        c.setBounds(50, 50, 110, 30);

        JRadioButton c1 = new JRadioButton("Descendente"); 
        c1.setBounds(200, 50, 110, 30);
        bg.add(c);
        bg.add(c1);
        panel.add(c);
        panel.add(c1);
        
        
        JPanel linea1 = new JPanel();
        linea1.setLayout(null);
        linea1.setBackground(Color.black);
        linea1.setBounds(10, 80, 400, 1);
        panel.add(linea1);  
        
        
        
        JLabel orderspeed = new JLabel("Velocidad de Ordenamiento");
        orderspeed.setFont(new Font("arial",Font.PLAIN,15));
        orderspeed.setBounds(10,90,200,50);
        panel.add(orderspeed);
        
        ButtonGroup bg1 = new ButtonGroup();
        JRadioButton c2 = new JRadioButton("Baja"); 
        c2.setSelected(true);
        c2.setBounds(15, 130, 110, 30);

        JRadioButton c3 = new JRadioButton("Media"); 
        c3.setBounds(15, 160, 110, 30);
        
        JRadioButton c4 = new JRadioButton("Alta"); 
        c4.setBounds(15, 190, 110, 30);
        bg1.add(c2);
        bg1.add(c3);
        bg1.add(c4);
        panel.add(c2);
        panel.add(c3);
        panel.add(c4);
        panel.add(orderspeed);
        
        
        JPanel linea2 = new JPanel();
        linea2.setLayout(null);
        linea2.setBackground(Color.black);
        linea2.setBounds(220, 110, 1, 110);
        panel.add(linea2);  
        
        
        
        JLabel orderalgorithm = new JLabel("Algoritmo de Ordenamiento");
        orderalgorithm.setFont(new Font("arial",Font.PLAIN,15));
        orderalgorithm.setBounds(250,90,200,50);
        panel.add(orderalgorithm);
        
        ButtonGroup bg2 = new ButtonGroup();
        JRadioButton c5 = new JRadioButton("Bubble Sort"); 
        c5.setSelected(true);
        c5.setBounds(250, 130, 110, 30);

        JRadioButton c6 = new JRadioButton("Quick Sort"); 
        c6.setBounds(250, 160, 110, 30);
        
        JRadioButton c7 = new JRadioButton("Shell Sort"); 
        c7.setBounds(250, 190, 110, 30);
        
        bg2.add(c5);
        bg2.add(c6);
        bg2.add(c7);
        panel.add(c5);
        panel.add(c6);
        panel.add(c7);
        panel.add(orderalgorithm);
        
        
        JButton boton = new JButton("Cancelar");////////////////////////////////////////////////        
        boton.setFont(new Font("arial",Font.CENTER_BASELINE,15));
        boton.setForeground(Color.red);
        boton.setBounds(190, 230, 120, 20);
        panel.add(boton);
        
        JButton boton1 = new JButton("Ordenar");////////////////////////////////////////////////        
        boton1.setFont(new Font("arial",Font.CENTER_BASELINE,15));
        boton1.setForeground(Color.blue);
        boton1.setBounds(320, 230, 120, 20);
        panel.add(boton1);
        
        ActionListener boto = (ActionEvent ae)->{
            uso = new interfaz();
            uso.setVisible(true);
            this.dispose();
        };
        boton.addActionListener(boto);
        
        ActionListener boto1 = (ActionEvent ae)->{
            
           interfaz.iniciaHilo=true;
            int x=0;
            int y=0;
            int z=0;
            
            if (c.isSelected()==true) {
//                based.getInstance().escogio[0].setTior(1);
                x=1;
            }
            else if (c1.isSelected()==true) {
//                based.getInstance().escogio[0].setTior(2);
                x=2;
            }
            if (c2.isSelected()==true) {
//                based.getInstance().escogio[0].setVelor(1);
                y=1;
            }
            else if (c3.isSelected()==true) {
//                based.getInstance().escogio[0].setVelor(2);
                y=2;
            }
            else if (c4.isSelected()==true) {
//                based.getInstance().escogio[0].setVelor(3);
                y=3;
            }
            if (c5.isSelected()==true) {
//                based.getInstance().escogio[0].setAlgoror(1);
                z=1;
            }
            else if (c6.isSelected()==true) {
//                based.getInstance().escogio[0].setAlgoror(2);
                z=2;
            }
            else if (c7.isSelected()==true) {
//                based.getInstance().escogio[0].setAlgoror(3);
                z=3;
            }
            based.getInstance().escogio[0] = new datos(x,y,z);
            interfaz.x=x;
            interfaz.y=y;
            interfaz.z=z;
            
            uso = new interfaz();
            uso.setVisible(true);
            
            this.dispose();
            
            
        };
        boton1.addActionListener(boto1);

        
        
        
    }
    
}
