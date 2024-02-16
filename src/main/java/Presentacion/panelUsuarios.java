package Presentacion;

import BusinessObject.Empleado;
import BusinessObject.RolUsuario;
import BusinessObject.Usuario;
import DataAccessObject.EmpleadoDAO;
import DataAccessObject.UsuarioDAO;
import TransferObject.EmpleadoDTO;
import TransferObject.RolUsuarioDTO;
import TransferObject.UsuarioDTO;
import Utilities.Controles;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KEVIN EP
 */
public class panelUsuarios extends javax.swing.JPanel {

    private EmpleadoDTO dtoEmpleado;
    private UsuarioDTO dtoUsuario;
    private RolUsuarioDTO dtoRolUsuario;
    private Empleado oEmpleado;
    private Usuario oUsuario;
    private RolUsuario oRolUsuario;
    private DefaultTableModel modeloEmpleados;
    private DefaultTableModel modeloUsuarios;
    private panelFormularioEmpleado jpFormularioEmpleado;
    private panelFormularioUsuario jpFormularioUsuario;
    // Campos de Texto -  Formulario Empleado
    private JTextField txtCodigo;
    private JTextField txtDni;
    private JTextField txtNombres;
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JTextField txtNumeroCelular;
    // Campos de texto y elementos - Formulario Usuario
    JComboBox<RolUsuarioDTO> cbRolUsuario;
    JTextField txtUserName;
    JTextField txtPassword;
    JRadioButton rbActivo;
    JRadioButton rbInactivo;

    public panelUsuarios() {
        initComponents();
        oEmpleado = new Empleado();
        oUsuario = new Usuario();
        oRolUsuario = new RolUsuario();
        modeloEmpleados = new DefaultTableModel();
        modeloUsuarios = new DefaultTableModel();
        jpFormularioEmpleado = new panelFormularioEmpleado();
        jpFormularioUsuario = new panelFormularioUsuario();
        iniciarPanelUsuarios();
        listarEmpleados();
        listarUsuarios();
    }

