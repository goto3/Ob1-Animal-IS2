package interfaz.paneles;

import dominio.Sistema;
import dominio.modelo.Animal;
import dominio.modelo.personas.Adoptante;
import dominio.modelo.personas.Padrino;
import dominio.modelo.personas.Responsable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

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
                //displayData(sistema.getPersona);
            }
        });
        tableModel = (DefaultTableModel) TablePersonas.getModel();
        FillTable();

        TablePersonas.getColumnModel().getColumn(0).setMaxWidth(90);
        TablePersonas.getColumnModel().getColumn(0).setMinWidth(90);
        TablePersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
        TablePersonas.getColumnModel().getColumn(1).setMinWidth(100);
        TablePersonas.getColumnModel().getColumn(2).setPreferredWidth(100);
        TablePersonas.getColumnModel().getColumn(2).setMinWidth(100);
        TablePersonas.getColumnModel().getColumn(3).setPreferredWidth(200);
        TablePersonas.getColumnModel().getColumn(3).setMinWidth(200);

        TablePersonas.setRowSelectionInterval(0, 0);

    }

    private void FillTable() {
        for (Responsable r : sistema.getResponsables()) {
            Object[] o = new Object[]{
                r.getClass().getSimpleName(), r.getNombre(), r.getApellido(), r.getEmail()};
            tableModel.insertRow(tableModel.getRowCount(), o);
        }
        for (Adoptante a : sistema.getAdoptantes()) {
            Object[] o = new Object[]{
                a.getClass().getSimpleName(), a.getNombre(), a.getApellido(), a.getEmail()};
            tableModel.insertRow(tableModel.getRowCount(), o);
        }
        for (Padrino p : sistema.getPadrinos()) {
            Object[] o = new Object[]{
                p.getClass().getSimpleName(), p.getNombre(), p.getApellido(), p.getEmail()};
            tableModel.insertRow(tableModel.getRowCount(), o);
        }
    }

    private void displayData(Animal a) {
        selectedAnimalID = a.getId();

    }

    private void cleanFields() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePersonas = new javax.swing.JTable();
        PanelFields = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 633));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Personas");

        TablePersonas.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        TablePersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Nombre", "Apellido", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablePersonas.setFocusable(false);
        TablePersonas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablePersonas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablePersonas);
        if (TablePersonas.getColumnModel().getColumnCount() > 0) {
            TablePersonas.getColumnModel().getColumn(0).setResizable(false);
            TablePersonas.getColumnModel().getColumn(0).setPreferredWidth(20);
            TablePersonas.getColumnModel().getColumn(1).setPreferredWidth(60);
            TablePersonas.getColumnModel().getColumn(2).setPreferredWidth(30);
            TablePersonas.getColumnModel().getColumn(3).setResizable(false);
            TablePersonas.getColumnModel().getColumn(3).setPreferredWidth(10);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addGap(10, 10, 10)
                        .addComponent(PanelFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelFields, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setAnimalValues(Animal a) {

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelFields;
    private javax.swing.JTable TablePersonas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
