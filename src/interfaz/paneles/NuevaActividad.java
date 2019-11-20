package interfaz.paneles;

import dominio.Sistema;
import dominio.modelo.Actividad;
import dominio.modelo.Animal;
import dominio.modelo.personas.Responsable;
import interfaz.paneles.actividades.PAlimentacion;
import interfaz.paneles.actividades.POtras;
import interfaz.paneles.actividades.PPaseo;
import interfaz.paneles.actividades.PVisitaVet;
import interfaz.paneles.helpers.SeleccionMascota;
import interfaz.paneles.helpers.SeleccionResponsable;
import java.awt.BorderLayout;
import java.awt.Color;
import static javax.swing.JOptionPane.showMessageDialog;

public class NuevaActividad extends javax.swing.JFrame {

    Sistema sistema = Sistema.getInstance();
    static Calendario cal;
    String tipoActividad;
    public Animal animalSeleccionado;
    public Responsable responsableSeleccionado;
    static String dateActividad;

    public NuevaActividad(Calendario cal, String date) {
        dateActividad = date;
        this.cal = cal;
        initComponents();

        PAlimentacion pal = new PAlimentacion(this, dateActividad);
        PanelCampos.setLayout(new BorderLayout());
        PanelCampos.add(pal, BorderLayout.CENTER);

        SeleccionMascota psm = new SeleccionMascota(this);
        PanelMascota.setLayout(new BorderLayout());
        PanelMascota.add(psm, BorderLayout.CENTER);

        SeleccionResponsable psr = new SeleccionResponsable(this);
        PanelResponsable.setLayout(new BorderLayout());
        PanelResponsable.add(psr, BorderLayout.CENTER);
        
        getContentPane().setBackground(Color.WHITE);
    }

    public void setTipoAct(Object tipo, String date) {
        dateActividad = date;
        this.ComTipoAct.setSelectedItem(tipo);
    }

    public void guardarActividad(Actividad a) {
        if (animalSeleccionado == null) {
            showMessageDialog(null, "Debe seleccionar una mascota.");
        } else if (responsableSeleccionado == null) {
            showMessageDialog(null, "Debe seleccionar un responsable.");
        } else {
            a.setMascota(animalSeleccionado);
            a.setUsuario(responsableSeleccionado);
            sistema.addActividad(a);
            limpiarCampos();
            cal.FillTable();
            cal.TableActividades.setRowSelectionInterval(cal.TableActividades.getRowCount() - 1, cal.TableActividades.getRowCount() - 1);
            dispose();
        }
    }

    public void limpiarCampos() {
        ComTipoAct.setSelectedIndex(0);
        animalSeleccionado = null;
        responsableSeleccionado = null;

        PanelMascota.removeAll();
        SeleccionMascota psm = new SeleccionMascota(this);
        PanelMascota.setLayout(new BorderLayout());
        PanelMascota.add(psm, BorderLayout.CENTER);

        PanelResponsable.removeAll();
        SeleccionResponsable psr = new SeleccionResponsable(this);
        PanelResponsable.setLayout(new BorderLayout());
        PanelResponsable.add(psr, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ComTipoAct = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        PanelCampos = new javax.swing.JPanel();
        PanelMascota = new javax.swing.JPanel();
        PanelResponsable = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar actividad");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1024, 600));
        setPreferredSize(new java.awt.Dimension(1024, 600));

        ComTipoAct.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ComTipoAct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alimentación", "Paseo", "Visita a veterinaria", "Otras" }));
        ComTipoAct.setFocusable(false);
        ComTipoAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComTipoActActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Nueva Actividad");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        PanelCampos.setBackground(new java.awt.Color(245, 245, 245));
        PanelCampos.setMaximumSize(new java.awt.Dimension(320, 32767));
        PanelCampos.setMinimumSize(new java.awt.Dimension(320, 100));
        PanelCampos.setPreferredSize(new java.awt.Dimension(320, 495));

        javax.swing.GroupLayout PanelCamposLayout = new javax.swing.GroupLayout(PanelCampos);
        PanelCampos.setLayout(PanelCamposLayout);
        PanelCamposLayout.setHorizontalGroup(
            PanelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        PanelCamposLayout.setVerticalGroup(
            PanelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PanelMascota.setBackground(new java.awt.Color(245, 245, 245));
        PanelMascota.setMinimumSize(new java.awt.Dimension(250, 0));
        PanelMascota.setPreferredSize(new java.awt.Dimension(250, 495));

        javax.swing.GroupLayout PanelMascotaLayout = new javax.swing.GroupLayout(PanelMascota);
        PanelMascota.setLayout(PanelMascotaLayout);
        PanelMascotaLayout.setHorizontalGroup(
            PanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        PanelMascotaLayout.setVerticalGroup(
            PanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PanelResponsable.setBackground(new java.awt.Color(245, 245, 245));
        PanelResponsable.setMinimumSize(new java.awt.Dimension(250, 0));
        PanelResponsable.setPreferredSize(new java.awt.Dimension(250, 495));

        javax.swing.GroupLayout PanelResponsableLayout = new javax.swing.GroupLayout(PanelResponsable);
        PanelResponsable.setLayout(PanelResponsableLayout);
        PanelResponsableLayout.setHorizontalGroup(
            PanelResponsableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        PanelResponsableLayout.setVerticalGroup(
            PanelResponsableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelMascota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(PanelResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ComTipoAct, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComTipoAct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(PanelMascota, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(PanelCampos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ComTipoActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComTipoActActionPerformed
        tipoActividad = ComTipoAct.getSelectedItem().toString();
        PanelCampos.removeAll();
        switch (tipoActividad) {
            case ("Alimentación"):
                PAlimentacion pal = new PAlimentacion(this, dateActividad);
                PanelCampos.setLayout(new BorderLayout());
                PanelCampos.add(pal, BorderLayout.CENTER);
                break;
            case ("Otras"):
                POtras pot = new POtras(this, dateActividad);
                PanelCampos.setLayout(new BorderLayout());
                PanelCampos.add(pot, BorderLayout.CENTER);
                break;
            case ("Visita a veterinaria"):
                PVisitaVet pvv = new PVisitaVet(this, dateActividad);
                PanelCampos.setLayout(new BorderLayout());
                PanelCampos.add(pvv, BorderLayout.CENTER);
                break;
            case ("Paseo"):
                PPaseo ppas = new PPaseo(this, dateActividad);
                PanelCampos.setLayout(new BorderLayout());
                PanelCampos.add(ppas, BorderLayout.CENTER);
                break;
        }
        PanelCampos.revalidate();
    }//GEN-LAST:event_ComTipoActActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComTipoAct;
    private javax.swing.JPanel PanelCampos;
    private javax.swing.JPanel PanelMascota;
    private javax.swing.JPanel PanelResponsable;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
