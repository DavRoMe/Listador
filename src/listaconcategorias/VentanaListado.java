package listaconcategorias;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaListado extends javax.swing.JFrame {

    private final ListaDB basededatos = new ListaDB();
    private GrupoDeFiltros filtrosGlobales = new GrupoDeFiltros();

    public VentanaListado() {
        initComponents();
        mostrarEnTabla();
        jScrollPane1.getViewport().setBackground(tabla_principal.getBackground());
    }

    private void mostrarEnTabla() {
        ResultSet rs;

        DefaultTableModel modelo_t = (DefaultTableModel) tabla_principal.getModel();
        modelo_t.setRowCount(0);
        Object[] fila = new Object[4]; // numero de columnas en la tabla

        try {
            if (filtrosGlobales.size() > 0) {
                rs = basededatos.leerJuegos(filtrosGlobales);
            } else {
                rs = basededatos.leerJuegos();
            }

            while (rs.next()) {
                fila[0] = rs.getString("nombre");
                fila[1] = rs.getString("vista");
                fila[2] = rs.getString("plataforma");
                fila[3] = obtenGeneros(rs.getString("id_juego"));

                modelo_t.addRow(fila);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String obtenGeneros(String idJuego) {
        ResultSet rs;
        String generos = "";

        try {
            rs = basededatos.verGenerosDeJuego(idJuego);
            boolean check = false;
            while (rs.next()) {
                if (check) {
                    generos += ",  \n";
                }
                generos += rs.getString("genero");
                check = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        editar_btn = new javax.swing.JButton();
        nuevo_btn = new javax.swing.JButton();
        borrar_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_principal = new javax.swing.JTable();
        admin_btn = new javax.swing.JButton();
        filtros_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de juegos");
        setMinimumSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        editar_btn.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        editar_btn.setForeground(new java.awt.Color(0, 102, 204));
        editar_btn.setText("Editar");
        editar_btn.setMaximumSize(new java.awt.Dimension(120, 35));
        editar_btn.setMinimumSize(new java.awt.Dimension(120, 35));
        editar_btn.setPreferredSize(new java.awt.Dimension(120, 35));
        editar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_btnActionPerformed(evt);
            }
        });

        nuevo_btn.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        nuevo_btn.setForeground(new java.awt.Color(0, 153, 0));
        nuevo_btn.setText("Nuevo");
        nuevo_btn.setMaximumSize(new java.awt.Dimension(120, 35));
        nuevo_btn.setMinimumSize(new java.awt.Dimension(120, 35));
        nuevo_btn.setPreferredSize(new java.awt.Dimension(120, 35));
        nuevo_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_btnActionPerformed(evt);
            }
        });

        borrar_btn.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        borrar_btn.setForeground(new java.awt.Color(153, 0, 0));
        borrar_btn.setText("Borrar");
        borrar_btn.setMaximumSize(new java.awt.Dimension(120, 35));
        borrar_btn.setMinimumSize(new java.awt.Dimension(120, 35));
        borrar_btn.setPreferredSize(new java.awt.Dimension(120, 35));
        borrar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_btnActionPerformed(evt);
            }
        });

        tabla_principal.setAutoCreateRowSorter(true);
        tabla_principal.setBackground(new java.awt.Color(0, 0, 0));
        tabla_principal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabla_principal.setForeground(new java.awt.Color(255, 255, 0));
        tabla_principal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Elemento", "Categoria_1", "Categotia_2", "Generos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_principal.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tabla_principal.setSelectionForeground(new java.awt.Color(51, 255, 0));
        tabla_principal.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_principal);
        if (tabla_principal.getColumnModel().getColumnCount() > 0) {
            tabla_principal.getColumnModel().getColumn(0).setMinWidth(100);
            tabla_principal.getColumnModel().getColumn(1).setMinWidth(80);
            tabla_principal.getColumnModel().getColumn(1).setMaxWidth(100);
            tabla_principal.getColumnModel().getColumn(2).setMinWidth(80);
            tabla_principal.getColumnModel().getColumn(2).setMaxWidth(100);
            tabla_principal.getColumnModel().getColumn(3).setMinWidth(100);
        }

        admin_btn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        admin_btn.setForeground(new java.awt.Color(255, 102, 0));
        admin_btn.setText("Administrar");
        admin_btn.setMaximumSize(new java.awt.Dimension(120, 35));
        admin_btn.setMinimumSize(new java.awt.Dimension(120, 35));
        admin_btn.setPreferredSize(new java.awt.Dimension(120, 35));
        admin_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_btnActionPerformed(evt);
            }
        });

        filtros_btn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        filtros_btn.setForeground(new java.awt.Color(255, 102, 0));
        filtros_btn.setText("Filtros");
        filtros_btn.setMaximumSize(new java.awt.Dimension(120, 35));
        filtros_btn.setMinimumSize(new java.awt.Dimension(120, 35));
        filtros_btn.setPreferredSize(new java.awt.Dimension(120, 35));
        filtros_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtros_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(editar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(nuevo_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(borrar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filtros_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(admin_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nuevo_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(borrar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(admin_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filtros_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void borrar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_btnActionPerformed
        if (tabla_principal.getSelectedRow() != -1) {
            String botones[] = {"Eliminar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(null, "El registro "
                    + "seleccionado se eliminará de la lista", "Confirmar",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, botones, this);

            if (eleccion == JOptionPane.YES_OPTION) {
                int num_fila = tabla_principal.getSelectedRow();
                String juego = tabla_principal.getValueAt(num_fila, 0).toString();

                // Eliminar registro de la base de datos
                try {
                    basededatos.eliminarJuego(juego);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                mostrarEnTabla();
            }
        }
    }//GEN-LAST:event_borrar_btnActionPerformed

    private void nuevo_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_btnActionPerformed
        DialogoDeEdicion editor = new DialogoDeEdicion(this, true);
        editor.setTitle("Agregar nuevo elemento");
        editor.setVisible(rootPaneCheckingEnabled);

        mostrarEnTabla();
    }//GEN-LAST:event_nuevo_btnActionPerformed

    private void editar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_btnActionPerformed
        if (tabla_principal.getSelectedRow() != -1) {
            String[] info = {"", "", ""};
            if (tabla_principal.getValueAt(tabla_principal.getSelectedRow(), 0) != null) {
                info[0] = tabla_principal.getValueAt(tabla_principal.getSelectedRow(), 0).toString();
            }
            if (tabla_principal.getValueAt(tabla_principal.getSelectedRow(), 1) != null) {
                info[1] = tabla_principal.getValueAt(tabla_principal.getSelectedRow(), 1).toString();
            }
            if (tabla_principal.getValueAt(tabla_principal.getSelectedRow(), 2) != null) {
                info[2] = tabla_principal.getValueAt(tabla_principal.getSelectedRow(), 2).toString();
            }

            DialogoDeEdicion editor = new DialogoDeEdicion(this, true);
            editor.setTitle("Editar elemento");
            editor.cargaInfoDeJuego(info);
            editor.setVisible(rootPaneCheckingEnabled);

            mostrarEnTabla();
        }
    }//GEN-LAST:event_editar_btnActionPerformed

    private void admin_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_btnActionPerformed
        GestorCategorias gestor = new GestorCategorias(this, true);
        gestor.setTitle("Gestor de categorias");
        gestor.setVisible(rootPaneCheckingEnabled);

        mostrarEnTabla();
    }//GEN-LAST:event_admin_btnActionPerformed

    private void filtros_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtros_btnActionPerformed
        Filtrador filtrador = new Filtrador(this, true);
        filtrador.setTitle("Filtros");
        if (filtrosGlobales.size() > 0) {
            filtrador.precargarFiltros(filtrosGlobales);
        }
        filtrador.setVisible(rootPaneCheckingEnabled);
        filtrosGlobales = filtrador.ObtenerFiltros();
        
        mostrarEnTabla();
    }//GEN-LAST:event_filtros_btnActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaListado().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admin_btn;
    private javax.swing.JButton borrar_btn;
    private javax.swing.JButton editar_btn;
    private javax.swing.JButton filtros_btn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nuevo_btn;
    private javax.swing.JTable tabla_principal;
    // End of variables declaration//GEN-END:variables
}
