/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modeloTablas;

import controlador.Utilidades;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.CuentaCobrarPagar;

/**
 *
 * @author jose
 */
public class ModeloTablaCoutasPagarCobrar extends AbstractTableModel{
    private List<CuentaCobrarPagar>lista = new ArrayList<CuentaCobrarPagar>();

    public List<CuentaCobrarPagar> getLista() {
        return lista;
    }

    public void setLista(List<CuentaCobrarPagar> lista) {
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
         CuentaCobrarPagar p = this.lista.get(rowIndex);
         
         String estado = "Debe";
         String nroFact="";
         String cliente="";
         String total="";
         if(!p.getEstado().equalsIgnoreCase("activo")){
             estado = "Pagado";
         }
         if(p.getVenta()!=null){
             nroFact = p.getVenta().getNro_venta();
             cliente = p.getVenta().getCliente().getApellidos_per()+" "+p.getVenta().getCliente().getNombres_per();
             total = String.valueOf(p.getVenta().getTotal());
         }else{
             nroFact = p.getCompra().getNumFact_compra();
             cliente = p.getCompra().getProveedor().getApellidos_per()+" "+p.getVenta().getCliente().getNombres_per();
             total = String.valueOf(p.getCompra().getTotal());
         }
        switch(columnIndex){
            case 0: return p.getTipo().toUpperCase();
            case 1: return nroFact;   
            case 2: return cliente;   
            case 3: return total;
            case 4: return estado;        
            default:return null;
        }
    }
     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Tipo de factura";
            case 1: return "Nro de Factura";
            case 2: return "Cliente";
            case 3: return "Total";
            case 4: return "Estado";
            default:return null;
        }
    }
}
