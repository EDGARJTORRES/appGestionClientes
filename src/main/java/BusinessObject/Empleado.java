package BusinessObject;

import DataAccessObject.EmpleadoDAO;
import TransferObject.EmpleadoDTO;

/**
 *
 * @author KEVIN EP
 */
public class Empleado {
    private EmpleadoDTO dtoEmpleado;
    private EmpleadoDAO daoEmpleado;

    
    public Empleado() {
        daoEmpleado = new EmpleadoDAO();
    }
    
    public EmpleadoDTO buscar(String codEmpleado){
        dtoEmpleado = daoEmpleado.buscar(new EmpleadoDTO(codEmpleado));
        if (dtoEmpleado!=null)
            return dtoEmpleado;
        return null;
    }
 
}
