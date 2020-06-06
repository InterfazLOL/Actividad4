package client.vistaPrincipal;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class VistaPrincipalTemplate extends JFrame{

    private JButton btnEnviar;
    private JTextField txtEnviar;   

    public VistaPrincipalTemplate(){
        
        //super("Vista principal");
        this.setTitle("Vista principal");
        this.setSize(1200, 700);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setUndecorated(true); Se quitan los barra superior con todas sus herramientas
        this.getContentPane().setBackground(Color.BLUE); 
        this.setLayout(null);
        this.setVisible(true);
    }
}