package BusinessObject;

import DataAccessObject.RolUsuarioDAO;
import TransferObject.RolUsuarioDTO;

/**
 *
 * @author KEVIN EP
 */
public class RolUsuario {
    private RolUsuarioDTO dtoRolUsuario;
    private RolUsuarioDAO daoRolUsuario;

    public RolUsuario() {
        daoRolUsuario = new RolUsuarioDAO();
    }
    

    public RolUsuarioDTO buscar(int codRolUsuario){
        dtoRolUsuario = daoRolUsuario.buscar(new RolUsuarioDTO(codRolUsuario));

        if (dtoRolUsuario!=null)
            return dtoRolUsuario;
        return null;
    }
}
