/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Reporte;
import controlador.Utilidades;
import controlador.servicios.ServicioPersona;
import controlador.servicios.ServicioRol;
import controlador.servicios.ServicioVenta;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import vista.modeloTablas.ModeloTablaCliente;

/**
 *
 * @author Alex
 */
public class PanelAdministrarClientes extends javax.swing.JPanel {

    private ServicioPersona sp = new ServicioPersona();
    private ModeloTablaCliente modelo = new ModeloTablaCliente();

    /**
     * Creates new form PanelAdministrarClientes
     */
    public PanelAdministrarClientes() {
        initComponents();
        rdoGrupo.add(rdoMasculino);
        rdoGrupo.add(rdoFemenino);
        this.lblFoto.setVisible(false);
        cargarTabla();
        tabbed.setSelectedIndex(1);
        tabbed.setEnabledAt(0, false);
    }

    private void cargarTabla() {
        modelo.setLista(sp.listar());
        tablaResultadosBusqueda.setModel(modelo);
        tablaResultadosBusqueda.updateUI();
    }

    private void irNuevo() {
        tabbed.setSelectedIndex(0);
        tabbed.setEnabledAt(0, true);
        tabbed.setEnabledAt(1, false);
    }

    private void irListar() {
        tabbed.setSelectedIndex(1);
        tabbed.setEnabledAt(0, false);
        tabbed.setEnabledAt(1, true);
        tabbed.setTitleAt(0, "CREAR");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdoGrupo = new javax.swing.ButtonGroup();
        tabbed = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnCancelarA = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTelfConv = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdoMasculino = new javax.swing.JRadioButton();
        rdoFemenino = new javax.swing.JRadioButton();
        lblFoto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_direccion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        date_nac = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cmbCriterio = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultadosBusqueda = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("ADMINISTRAR CLIENTES"));
        setLayout(new java.awt.BorderLayout());

        btnCancelarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/reload.png"))); // NOI18N
        btnCancelarA.setText("Cancelar");
        btnCancelarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));
        jPanel2.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Ingrese los Nombres: ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(610, 100, 105, 14);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Dirección:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 210, 73, 14);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Fecha nacimiento:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(610, 150, 120, 14);

        txtTelfConv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelfConvActionPerformed(evt);
            }
        });
        jPanel2.add(txtTelfConv);
        txtTelfConv.setBounds(190, 140, 350, 20);
        jPanel2.add(txtNombres);
        txtNombres.setBounds(780, 100, 391, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Ingrese Nro. Cedula:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 40, 101, 14);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Ingrese los Apellidos:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 90, 102, 14);
        jPanel2.add(txtApellidos);
        txtApellidos.setBounds(190, 90, 355, 20);
        jPanel2.add(txtCedula);
        txtCedula.setBounds(190, 40, 360, 20);

        jLabel5.setText("Genero: ");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(610, 200, 42, 14);

        rdoMasculino.setSelected(true);
        rdoMasculino.setText("Masculino");
        rdoMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMasculinoActionPerformed(evt);
            }
        });
        jPanel2.add(rdoMasculino);
        rdoMasculino.setBounds(790, 200, 71, 23);

        rdoFemenino.setText("Femenino");
        rdoFemenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFemeninoActionPerformed(evt);
            }
        });
        jPanel2.add(rdoFemenino);
        rdoFemenino.setBounds(920, 200, 71, 23);

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFoto.setMaximumSize(new java.awt.Dimension(256, 256));
        lblFoto.setMinimumSize(new java.awt.Dimension(256, 256));
        jPanel2.add(lblFoto);
        lblFoto.setBounds(790, 240, 250, 180);

        txt_direccion.setColumns(20);
        txt_direccion.setRows(5);
        jScrollPane2.setViewportView(txt_direccion);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(190, 190, 350, 96);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Teléfono/Celular:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 140, 120, 14);
        jPanel2.add(date_nac);
        date_nac.setBounds(780, 149, 390, 20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 875, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarA, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(456, Short.MAX_VALUE))
        );

        tabbed.addTab("CREAR", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterio de Búsqueda"));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Seleccione el Criterio:");

        cmbCriterio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Por Cédula", "Por Apellido" }));
        cmbCriterio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCriterioItemStateChanged(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Ingrese Búsqueda: ");

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados de Búsqueda"));
        jPanel5.setLayout(new java.awt.BorderLayout());

        tablaResultadosBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaResultadosBusqueda);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/delete-item.png"))); // NOI18N
        btnEliminar.setText("Act/Des");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/reload.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/edit.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/add-item.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/print.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(474, 474, 474))
        );

        tabbed.addTab("BUSCAR CLIENTE", jPanel3);

        add(tabbed, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelfConvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelfConvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelfConvActionPerformed

    private void rdoMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMasculinoActionPerformed
        // TODO add your handling code here:
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Hombre.png")));
        lblFoto.setVisible(true);
    }//GEN-LAST:event_rdoMasculinoActionPerformed

    private void rdoFemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFemeninoActionPerformed
        // TODO add your handling code here:
        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/Mujer.png")));
        lblFoto.setVisible(true);
    }//GEN-LAST:event_rdoFemeninoActionPerformed

    private void btnCancelarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAActionPerformed
        // TODO add your handling code here:
        irListar();
        limpiaCampos();
    }//GEN-LAST:event_btnCancelarAActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        irNuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed
    private void cargarObjeto() {
        sp.getPersona().setApellidos_per(txtApellidos.getText());
        sp.getPersona().setCedula_per(txtCedula.getText());
        sp.getPersona().setDireccion_per(txt_direccion.getText());
        sp.getPersona().setFono_per(txtTelfConv.getText());
        if (date_nac.getDate() != null) {
            sp.getPersona().setFechaNac_per(date_nac.getDate());
        }
        if (rdoMasculino.isSelected()) {
            sp.getPersona().setGenero_per("M");
        } else {
            sp.getPersona().setGenero_per("F");
        }
        sp.getPersona().setNombres_per(txtNombres.getText());
    }

    private void limpiaCampos() {
        txtApellidos.setText("");
        txtCedula.setText("");
        txtNombres.setText("");
        txtTelfConv.setText("");
        txt_direccion.setText("");
        date_nac.setDate(new Date());
        rdoMasculino.setSelected(true);
        txtCedula.setEnabled(true);
        sp.nuevaInstancia();
    }

    private void cargarVista() {
        txtApellidos.setText(sp.getPersona().getApellidos_per());
        txtCedula.setText(sp.getPersona().getCedula_per());
        txtNombres.setText(sp.getPersona().getNombres_per());
        txtTelfConv.setText(sp.getPersona().getFono_per());
        txt_direccion.setText(sp.getPersona().getDireccion_per());
        date_nac.setDate(sp.getPersona().getFechaNac_per());
        if (sp.getPersona().getGenero_per().equalsIgnoreCase("F")) {
            rdoFemenino.setSelected(true);
        }
        txtCedula.setEnabled(false);
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (Utilidades.requerido(txtCedula, txtCedula.getText()) == true && Utilidades.requerido(txtApellidos, txtApellidos.getText()) == true
                && Utilidades.requerido(txtNombres, txtNombres.getText())
                && Utilidades.requerido(txtTelfConv, txtTelfConv.getText())
                && Utilidades.requerido(txt_direccion, txt_direccion.getText())) {
            cargarObjeto();
            if (sp.getPersona().getId_persona() == null) {
                if (Utilidades.validarCedula(txtCedula.getText()) == true) {
                    if (sp.obtenerPersonaCedula(txtCedula.getText()) == null) {
                        sp.getPersona().setRol(new ServicioRol().obtenerRolNombre("cliente"));
                        if (sp.guardar() == true) {
                            JOptionPane.showMessageDialog(this, "Se ha guardado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            irListar();
                            limpiaCampos();
                            cargarTabla();
                        } else {
                            JOptionPane.showMessageDialog(this, "No se ha guardado", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Cédula no válida", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Cliente ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (sp.guardar() == true) {
                    JOptionPane.showMessageDialog(this, "Se ha modificado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    irListar();
                    limpiaCampos();
                    cargarTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "No se ha modificado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int pos = tablaResultadosBusqueda.getSelectedRow();
        if (pos >= 0) {
            sp.fijarInstancia(modelo.getLista().get(pos));
            cargarVista();
            irNuevo();
            tablaResultadosBusqueda.clearSelection();
            tabbed.setTitleAt(0, "MODIDICAR");
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed
    private void buscar(){
        if(cmbCriterio.getSelectedIndex()==0){
            cargarTabla();
        }else{
            String criterio="";
            if(cmbCriterio.getSelectedIndex()==1){
                criterio="p.cedula_per";
            }else{
                criterio="p.apellidos_per";
            }
            modelo.setLista(sp.buscar(criterio, txtBusqueda.getText()));
        }
        tablaResultadosBusqueda.updateUI();
    }
    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void cmbCriterioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCriterioItemStateChanged
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_cmbCriterioItemStateChanged

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int pos = tablaResultadosBusqueda.getSelectedRow();
        if (pos >= 0) {
            ServicioPersona spaux = new ServicioPersona();
            spaux.fijarInstancia(modelo.getLista().get(pos));            
            tablaResultadosBusqueda.clearSelection();
            String aux = (spaux.getPersona().getEstado_per().equals("activo"))?"desactivo":"activo";
            spaux.getPersona().setEstado_per(aux);
            spaux.guardar();
            JOptionPane.showMessageDialog(this, "Se ha modificado el estado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla();
            
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        enviarDatosReporte(sp);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void enviarDatosReporte(ServicioPersona svp){
        HashMap parametros = new HashMap();
            parametros.put("nombres_per", svp.getPersona().getNombres_per());
            parametros.put("apellidos_per", svp.getPersona().getApellidos_per());
            parametros.put("cedula", svp.getPersona().getCedula_per());
            new Reporte().crearReporte("clientes", modelo.getLista(), "lista_clientes.pdf", parametros);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarA;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cmbCriterio;
    private com.toedter.calendar.JDateChooser date_nac;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JRadioButton rdoFemenino;
    private javax.swing.ButtonGroup rdoGrupo;
    private javax.swing.JRadioButton rdoMasculino;
    private javax.swing.JTabbedPane tabbed;
    private javax.swing.JTable tablaResultadosBusqueda;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelfConv;
    private javax.swing.JTextArea txt_direccion;
    // End of variables declaration//GEN-END:variables
}