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
public class EventoTecladoLetras extends KeyAdapter {

    private JTextComponent texto;
    private int size = 0;

    public EventoTecladoLetras(JTextComponent texto) {
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
        char car = e.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas             
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas             
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && (car != (char) KeyEvent.VK_SPACE)) {
            e.consume();
        }
    }

}
