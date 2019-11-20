package interfaz.paneles.helpers;

import dominio.Sistema;
import dominio.modelo.personas.Responsable;
import interfaz.paneles.NuevaActividad;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class SeleccionResponsable extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    NuevaActividad na;
    Sistema sistema = Sistema.getInstance();
    Foto LblFoto;
    Object[] responsables;

    public SeleccionResponsable(NuevaActividad na) {
        this.na = na;
        initComponents();

        tableModel = (DefaultTableModel) TablaResp.getModel();
        TablaResp.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (tableModel.getRowCount() > 0) {
                int row = TablaResp.getSelectedRow();
                String id = tableModel.getValueAt(row, 0).toString();
                na.responsableSeleccionado = sistema.getResponsable(id);
            }
        });
        FillTable();

        TablaResp.getColumnModel().getColumn(0).setMaxWidth(55);
        TablaResp.getColumnModel().getColumn(0).setMinWidth(55);
        TablaResp.getColumnModel().getColumn(1).setPreferredWidth(90);
        TablaResp.getColumnModel().getColumn(1).setMinWidth(90);
        TablaResp.getColumnModel().getColumn(2).setPreferredWidth(90);
        TablaResp.getColumnModel().getColumn(2).setMinWidth(90);

        TxtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                Buscar();
            }
        });
    }

    private void Buscar() {
        String s = TxtSearch.getText().toLowerCase();
        if (s.length() == 0) {
            FillTable();
        } else {
            tableModel.setNumRows(0);
            for (Responsable r : sistema.getResponsables()) {
                boolean idMatches = r.getId().toLowerCase().contains(s);
                boolean nombreMatches = r.getNombre().toLowerCase().contains(s);
                boolean apellidoMatches = r.getApellido().toLowerCase().contains(s);
                boolean emailMatches = r.getEmail().toLowerCase().contains(s);
                if (idMatches || nombreMatches || apellidoMatches || emailMatches) {
                    responsables = new Object[]{
                        r.getId(), r.getNombre(), r.getApellido()
                    };
                    tableModel.insertRow(tableModel.getRowCount(), responsables);
                }
            }
        }
    }

    private void FillTable() {
        tableModel.setNumRows(0);
        for (Responsable r : sistema.getResponsables()) {
            responsables = new Object[]{
                r.getId(), r.getNombre(), r.getApellido()
            };
            tableModel.insertRow(tableModel.getRowCount(), responsables);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaResp = new javax.swing.JTable();
        TxtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(250, 550));
        setPreferredSize(new java.awt.Dimension(250, 500));

        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 100));

        TablaResp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TablaResp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaResp.setFocusable(false);
        TablaResp.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        TablaResp.setMinimumSize(new java.awt.Dimension(0, 0));
        TablaResp.setRowHeight(20);
        TablaResp.setSelectionBackground(new java.awt.Color(28, 62, 122));
        TablaResp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(TablaResp);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Buscar:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Selecciona un responsable:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaResp;
    private javax.swing.JTextField TxtSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
