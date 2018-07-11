package listaconcategorias;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DialogoDeEdicion extends javax.swing.JDialog {

    private final ListaDB basededatos = new ListaDB();
    private boolean modo_edicion = false;
    private String idInicial = new String();
    private String[] infoInicial = new String[3];
    private ArrayList<String> generosInic = new ArrayList<>();

    public DialogoDeEdicion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        actlzrVistas();
        actlzrPlataformas();
        actlzrGeneros();
        jScrollPane.getViewport().setBackground(tabla_generos.getBackground());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombreDelJuego_tf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tipoDeVista_cb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        plataforma_cb = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tabla_generos = new javax.swing.JTable();
        aceptar_btn = new javax.swing.JButton();
        cancelar_btn = new javax.swing.JButton();
        addVista_btn = new javax.swing.JButton();
        addPlataf_btn = new javax.swing.JButton();
        addGenero_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(386, 470));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nombre del elemento");

        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Categoria_1");

        tipoDeVista_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NULL" }));

        jLabel3.setForeground(new java.awt.Color(51, 204, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Categoria_2");

        plataforma_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NULL" }));

        jLabel4.setForeground(new java.awt.Color(51, 204, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Generos");

        tabla_generos.setAutoCreateRowSorter(true);
        tabla_generos.setBackground(new java.awt.Color(51, 51, 51));
        tabla_generos.setForeground(new java.awt.Color(255, 255, 0));
        tabla_generos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Genero", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_generos.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tabla_generos.setSelectionForeground(new java.awt.Color(51, 255, 0));
        tabla_generos.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(tabla_generos);
        if (tabla_generos.getColumnModel().getColumnCount() > 0) {
            tabla_generos.getColumnModel().getColumn(1).setMinWidth(30);
            tabla_generos.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        aceptar_btn.setText("Aceptar");
        aceptar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar_btnActionPerformed(evt);
            }
        });

        cancelar_btn.setText("Cancelar");
        cancelar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_btnActionPerformed(evt);
            }
        });

        addVista_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addVista_btn.setText("+");
        addVista_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVista_btnActionPerformed(evt);
            }
        });

        addPlataf_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addPlataf_btn.setText("+");
        addPlataf_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlataf_btnActionPerformed(evt);
            }
        });

        addGenero_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addGenero_btn.setText("+");
        addGenero_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGenero_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombreDelJuego_tf)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(plataforma_cb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(tipoDeVista_cb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addVista_btn)
                                    .addComponent(addPlataf_btn)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addGenero_btn))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(aceptar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreDelJuego_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoDeVista_cb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addVista_btn))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plataforma_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addPlataf_btn))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aceptar_btn)
                            .addComponent(cancelar_btn)))
                    .addComponent(addGenero_btn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargaInfoDeJuego(String[] info) {
        // Activar modo de edicion de un juego que ya existe
        modo_edicion = true;
        infoInicial = info;

        nombreDelJuego_tf.setText(info[0]);
        tipoDeVista_cb.setSelectedItem(info[1]);
        plataforma_cb.setSelectedItem(info[2]);

        // Activando los checkbox de los generos correspondientes al juego elegido 
        try {
            ResultSet rs = basededatos.leerID(info[0]);
            String id = new String();
            while (rs.next()) {
                id = rs.getString("id_juego");
            }
            idInicial = id;

            rs = basededatos.verGenerosDeJuego(id);
            // Arreglo con la lista de generos que tiene el juego
            ArrayList<String> arreglo = new ArrayList<>();
            while (rs.next()) {
                arreglo.add(rs.getString("genero"));
            }
            generosInic = arreglo;  // Guardando los generos iniciales antes de editar

            // Buscando que el genero de la tabla este en el arreglo
            for (int i = 0; i < tabla_generos.getRowCount(); i++) {
                for (int j = 0; j < arreglo.size(); j++) {
                    if (tabla_generos.getValueAt(i, 0).toString().equals(arreglo.get(j))) {
                        tabla_generos.setValueAt(true, i, 1);
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void actlzrVistas() {
        try {
            ResultSet rs = basededatos.leerVistas();
            Object seleccion = tipoDeVista_cb.getSelectedItem();
            tipoDeVista_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Null"}));
            while (rs.next()) {
                tipoDeVista_cb.addItem(rs.getString("vista"));
            }
            tipoDeVista_cb.setSelectedItem(seleccion);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actlzrPlataformas() {
        try {
            ResultSet rs = basededatos.leerPlataformas();
            Object seleccion = plataforma_cb.getSelectedItem();
            plataforma_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Null"}));
            while (rs.next()) {
                plataforma_cb.addItem(rs.getString("plataforma"));
            }
            plataforma_cb.setSelectedItem(seleccion);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actlzrGeneros() {
        DefaultTableModel modelo_t = (DefaultTableModel) tabla_generos.getModel();
        ArrayList<String> nombresGen = new ArrayList<>();

        for (int i = 0; i < modelo_t.getRowCount(); i++) {
            if (modelo_t.getValueAt(i, 1).equals(true)) {
                nombresGen.add(modelo_t.getValueAt(i, 0).toString());
            }
        }

        modelo_t.setRowCount(0);
        Object[] fila = new Object[2]; // numero de columnas en la tabla

        try {
            ResultSet rs = basededatos.leerGeneros();

            while (rs.next()) {
                String cadena = rs.getString("genero");
                fila[0] = cadena;
                fila[1] = false;

                modelo_t.addRow(fila);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < tabla_generos.getRowCount(); i++) {
            for (int j = 0; j < nombresGen.size(); j++) {
                if (tabla_generos.getModel().getValueAt(i, 0).toString().equals(nombresGen.get(j))) {
                    tabla_generos.setValueAt(true, i, 1);
                    break;
                }
            }
        }
    }

    private void cancelar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelar_btnActionPerformed

    private void addVista_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVista_btnActionPerformed
        String nombreVista = "" + JOptionPane.showInputDialog(null, "Nombre de la Categoria a crear", "Creando"
                + " nueva Categoria", JOptionPane.PLAIN_MESSAGE);
//        System.out.println(nombreVista);
        if (!nombreVista.equalsIgnoreCase("null")) {
            try {
                basededatos.agregaVista(nombreVista);
                actlzrVistas();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_addVista_btnActionPerformed

    private void addPlataf_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlataf_btnActionPerformed
        String nomPlataforma = "" + JOptionPane.showInputDialog(null, "Nombre de la Categoria a crear", "Creando"
                + " nueva Categoria", JOptionPane.PLAIN_MESSAGE);
        if (!nomPlataforma.equalsIgnoreCase("null")) {
            try {
                basededatos.agregaPlataforma(nomPlataforma);
                actlzrPlataformas();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_addPlataf_btnActionPerformed

    private void addGenero_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGenero_btnActionPerformed
        String nomGenero = "" + JOptionPane.showInputDialog(null, "Nombre del Genero a crear", "Creando"
                + " nuevo Genero", JOptionPane.PLAIN_MESSAGE);
        if (!nomGenero.equalsIgnoreCase("null")) {
            try {
                basededatos.agregaGenero(nomGenero);
                actlzrGeneros();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_addGenero_btnActionPerformed

    private void aceptar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar_btnActionPerformed
        String nombre = nombreDelJuego_tf.getText();

        if (!nombre.equals("")) {
            String plataforma = plataforma_cb.getSelectedItem().toString();
            String vista = tipoDeVista_cb.getSelectedItem().toString();
            final ArrayList<String> generosFinales = generosActivos();

            if (modo_edicion) {
                boolean n = true;
                boolean v = true;
                boolean p = true;

                if (infoInicial[0].equals(nombre)) {
                    n = false;
                }
                if (infoInicial[1].equals(vista)) {
                    v = false;
                }
                if (infoInicial[2].equals(plataforma)) {
                    p = false;
                }

                try {
                    basededatos.editaJuego(idInicial, nombre, vista, plataforma, generosAgregados(generosInic, generosFinales),
                            generosEliminados(generosInic, generosFinales), n, v, p);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                this.dispose();
            } else {
                try {
                    basededatos.agregaJuego(nombre, vista, plataforma, generosFinales);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo del Nombre esta vacio", "¡Atencion!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_aceptar_btnActionPerformed

    private ArrayList<String> generosActivos() {
        ArrayList<String> seleccion = new ArrayList<>();

        for (int i = 0; i < tabla_generos.getRowCount(); i++) {
            if (tabla_generos.getValueAt(i, 1).equals(true)) {
                seleccion.add(tabla_generos.getValueAt(i, 0).toString());
            }
        }

        return seleccion;
    }

    private ArrayList<String> generosAgregados(ArrayList<String> listaInicial, ArrayList<String> listaFinal) {
        // Creando una copia para no modificar el original
        ArrayList<String> agregados = new ArrayList<>(listaFinal);

        agregados.removeAll(listaInicial);

        return agregados;
    }

    private ArrayList<String> generosEliminados(ArrayList<String> listaInicial, ArrayList<String> listaFinal) {
        // Creando una copia para no modificar el original
        ArrayList<String> eliminados = new ArrayList<>(listaInicial);

        eliminados.removeAll(listaFinal);

        return eliminados;
    }

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
            java.util.logging.Logger.getLogger(DialogoDeEdicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogoDeEdicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogoDeEdicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogoDeEdicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogoDeEdicion dialog = new DialogoDeEdicion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton aceptar_btn;
    private javax.swing.JButton addGenero_btn;
    private javax.swing.JButton addPlataf_btn;
    private javax.swing.JButton addVista_btn;
    private javax.swing.JButton cancelar_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextField nombreDelJuego_tf;
    private javax.swing.JComboBox<String> plataforma_cb;
    private javax.swing.JTable tabla_generos;
    private javax.swing.JComboBox<String> tipoDeVista_cb;
    // End of variables declaration//GEN-END:variables
}
