
package TransferObject;

/**
 *
 * @author Bryam
 * @author KEVIN EP 
 */
public class ClienteDTO {
    private String codCliente;
    private String ruc;
    private String apellido;
    private String nombre;
    private String celular;
    private String direccion;
    private String distrito;
    private String provincia;

    public ClienteDTO() {
    }

    public ClienteDTO(String codCliente) {
        this.codCliente = codCliente;
    }

    public ClienteDTO(String codCliente, String ruc, String apellido, String nombre, String celular, String direccion, String distrito, String provincia) {
        this.codCliente = codCliente;
        this.ruc = ruc;
        this.apellido = apellido;
        this.nombre = nombre;
        this.celular = celular;
        this.direccion = direccion;
        this.distrito = distrito;
        this.provincia = provincia;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    
}
