package TransferObject;

/**
 *
 * @author KEVIN EP
 */
public class RolUsuarioDTO {
    private  int CodRolUsuario;
    private String NombreRol;

    public RolUsuarioDTO() {
    }

    public RolUsuarioDTO(int CodRolUsuario) {
        this.CodRolUsuario = CodRolUsuario;
    }

    public RolUsuarioDTO(int CodRolUsuario, String NombreRol) {
        this.CodRolUsuario = CodRolUsuario;
        this.NombreRol = NombreRol;
    }

    public int getCodRolUsuario() {
        return CodRolUsuario;
    }

    public void setCodRolUsuario(int CodRolUsuario) {
        this.CodRolUsuario = CodRolUsuario;
    }

    public String getNombreRol() {
        return NombreRol;
    }

    public void setNombreRol(String NombreRol) {
        this.NombreRol = NombreRol;
    }
}
