package Vista;

import Controlador.Conexion;
import Modelo.Control_Alumnos;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class Consultas extends javax.swing.JFrame {

    DefaultTableModel modeloTabla;
    String []columnas;
    
    public Consultas() {
        modeloTabla = new DefaultTableModel();
        initComponents();
        jCmbClase.setVisible(false);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTblConsulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox<>();
        jCmbClase = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTblConsulta.setModel(modeloTabla);
        jScrollPane1.setViewportView(jTblConsulta);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTAS GENERALES IYF");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONA UNA OPCION", "ALUMNOS ACTIVOS", "ALUMNOS INACTIVOS", "ALUMNOS CON ADEUDOS", "ALUMNOS AL CORRIENTE", "MAESTROS" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jCmbClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCION OPCION", "COREANO BASICO", "COREANO INTERMEDIO", "INGLES BASICO", "INGLES INTERMEDIO", "FRANCES BASICO", "FRANCES INTERMEDIO", "GUITARRA BASICO", "GUITARRA INTERMEDIO" }));
        jCmbClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbClaseActionPerformed(evt);
            }
        });

        jButton1.setText("VOLVER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCmbClase, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCmbClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        Control_Alumnos ca=new Control_Alumnos();
        String opcion = jComboBox1.getSelectedItem().toString();
        
        switch (opcion){
            case "MAESTROS":
                //JOptionPane.showMessageDialog(null, "Entro al Switch");
                modeloTabla = new DefaultTableModel(null, ca.getColumnas(opcion));
                jTblConsulta.setModel(modeloTabla);
                jTblConsulta.setVisible(true);
                ca.setFilas(modeloTabla, opcion);
                break;
            case "ALUMNOS ACTIVOS":
                modeloTabla = new DefaultTableModel(null, ca.getColumnas(opcion));
                jTblConsulta.setModel(modeloTabla);
                jTblConsulta.setVisible(true);
                ca.setFilas(modeloTabla, opcion);
                jCmbClase.setVisible(true);
                break;
            case "ALUMNOS INACTIVOS":
                modeloTabla = new DefaultTableModel(null, ca.getColumnas(opcion));
                jTblConsulta.setModel(modeloTabla);
                jTblConsulta.setVisible(true);
                ca.setFilas(modeloTabla, opcion);
                jCmbClase.setVisible(false);
                break;
            default:
                jCmbClase.setVisible(false);
                break;
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jCmbClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbClaseActionPerformed
        Control_Alumnos ca=new Control_Alumnos();
        String opcion = jCmbClase.getSelectedItem().toString();
        
        switch (opcion){
            case "COREANO BASICO":
                modeloTabla = new DefaultTableModel(null, ca.getColumnasClase());
                jTblConsulta.setModel(modeloTabla);
                jTblConsulta.setVisible(true);
                ca.setFilasClase(modeloTabla, opcion);
                break;
            case "COREANO INTERMEDIO":
                modeloTabla = new DefaultTableModel(null, ca.getColumnasClase());
                jTblConsulta.setModel(modeloTabla);
                jTblConsulta.setVisible(true);
                ca.setFilasClase(modeloTabla, opcion);
                break;
            case "INGLES BASICO":
                modeloTabla = new DefaultTableModel(null, ca.getColumnasClase());
                jTblConsulta.setModel(modeloTabla);
                jTblConsulta.setVisible(true);
                ca.setFilasClase(modeloTabla, opcion);
                break;
            case "INGLES INTERMEDIO":
                modeloTabla = new DefaultTableModel(null, ca.getColumnasClase());
                jTblConsulta.setModel(modeloTabla);
                jTblConsulta.setVisible(true);
                ca.setFilasClase(modeloTabla, opcion);
                break;
            case "FRANCES BASICO":
                modeloTabla = new DefaultTableModel(null, ca.getColumnasClase());
                jTblConsulta.setModel(modeloTabla);
                jTblConsulta.setVisible(true);
                ca.setFilasClase(modeloTabla, opcion);
                break;
            case "FRANCES INTERMEDIO":
                modeloTabla = new DefaultTableModel(null, ca.getColumnasClase());
                jTblConsulta.setModel(modeloTabla);
                jTblConsulta.setVisible(true);
                ca.setFilasClase(modeloTabla, opcion);
                break;
            case "GUITARRA BASICO":
                modeloTabla = new DefaultTableModel(null, ca.getColumnasClase());
                jTblConsulta.setModel(modeloTabla);
                jTblConsulta.setVisible(true);
                ca.setFilasClase(modeloTabla, opcion);
                break;
            case "GUITARRA INTERMEDIO":
                modeloTabla = new DefaultTableModel(null, ca.getColumnasClase());
                jTblConsulta.setModel(modeloTabla);
                jTblConsulta.setVisible(true);
                ca.setFilasClase(modeloTabla, opcion);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jCmbClaseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCmbClase;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTblConsulta;
    // End of variables declaration//GEN-END:variables
}
