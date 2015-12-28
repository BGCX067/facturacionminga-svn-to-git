/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.utilidades;

import controlador.Utilidades;
import controlador.servicios.ServicioCategoria;
import controlador.servicios.ServicioCuota;
import controlador.servicios.ServicioLoteProducto;
import controlador.servicios.ServicioMarca;
import controlador.servicios.ServicioProducto;
import controlador.servicios.ServicioTipoProducto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import modelo.Categoria;
import modelo.Compra;
import modelo.CuentaCobrarPagar;
import modelo.Cuota;
import modelo.DetalleVenta;
import modelo.LoteProducto;
import modelo.Marca;
import modelo.Producto;
import modelo.Servicio;
import modelo.TipoProducto;
import modelo.Venta;

/**
 *
 * @author jose
 */
public class FacadeComponentes {

    public static void cargarCombos(JComboBox cbx, String tipo) {
        if (tipo.equalsIgnoreCase("tipo")) {
            ServicioTipoProducto sp = new ServicioTipoProducto();
            for (TipoProducto tp : sp.listar()) {
                if (tp.isEstado_tipo() == true) {
                    cbx.addItem(tp);
                }
            }
        }
        if (tipo.equalsIgnoreCase("marca")) {
            ServicioMarca sp = new ServicioMarca();
            for (Marca tp : sp.listar()) {
                if (tp.isEstado_marca() == true) {
                    cbx.addItem(tp);
                }
            }
        }
        if (tipo.equalsIgnoreCase("categoria")) {
            ServicioCategoria sp = new ServicioCategoria();
            for (Categoria tp : sp.listar()) {
                if (tp.isEstado_categoria() == true) {
                    cbx.addItem(tp);
                }
            }
        }
        if (tipo.equalsIgnoreCase("producto")) {
            ServicioProducto sp = new ServicioProducto();
            for (Producto tp : sp.listar()) {
                if (tp.getEstado().equalsIgnoreCase("En uso")) {
                    cbx.addItem(tp);
                }
            }
        }
    }

    public static Categoria obtenerCategoriaCombo(JComboBox cbx) {
        return (Categoria) cbx.getSelectedItem();
    }

    public static TipoProducto obtenerTipoProductoCombo(JComboBox cbx) {
        return (TipoProducto) cbx.getSelectedItem();
    }

    public static Marca obtenerMarcaCombo(JComboBox cbx) {
        return (Marca) cbx.getSelectedItem();
    }

    public static Producto obtenerProductoCombo(JComboBox cbx) {
        return (Producto) cbx.getSelectedItem();
    }

    public static DetalleVenta llenarDetalle(Servicio s, LoteProducto p, Venta v, List<DetalleVenta> lista, boolean band) {
        DetalleVenta dv = null;
        if (band == false) {
            dv = new DetalleVenta();
            dv.setCant_detalle(1);
            if (p != null) {
                p.setStock(p.getStock() - 1);
                dv.setLote(p);
                dv.setPu_detalle(p.getPv_lote());
                dv.setPv_detalle(p.getPv_lote() * dv.getCant_detalle());
                dv.setVenta(v);
            } else {
                dv.setServicio(s);
                dv.setPu_detalle(s.getCosto_serv());
                dv.setPv_detalle(s.getCosto_serv() * dv.getCant_detalle());
                dv.setVenta(v);
            }

        } else {
            for (DetalleVenta aux : lista) {
                if (p != null) {
                    if (aux.getLote() != null) {
                        if (aux.getLote().getId_lote().intValue() == p.getId_lote().intValue()) {
                            aux.setCant_detalle(aux.getCant_detalle() + 1);
                            p.setStock(p.getStock() - 1);
                            aux.setLote(p);                            
                            aux.setPv_detalle(aux.getPu_detalle() * aux.getCant_detalle());
                            dv = aux;
                            break;
                        }
                    }
                } else {
                    if (aux.getServicio() != null) {
                        if (aux.getServicio().getId_servicio().intValue() == s.getId_servicio().intValue()) {
                            aux.setCant_detalle(aux.getCant_detalle() + 1);
                            aux.setServicio(s);
                            aux.setPv_detalle(aux.getPu_detalle() * aux.getCant_detalle());
                            dv = aux;
                            break;
                        }
                    }
                }

            }
        }
        return dv;
    }

    public static List<Object> existeProducto(List<DetalleVenta> lista, LoteProducto p, Servicio s) {
        List<Object> data = new ArrayList<Object>();
        boolean ver = false;
        int pos = -1;
        int cont = 0;
        for (DetalleVenta dv : lista) {
            if (p != null) {
                if (dv.getLote() != null) {
                    if (dv.getLote().getId_lote().intValue() == p.getId_lote().intValue()) {
                        ver = true;
                        pos = cont;
                        break;
                    }
                }
            } else if (s != null) {
                if (dv.getServicio() != null) {
                    if (dv.getServicio().getId_servicio().intValue() == s.getId_servicio().intValue()) {
                        ver = true;
                        pos = cont;
                        break;
                    }
                }
            }
            cont++;
        }
        data.add(ver);
        data.add(pos);
        return data;
    }

    public static List<DetalleVenta> borrarProducto(List<DetalleVenta> lista, int fila, List<LoteProducto> listaLote, List<Servicio> listaServicio) {
        DetalleVenta dv = lista.get(fila);
        if (dv.getCant_detalle() == 1) {
            lista.remove(fila);
        } else {
            dv.setCant_detalle(dv.getCant_detalle() - 1);
            dv.setPv_detalle(dv.getPu_detalle()* dv.getCant_detalle());
            lista.remove(fila);
            lista.add(fila, dv);
        }
        if (dv.getLote() != null) {
            for (LoteProducto lote : listaLote) {
                if(lote.getId_lote().intValue()==dv.getLote().getId_lote().intValue())
                    lote.setStock(lote.getStock() + 1);
            }
        }
        return lista;
    }
    
     public static List<Double> sumarDatosTabla(List<DetalleVenta> lista){
        List<Double> listaF = new ArrayList<Double>();
        double subtotal = 0;
        double iva=0;
        double total=0;
        for(DetalleVenta aux:lista){
            subtotal+=aux.getPv_detalle();            
        }
        iva = (subtotal*12)/100;
        total = subtotal+iva;
        listaF.add(subtotal);
        listaF.add(iva);
        listaF.add(total);
        return listaF;
    }
     public static void actualizarStockLote(List<DetalleVenta> lista){
         for(DetalleVenta aux:lista){
            if(aux.getLote()!=null){
                ServicioLoteProducto auxP = new ServicioLoteProducto();
                auxP.fijarInstancia(aux.getLote());
                auxP.guardar();
            }
        }
     }
     public static List<Cuota> crearCuotas(double saldo, int nro, CuentaCobrarPagar ccp, String para){
         List<Cuota>lista = new ArrayList<>();
         Calendar cal = Calendar.getInstance();
         double suma = 0;
         double cuota = Utilidades.redondear((saldo/nro));
         for(int i=1;i<=nro;i++){
             ServicioCuota sc = new ServicioCuota();
             cal.add(Calendar.MONTH, 1);
             sc.getCuota().setFecha(cal.getTime());
             
             if((nro)==i){
                 cuota = saldo - suma;
                 System.out.println("cuota: "+cuota);
             }else{
                 suma = suma+cuota;
                 System.out.println("suma: "+suma);
             }
             
             sc.getCuota().setValor(Utilidades.redondear(cuota));
             
             sc.getCuota().setCuentapg(ccp);
             lista.add(sc.getCuota());
         }
         ccp.setListaCuotas(lista);
         return lista;
     }
}
