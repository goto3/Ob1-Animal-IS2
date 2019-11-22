package interfaz.paneles.actividades;

import dominio.modelo.Actividad;
import dominio.modelo.actividades.Alimentacion;
import interfaz.MainWindow;
import java.time.format.DateTimeFormatter;

public class PAlimentacionView extends javax.swing.JPanel {

    MainWindow mw;
    Alimentacion actividad;

    public PAlimentacionView(MainWindow mw, Actividad a) {
        this.mw = mw;
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        initComponents();

        actividad = (Alimentacion) a;
        TxtNombre.setText(actividad.getNombre());
        TxtFecha.setText(actividad.getFechaHora().format(formatDateTime));
        TxtDuracion.setText(String.valueOf(actividad.getDuracion()));
        TxtMascota.setText(actividad.getMascota().toString());
        TxtResponsable.setText(actividad.getUsuario().toString());
        TxtTipoAl.setText(actividad.getTipoAlimento());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtMascota = new javax.swing.JTextField();
        TxtResponsable = new javax.swing.JTextField();
        TxtDuracion = new javax.swing.JTextField();
        TxtTipoAl = new javax.swing.JTextField();
        BtnVerMascota = new rojeru_san.complementos.ButtonHover();
        BtnVerResponsable = new rojeru_san.complementos.ButtonHover();
        jLabel8 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtFecha = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(900, 0));
        setPreferredSize(new java.awt.Dimension(900, 213));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Mascota:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Responsable:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Fecha:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Duración:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Tipo de alimento:");

        TxtMascota.setEditable(false);
        TxtMascota.setBackground(new java.awt.Color(248, 248, 248));
        TxtMascota.setFocusable(false);
        TxtMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMascotaActionPerformed(evt);
            }
        });

        TxtResponsable.setEditable(false);
        TxtResponsable.setBackground(new java.awt.Color(248, 248, 248));
        TxtResponsable.setFocusable(false);
        TxtResponsable.setMinimumSize(new java.awt.Dimension(60, 20));

        TxtDuracion.setEditable(false);
        TxtDuracion.setBackground(new java.awt.Color(248, 248, 248));
        TxtDuracion.setFocusable(false);
        TxtDuracion.setMinimumSize(new java.awt.Dimension(60, 20));

        TxtTipoAl.setEditable(false);
        TxtTipoAl.setBackground(new java.awt.Color(248, 248, 248));
        TxtTipoAl.setFocusable(false);

        BtnVerMascota.setBackground(new java.awt.Color(28, 62, 122));
        BtnVerMascota.setText("Ver");
        BtnVerMascota.setColorHover(new java.awt.Color(36, 80, 160));
        BtnVerMascota.setFocusable(false);
        BtnVerMascota.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnVerMascota.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnVerMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVerMascotaActionPerformed(evt);
            }
        });

        BtnVerResponsable.setBackground(new java.awt.Color(28, 62, 122));
        BtnVerResponsable.setText("Ver");
        BtnVerResponsable.setColorHover(new java.awt.Color(36, 80, 160));
        BtnVerResponsable.setFocusable(false);
        BtnVerResponsable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnVerResponsable.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnVerResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVerResponsableActionPerformed(evt);
            }
        });

        jLabel8.setText("(minutos)");

        TxtNombre.setEditable(false);
        TxtNombre.setBackground(new java.awt.Color(248, 248, 248));
        TxtNombre.setFocusable(false);
        TxtNombre.setMinimumSize(new java.awt.Dimension(60, 20));

        TxtFecha.setEditable(false);
        TxtFecha.setBackground(new java.awt.Color(248, 248, 248));
        TxtFecha.setFocusable(false);
        TxtFecha.setMinimumSize(new java.awt.Dimension(60, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnVerMascota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnVerResponsable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtTipoAl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnVerMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(TxtTipoAl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnVerResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnVerMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerMascotaActionPerformed
        mw.MostrarAnimal(actividad.getMascota());
    }//GEN-LAST:event_BtnVerMascotaActionPerformed

    private void TxtMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtMascotaActionPerformed

    private void BtnVerResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerResponsableActionPerformed
        mw.MostrarResponsable(actividad.getUsuario());
    }//GEN-LAST:event_BtnVerResponsableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.ButtonHover BtnVerMascota;
    private rojeru_san.complementos.ButtonHover BtnVerResponsable;
    private javax.swing.JTextField TxtDuracion;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtMascota;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtResponsable;
    private javax.swing.JTextField TxtTipoAl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
