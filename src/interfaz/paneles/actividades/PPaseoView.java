package interfaz.paneles.actividades;

import dominio.modelo.Actividad;
import dominio.modelo.actividades.Paseo;
import interfaz.MainWindow;
import interfaz.paneles.helpers.Foto;
import java.awt.FlowLayout;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;

public class PPaseoView extends javax.swing.JPanel {

    Foto LblFoto;
    MainWindow mw;
    Paseo actividad;

    public PPaseoView(MainWindow mw, Actividad a) {
        this.mw = mw;
        initComponents();
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        actividad = (Paseo) a;

        LblFoto = new Foto(new ImageIcon(getClass().getResource("/interfaz/Resources/map.png")), 226, 166);
        PanelImagen.setLayout(new FlowLayout());
        PanelImagen.add(LblFoto);

        if (actividad != null && actividad.getRuta() != null) {
            LblFoto.UpdatePhoto(actividad.getRuta(), 226, 166);
        } else {
            LblFoto.UpdatePhoto(new ImageIcon(getClass().getResource("/interfaz/Resources/map.png")), 226, 166);
        }

        if (actividad != null) {
            TxtNombre.setText(actividad.getNombre());
            TxtFecha.setText(actividad.getFechaHora().format(formatDateTime));
            TxtDuracion.setText(String.valueOf(actividad.getDuracion()));
            TxtMascota.setText(actividad.getMascota().toString());
            TxtResponsable.setText(actividad.getUsuario().toString());
            TxtDistancia.setText(String.valueOf(actividad.getDistancia()));
        }
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
        TxtDistancia = new javax.swing.JTextField();
        BtnVerMascota = new rojeru_san.complementos.ButtonHover();
        BtnVerResponsable = new rojeru_san.complementos.ButtonHover();
        jLabel8 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtFecha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PanelImagen = new javax.swing.JPanel();

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
        jLabel7.setText("Distancia:");

        TxtMascota.setEditable(false);
        TxtMascota.setBackground(new java.awt.Color(248, 248, 248));
        TxtMascota.setFocusable(false);

        TxtResponsable.setEditable(false);
        TxtResponsable.setBackground(new java.awt.Color(248, 248, 248));
        TxtResponsable.setFocusable(false);
        TxtResponsable.setMinimumSize(new java.awt.Dimension(60, 20));

        TxtDuracion.setEditable(false);
        TxtDuracion.setBackground(new java.awt.Color(248, 248, 248));
        TxtDuracion.setFocusable(false);
        TxtDuracion.setMinimumSize(new java.awt.Dimension(60, 20));

        TxtDistancia.setEditable(false);
        TxtDistancia.setBackground(new java.awt.Color(248, 248, 248));
        TxtDistancia.setFocusable(false);

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

        jLabel9.setText("(metros)");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Ruta:");

        PanelImagen.setMaximumSize(new java.awt.Dimension(236, 176));
        PanelImagen.setMinimumSize(new java.awt.Dimension(236, 176));

        javax.swing.GroupLayout PanelImagenLayout = new javax.swing.GroupLayout(PanelImagen);
        PanelImagen.setLayout(PanelImagenLayout);
        PanelImagenLayout.setHorizontalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
        );
        PanelImagenLayout.setVerticalGroup(
            PanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnVerMascota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnVerResponsable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(85, 85, 85)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(TxtDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(BtnVerMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel10)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(TxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BtnVerResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(TxtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnVerMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerMascotaActionPerformed
        mw.MostrarAnimal(actividad.getMascota());
    }//GEN-LAST:event_BtnVerMascotaActionPerformed

    private void BtnVerResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerResponsableActionPerformed
        mw.MostrarResponsable(actividad.getUsuario());
    }//GEN-LAST:event_BtnVerResponsableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.ButtonHover BtnVerMascota;
    private rojeru_san.complementos.ButtonHover BtnVerResponsable;
    private javax.swing.JPanel PanelImagen;
    private javax.swing.JTextField TxtDistancia;
    private javax.swing.JTextField TxtDuracion;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtMascota;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtResponsable;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
