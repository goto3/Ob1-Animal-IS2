package interfaz.paneles;

import dominio.Sistema;
import dominio.modelo.Actividad;
import interfaz.MainWindow;
import interfaz.paneles.actividades.PAlimentacionView;
import interfaz.paneles.actividades.POtrasView;
import interfaz.paneles.actividades.PPaseoView;
import interfaz.paneles.actividades.PVisitaVetView;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class Calendario extends javax.swing.JPanel {

    Sistema sistema = Sistema.getInstance();
    MainWindow mw;
    public DefaultTableModel tableModel;
    Object[] actividades;
    DateTimeFormatter formatDateTime;
    DateTimeFormatter formatDate;

    public Calendario(MainWindow mw) {
        this.mw = mw;
        formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        initComponents();

        tableModel = (DefaultTableModel) TableActividades.getModel();
        TableActividades.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (tableModel.getRowCount() > 0) {
                int row = TableActividades.getSelectedRow();
                displayData((Actividad) tableModel.getValueAt(row, 5));
            }
        });
        FillTable();

        TableActividades.getColumnModel().getColumn(0).setMaxWidth(115);
        TableActividades.getColumnModel().getColumn(0).setMinWidth(115);
        TableActividades.getColumnModel().getColumn(1).setPreferredWidth(90);
        TableActividades.getColumnModel().getColumn(1).setMinWidth(90);
        TableActividades.getColumnModel().getColumn(2).setPreferredWidth(90);
        TableActividades.getColumnModel().getColumn(2).setMinWidth(90);
        TableActividades.getColumnModel().getColumn(4).setMaxWidth(60);
        TableActividades.getColumnModel().getColumn(4).setMinWidth(60);
        TableActividades.removeColumn(TableActividades.getColumnModel().getColumn(5));
    }

    public void FillTable() {
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        String tipoActividad = ComTipoActividad.getSelectedItem().toString();
        LocalDate selDate = LocalDate.now();
        if (RSCalender.getFechaSeleccionada() != null) {
            System.out.println(RSCalender.getFechaSeleccionada());
            selDate = LocalDate.parse(RSCalender.getFechaSeleccionada(), formatDate);
        }
        for (Actividad a : sistema.getActividades()) {
            LocalDate ld = a.getFechaHora().toLocalDate();
            boolean enFecha = ld.equals(selDate);
            switch (tipoActividad) {
                case ("Alimentación"):
                    if (enFecha && a.getClass().getSimpleName().equals("Alimentacion")) {
                        actividades = new Object[]{
                            a.getFechaHora().format(formatDateTime), a.getNombre(), a.getMascota(), a.getUsuario(), a.getDuracion(), a
                        };
                        tableModel.insertRow(tableModel.getRowCount(), actividades);
                    }
                    break;
                case ("Otras"):
                    if (enFecha && a.getClass().getSimpleName().equals("OtraActividad")) {
                        actividades = new Object[]{
                            a.getFechaHora().format(formatDateTime), a.getNombre(), a.getMascota(), a.getUsuario(), a.getDuracion(), a
                        };
                        tableModel.insertRow(tableModel.getRowCount(), actividades);
                    }
                    break;
                case ("Visita a veterinaria"):
                    if (enFecha && a.getClass().getSimpleName().equals("VisitaVeterinaria")) {
                        actividades = new Object[]{
                            a.getFechaHora().format(formatDateTime), a.getNombre(), a.getMascota(), a.getUsuario(), a.getDuracion(), a
                        };
                        tableModel.insertRow(tableModel.getRowCount(), actividades);
                    }
                    break;
                case ("Paseo"):
                    if (enFecha && a.getClass().getSimpleName().equals("Paseo")) {
                        actividades = new Object[]{
                            a.getFechaHora().format(formatDateTime), a.getNombre(), a.getMascota(), a.getUsuario(), a.getDuracion(), a
                        };
                        tableModel.insertRow(tableModel.getRowCount(), actividades);
                    }
                    break;
            }
        }
    }

    private void displayData(Actividad a) {
        PanelView.removeAll();
        switch (a.getClass().getSimpleName()) {
            case ("Alimentacion"):
                PAlimentacionView pav = new PAlimentacionView(mw, a);
                PanelView.setLayout(new BorderLayout());
                PanelView.add(pav, BorderLayout.CENTER);
                break;
            case ("OtraActividad"):
                POtrasView pov = new POtrasView();
                PanelView.setLayout(new BorderLayout());
                PanelView.add(pov, BorderLayout.CENTER);
                break;
            case ("Paseo"):
                PPaseoView ppv = new PPaseoView();
                PanelView.setLayout(new BorderLayout());
                PanelView.add(ppv, BorderLayout.CENTER);
                break;
            case ("VisitaVeterinaria"):
                PVisitaVetView pvv = new PVisitaVetView();
                PanelView.setLayout(new BorderLayout());
                PanelView.add(pvv, BorderLayout.CENTER);
                break;
        }
        PanelView.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RSCalender = new rojeru_san.componentes.RSCalendar();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableActividades = new javax.swing.JTable();
        ComTipoActividad = new javax.swing.JComboBox<>();
        buttonHover1 = new rojeru_san.complementos.ButtonHover();
        PanelView = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        RSCalender.setForeground(new java.awt.Color(255, 255, 255));
        RSCalender.setAltoFilas(40);
        RSCalender.setColorBackground(new java.awt.Color(31, 67, 135));
        RSCalender.setColorButtonHover(new java.awt.Color(43, 94, 188));
        RSCalender.setColorDiaActual(new java.awt.Color(217, 217, 217));
        RSCalender.setColorTextDiaActual(new java.awt.Color(24, 24, 24));
        RSCalender.setFgText(new java.awt.Color(50, 50, 50));
        RSCalender.setFormatoFecha("dd/MM/yyyy");
        RSCalender.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        RSCalender.setMinimumSize(new java.awt.Dimension(275, 130));
        RSCalender.setOpaque(false);
        RSCalender.setPreferredSize(new java.awt.Dimension(380, 456));
        RSCalender.setTextMayusculas(false);
        RSCalender.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                RSCalenderFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                RSCalenderFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Calendario");

        TableActividades.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TableActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Nombre", "Mascota", "Responsable", "Duración", "Object"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableActividades.setFocusable(false);
        TableActividades.setRowHeight(20);
        TableActividades.setSelectionBackground(new java.awt.Color(28, 62, 122));
        TableActividades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TableActividades.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TableActividades);
        if (TableActividades.getColumnModel().getColumnCount() > 0) {
            TableActividades.getColumnModel().getColumn(0).setResizable(false);
            TableActividades.getColumnModel().getColumn(4).setResizable(false);
            TableActividades.getColumnModel().getColumn(5).setResizable(false);
        }

        ComTipoActividad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ComTipoActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alimentación", "Paseo", "Visita a veterinaria", "Otras" }));
        ComTipoActividad.setFocusable(false);
        ComTipoActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComTipoActividadActionPerformed(evt);
            }
        });

        buttonHover1.setBackground(new java.awt.Color(28, 62, 122));
        buttonHover1.setText("Nueva actividad");
        buttonHover1.setColorHover(new java.awt.Color(36, 80, 160));
        buttonHover1.setFocusable(false);
        buttonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHover1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelViewLayout = new javax.swing.GroupLayout(PanelView);
        PanelView.setLayout(PanelViewLayout);
        PanelViewLayout.setHorizontalGroup(
            PanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        PanelViewLayout.setVerticalGroup(
            PanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(RSCalender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ComTipoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComTipoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(RSCalender, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHover1ActionPerformed
        NuevaActividad pNewAct = new NuevaActividad(this, null);
        pNewAct.setTipoAct(ComTipoActividad.getSelectedItem(), RSCalender.getFechaSeleccionada());
        pNewAct.setVisible(true);
    }//GEN-LAST:event_buttonHover1ActionPerformed

    private void ComTipoActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComTipoActividadActionPerformed
        FillTable();
    }//GEN-LAST:event_ComTipoActividadActionPerformed

    private void RSCalenderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RSCalenderFocusGained
        System.out.println("Focus gained");
    }//GEN-LAST:event_RSCalenderFocusGained

    private void RSCalenderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RSCalenderFocusLost
        System.out.println("Focus lost");
    }//GEN-LAST:event_RSCalenderFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComTipoActividad;
    private javax.swing.JPanel PanelView;
    private rojeru_san.componentes.RSCalendar RSCalender;
    public javax.swing.JTable TableActividades;
    private rojeru_san.complementos.ButtonHover buttonHover1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
