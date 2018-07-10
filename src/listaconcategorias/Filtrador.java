package listaconcategorias;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Filtrador extends javax.swing.JDialog {

    private final ListaDB basededatos = new ListaDB();
    private GrupoDeFiltros grupoFiltros;
    private boolean enviar = false;
    private boolean toggleG = true;
    private boolean toggleP = true;
    private boolean toggleV = true;

    public Filtrador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jScrollPane1.getViewport().setBackground(tabla_gen.getBackground());
        jScrollPane2.getViewport().setBackground(tabla_vis.getBackground());
        jScrollPane3.getViewport().setBackground(tabla_plat.getBackground());
        cargarGeneros();
        cargarVistas();
        cargarPlataformas();
    }

    private void cargarGeneros() {
        DefaultTableModel modelo = (DefaultTableModel) tabla_gen.getModel();
        modelo.setRowCount(0);
        Object[] fila = new Object[3];

        try {
            ResultSet rs = basededatos.leerGeneros();

            while (rs.next()) {
                fila[0] = rs.getInt("id_generos");
                fila[1] = "  " + rs.getString("genero");
                fila[2] = false;

                modelo.addRow(fila);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarVistas() {
        DefaultTableModel modelo = (DefaultTableModel) tabla_vis.getModel();
        modelo.setRowCount(0);
        Object[] fila = new Object[3];

        try {
            ResultSet rs = basededatos.leerVistas();

            while (rs.next()) {
                fila[0] = rs.getInt("id_vista");
                fila[1] = "  " + rs.getString("vista");
                fila[2] = false;

                modelo.addRow(fila);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarPlataformas() {
        DefaultTableModel modelo = (DefaultTableModel) tabla_plat.getModel();
        modelo.setRowCount(0);
        Object[] fila = new Object[3];

        try {
            ResultSet rs = basededatos.leerPlataformas();

            while (rs.next()) {
                fila[0] = rs.getInt("id_plataforma");
                fila[1] = "  " + rs.getString("plataforma");
                fila[2] = false;

                modelo.addRow(fila);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void precargarFiltros(GrupoDeFiltros fActivos) {
        DefaultTableModel mGen = (DefaultTableModel) tabla_gen.getModel();
        DefaultTableModel mVis = (DefaultTableModel) tabla_vis.getModel();
        DefaultTableModel mPlat = (DefaultTableModel) tabla_plat.getModel();
        
        for(int i = 0; i < mGen.getRowCount(); i++) {
            for (String idGenero : fActivos.obtenerGeneros()) {
                if(mGen.getValueAt(i, 0).toString().equals(idGenero)){
                    mGen.setValueAt(true, i, 2);
                    break;
                }
            }
        }
        
        for(int i = 0; i < mPlat.getRowCount(); i++) {
            for (String idPlataforma : fActivos.obtenerPlataformas()) {
                if(mPlat.getValueAt(i, 0).toString().equals(idPlataforma)){
                    mPlat.setValueAt(true, i, 2);
                    break;
                }
            }
        }
        
        for(int i = 0; i < mVis.getRowCount(); i++) {
            for (String idVista : fActivos.obtenerVistas()) {
                if(mVis.getValueAt(i, 0).toString().equals(idVista)){
                    mVis.setValueAt(true, i, 2);
                    break;
                }
            }
        }
    }

    public GrupoDeFiltros ObtenerFiltros() {
        DefaultTableModel mGen = (DefaultTableModel) tabla_gen.getModel();
        DefaultTableModel mVis = (DefaultTableModel) tabla_vis.getModel();
        DefaultTableModel mPlat = (DefaultTableModel) tabla_plat.getModel();

        if (enviar) {
            if (rb_incluir.isSelected()) {
                grupoFiltros = new GrupoDeFiltros(mGen, mVis, mPlat, GrupoDeFiltros.INCLUYENTE);
            } else if (rb_excluir.isSelected()) {
                grupoFiltros = new GrupoDeFiltros(mGen, mVis, mPlat, GrupoDeFiltros.EXCLUYENTE);
            } else {
                grupoFiltros = new GrupoDeFiltros(mGen, mVis, mPlat, GrupoDeFiltros.INACTIVO);
            }
        } else {
            grupoFiltros = new GrupoDeFiltros(mGen, mVis, mPlat, GrupoDeFiltros.INACTIVO);
        }

        return grupoFiltros;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Panel_fondo = new javax.swing.JPanel();
        Panel_tablas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_gen = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_vis = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_plat = new javax.swing.JTable();
        Panel_botones = new javax.swing.JPanel();
        btn_toggleG = new javax.swing.JButton();
        btn_toggleV = new javax.swing.JButton();
        btn_toggleP = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rb_incluir = new javax.swing.JRadioButton();
        rb_excluir = new javax.swing.JRadioButton();
        rb_noFiltrar = new javax.swing.JRadioButton();
        btn_aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 350));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        Panel_fondo.setBackground(new java.awt.Color(51, 51, 51));
        Panel_fondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_fondo.setLayout(new java.awt.BorderLayout(0, 5));

        Panel_tablas.setBackground(new java.awt.Color(51, 51, 51));
        Panel_tablas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_tablas.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(25, 200));

        tabla_gen.setAutoCreateRowSorter(true);
        tabla_gen.setBackground(new java.awt.Color(0, 0, 0));
        tabla_gen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabla_gen.setForeground(new java.awt.Color(255, 255, 0));
        tabla_gen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Generos", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_gen.setMinimumSize(new java.awt.Dimension(50, 0));
        tabla_gen.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tabla_gen.setSelectionForeground(new java.awt.Color(51, 255, 0));
        tabla_gen.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_gen);
        if (tabla_gen.getColumnModel().getColumnCount() > 0) {
            tabla_gen.getColumnModel().getColumn(0).setMinWidth(30);
            tabla_gen.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabla_gen.getColumnModel().getColumn(0).setMaxWidth(50);
            tabla_gen.getColumnModel().getColumn(2).setMinWidth(30);
            tabla_gen.getColumnModel().getColumn(2).setPreferredWidth(30);
            tabla_gen.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        Panel_tablas.add(jScrollPane1);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(25, 200));

        tabla_vis.setAutoCreateRowSorter(true);
        tabla_vis.setBackground(new java.awt.Color(0, 0, 0));
        tabla_vis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabla_vis.setForeground(new java.awt.Color(255, 255, 0));
        tabla_vis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Vistas", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_vis.setMinimumSize(new java.awt.Dimension(50, 0));
        tabla_vis.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tabla_vis.setSelectionForeground(new java.awt.Color(51, 255, 0));
        tabla_vis.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla_vis);
        if (tabla_vis.getColumnModel().getColumnCount() > 0) {
            tabla_vis.getColumnModel().getColumn(0).setMinWidth(30);
            tabla_vis.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabla_vis.getColumnModel().getColumn(0).setMaxWidth(50);
            tabla_vis.getColumnModel().getColumn(2).setMinWidth(30);
            tabla_vis.getColumnModel().getColumn(2).setPreferredWidth(30);
            tabla_vis.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        Panel_tablas.add(jScrollPane2);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(25, 200));

        tabla_plat.setAutoCreateRowSorter(true);
        tabla_plat.setBackground(new java.awt.Color(0, 0, 0));
        tabla_plat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabla_plat.setForeground(new java.awt.Color(255, 255, 0));
        tabla_plat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Plataformas", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_plat.setMinimumSize(new java.awt.Dimension(50, 0));
        tabla_plat.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tabla_plat.setSelectionForeground(new java.awt.Color(51, 255, 0));
        tabla_plat.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabla_plat);
        if (tabla_plat.getColumnModel().getColumnCount() > 0) {
            tabla_plat.getColumnModel().getColumn(0).setMinWidth(30);
            tabla_plat.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabla_plat.getColumnModel().getColumn(0).setMaxWidth(50);
            tabla_plat.getColumnModel().getColumn(2).setMinWidth(30);
            tabla_plat.getColumnModel().getColumn(2).setPreferredWidth(30);
            tabla_plat.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        Panel_tablas.add(jScrollPane3);

        Panel_fondo.add(Panel_tablas, java.awt.BorderLayout.CENTER);

        Panel_botones.setBackground(new java.awt.Color(51, 51, 51));
        Panel_botones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_botones.setMinimumSize(new java.awt.Dimension(437, 20));
        Panel_botones.setPreferredSize(new java.awt.Dimension(437, 30));
        Panel_botones.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btn_toggleG.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_toggleG.setText("Alternar selección");
        btn_toggleG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_toggleGActionPerformed(evt);
            }
        });
        Panel_botones.add(btn_toggleG);

        btn_toggleV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_toggleV.setText("Alternar selección");
        btn_toggleV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_toggleVActionPerformed(evt);
            }
        });
        Panel_botones.add(btn_toggleV);

        btn_toggleP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_toggleP.setText("Alternar selección");
        btn_toggleP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_togglePActionPerformed(evt);
            }
        });
        Panel_botones.add(btn_toggleP);

        Panel_fondo.add(Panel_botones, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        rb_incluir.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(rb_incluir);
        rb_incluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rb_incluir.setForeground(new java.awt.Color(0, 255, 0));
        rb_incluir.setSelected(true);
        rb_incluir.setText("Incluir seleccionados");
        jPanel1.add(rb_incluir);

        rb_excluir.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(rb_excluir);
        rb_excluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rb_excluir.setForeground(new java.awt.Color(0, 255, 255));
        rb_excluir.setText("Excluir seleccionados");
        jPanel1.add(rb_excluir);

        rb_noFiltrar.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(rb_noFiltrar);
        rb_noFiltrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rb_noFiltrar.setForeground(new java.awt.Color(255, 255, 0));
        rb_noFiltrar.setText("No filtrar");
        jPanel1.add(rb_noFiltrar);

        btn_aceptar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_aceptar);

        Panel_fondo.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(Panel_fondo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        enviar = true;
        this.dispose();
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_toggleGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_toggleGActionPerformed
        DefaultTableModel mGen = (DefaultTableModel) tabla_gen.getModel();
        
        for(int i = 0; i < mGen.getRowCount(); i++) {
            mGen.setValueAt(toggleG, i, 2);
        }
        
        toggleG = !toggleG;
    }//GEN-LAST:event_btn_toggleGActionPerformed

    private void btn_toggleVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_toggleVActionPerformed
        DefaultTableModel mVis = (DefaultTableModel) tabla_vis.getModel();
        
        for(int i = 0; i < mVis.getRowCount(); i++) {
            mVis.setValueAt(toggleV, i, 2);
        }
        
        toggleV = !toggleV;
    }//GEN-LAST:event_btn_toggleVActionPerformed

    private void btn_togglePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_togglePActionPerformed
        DefaultTableModel mPlat = (DefaultTableModel) tabla_plat.getModel();
        
        for(int i = 0; i < mPlat.getRowCount(); i++) {
            mPlat.setValueAt(toggleP, i, 2);
        }
        
        toggleP = !toggleP;
    }//GEN-LAST:event_btn_togglePActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Filtrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filtrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filtrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filtrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Filtrador dialog = new Filtrador(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_botones;
    private javax.swing.JPanel Panel_fondo;
    private javax.swing.JPanel Panel_tablas;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_toggleG;
    private javax.swing.JButton btn_toggleP;
    private javax.swing.JButton btn_toggleV;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rb_excluir;
    private javax.swing.JRadioButton rb_incluir;
    private javax.swing.JRadioButton rb_noFiltrar;
    private javax.swing.JTable tabla_gen;
    private javax.swing.JTable tabla_plat;
    private javax.swing.JTable tabla_vis;
    // End of variables declaration//GEN-END:variables

}
