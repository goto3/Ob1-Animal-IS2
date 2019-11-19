package interfaz.paneles.personas;

import dominio.modelo.Persona;
import dominio.modelo.personas.Padrino;
import interfaz.paneles.Personas;

public class PPadrino extends javax.swing.JPanel {

    private Padrino p;
    private Personas panelPersonas;
    
    public PPadrino(Personas pPersonas, Persona pers) {
        panelPersonas = pPersonas;
        p = (Padrino) pers;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(300, 30000));
        setMinimumSize(new java.awt.Dimension(300, 300));

        jButton1.setText("Padrino");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 231, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 577, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
