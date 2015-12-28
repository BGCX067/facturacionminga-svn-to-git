/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.modeloTablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;
import modelo.Proveedor;

/**
 *
 * @author jose
 */
public class ModeloTablaProvvedor extends AbstractTableModel{
    private List<Proveedor> lista = new ArrayList<Proveedor>();

    public List<Proveedor> getLista() {
        return lista;
    }

    public void setLista(List<Proveedor> lista) {
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
        Proveedor p = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getCedula_per();
            case 1: return p.getApellidos_per().toUpperCase()+" "+p.getNombres_per().toUpperCase();
            case 2: return p.getDireccion_per();
            case 3: return p.getFono_per();
            case 4: return p.getEmpresa_prov();
            case 5: return p.getEstado_per().toUpperCase();
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Céula";
            case 1: return "Cliente";
            case 2: return "Dirección";
            case 3: return "Teléfono/Celular";
            case 4: return "Empresa";
            case 5: return "Estado";
            default:return null;
        }
    }
}
