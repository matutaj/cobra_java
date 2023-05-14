/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfaceGrafica;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author matuta_jr
 */
public class Tela extends JFrame {
    
    //class para apresentar tela
    
    public static final int largura_tela = 800;
    public static final int altura_tela = 600;
    
    
    DrawPanel cobra = new DrawPanel();
    
      
    public Tela(){   
        super("Jogo da Cobra");
        super.add(cobra);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(largura_tela,altura_tela);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);
    }
}