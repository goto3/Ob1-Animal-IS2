package interfaz.paneles.helpers;

import dominio.Sistema;
import dominio.modelo.Animal;
import interfaz.paneles.NuevaActividad;
import interfaz.paneles.personas.PAdoptante;
import interfaz.paneles.personas.PPadrino;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class SeleccionMultipleMascotas extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    NuevaActividad na;
    Sistema sistema = Sistema.getInstance();
    Foto LblFoto;
    PPadrino pp;
    List<Object[]> mascotas = new ArrayList<>();
    List<Animal> mascotasS = new ArrayList<>();
    List<String> mascotasSeleccionadas = new ArrayList<>();

    public SeleccionMultipleMascotas(List<Animal> m, PPadrino pp) {
        this.pp = pp;
        mascotasS = m;
        initComponents();

        tableModel = (DefaultTableModel) TablaMasc.getModel();
        FillTable();

        TablaMasc.getColumnModel().getColumn(0).setMaxWidth(30);
        TablaMasc.getColumnModel().getColumn(0).setMinWidth(30);
        TablaMasc.getColumnModel().getColumn(1).setMaxWidth(55);
        TablaMasc.getColumnModel().getColumn(1).setMinWidth(55);
        TablaMasc.getColumnModel().getColumn(2).setPreferredWidth(100);
        TablaMasc.getColumnModel().getColumn(2).setMinWidth(100);
        TablaMasc.getColumnModel().getColumn(3).setMaxWidth(75);
        TablaMasc.getColumnModel().getColumn(3).setMinWidth(75);

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
            tableModel.getDataVector().removeAllElements();
            tableModel.fireTableDataChanged();
            for (int i = 0; i < mascotas.size(); i++) {
                tableModel.insertRow(tableModel.getRowCount(), mascotas.get(i));
            }
        } else {
            List<Object[]> busqueda = new ArrayList<>();
            for (int mas = 0; mas < mascotas.size(); mas++) {
                for (int col = 1; col < 3; col++) {
                    boolean matches = mascotas.get(mas)[col].toString().toLowerCase().contains(s);
                    if (matches) {
                        busqueda.add(mascotas.get(mas));
                        break;
                    }
                }
            }
            tableModel.getDataVector().removeAllElements();
            tableModel.fireTableDataChanged();
            for (Object[] o : busqueda) {
                tableModel.insertRow(tableModel.getRowCount(), o);
            }
        }
    }

    private void FillTable() {
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        mascotas = new ArrayList<>();
        for (Animal a : sistema.getAnimales()) {
            Object[] animal = new Object[]{
                mascotasS.contains(a), a.getId(), a.getNombre(), a.getTipo()
            };
            mascotas.add(animal);
            tableModel.insertRow(tableModel.getRowCount(), animal);
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMasc = new javax.swing.JTable();
        TxtSearch = new javax.swing.JTextField();
        BtnGuardar1 = new rojeru_san.complementos.ButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selección de mascotas");
        setMaximumSize(new java.awt.Dimension(400, 500));
        setMinimumSize(new java.awt.Dimension(400, 500));
        setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Selecciona algunas mascotas:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Buscar:");

        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 200));

        TablaMasc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TablaMasc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Nombre", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaMasc.setFocusable(false);
        TablaMasc.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        TablaMasc.setMinimumSize(new java.awt.Dimension(0, 0));
        TablaMasc.setRowHeight(20);
        TablaMasc.setSelectionBackground(new java.awt.Color(255, 255, 255));
        TablaMasc.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TablaMasc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablaMasc.getTableHeader().setReorderingAllowed(false);
        TablaMasc.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TablaMascPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(TablaMasc);
        if (TablaMasc.getColumnModel().getColumnCount() > 0) {
            TablaMasc.getColumnModel().getColumn(0).setResizable(false);
        }

        BtnGuardar1.setBackground(new java.awt.Color(28, 62, 122));
        BtnGuardar1.setText("Guardar");
        BtnGuardar1.setColorHover(new java.awt.Color(36, 80, 160));
        BtnGuardar1.setFocusable(false);
        BtnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(188, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardar1ActionPerformed
        pp.setMascotas(mascotasSeleccionadas);
        this.dispose();
    }//GEN-LAST:event_BtnGuardar1ActionPerformed

    private void TablaMascPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TablaMascPropertyChange
        mascotasSeleccionadas = new ArrayList<>();
        for (int row = 0; row < TablaMasc.getRowCount(); row++) {
            if ((boolean) TablaMasc.getValueAt(row, 0)) {
                mascotasSeleccionadas.add((String) TablaMasc.getValueAt(row, 1));
            }
        }
    }//GEN-LAST:event_TablaMascPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.ButtonHover BtnGuardar1;
    private javax.swing.JTable TablaMasc;
    private javax.swing.JTextField TxtSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
