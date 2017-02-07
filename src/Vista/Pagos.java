/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Alumno;
import Controlador.Clases;
import Modelo.Control_Alumnos;

/**
 *
 * @author Uknown
 */
public class Pagos extends javax.swing.JFrame {

    /**
     * Creates new form Pagos
     */
    public Pagos() {
        initComponents();
        jLblFechaPago.setVisible(false);
        jLblNombre.setVisible(false);
        jLblPago.setVisible(false);
        jTxtPago.setVisible(false);
        jButtonPago.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jTxtIdAlumno = new javax.swing.JTextField();
        jLblNombre = new javax.swing.JLabel();
        jLblFechaPago = new javax.swing.JLabel();
        jLblPago = new javax.swing.JLabel();
        jTxtPago = new javax.swing.JTextField();
        jButtonPago = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PAGOS DE ACADEMIAS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID ALUMNO:");

        jTxtIdAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIdAlumnoActionPerformed(evt);
            }
        });

        jLblNombre.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLblNombre.setForeground(new java.awt.Color(204, 0, 0));

        jLblFechaPago.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLblFechaPago.setForeground(new java.awt.Color(204, 0, 0));

        jLblPago.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLblPago.setForeground(new java.awt.Color(204, 0, 0));
        jLblPago.setText("Cantidad a Pagar:");

        jTxtPago.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButtonPago.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonPago.setText("Registrar Pago");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblFechaPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLblPago)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jButtonPago, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblPago, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonPago)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtIdAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIdAlumnoActionPerformed
        Control_Alumnos ca=new Control_Alumnos();
        Clases clase =new Clases();
        Alumno al=new Alumno();
        
        al.setId_alumno(jTxtIdAlumno.getText().toString());
        
        ca.recuperaAlumno(al, clase);
        
        if(al.getStatus().toUpperCase().equals("ACTIVO")){
            jLblNombre.setText(al.getNombre().toUpperCase()+" "+al.getApellido_paterno().toUpperCase()
                    +", CLASE: "+clase.getNombreClase().toUpperCase());
            jLblFechaPago.setText("FECHA A PAGAR: "+ca.obtenerFechaPago(jTxtIdAlumno.getText().toString()));
            
            jLblFechaPago.setVisible(true);
            jLblNombre.setVisible(true);
            jLblPago.setVisible(true);
            jTxtPago.setVisible(true);
            jButtonPago.setVisible(true);
        }else{
            jLblNombre.setText("ALUMNO NO EXISTENTE O SE ENCUENTRA INACTIVO");
            jLblNombre.setVisible(true);
        } 
    }//GEN-LAST:event_jTxtIdAlumnoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLblFechaPago;
    private javax.swing.JLabel jLblNombre;
    private javax.swing.JLabel jLblPago;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTxtIdAlumno;
    private javax.swing.JTextField jTxtPago;
    // End of variables declaration//GEN-END:variables
}
