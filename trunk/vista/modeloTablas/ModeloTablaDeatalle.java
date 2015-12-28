/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modeloTablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.DetalleVenta;

/**
 *
 * @author jose
 */
public class ModeloTablaDeatalle extends AbstractTableModel{
    private List<DetalleVenta>lista = new ArrayList<DetalleVenta>();

    public List<DetalleVenta> getLista() {
        return lista;
    }

    public void setLista(List<DetalleVenta> lista) {
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
        DetalleVenta p = lista.get(rowIndex);
        String porducto = "";
        if(p.getLote()!=null){
            porducto = p.getLote().getProducto().getTipo()+" "+p.getLote().getProducto().getMarca()+" "+p.getLote().getProducto().getModelo();
        }else if(p.getServicio()!=null){
            porducto = p.getServicio().getNombre_serv();
        }
        switch(columnIndex){
            case 0: return p.getCant_detalle();
            case 1: return porducto;    
            case 2: return p.getPu_detalle();                    
            case 3: return p.getPv_detalle();           
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Cant";
            case 1: return "Detalle";
            case 2: return "P/U";
            case 3: return "P/T";
            
            
            default:return null;
        }
    }
}
