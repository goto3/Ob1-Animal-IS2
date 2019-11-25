package interfaz.paneles;

import dominio.Sistema;
import dominio.modelo.Animal;
import dominio.modelo.Persona;
import dominio.modelo.personas.Adoptante;
import dominio.modelo.personas.Padrino;
import dominio.modelo.personas.Responsable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import interfaz.paneles.personas.PAdoptante;
import interfaz.paneles.personas.PPadrino;
import interfaz.paneles.personas.PResponsable;
import java.awt.BorderLayout;

public class Personas extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    Sistema sistema = Sistema.getInstance();
    ListSelectionModel tableSelectedRow;
    String selectedAnimalID;
    boolean creatingNew;

    public Personas() {
        initComponents();

        /* Tabla de personas */
        TablePersonas.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (tableModel.getRowCount() > 0) {
                creatingNew = false;
                int row = TablePersonas.getSelectedRow();
                String id = tableModel.getValueAt(row, 0).toString();
                String tipo = tableModel.getValueAt(row, 1).toString();
                displayData(sistema.getPersona(id, tipo));
            }
        });
        tableModel = (DefaultTableModel) TablePersonas.getModel();
        FillTable();

        TablePersonas.getColumnModel().getColumn(0).setMaxWidth(65);
        TablePersonas.getColumnModel().getColumn(0).setMinWidth(65);
        TablePersonas.getColumnModel().getColumn(1).setMaxWidth(85);
        TablePersonas.getColumnModel().getColumn(1).setMinWidth(85);
        TablePersonas.getColumnModel().getColumn(2).setPreferredWidth(100);
        TablePersonas.getColumnModel().getColumn(2).setMinWidth(100);
        TablePersonas.getColumnModel().getColumn(3).setPreferredWidth(100);
        TablePersonas.getColumnModel().getColumn(3).setMinWidth(100);
        TablePersonas.getColumnModel().getColumn(4).setPreferredWidth(200);
        TablePersonas.getColumnModel().getColumn(4).setMinWidth(200);

        TablePersonas.setRowSelectionInterval(0, 0);
    }

    private void FillTable() {
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        for (Responsable r : sistema.getResponsables()) {
            Object[] o = new Object[]{
                r.getId(), r.getClass().getSimpleName(), r.getNombre(), r.getApellido(), r.getEmail()};
            tableModel.insertRow(tableModel.getRowCount(), o);
        }
        for (Adoptante a : sistema.getAdoptantes()) {
            Object[] o = new Object[]{
                a.getId(), a.getClass().getSimpleName(), a.getNombre(), a.getApellido(), a.getEmail()};
            tableModel.insertRow(tableModel.getRowCount(), o);
        }
        for (Padrino p : sistema.getPadrinos()) {
            Object[] o = new Object[]{
                p.getId(), p.getClass().getSimpleName(), p.getNombre(), p.getApellido(), p.getEmail()};
            tableModel.insertRow(tableModel.getRowCount(), o);
        }
    }

    private void displayData(Persona p) {
        int row = TablePersonas.getSelectedRow();
        String tipo = tableModel.getValueAt(row, 1).toString();
        PanelFields.removeAll();
        switch (tipo) {
            case ("Adoptante"):
                PAdoptante pad = new PAdoptante(this, p);
                PanelFields.setLayout(new BorderLayout());
                PanelFields.add(pad, BorderLayout.CENTER);
                break;
            case ("Responsable"):
                PResponsable pre = new PResponsable(this, p);
                PanelFields.setLayout(new BorderLayout());
                PanelFields.add(pre, BorderLayout.CENTER);
                break;
            case ("Padrino"):
                PPadrino ppa = new PPadrino(this, p);
                PanelFields.setLayout(new BorderLayout());
                PanelFields.add(ppa, BorderLayout.CENTER);
                break;
        }
        PanelFields.revalidate();
    }

    public void editPersona(Persona p) {
        int row = TablePersonas.getSelectedRow();
        tableModel.setValueAt(p.getNombre(), row, 2);
        tableModel.setValueAt(p.getApellido(), row, 3);
        tableModel.setValueAt(p.getEmail(), row, 4);
        TablePersonas.setRowSelectionInterval(row, row);
    }

    public void addPersona(Persona p) {
        Object[] o = new Object[]{
            p.getId(), p.getClass().getSimpleName(), p.getNombre(), p.getApellido(), p.getEmail()};
        tableModel.insertRow(tableModel.getRowCount(), o);
        sistema.addPersona(p);
        TablePersonas.setRowSelectionInterval(TablePersonas.getRowCount() - 1, TablePersonas.getRowCount() - 1);
    }

    public void SeleccionarPersona(Responsable r) {
        FillTable();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(r.getId())) {
                TablePersonas.setRowSelectionInterval(i, i);
            }
        }
    }

    public void UpdateData() {
        FillTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePersonas = new javax.swing.JTable();
        PanelFields = new javax.swing.JPanel();
        BtnNewResponsable = new rojeru_san.complementos.ButtonHover();
        BtnNewAdoptante = new rojeru_san.complementos.ButtonHover();
        BtnNewPadrino = new rojeru_san.complementos.ButtonHover();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 633));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Personas");

        TablePersonas.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        TablePersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tipo", "Nombre", "Apellido", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablePersonas.setFocusable(false);
        TablePersonas.setRowHeight(20);
        TablePersonas.setSelectionBackground(new java.awt.Color(28, 62, 122));
        TablePersonas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablePersonas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablePersonas);
        if (TablePersonas.getColumnModel().getColumnCount() > 0) {
            TablePersonas.getColumnModel().getColumn(0).setResizable(false);
            TablePersonas.getColumnModel().getColumn(1).setResizable(false);
            TablePersonas.getColumnModel().getColumn(1).setPreferredWidth(20);
            TablePersonas.getColumnModel().getColumn(2).setPreferredWidth(60);
            TablePersonas.getColumnModel().getColumn(3).setPreferredWidth(30);
            TablePersonas.getColumnModel().getColumn(4).setResizable(false);
            TablePersonas.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        PanelFields.setMaximumSize(new java.awt.Dimension(300, 32767));
        PanelFields.setMinimumSize(new java.awt.Dimension(300, 100));
        PanelFields.setPreferredSize(new java.awt.Dimension(300, 0));

        javax.swing.GroupLayout PanelFieldsLayout = new javax.swing.GroupLayout(PanelFields);
        PanelFields.setLayout(PanelFieldsLayout);
        PanelFieldsLayout.setHorizontalGroup(
            PanelFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        PanelFieldsLayout.setVerticalGroup(
            PanelFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        BtnNewResponsable.setBackground(new java.awt.Color(28, 62, 122));
        BtnNewResponsable.setText("Nuevo Responsable");
        BtnNewResponsable.setColorHover(new java.awt.Color(36, 80, 160));
        BtnNewResponsable.setFocusable(false);
        BtnNewResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNewResponsableActionPerformed(evt);
            }
        });

        BtnNewAdoptante.setBackground(new java.awt.Color(28, 62, 122));
        BtnNewAdoptante.setText("Nuevo Adoptante");
        BtnNewAdoptante.setColorHover(new java.awt.Color(36, 80, 160));
        BtnNewAdoptante.setFocusable(false);
        BtnNewAdoptante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNewAdoptanteActionPerformed(evt);
            }
        });

        BtnNewPadrino.setBackground(new java.awt.Color(28, 62, 122));
        BtnNewPadrino.setText("Nuevo Padrino");
        BtnNewPadrino.setColorHover(new java.awt.Color(36, 80, 160));
        BtnNewPadrino.setFocusable(false);
        BtnNewPadrino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNewPadrinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(PanelFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addComponent(BtnNewResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnNewPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(BtnNewAdoptante, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BtnNewResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnNewAdoptante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnNewPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelFields, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNewResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNewResponsableActionPerformed
        PanelFields.removeAll();
        PResponsable res = new PResponsable(this, null);
        PanelFields.setLayout(new BorderLayout());
        PanelFields.add(res, BorderLayout.CENTER);
        PanelFields.revalidate();
    }//GEN-LAST:event_BtnNewResponsableActionPerformed

    private void BtnNewAdoptanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNewAdoptanteActionPerformed
        PanelFields.removeAll();
        PAdoptante ad = new PAdoptante(this, null);
        PanelFields.setLayout(new BorderLayout());
        PanelFields.add(ad, BorderLayout.CENTER);
        PanelFields.revalidate();
    }//GEN-LAST:event_BtnNewAdoptanteActionPerformed

    private void BtnNewPadrinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNewPadrinoActionPerformed
        PanelFields.removeAll();
        PPadrino pad = new PPadrino(this, null);
        PanelFields.setLayout(new BorderLayout());
        PanelFields.add(pad, BorderLayout.CENTER);
        PanelFields.revalidate();
    }//GEN-LAST:event_BtnNewPadrinoActionPerformed

    private void setAnimalValues(Animal a) {

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.ButtonHover BtnNewAdoptante;
    private rojeru_san.complementos.ButtonHover BtnNewPadrino;
    private rojeru_san.complementos.ButtonHover BtnNewResponsable;
    private javax.swing.JPanel PanelFields;
    private javax.swing.JTable TablePersonas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