    private void iniciarPanelUsuarios() {
        Controles.cargarFormularios(panelContenedorEmpleado, jpFormularioEmpleado, 366, 300);
        Controles.cargarFormularios(panelContenedorUsuario, jpFormularioUsuario, 360, 300);

        // Instancias de elementos de Formulario Empleados
        txtCodigo = jpFormularioEmpleado.txtCodigoEmpleado;
        txtDni = jpFormularioEmpleado.txtDniEmpleado;
        txtNombres = jpFormularioEmpleado.txtNombresEmpleado;
        txtApellidoPaterno = jpFormularioEmpleado.txtApellidoPaternoEmple;
        txtApellidoMaterno = jpFormularioEmpleado.txtApellidoMaternoEmmple;
        txtNumeroCelular = jpFormularioEmpleado.txtCelularEmpleado;
        txtDni.setEditable(false);
        txtNombres.setEditable(false);
        txtApellidoPaterno.setEditable(false);
        txtApellidoMaterno.setEditable(false);
        txtNumeroCelular.setEditable(false);

        // Instancias de elementos de Formulario Usuario
        cbRolUsuario = jpFormularioUsuario.cbTipoUsuario;
        txtUserName = jpFormularioUsuario.txtNameUser;
        txtPassword = jpFormularioUsuario.txtPassword;
        rbActivo = jpFormularioUsuario.rbUsuarioActivo;
        rbInactivo = jpFormularioUsuario.rbUsuarioInactivo;

        String[] tituloTablaEmpleado = {"COÓDIGO", "N° DNI", "NOMBRES", "APELLIDOS"};
        modeloEmpleados.setColumnIdentifiers(tituloTablaEmpleado);
        String[] tituloTablaUsuario = {"COÓDIGO", "NOMBRES Y APELLIDOS", "NOMBRE DE USUARIO", "ROL", "ESTADO"};
        modeloUsuarios.setColumnIdentifiers(tituloTablaUsuario);

        jpFormularioUsuario.btnCrearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });
    }

    private void listarEmpleados() {
        Object[] datos = new Object[4];
        for (EmpleadoDTO empleado : oEmpleado.listar()) {
            datos[0] = empleado.getCodEmpleado();
            datos[1] = empleado.getDNIEmpleado();
            datos[2] = empleado.getNombres();
            datos[3] = empleado.getApellidoPaterno() + " " + empleado.getApellidoMaterno();
            modeloEmpleados.addRow(datos);
        }
        tbEmpleados.setModel(modeloEmpleados);
    }

    private void listarUsuarios() {
        Object[] datos = new Object[5];
        for (UsuarioDTO usuario : oUsuario.listar()) {
            dtoEmpleado = oEmpleado.buscar(usuario.getCodEmpleado());
            dtoRolUsuario = oRolUsuario.buscar(usuario.getCodRolUsuario());
            datos[0] = usuario.getCodEmpleado();
            datos[1] = dtoEmpleado.getNombres() + " " + dtoEmpleado.getApellidoPaterno() + " " + dtoEmpleado.getApellidoMaterno();
            datos[2] = usuario.getUserName();
            datos[3] = dtoRolUsuario.getNombreRol();
            switch (usuario.getEstado()) {
                case "1" -> {
                    datos[4] = "Activo";
                }
                case "0" -> {
                    datos[4] = "Inactivo";
                }
            }

            modeloUsuarios.addRow(datos);
        }
        tbUsuarios.setModel(modeloUsuarios);
    }

    private void btnCrearUsuarioActionPerformed(ActionEvent evt) {
        if (tbEmpleados.getSelectedRowCount() > 0) {
            if (jpFormularioUsuario.validarFormularioUsuario()) {
                String userName = txtUserName.getText().trim();
                String password = txtPassword.getText().trim();
                int codRolUsuario = cbRolUsuario.getItemAt(cbRolUsuario.getSelectedIndex()).getCodRolUsuario();
                String codEmpleado = jpFormularioUsuario.labelCodigoEmpleado.getText();
                String estado = "";
                if (rbActivo.isSelected()) {
                    estado = "1";
                } else if (rbInactivo.isSelected()) {
                    estado = "0";
                }

                UsuarioDAO daoUsuario = new UsuarioDAO();

                if (!daoUsuario.buscarCodigoEmpleado(codEmpleado)) {
                    if (!daoUsuario.buscarUsuario(new UsuarioDTO(userName))) {
                        JOptionPane.showMessageDialog(null, "El usuario no exsiste será registrado");
//                Toolkit.getDefaultToolkit().beep();
//                // Registramos el usuario generado
//                String mensaje = oUsuario.agregar(userName, password, estado, codRolUsuario, codEmpleado);
//                JOptionPane.showMessageDialog(null, mensaje, "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
//
//                cancelar();
                    } else {
                        JOptionPane.showMessageDialog(null, "El Nombre de Usuario ya existe", "¡Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El empleado ya cuenta con un usuario", "¡Error!", JOptionPane.ERROR_MESSAGE);
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado de la tabla empleados.", "¡Error! Acción Inválida", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void cancelar() {
        txtCodigo.setText("");
        txtDni.setText("");
        txtNombres.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtNumeroCelular.setText("");
        jpFormularioUsuario.cancelar();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBuscarDNI = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpleados = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtBuscarNombres = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        panelContenedorEmpleado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscarDNI1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtBuscarNombres1 = new javax.swing.JTextField();
        panelContenedorUsuario = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnGuardarEmpleado = new javax.swing.JButton();
        btnEditarrEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGenerarUsuario = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Buscar por");

        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpleados);

        jLabel9.setText("Buscar por");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscarNombres))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscarDNI)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestionar Usuario");

        jLabel2.setText("FORMULARIO EMPLEADO");

        javax.swing.GroupLayout panelContenedorEmpleadoLayout = new javax.swing.GroupLayout(panelContenedorEmpleado);
        panelContenedorEmpleado.setLayout(panelContenedorEmpleadoLayout);
        panelContenedorEmpleadoLayout.setHorizontalGroup(
            panelContenedorEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorEmpleadoLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel2)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        panelContenedorEmpleadoLayout.setVerticalGroup(
            panelContenedorEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorEmpleadoLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel2)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Selecciones o busque un empleado para generar su Cuenta de Usuario:");

        jLabel10.setText("Buscar por");

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbUsuarios);

        jLabel11.setText("Buscar por");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarDNI1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarNombres1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarDNI1)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarNombres1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setText("FORMULARIO USUARIO");

        javax.swing.GroupLayout panelContenedorUsuarioLayout = new javax.swing.GroupLayout(panelContenedorUsuario);
        panelContenedorUsuario.setLayout(panelContenedorUsuarioLayout);
        panelContenedorUsuarioLayout.setHorizontalGroup(
            panelContenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorUsuarioLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel4)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        panelContenedorUsuarioLayout.setVerticalGroup(
            panelContenedorUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorUsuarioLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel4)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnGuardarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnGuardar.png"))); // NOI18N
        btnGuardarEmpleado.setContentAreaFilled(false);
        btnGuardarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarEmpleado.setName("btnGuardar"); // NOI18N
        btnGuardarEmpleado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnGuardarHover.png"))); // NOI18N

        btnEditarrEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botones/btnEditarUsuario.png"))); // NOI18N
        btnEditarrEmpleado.setContentAreaFilled(false);
        btnEditarrEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarrEmpleado.setName("btnActualizar"); // NOI18N
        btnEditarrEmpleado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botones/btnEditarUsuarioHover.png"))); // NOI18N

        btnEliminarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botones/btnELiminarUsuario.png"))); // NOI18N
        btnEliminarEmpleado.setContentAreaFilled(false);
        btnEliminarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarEmpleado.setName("btnEliminar"); // NOI18N
        btnEliminarEmpleado.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botones/btnELiminarUsuarioHover.png"))); // NOI18N

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarHover.png"))); // NOI18N
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditarrEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarrEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        btnGenerarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnGenerarUsuario.png"))); // NOI18N
        btnGenerarUsuario.setContentAreaFilled(false);
        btnGenerarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarUsuario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/btnGenerarUsuarioHover.png"))); // NOI18N
        btnGenerarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelContenedorEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelContenedorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelContenedorEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelContenedorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btnGenerarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpleadosMouseClicked
        String codEmpleado = (String) tbEmpleados.getValueAt(tbEmpleados.getSelectedRow(), 0);

        dtoEmpleado = oEmpleado.buscar(codEmpleado);
        txtCodigo.setText(dtoEmpleado.getCodEmpleado());
        txtDni.setText(dtoEmpleado.getDNIEmpleado());
        txtNombres.setText(dtoEmpleado.getNombres());
        txtApellidoPaterno.setText(dtoEmpleado.getApellidoPaterno());
        txtApellidoMaterno.setText(dtoEmpleado.getApellidoMaterno());
        txtNumeroCelular.setText(dtoEmpleado.getCelular());

        jpFormularioUsuario.cancelar();
    }//GEN-LAST:event_tbEmpleadosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
