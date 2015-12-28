/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modeloTablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Categoria;

import modelo.TipoProducto;

/**
 *
 * @author Alex
 */
public class ModeloTablaCategoria extends AbstractTableModel{
    private List<Categoria>lista = new ArrayList<Categoria>();

    public List<Categoria> getLista() {
        return lista;
    }

    public void setLista(List<Categoria> lista) {
        this.lista = lista;
    }
    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categoria p = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getNombre_categoria();
            case 1: return (p.isEstado_categoria()==true)?"En uso":"Desabilitado";
            
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Categoría";
            case 1: return "Estado";
            
            default:return null;
        }
    }
}
