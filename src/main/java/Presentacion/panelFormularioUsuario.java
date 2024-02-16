package Presentacion;

import BusinessObject.RolUsuario;
import TransferObject.RolUsuarioDTO;
import Utilities.DisabledItemRenderer;
import javax.swing.JOptionPane;

/**
 *
 * @author KEVIN EP
 */
public class panelFormularioUsuario extends javax.swing.JPanel {

    private RolUsuarioDTO dtoRolUsuario;
    private RolUsuario oRolUsuario;

    public panelFormularioUsuario() {
        oRolUsuario = new RolUsuario();
        initComponents();
        llenarComboBox();

    }

    private void llenarComboBox() {
        RolUsuarioDTO mensajeSeleccionStart = new RolUsuarioDTO(0, "-- Seleccione --");
        cbTipoUsuario.addItem(mensajeSeleccionStart);
        for (RolUsuarioDTO rol : oRolUsuario.listar()) {
            cbTipoUsuario.addItem(rol);
        }
        cbTipoUsuario.setRenderer(new DisabledItemRenderer());
    }

    public boolean validarFormularioUsuario() {
        String userName = txtNameUser.getText().trim();
        String password = txtPassword.getText().trim();
        if (cbTipoUsuario.getSelectedIndex() != 0) {
            if (!userName.isEmpty()) {
                if (!password.isEmpty()) {
                    if (!rbUsuarioActivo.isSelected() || !rbUsuarioInactivo.isSelected()) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Dedes seleccionar un Estado", "¡Error! Datos Incompletos", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Dedes ingresar una contraseña", "¡Error! Datos Incompletos", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Dedes ingresar un Nombre de Usuario", "¡Error! Datos Incompletos", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Dedes Seleccionar un Rol", "¡Error! Datos Incompletos", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public void cancelar() {
        cbTipoUsuario.setSelectedIndex(0);
        txtNameUser.setText("");
        txtPassword.setText("");
        rbUsuarioActivo.setSelected(false);
        rbUsuarioInactivo.setSelected(false);
        labelCodigoEmpleado.setText("");
        labelNombreApellidoEmpleado.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupUsuario = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        labelNombreApellidoEmpleado = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbTipoUsuario = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtNameUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rbUsuarioActivo = new javax.swing.JRadioButton();
        rbUsuarioInactivo = new javax.swing.JRadioButton();
        btnCrearUsuario = new javax.swing.JButton();
        labelCodigoEmpleado = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(137, 176, 212), 2, true), "DATOS DEL USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(30, 64, 175))); // NOI18N

        jLabel2.setText("para: ");

        labelNombreApellidoEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelNombreApellidoEmpleado.setForeground(new java.awt.Color(0, 102, 102));
        labelNombreApellidoEmpleado.setText("- Nombre Apellido");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Rol de Usuario");

        cbTipoUsuario.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Nombre de Usuario:");

        txtNameUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Contraseña:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Estado:");

        buttonGroupUsuario.add(rbUsuarioActivo);
        rbUsuarioActivo.setText("Activo");

        buttonGroupUsuario.add(rbUsuarioInactivo);
        rbUsuarioInactivo.setText("Inactivo");

        btnCrearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botones/btnCrearUsuario.png"))); // NOI18N
        btnCrearUsuario.setContentAreaFilled(false);
        btnCrearUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearUsuario.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botones/btnCrearUsuarioHover.png"))); // NOI18N

        labelCodigoEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCodigoEmpleado.setForeground(new java.awt.Color(0, 51, 51));
        labelCodigoEmpleado.setText("CODIGO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNombreApellidoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbUsuarioActivo)
                                .addGap(18, 18, 18)
                                .addComponent(rbUsuarioInactivo))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(txtNameUser, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelNombreApellidoEmpleado)
                    .addComponent(labelCodigoEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbUsuarioActivo)
                    .addComponent(rbUsuarioInactivo)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCrearUsuario;
    private javax.swing.ButtonGroup buttonGroupUsuario;
    public javax.swing.JComboBox<RolUsuarioDTO> cbTipoUsuario;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel labelCodigoEmpleado;
    public javax.swing.JLabel labelNombreApellidoEmpleado;
    public javax.swing.JRadioButton rbUsuarioActivo;
    public javax.swing.JRadioButton rbUsuarioInactivo;
    public javax.swing.JTextField txtNameUser;
    public javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}