//        Toolkit.getDefaultToolkit().beep();
//        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGenerarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarUsuarioActionPerformed
        if (tbEmpleados.getSelectedRowCount() > 0) {
            String codigoEmpleado = txtCodigo.getText();
            String nombres = txtNombres.getText();
            String apellidoPat = txtApellidoPaterno.getText();

            String[] nombresArray = nombres.split(" ");
            jpFormularioUsuario.labelCodigoEmpleado.setText(codigoEmpleado);
            jpFormularioUsuario.labelNombreApellidoEmpleado.setText("- " + nombresArray[0] + " " + apellidoPat);

            txtUserName.setText(txtDni.getText() + codigoEmpleado.substring(1, 4));
            txtPassword.setText(txtDni.getText());
            rbActivo.setSelected(true);
            rbInactivo.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado de la tabla empleados.", "¡Error! Acción Inválida", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGenerarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarrEmpleado;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnGenerarUsuario;
    private javax.swing.JButton btnGuardarEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelContenedorEmpleado;
    private javax.swing.JPanel panelContenedorUsuario;
    private javax.swing.JTable tbEmpleados;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JTextField txtBuscarDNI;
    private javax.swing.JTextField txtBuscarDNI1;
    private javax.swing.JTextField txtBuscarNombres;
    private javax.swing.JTextField txtBuscarNombres1;
    // End of variables declaration//GEN-END:variables
}
