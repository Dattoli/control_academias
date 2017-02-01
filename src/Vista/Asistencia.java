/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Alumno;
import Controlador.Clases;
import Modelo.Control_Alumnos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Uknown
 */
public class Asistencia extends javax.swing.JFrame {

    /**
     * Creates new form Asistencia
     */
    public Asistencia() {
        initComponents();
        
        jBEnviar.setVisible(false);
        jChkAsistencia.setVisible(false);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = new Date();
        
        jLblFecha.setText(formato.format(fecha).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jTxtIdAlumno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLblFecha = new javax.swing.JLabel();
        jLblAlumno = new javax.swing.JLabel();
        jChkAsistencia = new javax.swing.JCheckBox();
        jBEnviar = new javax.swing.JButton();
        jBVolver = new javax.swing.JButton();
        jLblPago = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE ASISTENCIA");

        jLabel2.setText("ID ALUMNO:");

        jTxtIdAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIdAlumnoActionPerformed(evt);
            }
        });

        jLabel3.setText("FECHA:");

        jLblAlumno.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLblAlumno.setForeground(new java.awt.Color(0, 102, 255));

        jChkAsistencia.setText("REGISTRAR ASISTENCIA");

        jBEnviar.setText("ASISTENCIA");
        jBEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEnviarActionPerformed(evt);
            }
        });

        jBVolver.setText("VOLVER");
        jBVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVolverActionPerformed(evt);
            }
        });

        jLblPago.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLblPago.setForeground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jChkAsistencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                        .addComponent(jBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jBVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtIdAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLblAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblPago, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChkAsistencia)
                    .addComponent(jBEnviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBVolver)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVolverActionPerformed
        this.dispose();
        
        new Principal().setVisible(true);
    }//GEN-LAST:event_jBVolverActionPerformed

    private void jTxtIdAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIdAlumnoActionPerformed
        Control_Alumnos ca=new Control_Alumnos();
        Clases clase =new Clases();
        Alumno al=new Alumno();
        
        al.setId_alumno(jTxtIdAlumno.getText().toString());
        
        ca.recuperaAlumno(al, clase);
        
        if(al.getStatus().toUpperCase().equals("ACTIVO")){
            jLblAlumno.setText(al.getNombre().toUpperCase()+" "+al.getApellido_paterno().toUpperCase()
                    +", CLASE: "+clase.getNombreClase().toUpperCase());
            jBEnviar.setVisible(true);
            jLblPago.setText("PRÓXIMO PAGO: "+ca.obtenerFechaPago(jTxtIdAlumno.getText().toString())
                    +" STATUS "+pagado().toString());
            jChkAsistencia.setVisible(true);
        }else{
            jLblAlumno.setText("ALUMNO NO EXISTENTE O SE ENCUENTRA INACTIVO");
        }   
    }//GEN-LAST:event_jTxtIdAlumnoActionPerformed

    private void jBEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnviarActionPerformed
        int bandera;
        Control_Alumnos ca=new Control_Alumnos();
        Clases clase =new Clases();
        Alumno al=new Alumno();
        
        al.setId_alumno(jTxtIdAlumno.getText().toString());
        
        if(jChkAsistencia.isSelected()){
            bandera = ca.asistencia(ca.recuperaAlumno(al, clase), jLblFecha.getText());
            
            if(bandera == 1){
                JOptionPane.showMessageDialog(null, "Se ha registrado la asistencia");
                jTxtIdAlumno.setText("");
                jLblAlumno.setText("");
                jBEnviar.setVisible(false);
                jChkAsistencia.setVisible(false);
                
            }else{
                JOptionPane.showMessageDialog(null, "No se ha podido registrar la asistencia");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Primero debes seleccionar la casilla de Asistencia");
        }
    }//GEN-LAST:event_jBEnviarActionPerformed

    private String pagado(){
        String leyenda="";
        Control_Alumnos ca=new Control_Alumnos();
        int bf = 0;
        boolean bc;
        Date fechaActual = new Date();;
        Date fechaPago = null;
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            fechaPago = formateador.parse(ca.obtenerFechaPago(jTxtIdAlumno.getText().toString()));
            bf = fechaActual.compareTo(fechaPago);
            bc = fechaPago.before(fechaActual);
            
        } catch (ParseException ex) {
            Logger.getLogger(Asistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(bf < 0){
            if(bc = true){
                leyenda = "PENDIENTE";
            }else{
                leyenda = "PAGADO";
            }
        }else{
            leyenda = "FECHA IGUAL";
        }
        
        return leyenda;   
        
    }
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
            java.util.logging.Logger.getLogger(Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asistencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEnviar;
    private javax.swing.JButton jBVolver;
    private javax.swing.JCheckBox jChkAsistencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLblAlumno;
    private javax.swing.JLabel jLblFecha;
    private javax.swing.JLabel jLblPago;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTxtIdAlumno;
    // End of variables declaration//GEN-END:variables
}
