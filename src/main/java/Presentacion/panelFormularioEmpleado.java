package Presentacion;

import DataAccessObject.EmpleadoDAO;
import Utilities.Controles;
import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JOptionPane;

/**
 *
 * @author KEVIN EP
 */
public class panelFormularioEmpleado extends javax.swing.JPanel {

    EmpleadoDAO daoEmpleado;

    /**
     * Creates new form panelFormularioEmpleado
     */
    public panelFormularioEmpleado() {
        daoEmpleado = new EmpleadoDAO();
        initComponents();
        iniicarFlatLaf();
        txtCodigoEmpleado.setEnabled(false);
    }

    public boolean validarFormularioEmpleado() {
        String dni = txtDniEmpleado.getText().trim();
        String nombres = txtNombresEmpleado.getText().trim();
        String apellidoPaterno = txtApellidoPaternoEmple.getText().trim();
        String apellidoMaterno = txtApellidoMaternoEmmple.getText().trim();
        String numeroCelular = txtCelularEmpleado.getText().trim();

        if (dni.isEmpty() || nombres.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() || numeroCelular.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes completar todos los campos", "¡Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            if (dni.length() == 8) {
                if (numeroCelular.startsWith("9") && numeroCelular.length() == 9) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Debe tener 9 dígitos y comenzar con el n° 9", "¡Error! N° de Celular no válido", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe tener 8 dígitos", "¡Error! N° DNI no válido", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

     private void iniicarFlatLaf() {
        txtCodigoEmpleado.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10");
        txtDniEmpleado.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10");
        txtNombresEmpleado.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10");
        txtApellidoPaternoEmple.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10");
        txtApellidoMaternoEmmple.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10");
        txtCelularEmpleado.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10");
    }
     
     public void cancelar() {
         txtCodigoEmpleado.setText("");
         txtDniEmpleado.setText("");
         txtNombresEmpleado.setText("");
         txtApellidoPaternoEmple.setText("");
         txtApellidoMaternoEmmple.setText("");
         txtCelularEmpleado.setText("");
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        txtCodigoEmpleado = new javax.swing.JTextField();
        txtDniEmpleado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombresEmpleado = new javax.swing.JTextField();
        txtApellidoPaternoEmple = new javax.swing.JTextField();
        txtApellidoMaternoEmmple = new javax.swing.JTextField();
        txtCelularEmpleado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(137, 176, 212), 2, true), "DATOS DEL EMPLEADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(30, 64, 175))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Código:");

        txtCodigoEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtDniEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDniEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniEmpleadoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("DNI:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Nombres:");

        txtNombresEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombresEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresEmpleadoKeyTyped(evt);
            }
        });

        txtApellidoPaternoEmple.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtApellidoMaternoEmmple.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtApellidoMaternoEmmple.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMaternoEmmpleKeyTyped(evt);
            }
        });

        txtCelularEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCelularEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularEmpleadoKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Nro. Celular:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Apellido Paterno:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Apellido Paterno:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(txtDniEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombresEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(txtApellidoPaternoEmple, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(12, 12, 12)
                        .addComponent(txtApellidoMaternoEmmple, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtCelularEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDniEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNombresEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtApellidoPaternoEmple, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtApellidoMaternoEmmple, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCelularEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniEmpleadoKeyTyped
        Controles.solonumeros(evt);
        Controles.longitudTexto(evt, txtDniEmpleado, 8);
    }//GEN-LAST:event_txtDniEmpleadoKeyTyped

    private void txtNombresEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresEmpleadoKeyTyped
        Controles.soloLetras(evt);
    }//GEN-LAST:event_txtNombresEmpleadoKeyTyped

    private void txtApellidoMaternoEmmpleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMaternoEmmpleKeyTyped
        Controles.soloLetras(evt);
    }//GEN-LAST:event_txtApellidoMaternoEmmpleKeyTyped

    private void txtCelularEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularEmpleadoKeyTyped
        Controles.solonumeros(evt);
        Controles.longitudTexto(evt, txtCelularEmpleado, 9);
    }//GEN-LAST:event_txtCelularEmpleadoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField txtApellidoMaternoEmmple;
    public javax.swing.JTextField txtApellidoPaternoEmple;
    public javax.swing.JTextField txtCelularEmpleado;
    public javax.swing.JTextField txtCodigoEmpleado;
    public javax.swing.JTextField txtDniEmpleado;
    public javax.swing.JTextField txtNombresEmpleado;
    // End of variables declaration//GEN-END:variables
}
