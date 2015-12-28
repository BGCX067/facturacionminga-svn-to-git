/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modeloTablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Servicio;

/**
 *
 * @author jose
 */
public class ModeloTablaServicio extends AbstractTableModel{
    private List<Servicio>lista = new ArrayList<Servicio>();

    public List<Servicio> getLista() {
        return lista;
    }

    public void setLista(List<Servicio> lista) {
        this.lista = lista;
    }
    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Servicio p = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getCod_servicio();
            case 1: return p.getNombre_serv();    
            case 2: return p.getCosto_serv();                    
            case 3: return p.getDescripcion_serv();                        
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Código";
            case 1: return "Servicio";
            case 2: return "Costo";
            case 3: return "Descripción";            
            
            default:return null;
        }
    }
}
