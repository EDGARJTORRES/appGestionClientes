package DataAccessObject;

import DataSource.Conexion;
import TransferObject.EmpleadoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author KEVIN EP
 */
public class EmpleadoDAO implements ICrud<EmpleadoDTO>{
    PreparedStatement ps;
    ResultSet rs;
    Conexion oConexion;


    public EmpleadoDAO() {
        oConexion = new Conexion();
    }

    @Override
    public boolean agregar(EmpleadoDTO tdtoEmpleado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(EmpleadoDTO dtoEmpleado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(EmpleadoDTO dtoEmpleado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EmpleadoDTO buscar(EmpleadoDTO dtoEmpleado) {
        boolean encontrado = false;
        
        try {
            ps = oConexion.conectar().prepareStatement("SELECT * FROM Empleado WHERE CodEmpleado = ?");
            ps.setString(1, dtoEmpleado.getCodEmpleado());
            rs = ps.executeQuery();
            while (rs.next()){
                dtoEmpleado.setCodEmpleado(rs.getString(1));
                dtoEmpleado.setDNIEmpleado(rs.getString(2));
                dtoEmpleado.setNombres(rs.getString(3));
                dtoEmpleado.setApellidoPaterno(rs.getString(4));
                dtoEmpleado.setApellidoMaterno(rs.getString(5));
                dtoEmpleado.setCelular(rs.getString(6));
                encontrado = true;
            }
            if (encontrado) {
                return dtoEmpleado;
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
    public List<EmpleadoDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
