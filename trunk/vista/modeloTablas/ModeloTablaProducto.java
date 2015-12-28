/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modeloTablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Producto;

/**
 *
 * @author jose
 */
public class ModeloTablaProducto extends AbstractTableModel{
    private List<Producto>lista = new ArrayList<Producto>();

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }
    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getTipo();
            case 1: return p.getMarca();    
            case 2: return p.getModelo();        
            case 3: return p.getCategoria().getNombre_categoria();           
            case 4: return p.getDescripcion();           
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Tipo";
            case 1: return "Marca";
            case 2: return "Modelo";
            case 3: return "Categoría";
            case 4: return "Descripción";
            
            default:return null;
        }
    }
}
