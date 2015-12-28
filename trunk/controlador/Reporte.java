/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Chio
 */
//import com.libreria.negocio.datos.Conexion;
import controlador.servicios.ServicioPersona;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reporte {

    //C:\tourpnp\src\java\reporte\reporte_votos.jrxml

    private String dirInicio = "";
    private String dirDestino = "";
      //private String salida="src/java/reporte/ReporteSugerencia.jrxml";

    public void crearReporte(String url, List lista, String nombre, HashMap parametros) {
        url = Utilidades.obtenerRutaRoot() + "/src/vista/reportes/"+url+".jrxml";
        dirInicio = url;
        dirDestino = nombre;
        //parametros.put("fecha", new Date());//nombre de parametros, tipo de dato
        try {
            JasperDesign jd = JRXmlLoader.load(dirInicio);
            
            JasperReport jasperReport = JasperCompileManager.compileReport(jd);
            //JasperReport jasperReport = JasperCompileManager.compileReport(dirInicio);//compilar el reporte

            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(
                            jasperReport, parametros, new JRBeanCollectionDataSource(lista));//crear el reporte
            //System.out.println("listas -- " + lista.size());
//                JasperExportManager.exportReportToPdfFile(
//                    jasperPrint, salida);//para exportalo
            JasperExportManager.exportReportToPdfFile(jasperPrint, dirDestino);

            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("error de reporte : " + ex);
        }
    }

    public static void main(String[] args) {
        String ruta = Utilidades.obtenerRutaRoot() + "/src/reportes/clientes.jrxml";
        System.out.println(ruta);
        new Reporte().crearReporte("clientes",new ServicioPersona().listar(),"clientes.pdf",new HashMap());
        //Reporte r = new Reporte();
        //System.out.println(r.getClass().getClassLoader().getResource("clientes.jrxml").getPath());
        //uuid="\w*-\w*-\w*-\w*-\w*"
    }
}
