package interfaz.paneles.helpers;

import dominio.Sistema;
import dominio.modelo.Animal;
import interfaz.paneles.NuevaActividad;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class SeleccionMascota extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    NuevaActividad na;
    Sistema sistema = Sistema.getInstance();
    Foto LblFoto;
    Object[] animales;

    public SeleccionMascota(NuevaActividad na) {
        this.na = na;
        initComponents();

        /* Panel de foto */
        LblFoto = new Foto(new ImageIcon(getClass().getResource("/interfaz/Resources/icons8-dog-paw-100.png")), 226, 166);
        PanelImagen.setLayout(new FlowLayout());
        PanelImagen.add(LblFoto);

        tableModel = (DefaultTableModel) TablaMasc.getModel();
        TablaMasc.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (tableModel.getRowCount() > 0) {
                int row = TablaMasc.getSelectedRow();
                String id = tableModel.getValueAt(row, 0).toString();
                displayData(Sistema.getInstance().getAnimal(id));
            }
        });
        FillTable();

        TablaMasc.getColumnModel().getColumn(0).setMaxWidth(55);
        TablaMasc.getColumnModel().getColumn(0).setMinWidth(55);
        TablaMasc.getColumnModel().getColumn(1).setPreferredWidth(100);
        TablaMasc.getColumnModel().getColumn(1).setMinWidth(100);
        TablaMasc.getColumnModel().getColumn(2).setMaxWidth(75);
        TablaMasc.getColumnModel().getColumn(2).setMinWidth(75);

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
            for (Animal a : sistema.getAnimales()) {
                boolean idMatches = a.getId().toLowerCase().contains(s);
                boolean nombreMatches = a.getNombre().toLowerCase().contains(s);
                boolean tipoMatches = a.getTipo().toLowerCase().contains(s);
                boolean estadoMatches = a.getEstado().toString().toLowerCase().contains(s);
                if (idMatches || nombreMatches || tipoMatches || estadoMatches) {
                    animales = new Object[]{
                        a.getId(), a.getNombre(), a.getTipo()
                    };
                    tableModel.insertRow(tableModel.getRowCount(), animales);
                }
            }
        }
    }

    private void FillTable() {
        tableModel.setNumRows(0);
        for (Animal a : sistema.getAnimales()) {
            animales = new Object[]{
                a.getId(), a.getNombre(), a.getTipo()
            };
            tableModel.insertRow(tableModel.getRowCount(), animales);
        }
    }

    private void displayData(Animal a) {
        na.animalSeleccionado = a;
        if (a != null && a.getFoto() != null) {
            LblFoto.UpdatePhoto(a.getFoto(), 226, 166);
        } else {
            LblFoto.UpdatePhoto(new ImageIcon(getClass().getResource("/interfaz/Resources/icons8-dog-paw-100.png")), 226, 166);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMasc = new javax.swing.JTable();
        PanelImagen = new javax.swing.JPanel();
        TxtSearch = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(250, 550));
        setPreferredSize(new java.awt.Dimension(250, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Selecciona una mascota:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Buscar:");

        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 100));

        TablaMasc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TablaMasc.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaMasc.setFocusable(false);
        TablaMasc.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        TablaMasc.setMinimumSize(new java.awt.Dimension(0, 0));
        TablaMasc.setRowHeight(20);
        TablaMasc.setSelectionBackground(new java.awt.Color(28, 62, 122));
        TablaMasc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(TablaMasc);
        if (TablaMasc.getColumnModel().getColumnCount() > 0) {
            TablaMasc.getColumnModel().getColumn(0).setResizable(false);
            TablaMasc.getColumnModel().getColumn(1).setResizable(false);
            TablaMasc.getColumnModel().getColumn(2).setResizable(false);
        }

        PanelImagen.setMaximumSize(new java.awt.Dimension(226, 166));
        PanelImagen.setMinimumSize(new java.awt.Dimension(226, 166));
        PanelImagen.setPreferredSize(new java.awt.Dimension(226, 166));

        javax.swing.GroupLayout PanelImagenLayout = new javax.swing.GroupLayout(PanelImagen);
        PanelImagen.setLayout(PanelImagenLayout);
        PanelImagenLayout.setHorizontalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );
        PanelImagenLayout.setVerticalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(12, Short.MAX_VALUE)
                                .addComponent(PanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelImagen;
    private javax.swing.JTable TablaMasc;
    private javax.swing.JTextField TxtSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
