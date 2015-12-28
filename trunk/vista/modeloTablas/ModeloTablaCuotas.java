/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modeloTablas;

import com.lowagie.text.Utilities;
import controlador.Utilidades;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Cuota;

/**
 *
 * @author jose
 */
public class ModeloTablaCuotas extends AbstractTableModel{
    private List<Cuota>lista = new ArrayList<Cuota>();

    public List<Cuota> getLista() {
        return lista;
    }

    public void setLista(List<Cuota> lista) {
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
         Cuota p = this.lista.get(rowIndex);
         String fechaPago="";
         String estado = "Pagado";
         if(p.isPagado()==true){
             fechaPago = Utilidades.formatoFechaDateString(p.getFecha_pago());
         }else{
             estado = "Debe";
         }
        switch(columnIndex){
            case 0: return Utilidades.formatoFechaDateString(p.getFecha());
            case 1: return p.getValor();   
            case 2: return fechaPago;        
            case 3: return estado;        
            default:return null;
        }
    }
     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Feha de pago";
            case 1: return "Valor";
            case 2: return "Fecha pagada";
            case 3: return "Estado";
            default:return null;
        }
    }
    
}
