/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfaceGrafica;
import java.awt.Color;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author matuta_jr
 */
public class Tela extends JFrame {
    
    //class para apresentar tela
    
    public static final int largura_tela = 800;
    public static final int altura_tela = 600;
    
    
    JogoDeCobra cobra = new JogoDeCobra();
    Scanner teclado = new Scanner(System.in);
      static JTextField texto_Boas_Vinda = new JTextField("Bem-Vindo ao Meu Jogo de Cobra\n Ditite o seu nome");
     static JTextField erro = new JTextField("O Jogador deve ter um Nome");
     
    private String nomeDoJogador;
      
    public Tela(String n){   
        super("Jogo da Cobra Jogador: "+n);
        if(nomeDoJogador == n){
            super.add(erro);
        }else {
        super.add(cobra);
        }
        
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(largura_tela,altura_tela);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);
    }
    
    
}
