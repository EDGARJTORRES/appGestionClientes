/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataAccessObject.ClienteDAO;
import TransferObject.ClienteDTO;
import TransferObject.EmpleadoDTO;
import java.util.List;

/**
 *
 * @author Bryam
 */
public class Cliente {
    private ClienteDAO clienteDAO;
    private ClienteDTO clienteDTO;
    
    public Cliente() {
        clienteDAO = new ClienteDAO();
    }
    
    public String agregar(String codcliente, String ruc, String apellido, String nombre, String celular, String direccion, String distrito, String provincia){
        String mensaje;

        clienteDTO = new ClienteDTO(codcliente, ruc, apellido, nombre, celular, direccion, distrito, provincia);
        if (clienteDAO.agregar(clienteDTO))
            mensaje = "Registro Guardado";
        else
            mensaje = "Registro no guardado";
        return mensaje;
    }
    
    public String actualizar(String codcliente, String ruc, String apellido, String nombre, String celular, String direccion, String distrito, String provincia){
        String mensaje;
        clienteDTO = new ClienteDTO(codcliente, ruc, apellido, nombre, celular, direccion, distrito, provincia);
        if (clienteDAO.actualizar(clienteDTO))
            mensaje = "Se actualizó correctamente";
        else
            mensaje = "Error, no se pudo actualizar";
        return mensaje;
    }
    
    public String eliminar(String codcliente){
        String mensaje;
        clienteDTO = new ClienteDTO(codcliente);
        if (clienteDAO.eliminar(clienteDTO))
            mensaje = "Registro Eliminado";
        else
            mensaje = "Registro no Eliminado";
        return mensaje;
    }
    
    public ClienteDTO buscar(String codcliente){
        clienteDTO = clienteDAO.buscar(new ClienteDTO(codcliente));
        if (clienteDTO!=null)
            return clienteDTO;
        return null;
    }
    
    public List<ClienteDTO>listar(){
        if(clienteDAO.listar()!=null){
            List<ClienteDTO>lista = clienteDAO.listar();
            return lista;
        }
        return null;
    }
}
