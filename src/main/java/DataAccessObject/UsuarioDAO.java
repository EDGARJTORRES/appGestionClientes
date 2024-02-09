package DataAccessObject;

import DataSource.Conexion;
import TransferObject.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KEVIN EP
 */
public class UsuarioDAO implements ICrud<UsuarioDTO>{
    PreparedStatement ps;
    ResultSet rs;
    Conexion oConexion;
    
    public UsuarioDAO() {
        oConexion = new Conexion();
    }

    @Override
    public boolean agregar(UsuarioDTO dtoUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(UsuarioDTO dtoUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(UsuarioDTO dtoUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UsuarioDTO buscar(UsuarioDTO dtoUsuario) {
        boolean encontrado = false;
        try {    
            ps = oConexion.conectar().prepareStatement("SELECT * FROM Usuario WHERE CodUsuario = ?");
            ps.setInt(1, dtoUsuario.getCodUsuario());
            rs = ps.executeQuery();
            while (rs.next()) {                
                dtoUsuario.setCodUsuario(rs.getInt(1));
                dtoUsuario.setUserName(rs.getString(2));
                dtoUsuario.setPassword(rs.getString(3));
                dtoUsuario.setEstado(rs.getString(4));
                dtoUsuario.setCodRolUsuario(rs.getInt(5));
                dtoUsuario.setCodEmpleado(rs.getString(6));
                encontrado = true;
            }
            
            if (encontrado) {
                return dtoUsuario;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        } finally {
            oConexion.desconectar();
        }
    }

    @Override
    public List<UsuarioDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean buscarUsuario(UsuarioDTO dtoUsuario) {
        try {    
            ps = oConexion.conectar().prepareStatement("SELECT * FROM Usuario WHERE UserName = ?");
            ps.setString(1, dtoUsuario.getUserName());
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } finally {
            oConexion.desconectar();
        }
        return false;
    }
    
    public boolean estadoUsuario(UsuarioDTO dtoUsuario) {
        try {
            ps = oConexion.conectar().prepareStatement("SELECT * FROM Usuario WHERE UserName = ? AND Estado = 1");
            ps.setString(1, dtoUsuario.getUserName());
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } finally {
            oConexion.desconectar();
        }
        return false;
    }
    
    public boolean verificaPassword(UsuarioDTO dtoUsuario) {
        try {
            ps = oConexion.conectar().prepareStatement("SELECT * FROM Usuario WHERE UserName = ? AND Password = ?");
            ps.setString(1, dtoUsuario.getUserName());
            ps.setString(2, dtoUsuario.getPassword());
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } finally {
            oConexion.desconectar();
        }
        return false;
    }
    
    public UsuarioDTO login(UsuarioDTO dtoUsuario){
        boolean encontrado = false;
        try {
            ps = oConexion.conectar().prepareStatement("SELECT * FROM Usuario WHERE UserName = ? AND Password = ?");
            ps.setString(1, dtoUsuario.getUserName());
            ps.setString(2, dtoUsuario.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {                
                dtoUsuario.setCodUsuario(rs.getInt(1));
                dtoUsuario.setUserName(rs.getString(2));
                dtoUsuario.setPassword(rs.getString(3));
                dtoUsuario.setEstado(rs.getString(4));
                dtoUsuario.setCodRolUsuario(rs.getInt(5));
                dtoUsuario.setCodEmpleado(rs.getString(6));
                encontrado = true;
            }
            
            if (encontrado) {
                return dtoUsuario;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        } finally {
            oConexion.desconectar();
        }
    }
}
