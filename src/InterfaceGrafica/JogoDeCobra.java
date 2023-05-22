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
    
    public static final int tamanho_bloco=20;
    public static final int tamanho_mover=20;
    
    private int direcao = 1; //0- esquerdo, 1-direito, 2 cima, 3baixo
    private Thread thread;
    
    
    Cobra primeiroBloco;
    private Bolinha a;
    ArrayList<Metodos>blocks;
    
    public static int Tamanho_array;
    
    JogoDeCobra(){
    
        blocks = new ArrayList<>();
        
        Tamanho_array= blocks.size();
        
        Random renderizar = new Random();
        
        a = new Bolinha((renderizar.nextInt(3)+1)*tamanho_bloco,(renderizar.nextInt(6)+1)*tamanho_bloco);
        
        Cobra b = new Cobra(tamanho_bloco,tamanho_bloco );
        
        blocks.add(b);
        
        primeiroBloco = (Cobra)blocks.get(0);
        
        this.addKeyListener(this);
        this.setFocusable(true);
        
        thread = new Thread(this);
        thread.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g); 
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Tela.largura_tela, Tela.altura_tela);
        g.setColor(Color.GRAY);
        
        for(Metodos b : blocks) {
            b.draw(g);
        }
        a.draw(g);
        
        g.setColor(Color.MAGENTA);
        g.drawRect(tamanho_bloco, tamanho_bloco, tamanho_bloco*37, tamanho_bloco*26);
        
    }
    
    
    @Override
    public void run() {
            while(true){

                 if(blocks.get(0).getX()== a.getX() &&
                      blocks.get(0).getY()== a.getY()){
                   
                     Random renderizar = new Random();
                     
                     a.setX((renderizar.nextInt(37)+1)*tamanho_bloco);
                     a.setY((renderizar.nextInt(26)+1)*tamanho_bloco);
 
                    Tamanho_array = blocks.size()-1;
                    
                     switch (direcao) {
                         case 0:
                             blocks.add(new Cobra(blocks.get(Tamanho_array).getX()+tamanho_bloco, blocks.get(Tamanho_array).getY()));
                             break;
                         case 1:
                             blocks.add(new Cobra(blocks.get(Tamanho_array).getX()-tamanho_bloco, blocks.get(Tamanho_array).getY()));
                             break;
                         case 2:
                             blocks.add(new Cobra(blocks.get(Tamanho_array).getX(), blocks.get(Tamanho_array).getY()+tamanho_bloco));
                             break;
                         case 3:
                             blocks.add(new Cobra(blocks.get(Tamanho_array).getX(), blocks.get(Tamanho_array).getY()-tamanho_bloco));
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
                        JOptionPane.showMessageDialog(this,"Você perdeu");
                        System.exit(0);
                    }       
                }
                 
                repaint();
                
                
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
             }
 
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
                
              
        } }


    @Override
    public void keyPressed(KeyEvent e) {
       switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                if(direcao!=0){
                    
                    this.direcao = 1;
                    //MovimentaCobra(BLOCK_MOVE, 0);
                    
                }       break;
            case KeyEvent.VK_LEFT:
                if(direcao!=1){
                    
                    this.direcao = 0; 
                    //MovimentaCobra(-BLOCK_MOVE,0);
                    
                }   break;
            case KeyEvent.VK_UP:
                if(direcao!=3){
                    
                    this.direcao = 2;  
                   // MovimentaCobra(0,-BLOCK_MOVE);
                    
                }   break;
            case KeyEvent.VK_DOWN:
                if(direcao !=2){
                    
                    this.direcao = 3;
                   // MovimentaCobra(0,BLOCK_MOVE);
                    
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
