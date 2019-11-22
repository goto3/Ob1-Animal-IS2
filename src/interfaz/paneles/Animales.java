package interfaz.paneles;

import interfaz.paneles.helpers.Foto;
import dominio.Sistema;
import dominio.modelo.Animal;
import java.awt.FlowLayout;
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
        LblFoto = new Foto(new ImageIcon(getClass().getResource("/interfaz/Resources/icons8-dog-paw-100.png")), 226, 166);
        PanelImagen.setLayout(new FlowLayout());
        PanelImagen.add(LblFoto);

        /* Tabla de animales */
        tableModel = (DefaultTableModel) TableAnimales.getModel();
        TableAnimales.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (tableModel.getRowCount() > 0) {
                creatingNew = false;
                int row = TableAnimales.getSelectedRow();
                System.out.println(tableModel.getRowCount());
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

        TableAnimales.setRowSelectionInterval(0, 0);

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
    }

    private void displayData(Animal a) {
        selectedAnimalID = a.getId();
        TxtNombre.setText(a.getNombre());
        TxtTipo.setText(a.getTipo());
        TxtPeso.setText(String.valueOf(a.getPeso()));
        TxtAltura.setText(String.valueOf(a.getAltura()));
        TxtComentarios.setText(a.getComentarios());
        if (a.getFoto() != null) {
            LblFoto.UpdatePhoto(a.getFoto(), 226, 166);
        } else {
            LblFoto.UpdatePhoto(new ImageIcon(getClass().getResource("/interfaz/Resources/icons8-dog-paw-100.png")), 226, 166);
        }
    }

    private void cleanFields() {
        TxtNombre.setText("");
        TxtTipo.setText("");
        TxtPeso.setText("0");
        TxtAltura.setText("0");
        TxtComentarios.setText("");
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
        BtnNuevo = new javax.swing.JButton();
        TxtGuardar = new javax.swing.JButton();
        TxtPeso = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        TxtAltura = new javax.swing.JTextField();
        TxtTipo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtComentarios = new javax.swing.JTextArea();
        PanelImagen = new javax.swing.JPanel();

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

        BtnNuevo.setText("Nuevo");
        BtnNuevo.setFocusable(false);
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        TxtGuardar.setText("Guardar");
        TxtGuardar.setFocusable(false);
        TxtGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtGuardarActionPerformed(evt);
            }
        });

        TxtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPesoKeyTyped(evt);
            }
        });

        TxtAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtAlturaKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Tipo:");

        jLabel5.setText("Altura:");

        jLabel6.setText("Peso:");

        jLabel7.setText("(centímetros)");

        jLabel8.setText("(gramos)");

        jLabel9.setText("Comentarios:");

        TxtComentarios.setColumns(20);
        TxtComentarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtComentarios.setLineWrap(true);
        TxtComentarios.setRows(5);
        jScrollPane2.setViewportView(TxtComentarios);

        PanelImagen.setMaximumSize(new java.awt.Dimension(236, 176));
        PanelImagen.setMinimumSize(new java.awt.Dimension(236, 176));
        PanelImagen.setPreferredSize(new java.awt.Dimension(236, 176));

        javax.swing.GroupLayout PanelImagenLayout = new javax.swing.GroupLayout(PanelImagen);
        PanelImagen.setLayout(PanelImagenLayout);
        PanelImagenLayout.setHorizontalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
        );
        PanelImagenLayout.setVerticalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TxtPeso)
                                            .addComponent(TxtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(3, 3, 3)))
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(PanelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(PanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        cleanFields();
        creatingNew = true;
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void TxtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtGuardarActionPerformed
        if (!creatingNew) {
            Animal a = sistema.getAnimal(selectedAnimalID);
            setAnimalValues(a);

            int row = TableAnimales.getSelectedRow();
            tableModel.setValueAt(TxtNombre.getText(), row, 1);
            tableModel.setValueAt(TxtTipo.getText(), row, 2);
            tableModel.setValueAt(TxtAltura.getText(), row, 3);
            tableModel.setValueAt(TxtPeso.getText(), row, 4);
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
    }//GEN-LAST:event_TxtGuardarActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JPanel PanelImagen;
    private javax.swing.JTable TableAnimales;
    private javax.swing.JTextField TxtAltura;
    private javax.swing.JTextArea TxtComentarios;
    private javax.swing.JButton TxtGuardar;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtPeso;
    private javax.swing.JTextField TxtTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
