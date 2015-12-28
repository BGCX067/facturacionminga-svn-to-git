/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.utilidades;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.text.JTextComponent;

/**
 *
 * @author jose
 */
public class EventoTecladoNumerico extends KeyAdapter{
    private JTextComponent texto;
    private int size=0;
    public EventoTecladoNumerico(JTextComponent texto) {
        this.texto = texto;
    }

    public JTextComponent getTexto() {
        return texto;
    }

    public void setTexto(JTextComponent texto) {
        this.texto = texto;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //super.keyTyped(e); //To change body of generated methods, choose Tools | Templates.
        char caracter = e.getKeyChar();
        
        if(!(Character.isDigit(caracter))&&(caracter!= KeyEvent.VK_BACK_SPACE)){
            e.consume();//No pinta el caracter
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
}
