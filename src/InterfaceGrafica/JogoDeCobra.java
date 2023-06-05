/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfaceGrafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author matuta_jr
 */
public final class JogoDeCobra extends JPanel implements Runnable, KeyListener {
    
    public static final int posicao_bolinha=20;
    public static final int tamanho_mover=20;
    JPanel percentagem = new JPanel();
    private int direcao ;
    private Thread thread;
    
    
    Cobra primeiroBloco;
    private Bolinha a;
    ArrayList<Metodos>blocks;
    //ArryList é polimorfismo por sobreCarga
    
    public static int Tamanho_cobra;
    
    JogoDeCobra(){
    
        blocks = new ArrayList<>();
        //List fornece métodos para manipular elementos baseado na sua posição
        //(ou índice) numérica na lista, remover determinado elemento,
       
        Random renderizar = new Random();
        
        a = new Bolinha((renderizar.nextInt(37)+1)*posicao_bolinha,(renderizar.nextInt(26)+1)*posicao_bolinha);
        //da uma posição aliatoria que ão saia do tamanhho da tela
        
       Cobra b = new Cobra(posicao_bolinha,posicao_bolinha );
        
        blocks.add(b);
        
       primeiroBloco = (Cobra)blocks.get(0);
       //localiza a cobra na primeira c e c, permitindo correr 

        this.addKeyListener(this);
        // addKeyListener especifica os métodos necessários para detectar e tratar eventos de teclado. 
        this.setFocusable(true);
        
        thread = new Thread(this);
        //Thread, representa uma instância da CPU da máquina virtual Java,
        //e que tem associada um trecho de código que será executado, e uma área de memória. 
        thread.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        //Pintar o compomente ou tela
        super.paintComponent(g); 
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Tela.largura_tela, Tela.altura_tela);
              //fillRect() da API Canvas 2D desenha um retângulo preenchido na posição (x, y),
              //no qual o tamanho é determinado pela width
        for(Metodos b : blocks) {
            b.draw(g);
        }
        a.draw(g);
        
        g.setColor(Color.MAGENTA);
        g.drawRect(posicao_bolinha, posicao_bolinha, posicao_bolinha*37, posicao_bolinha*26);
        
    }
    
    
    @Override
    public void run() {
            while(true){

                 if(blocks.get(0).getX()== a.getX() &&
                      blocks.get(0).getY()== a.getY()){
                   
                     Random renderizar = new Random();
                     
                     a.setX((renderizar.nextInt(37)+1)*posicao_bolinha);
                     a.setY((renderizar.nextInt(26)+1)*posicao_bolinha);
 
                    Tamanho_cobra = blocks.size()-1;
                     switch (direcao) {
                         case 0:
                             blocks.add(new Cobra(blocks.get(Tamanho_cobra).getX()+posicao_bolinha, blocks.get(Tamanho_cobra).getY()));
                             break;
                         case 1:
                             blocks.add(new Cobra(blocks.get(Tamanho_cobra).getX()-posicao_bolinha, blocks.get(Tamanho_cobra).getY()));
                             break;
                         case 2:
                             blocks.add(new Cobra(blocks.get(Tamanho_cobra).getX(), blocks.get(Tamanho_cobra).getY()+posicao_bolinha));
                             break;
                         case 3:
                             blocks.add(new Cobra(blocks.get(Tamanho_cobra).getX(), blocks.get(Tamanho_cobra).getY()-posicao_bolinha));
                             break;
                         default:
                             break;
                     }         
                }
                 
                 for(Metodos block : blocks) {
                    if(block.getX()>740)
                       block.setX(20);
                    if(block.getY()>520)
                        block.setY(20);
                    if(block.getX()<20)
                        block.setX(740);
                    if(block.getY()<20)
                        block.setY(520);
                           
                }
                 
                 for (int i = 1; i < blocks.size(); i++) {
                    if(blocks.get(i).getX()==blocks.get(0).getX() && blocks.get(i).getY()==blocks.get(0).getY()){
                        JOptionPane.showMessageDialog(this,"Você perdeu com "+((Tamanho_cobra +1)*(10))+ " de pontos");
                        System.exit(0);
                    }       
                }
                 
                repaint();
                //repetir se a cobra morrer
                
                //deslocação da cobra no eixo
                switch(direcao){
                    case 0:
                        MovimentoCobra(-tamanho_mover,0)
                            ;break;
                    case 1 :
                        MovimentoCobra(tamanho_mover, 0)
                            ;break;
                    case  2 :
                        MovimentoCobra(0, -tamanho_mover)
                            ;break;
                    case  3 :
                        MovimentoCobra(0, tamanho_mover)
                            ;break;
                }
                   
                
                
             try { 
                thread.sleep(90); 
                //intervalo em min.
             }
 
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
                
              
        } }


    @Override
    public void keyPressed(KeyEvent e) {
        //para indicar que a tecla foi pressionada; keyReleased(), para indicar que a tecla foi solta
       switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                if(direcao!=0){
                    
                    this.direcao = 1;
                    //MovimentaCobra(tamanho_mover, 0);
                    
                }       break;
            case KeyEvent.VK_LEFT:
                if(direcao!=1){
                    
                    this.direcao = 0; 
                    //MovimentaCobra(-tamanho_mover,0);
                    
                }   break;
            case KeyEvent.VK_UP:
                if(direcao!=3){
                    
                    this.direcao = 2;  
                   // MovimentaCobra(0,-tamanho_mover);
                    
                }   break;
            case KeyEvent.VK_DOWN:
                if(direcao !=2){
                    
                    this.direcao = 3;
                   // MovimentaCobra(0,tamanho_mover);
                    
                }   break;
            default:
                break;
        }    
    }
     public void MovimentoCobra(int moveX,int moveY) {
      
     
       
        ArrayList<Metodos> antigo = new ArrayList<>();

        for(Metodos block : blocks){
            antigo.add(new Cobra(block.getX(), block.getY()));
        }
        

        primeiroBloco.moveX(moveX);
        primeiroBloco.moveY(moveY);
     
        if(blocks.size()>1){

            for (int i = 1; i < blocks.size(); i++) {
                
                blocks.get(i).setX(antigo.get(i-1).getX());
                blocks.get(i).setY(antigo.get(i-1).getY());
            }
         }
   }

    @Override
    public void keyReleased(KeyEvent e) {
      }
        @Override
    public void keyTyped(KeyEvent e) {
        }

}
