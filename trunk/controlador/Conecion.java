/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author alex
 */
public class Conecion {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public void conectar() throws ClassNotFoundException, SQLException {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bdminga", "root", "root");

        } finally {

        }
    }
    
    private static void iniciar() {
        if (Conecion.em == null) {
            Conecion.emf = Persistence.createEntityManagerFactory("facturacionPU");          
        }
        Conecion.em = Conecion.emf.createEntityManager();
    }

    public Conecion() {
        Conecion.iniciar();
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        Conecion.emf = emf;
    }

    public static EntityManager getEm() {
        Conecion.iniciar();
        return em;
    }

    public static void setEm(EntityManager em) {
        Conecion.em = em;
    }

    public static void main(String[] args) {
        new Conecion();
    }
}
