package listaconcategorias;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorCategorias extends javax.swing.JDialog {

    private final ListaDB basededatos = new ListaDB();

    public GestorCategorias(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargaGeneros();
        cargaVistas();
        cargaPlataformas();
        jScrollPane1.getViewport().setBackground(tabl_Gen.getBackground());
        jScrollPane2.getViewport().setBackground(tabl_Vis.getBackground());
        jScrollPane3.getViewport().setBackground(tabl_Plat.getBackground());
    }

    private void cargaGeneros() {
        DefaultTableModel modelo = (DefaultTableModel) tabl_Gen.getModel();
        modelo.setRowCount(0);
        Object[] fila = new Object[2];

        try {
            ResultSet rs = basededatos.leerGeneros();

            while (rs.next()) {
                fila[0] = rs.getInt("id_generos");
                fila[1] = "  " + rs.getString("genero");

                modelo.addRow(fila);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargaVistas() {
        DefaultTableModel modelo = (DefaultTableModel) tabl_Vis.getModel();
        modelo.setRowCount(0);
        Object[] fila = new Object[2];

        try {
            ResultSet rs = basededatos.leerVistas();

            while (rs.next()) {
                fila[0] = rs.getInt("id_vista");
                fila[1] = "  " + rs.getString("vista");

                modelo.addRow(fila);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargaPlataformas() {
        DefaultTableModel modelo = (DefaultTableModel) tabl_Plat.getModel();
        modelo.setRowCount(0);
        Object[] fila = new Object[2];

        try {
            ResultSet rs = basededatos.leerPlataformas();

            while (rs.next()) {
                fila[0] = rs.getInt("id_plataforma");
                fila[1] = "  " + rs.getString("plataforma");

                modelo.addRow(fila);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_addGen = new javax.swing.JButton();
        btn_edGen = new javax.swing.JButton();
        btn_delGen = new javax.swing.JButton();
        btn_addVis = new javax.swing.JButton();
        btn_edVis = new javax.swing.JButton();
        btn_delVis = new javax.swing.JButton();
        btn_addPlat = new javax.swing.JButton();
        btn_edPlat = new javax.swing.JButton();
        btn_delPlat = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabl_Gen = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabl_Vis = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabl_Plat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(730, 320));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(635, 305));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 8, 0));

        btn_addGen.setText("Agregar");
        btn_addGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addGenActionPerformed(evt);
            }
        });
        jPanel2.add(btn_addGen);

        btn_edGen.setText("Editar");
        btn_edGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edGenActionPerformed(evt);
            }
        });
        jPanel2.add(btn_edGen);

        btn_delGen.setText("Borrar");
        btn_delGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delGenActionPerformed(evt);
            }
        });
        jPanel2.add(btn_delGen);

        btn_addVis.setText("Agregar");
        btn_addVis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addVisActionPerformed(evt);
            }
        });
        jPanel2.add(btn_addVis);

        btn_edVis.setText("Editar");
        btn_edVis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edVisActionPerformed(evt);
            }
        });
        jPanel2.add(btn_edVis);

        btn_delVis.setText("Borrar");
        btn_delVis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delVisActionPerformed(evt);
            }
        });
        jPanel2.add(btn_delVis);

        btn_addPlat.setText("Agregar");
        btn_addPlat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addPlatActionPerformed(evt);
            }
        });
        jPanel2.add(btn_addPlat);

        btn_edPlat.setText("Editar");
        btn_edPlat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edPlatActionPerformed(evt);
            }
        });
        jPanel2.add(btn_edPlat);

        btn_delPlat.setText("Borrar");
        btn_delPlat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delPlatActionPerformed(evt);
            }
        });
        jPanel2.add(btn_delPlat);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(210, 250));

        tabl_Gen.setAutoCreateRowSorter(true);
        tabl_Gen.setBackground(new java.awt.Color(0, 0, 0));
        tabl_Gen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabl_Gen.setForeground(new java.awt.Color(255, 255, 0));
        tabl_Gen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Generos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabl_Gen.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tabl_Gen.setSelectionForeground(new java.awt.Color(51, 255, 0));
        tabl_Gen.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabl_Gen);
        if (tabl_Gen.getColumnModel().getColumnCount() > 0) {
            tabl_Gen.getColumnModel().getColumn(0).setMinWidth(30);
            tabl_Gen.getColumnModel().getColumn(0).setMaxWidth(50);
            tabl_Gen.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane1);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(210, 250));

        tabl_Vis.setAutoCreateRowSorter(true);
        tabl_Vis.setBackground(new java.awt.Color(0, 0, 0));
        tabl_Vis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabl_Vis.setForeground(new java.awt.Color(255, 255, 0));
        tabl_Vis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Vistas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabl_Vis.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tabl_Vis.setSelectionForeground(new java.awt.Color(51, 255, 0));
        tabl_Vis.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabl_Vis);
        if (tabl_Vis.getColumnModel().getColumnCount() > 0) {
            tabl_Vis.getColumnModel().getColumn(0).setMinWidth(30);
            tabl_Vis.getColumnModel().getColumn(0).setMaxWidth(50);
            tabl_Vis.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane2);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(210, 250));

        tabl_Plat.setAutoCreateRowSorter(true);
        tabl_Plat.setBackground(new java.awt.Color(0, 0, 0));
        tabl_Plat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabl_Plat.setForeground(new java.awt.Color(255, 255, 0));
        tabl_Plat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Plataformas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabl_Plat.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tabl_Plat.setSelectionForeground(new java.awt.Color(51, 255, 0));
        tabl_Plat.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabl_Plat);
        if (tabl_Plat.getColumnModel().getColumnCount() > 0) {
            tabl_Plat.getColumnModel().getColumn(0).setMinWidth(30);
            tabl_Plat.getColumnModel().getColumn(0).setMaxWidth(50);
            tabl_Plat.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_delGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delGenActionPerformed
        if (tabl_Gen.getSelectedRow() != -1) {
            String botones[] = {"Eliminar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(null, "El Genero "
                    + "seleccionado se eliminará de la base de datos", "Confirmar",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, botones, this);

            if (eleccion == JOptionPane.YES_OPTION) {
                String id_genero = tabl_Gen.getValueAt(tabl_Gen.getSelectedRow(), 0).toString();
                try {
                    basededatos.borrarGenero(id_genero);
                    cargaGeneros();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btn_delGenActionPerformed

    private void btn_addGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addGenActionPerformed
        String nomGenero = "" + JOptionPane.showInputDialog(null, "Nombre del Genero a crear", "Creando"
                + " nuevo Genero", JOptionPane.PLAIN_MESSAGE);
        if (!nomGenero.equalsIgnoreCase("null")) {
            try {
                basededatos.agregaGenero(nomGenero);
                cargaGeneros();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_addGenActionPerformed

    private void btn_addVisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addVisActionPerformed
        String nomVista = "" + JOptionPane.showInputDialog(null, "Nombre de la Vista a crear", "Creando"
                + " nueva Vista", JOptionPane.PLAIN_MESSAGE);
        if (!nomVista.equalsIgnoreCase("null")) {
            try {
                basededatos.agregaVista(nomVista);
                cargaVistas();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_addVisActionPerformed

    private void btn_delVisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delVisActionPerformed
        if (tabl_Vis.getSelectedRow() != -1) {
            String botones[] = {"Eliminar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(null, "La Vista "
                    + "seleccionada se eliminará de la base de datos", "Confirmar",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, botones, this);

            if (eleccion == JOptionPane.YES_OPTION) {
                String id_vista = tabl_Vis.getValueAt(tabl_Vis.getSelectedRow(), 0).toString();
                try {
                    basededatos.borrarVista(id_vista);
                    cargaVistas();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btn_delVisActionPerformed

    private void btn_addPlatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addPlatActionPerformed
        String nomPlataforma = "" + JOptionPane.showInputDialog(null, "Nombre de la Plataforma a crear", "Creando"
                + " nueva Plataforma", JOptionPane.PLAIN_MESSAGE);
        if (!nomPlataforma.equalsIgnoreCase("null")) {
            try {
                basededatos.agregaPlataforma(nomPlataforma);
                cargaPlataformas();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_addPlatActionPerformed

    private void btn_delPlatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delPlatActionPerformed
        if (tabl_Plat.getSelectedRow() != -1) {
            String botones[] = {"Eliminar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(null, "La Plataforma "
                    + "seleccionada se eliminará de la base de datos", "Confirmar",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, botones, this);

            if (eleccion == JOptionPane.YES_OPTION) {
                String id_plataf = tabl_Plat.getValueAt(tabl_Plat.getSelectedRow(), 0).toString();
                try {
                    basededatos.borrarPlataforma(id_plataf);
                    cargaPlataformas();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btn_delPlatActionPerformed

    private void btn_edGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edGenActionPerformed
        if (tabl_Gen.getSelectedRow() != -1) {
            String botones[] = {"Renombrar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(null, "¿Desea cambiar el nombre del genero seleccionado?",
                    "Renombrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, this);

            if (eleccion == JOptionPane.YES_OPTION) {
                String nuevoNombre = "" + JOptionPane.showInputDialog(null, "Escribe el nuevo nombre", "Modificando"
                        + " nombre del genero", JOptionPane.PLAIN_MESSAGE);

                if (!nuevoNombre.equalsIgnoreCase("null")) {
                    String id = tabl_Gen.getValueAt(tabl_Gen.getSelectedRow(), 0).toString();

                    try {
                        basededatos.renombraGenero(nuevoNombre, id);
                        cargaGeneros();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_edGenActionPerformed

    private void btn_edVisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edVisActionPerformed
        if (tabl_Vis.getSelectedRow() != -1) {
            String botones[] = {"Renombrar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(null, "¿Desea cambiar el nombre de la vista seleccionada?",
                    "Renombrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, this);

            if (eleccion == JOptionPane.YES_OPTION) {
                String nuevoNombre = "" + JOptionPane.showInputDialog(null, "Escribe el nuevo nombre", "Modificando"
                        + " nombre de la vista", JOptionPane.PLAIN_MESSAGE);

                if (!nuevoNombre.equalsIgnoreCase("null")) {
                    String id = tabl_Vis.getValueAt(tabl_Vis.getSelectedRow(), 0).toString();

                    try {
                        basededatos.renombraVista(nuevoNombre, id);
                        cargaVistas();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_edVisActionPerformed

    private void btn_edPlatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edPlatActionPerformed
        if (tabl_Plat.getSelectedRow() != -1) {
            String botones[] = {"Renombrar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(null, "¿Desea cambiar el nombre de la plataforma seleccionada?",
                    "Renombrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, this);

            if (eleccion == JOptionPane.YES_OPTION) {
                String nuevoNombre = "" + JOptionPane.showInputDialog(null, "Escribe el nuevo nombre", "Modificando"
                        + " nombre de la plataforma", JOptionPane.PLAIN_MESSAGE);

                if (!nuevoNombre.equalsIgnoreCase("null")) {
                    String id = tabl_Plat.getValueAt(tabl_Plat.getSelectedRow(), 0).toString();

                    try {
                        basededatos.renombraPlataforma(nuevoNombre, id);
                        cargaPlataformas();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_edPlatActionPerformed

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
            java.util.logging.Logger.getLogger(GestorCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestorCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestorCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestorCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestorCategorias dialog = new GestorCategorias(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_addGen;
    private javax.swing.JButton btn_addPlat;
    private javax.swing.JButton btn_addVis;
    private javax.swing.JButton btn_delGen;
    private javax.swing.JButton btn_delPlat;
    private javax.swing.JButton btn_delVis;
    private javax.swing.JButton btn_edGen;
    private javax.swing.JButton btn_edPlat;
    private javax.swing.JButton btn_edVis;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabl_Gen;
    private javax.swing.JTable tabl_Plat;
    private javax.swing.JTable tabl_Vis;
    // End of variables declaration//GEN-END:variables
}
