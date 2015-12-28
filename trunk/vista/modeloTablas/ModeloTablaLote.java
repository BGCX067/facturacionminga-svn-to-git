/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modeloTablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import modelo.LoteProducto;

/**
 *
 * @author Alex
 */
public class ModeloTablaLote extends AbstractTableModel{
    private List<LoteProducto>lista = new ArrayList<LoteProducto>();

    public List<LoteProducto> getLista() {
        return lista;
    }

    public void setLista(List<LoteProducto> lista) {
        this.lista = lista;
    }
    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LoteProducto p = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getCodBarra_lote();
            case 1: return p.getProducto().getTipo()+" "+p.getProducto().getMarca()+" "+p.getProducto().getModelo();    
            case 2: return p.getPc_lote();        
            case 3: return p.getPv_lote();
            case 4: return p.getStock();
            case 5: return p.getNro_compra();
            
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Código de barra";
            case 1: return "Producto";
            case 2: return "Precio de compra";
            case 3: return "Precio de venta";
            case 4: return "Stock";
            case 5: return "Nro de compra";
            default:return null;
        }
    }
}
