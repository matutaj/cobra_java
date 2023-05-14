/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfaceGrafica;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author matuta_jr
 */
public class Cobra implements Metodos {

     public int X;
    public int Y;
    
    public Cobra(int x, int y ){
      X=x;
     Y=y;
    }
    
  
  
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(X, Y, DrawPanel.tamanho_bloco, DrawPanel.tamanho_bloco);
  }
    
    @Override
    public int getX() {
        return this.X;
        }

      public void moveX(int x){
        this.X+=x;
    }
    
    public void moveY(int y){
        this.Y+=y;
        
    }
    @Override
    public int getY() {
        return this.Y;
        }

    @Override
    public void setX(int x) {
        this.X = x;
      }

    @Override
    public void setY(int y) {
        this.Y=y;
      }

    public String toString(){
    return String.format("X : %d | Y : %d", this.getX(), this.getY());
    }

}
