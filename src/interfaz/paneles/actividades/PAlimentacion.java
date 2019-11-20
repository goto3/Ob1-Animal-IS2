package interfaz.paneles.actividades;

import dominio.modelo.actividades.Alimentacion;
import interfaz.paneles.NuevaActividad;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import static javax.swing.JOptionPane.showMessageDialog;

public class PAlimentacion extends javax.swing.JPanel {

    NuevaActividad na;

    public PAlimentacion(NuevaActividad na, String date) {
        this.na = na;
        initComponents();       
        
        try {
            TxtFecha.setDatoFecha(new SimpleDateFormat("dd/MM/yyyy").parse(date));
        } catch (Exception ex) {
            TxtFecha.setDatoFecha(new Date());
        }
        TxtHora.setText("00:00");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtFecha = new rojeru_san.componentes.RSDateChooser();
        TxtDuracion = new javax.swing.JTextField();
        TxtAlimento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtHora = new javax.swing.JTextField();
        buttonHover1 = new rojeru_san.complementos.ButtonHover();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Fecha:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Duración:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Alimento:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nombre:");

        TxtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TxtFecha.setColorBackground(new java.awt.Color(0, 0, 0));
        TxtFecha.setColorButtonHover(new java.awt.Color(102, 102, 102));
        TxtFecha.setColorDiaActual(new java.awt.Color(204, 204, 204));
        TxtFecha.setColorForeground(new java.awt.Color(0, 0, 0));
        TxtFecha.setFgText(new java.awt.Color(102, 102, 102));
        TxtFecha.setFormatoFecha("dd/MM/yyyy");

        TxtDuracion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDuracionKeyTyped(evt);
            }
        });

        TxtAlimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Hora:");

        TxtHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TxtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        buttonHover1.setBackground(new java.awt.Color(28, 62, 122));
        buttonHover1.setText("Guardar");
        buttonHover1.setColorHover(new java.awt.Color(36, 80, 160));
        buttonHover1.setFocusable(false);
        buttonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHover1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("(HH:MM)");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("(Minutos)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(TxtNombre)
                    .addComponent(TxtAlimento)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtDuracion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtHora))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonHover1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(buttonHover1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHover1ActionPerformed
        int duracion = 0;
        try {
            duracion = Integer.parseInt(TxtDuracion.getText());
        } catch (NumberFormatException ex) {
        }
        try {
            Date date = TxtFecha.getDatoFecha();
            LocalDate ld = new java.sql.Date(date.getTime()).toLocalDate();
            LocalDateTime ldt = LocalDateTime.of(ld, LocalTime.parse(TxtHora.getText()));
            Alimentacion a = new Alimentacion(TxtNombre.getText(), null, null, ldt, duracion, TxtAlimento.getText());
            na.guardarActividad(a);
        } catch (Exception ex) {
            showMessageDialog(null, "Debe ingresar una fecha y hora válida.");
        }
    }//GEN-LAST:event_buttonHover1ActionPerformed

    private void TxtDuracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDuracionKeyTyped
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
                || (vChar == evt.VK_BACK_SPACE)
                || (vChar == evt.VK_DELETE))
                || TxtDuracion.getText().length() > 8) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtDuracionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtAlimento;
    private javax.swing.JTextField TxtDuracion;
    private rojeru_san.componentes.RSDateChooser TxtFecha;
    private javax.swing.JTextField TxtHora;
    private javax.swing.JTextField TxtNombre;
    private rojeru_san.complementos.ButtonHover buttonHover1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
