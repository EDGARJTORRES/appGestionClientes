package BusinessObject;

import DataAccessObject.RolUsuarioDAO;
import DataAccessObject.UsuarioDAO;
import TransferObject.RolUsuarioDTO;
import TransferObject.UsuarioDTO;

/**
 *
 * @author KEVIN EP
 */
public class Usuario {

    private UsuarioDAO usuarioDAO;
    private UsuarioDTO usuarioDTO;
    private RolUsuarioDTO rolUsuarioDTO;
    private RolUsuarioDAO rolUsuarioDAO;

    public Usuario() {
        usuarioDAO = new UsuarioDAO();
        rolUsuarioDAO = new RolUsuarioDAO();
    }

    public String validarUsuario(String userName, String password) {
        String mensaje = null;
        usuarioDTO = usuarioDAO.login(new UsuarioDTO(userName, password));

        if (!usuarioDAO.buscarUsuario(new UsuarioDTO(userName))) {
            mensaje = "El usuario no existe en la base de datos";
            System.out.println("Hola GitHub");

        } else if (!usuarioDAO.estadoUsuario(new UsuarioDTO(userName))) {
            mensaje = "El usuario está deshabilitado";
        } else if (usuarioDTO != null) {
            int codRolUsuario = usuarioDTO.getCodRolUsuario();
            int codUsuario = usuarioDTO.getCodUsuario();
            System.out.println(codUsuario);
            rolUsuarioDTO = rolUsuarioDAO.buscar(new RolUsuarioDTO(codRolUsuario));
            if (rolUsuarioDTO.getNombreRol().equals("Administrador")) {
                mensaje = "Administrador";
            } else if (rolUsuarioDTO.getNombreRol().equals("Vendedor")) {
                mensaje = "Vendedor";
            }

        } else {
            mensaje = "La contraseña no es correcta";
        }
        return mensaje;
    }

    public UsuarioDTO loginUsuario(String userName, String password) {
        usuarioDTO = usuarioDAO.login(new UsuarioDTO(userName, password));
        if (usuarioDTO != null) {
            return usuarioDTO;
        }
        return null;
    }

    public UsuarioDTO buscar(int codUsuario) {
        usuarioDTO = usuarioDAO.buscar(new UsuarioDTO(codUsuario));

        if (usuarioDTO != null) {
            return usuarioDTO;
        }
        return null;
    }
}
