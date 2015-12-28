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
import modelo.Venta;

/**
 *
 * @author jose
 */
public class ModeloTablaPrueba extends AbstractTableModel{
    private List<Venta>lista = new ArrayList<Venta>();

    public List<Venta> getLista() {
        return lista;
    }

    public void setLista(List<Venta> lista) {
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
        Venta p = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return p.getNro_venta();
            case 1: return p.getCliente().getApellidos_per()+" "+p.getCliente().getNombres_per();    
            case 2: return p.getFecha_venta();                    
            case 3: return p.getTotal();           
            default:return null;
        }
    }
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Nro";
            case 1: return "Cliente";
            case 2: return "fecha";
            case 3: return "valor factura";
            default:return null;
        }
    }
}
