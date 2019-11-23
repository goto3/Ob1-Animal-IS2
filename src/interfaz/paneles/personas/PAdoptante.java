package interfaz.paneles.personas;

import dominio.Sistema;
import dominio.modelo.Animal;
import dominio.modelo.Persona;
import dominio.modelo.personas.Adoptante;
import dominio.tools.EstadoAnimal;
import interfaz.paneles.Personas;
import interfaz.paneles.helpers.SeleccionMultipleMascotasEnAdopcion;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

public class PAdoptante extends javax.swing.JPanel {

    private Adoptante a;
    private Personas panelPersonas;
    private boolean newPersona;
    Sistema sistema = Sistema.getInstance();
    List<Animal> mascotas = new ArrayList<>();

    public PAdoptante(Personas pPersonas, Persona p) {
        if (p == null) {
            a = new Adoptante("", "", "", "");
            newPersona = true;
        } else {
            a = (Adoptante) p;
        }
        panelPersonas = pPersonas;

        initComponents();

        TxtNombre.setText(a.getNombre());
        TxtApellido.setText(a.getApellido());
        TxtEmail.setText(a.getEmail());
        TxtTelefono.setText(a.getTelefono());
    }

    public void setMascotas(List<String> lm) {
        for (String s : lm) {
            mascotas.add(sistema.getAnimal(s));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        BtnGuardar1 = new rojeru_san.complementos.ButtonHover();
        BtnSeleccionMascotas = new rojeru_san.complementos.ButtonHover();

        setMaximumSize(new java.awt.Dimension(300, 32767));
        setMinimumSize(new java.awt.Dimension(300, 0));
        setPreferredSize(new java.awt.Dimension(300, 600));

        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Adoptante");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel6.setText("Teléfono:");

        BtnGuardar1.setBackground(new java.awt.Color(28, 62, 122));
        BtnGuardar1.setText("Guardar");
        BtnGuardar1.setColorHover(new java.awt.Color(36, 80, 160));
        BtnGuardar1.setFocusable(false);
        BtnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardar1ActionPerformed(evt);
            }
        });

        BtnSeleccionMascotas.setBackground(new java.awt.Color(28, 62, 122));
        BtnSeleccionMascotas.setText("Mascotas adoptadas");
        BtnSeleccionMascotas.setColorHover(new java.awt.Color(36, 80, 160));
        BtnSeleccionMascotas.setFocusable(false);
        BtnSeleccionMascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeleccionMascotasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnGuardar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnSeleccionMascotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addComponent(BtnSeleccionMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                .addComponent(BtnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardar1ActionPerformed
        a.setNombre(TxtNombre.getText());
        a.setApellido(TxtApellido.getText());
        a.setEmail(TxtEmail.getText());
        a.setTelefono(TxtTelefono.getText());
        a.setAnimales(mascotas);
        for (Animal a : mascotas){
            a.setEstado(EstadoAnimal.ADOPTADO);
        }
        if (newPersona) {
            newPersona = false;
            panelPersonas.addPersona(a);
        } else {
            panelPersonas.editPersona(a);
        }
        showMessageDialog(null, "Cambios guardados exitosamente.");
    }//GEN-LAST:event_BtnGuardar1ActionPerformed

    private void BtnSeleccionMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeleccionMascotasActionPerformed
        SeleccionMultipleMascotasEnAdopcion pSMM = new SeleccionMultipleMascotasEnAdopcion(a.getAnimales(), this);
        pSMM.setVisible(true);
    }//GEN-LAST:event_BtnSeleccionMascotasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.ButtonHover BtnGuardar1;
    private rojeru_san.complementos.ButtonHover BtnSeleccionMascotas;
    private javax.swing.JTextField TxtApellido;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

}
