package interfaz.paneles;

import interfaz.paneles.helpers.Foto;
import dominio.Sistema;
import dominio.modelo.Animal;
import dominio.tools.EstadoAnimal;
import dominio.tools.Pago;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class Animales extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    Sistema sistema = Sistema.getInstance();
    ListSelectionModel tableSelectedRow;
    String selectedAnimalID;
    boolean creatingNew;
    Foto LblFoto;

    public Animales() {
        initComponents();

        /* Panel de foto */
        LblFoto = new Foto(new ImageIcon(getClass().getResource("/interfaz/Resources/icons8-dog-paw-100.png")), 280, 176);
        PanelImagen.setLayout(new FlowLayout());
        PanelImagen.add(LblFoto);

        /* Tabla de animales */
        tableModel = (DefaultTableModel) TableAnimales.getModel();
        TableAnimales.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (tableModel.getRowCount() > 0) {
                creatingNew = false;
                int row = TableAnimales.getSelectedRow();
                String id = tableModel.getValueAt(row, 0).toString();
                displayData(sistema.getAnimal(id));
            }
        });
        FillTable();

        TableAnimales.getColumnModel().getColumn(0).setMaxWidth(65);
        TableAnimales.getColumnModel().getColumn(0).setMinWidth(65);
        TableAnimales.getColumnModel().getColumn(1).setPreferredWidth(300);
        TableAnimales.getColumnModel().getColumn(1).setMinWidth(100);
        TableAnimales.getColumnModel().getColumn(2).setPreferredWidth(100);
        TableAnimales.getColumnModel().getColumn(2).setMinWidth(100);
        TableAnimales.getColumnModel().getColumn(3).setMaxWidth(75);
        TableAnimales.getColumnModel().getColumn(3).setMinWidth(75);
        TableAnimales.getColumnModel().getColumn(4).setMaxWidth(75);
        TableAnimales.getColumnModel().getColumn(4).setMinWidth(75);
        TableAnimales.getColumnModel().getColumn(5).setMaxWidth(100);
        TableAnimales.getColumnModel().getColumn(5).setMinWidth(100);

        ComEstado.setModel(new DefaultComboBoxModel(EstadoAnimal.values()));
    }

    private void FillTable() {
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        for (Animal a : sistema.getAnimales()) {
            Object[] o = new Object[]{
                a.getId(), a.getNombre(), a.getTipo(),
                a.getAltura(), a.getPeso(), a.getEstado()
            };
            tableModel.insertRow(tableModel.getRowCount(), o);
        }
        if (TableAnimales.getRowCount() > 0) {
            TableAnimales.setRowSelectionInterval(0, 0);
        }
    }

    private void displayData(Animal a) {
        selectedAnimalID = a.getId();
        TxtNombre.setText(a.getNombre());
        TxtTipo.setText(a.getTipo());
        TxtPeso.setText(String.valueOf(a.getPeso()));
        TxtAltura.setText(String.valueOf(a.getAltura()));
        TxtComentarios.setText(a.getComentarios());
        ComEstado.setSelectedItem(a.getEstado());
        if (a.getFoto() != null) {
            LblFoto.UpdatePhoto(a.getFoto(), 226, 166);
        } else {
            LblFoto.UpdatePhoto(new ImageIcon(getClass().getResource("/interfaz/Resources/icons8-dog-paw-100.png")), 280, 176);
        }
    }

    private void cleanFields() {
        TxtNombre.setText("");
        TxtTipo.setText("");
        TxtPeso.setText("0");
        TxtAltura.setText("0");
        TxtComentarios.setText("");
        ComEstado.setSelectedIndex(0);
    }

    public void SeleccionarAnimal(Animal a) {
        FillTable();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(a.getId())) {
                TableAnimales.setRowSelectionInterval(i, i);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableAnimales = new javax.swing.JTable();
        BtnNew = new rojeru_san.complementos.ButtonHover();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtComentarios = new javax.swing.JTextArea();
        TxtNombre = new javax.swing.JTextField();
        TxtAltura = new javax.swing.JTextField();
        PanelImagen = new javax.swing.JPanel();
        TxtTipo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        BtnGuardar = new rojeru_san.complementos.ButtonHover();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtPeso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 633));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Animales");

        TableAnimales.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TableAnimales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tipo", "Altura", "Peso", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableAnimales.setFocusable(false);
        TableAnimales.setRowHeight(20);
        TableAnimales.setSelectionBackground(new java.awt.Color(28, 62, 122));
        TableAnimales.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TableAnimales.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TableAnimales);
        if (TableAnimales.getColumnModel().getColumnCount() > 0) {
            TableAnimales.getColumnModel().getColumn(0).setResizable(false);
            TableAnimales.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableAnimales.getColumnModel().getColumn(1).setPreferredWidth(60);
            TableAnimales.getColumnModel().getColumn(2).setPreferredWidth(30);
            TableAnimales.getColumnModel().getColumn(3).setResizable(false);
            TableAnimales.getColumnModel().getColumn(3).setPreferredWidth(10);
            TableAnimales.getColumnModel().getColumn(4).setResizable(false);
            TableAnimales.getColumnModel().getColumn(4).setPreferredWidth(10);
            TableAnimales.getColumnModel().getColumn(5).setResizable(false);
            TableAnimales.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

        BtnNew.setBackground(new java.awt.Color(28, 62, 122));
        BtnNew.setText("Nuevo");
        BtnNew.setColorHover(new java.awt.Color(36, 80, 160));
        BtnNew.setFocusable(false);
        BtnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNewActionPerformed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 574));

        TxtComentarios.setColumns(20);
        TxtComentarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtComentarios.setLineWrap(true);
        TxtComentarios.setRows(5);
        jScrollPane2.setViewportView(TxtComentarios);

        TxtAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtAlturaKeyTyped(evt);
            }
        });

        PanelImagen.setMaximumSize(new java.awt.Dimension(280, 176));
        PanelImagen.setMinimumSize(new java.awt.Dimension(280, 176));
        PanelImagen.setPreferredSize(new java.awt.Dimension(280, 176));

        javax.swing.GroupLayout PanelImagenLayout = new javax.swing.GroupLayout(PanelImagen);
        PanelImagen.setLayout(PanelImagenLayout);
        PanelImagenLayout.setHorizontalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelImagenLayout.setVerticalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Estado:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre:");

        ComEstado.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tipo:");

        BtnGuardar.setBackground(new java.awt.Color(28, 62, 122));
        BtnGuardar.setText("Guardar");
        BtnGuardar.setColorHover(new java.awt.Color(36, 80, 160));
        BtnGuardar.setFocusable(false);
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Peso:");

        jLabel8.setText("(gramos)");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Comentarios:");

        TxtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPesoKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Altura:");

        jLabel7.setText("(centímetros)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(TxtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7))
                                            .addComponent(TxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(TxtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel8))))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ComEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ComEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addComponent(BtnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BtnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setAnimalValues(Animal a) {
        a.setNombre(TxtNombre.getText());
        a.setTipo(TxtTipo.getText());
        try {
            a.setPeso(Integer.parseInt(TxtPeso.getText()));
        } catch (Exception ex) {
            a.setPeso(0);
        }
        try {
            a.setAltura(Integer.parseInt(TxtAltura.getText()));
        } catch (Exception ex) {
            a.setAltura(0);
        }
        a.setComentarios(TxtComentarios.getText());
        a.setFoto(LblFoto.imageShowing);
        a.setEstado(EstadoAnimal.valueOf(ComEstado.getSelectedItem().toString()));
    }

    private void TxtAlturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAlturaKeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
                || (vChar == evt.VK_BACK_SPACE)
                || (vChar == evt.VK_DELETE))
                || TxtAltura.getText().length() > 8) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtAlturaKeyTyped

    private void TxtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPesoKeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
                || (vChar == evt.VK_BACK_SPACE)
                || (vChar == evt.VK_DELETE))
                || TxtPeso.getText().length() > 8) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtPesoKeyTyped

    private void BtnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNewActionPerformed
        cleanFields();
        creatingNew = true;
    }//GEN-LAST:event_BtnNewActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        if (!creatingNew) {
            Animal a = sistema.getAnimal(selectedAnimalID);
            setAnimalValues(a);

            int row = TableAnimales.getSelectedRow();
            tableModel.setValueAt(TxtNombre.getText(), row, 1);
            tableModel.setValueAt(TxtTipo.getText(), row, 2);
            tableModel.setValueAt(TxtAltura.getText(), row, 3);
            tableModel.setValueAt(TxtPeso.getText(), row, 4);
            tableModel.setValueAt(ComEstado.getSelectedItem().toString(), row, 5);
            TableAnimales.setRowSelectionInterval(row, row);
        } else {
            Animal a = new Animal();
            setAnimalValues(a);
            Object[] o = new Object[]{
                a.getId(), a.getNombre(), a.getTipo(),
                a.getAltura(), a.getPeso(), a.getEstado()
            };
            tableModel.insertRow(tableModel.getRowCount(), o);
            sistema.addAnimal(a);
            TableAnimales.setRowSelectionInterval(TableAnimales.getRowCount() - 1, TableAnimales.getRowCount() - 1);
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.ButtonHover BtnGuardar;
    private rojeru_san.complementos.ButtonHover BtnNew;
    private javax.swing.JComboBox<String> ComEstado;
    private javax.swing.JPanel PanelImagen;
    private javax.swing.JTable TableAnimales;
    private javax.swing.JTextField TxtAltura;
    private javax.swing.JTextArea TxtComentarios;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtPeso;
    private javax.swing.JTextField TxtTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
