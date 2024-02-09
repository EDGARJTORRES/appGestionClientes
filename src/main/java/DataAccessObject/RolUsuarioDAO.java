package DataAccessObject;

import DataSource.Conexion;
import TransferObject.RolUsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author KEVIN EP
 */
public class RolUsuarioDAO implements ICrud<RolUsuarioDTO>{
    PreparedStatement ps;
    ResultSet rs;
    Conexion oConexion;
    
    public RolUsuarioDAO() {
        oConexion = new Conexion();
    }
    @Override
    public boolean agregar(RolUsuarioDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(RolUsuarioDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(RolUsuarioDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RolUsuarioDTO buscar(RolUsuarioDTO rolUsuarioDTO) {
        boolean encontrado = false;
        
        try {
            ps = oConexion.conectar().prepareStatement("SELECT * FROM RolUsuario WHERE CodRolUsuario = ?");
            ps.setInt(1, rolUsuarioDTO.getCodRolUsuario());
            rs = ps.executeQuery();
            while (rs.next()){
                rolUsuarioDTO.setCodRolUsuario(rs.getInt(1));
                rolUsuarioDTO.setNombreRol(rs.getString(2));
                encontrado = true;
            }
            if (encontrado) {
                return rolUsuarioDTO;
            }
            else {
                return null;
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        finally {
            oConexion.desconectar();
        }
    }

    @Override
    public List<RolUsuarioDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
