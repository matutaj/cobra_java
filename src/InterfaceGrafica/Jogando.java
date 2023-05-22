/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package InterfaceGrafica;
import javax.swing.JOptionPane;
/**
 *
 * @author matuta_jr
 */
public class Jogando  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


    String nome;
    StringBuilder mensagem = new StringBuilder();

    nome = JOptionPane.showInputDialog("Digite seu nome:");
    mensagem.append("Bem-vindo Ao Meu Jogo de Cobra: ").append(nome).append("!");
    JOptionPane.showMessageDialog(null, mensagem);
 
       Tela jogo = new Tela(nome);
    }
    
}
