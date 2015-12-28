/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.servicios;

import controlador.daos.CuentaCobrarPagarDao;
import java.util.List;
import modelo.CuentaCobrarPagar;
import modelo.Cuota;

/**
 *
 * @author jose
 */
public class ServicioCuotaCobrarPagar {
    private CuentaCobrarPagarDao dao;

    public ServicioCuotaCobrarPagar() {
        dao = new CuentaCobrarPagarDao();
    }
    public CuentaCobrarPagar getCuota() {
        return dao.getCuentaCobrarPagar();
    }
    public void fijarInstancia(CuentaCobrarPagar a) {
        dao.fijarInstancia(a);
    }
    public void nuevaInstancia() {
        dao.nuevaInstancia();
    }
    public boolean guardar() {
        return dao.guardar();
    }
    public List<CuentaCobrarPagar>listar(){
        return dao.enlistar("");
    }
    public List<CuentaCobrarPagar>listarCondicion(String condicion){
        return dao.enlistar(condicion);
    }
    public CuentaCobrarPagar obtenerId(Long id){
        return dao.obtenerPorId(id);
    }
    public boolean algunoPagado(){
        boolean band = false;
        for(Cuota p:dao.getCuentaCobrarPagar().getListaCuotas()){
            if(p.isPagado()==true){
                band = true;
                break;
            }
        }
        return band;
    }
    public boolean eliminar(){
        return dao.eliminar();
    }
    public void modificarEstadoCuotas(){
        boolean band = false;
        for(Cuota p: dao.getCuentaCobrarPagar().getListaCuotas()){
            if(p.isPagado()==true){
                band = true;
                break;
            }
        }
        if(band == false){
            dao.getCuentaCobrarPagar().setEstado("pagado");
            dao.guardar();
            
        }            
            
    }
}
