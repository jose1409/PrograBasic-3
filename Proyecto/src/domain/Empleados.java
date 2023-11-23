package domain;
import presentation.Gui;
public class Empleados {
    private byte id;
    private String nombre;
    private String apellidos;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String correo;
    private boolean estadoempleado; // true para activo, false para inactivo
    private Empleados listaEmpleados[] = new Empleados[10];
     Gui gui;

    public Empleados() {
        this.id = 0;
        this.nombre = "";
        this.apellidos = "";
        this.ciudad = "";
        this.direccion = "";
        this.telefono = "";
        this.correo ="";
        this.estadoempleado = true; //el empleado se crea activo 
        gui = new Gui();
    } 
    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstadoempleado() {
        return estadoempleado;
    }

    public void setEstadoempleado(boolean estadoempleado) {
        this.estadoempleado = estadoempleado;
    }

    public Empleados[] getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(Empleados[] listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    

    public void inactivarEmpleado(){
        this.estadoempleado=false;
    }  
  //Agregar empleado
    public void agregarEmpleado() {
        fullList(listaEmpleados);
    }
    public boolean fullList(Empleados Empleados[]) {
        boolean test = false;
        for (int i = 0; i < Empleados.length; i++) {
            if (Empleados[i] == null) {
              Empleados empleado = new Empleados();
                empleado.setId((byte) (i + 1));
                empleado.setNombre(gui.input("Digite el nombre del empleado"));
                empleado.setApellidos(gui.input("Digite los Apellidos Completos: "));
                empleado.setCiudad(gui.input("Digite la ciudad por favor: "));
                empleado.setDireccion(gui.input("Digite la dirección de hogar por favor: "));
                empleado.setTelefono(gui.input("Digite el número de teléfono por favor: "));
                empleado.setCorreo(gui.input("Digite el correo electrónico por favor: "));
                empleado.setEstadoempleado(true);
                Empleados[i] = empleado;
                test = true;
                break;
            } else {
                if (Empleados[9] != null) {
                    gui.print("Lista llena, por favor eliminar");
                    break;
                }
            }

        }
        return test; 
    }
     // Metodo para mostrar empleados activos
    public void mostrarActivos() {
        String s = "Empleados Activos:";
        for (byte i = 0; i < listaEmpleados.length; i++) {
            if (listaEmpleados[i] != null && listaEmpleados[i].isEstadoempleado()) {
                s += "\nNombre: " + listaEmpleados[i].getNombre()
                        + "\nApellidos: " + listaEmpleados[i].getApellidos()
                        + "\nCiudad: " + listaEmpleados[i].getCiudad()
                        + "\nDirección: " + listaEmpleados[i].getDireccion()
                        + "\nTeléfono: " + listaEmpleados[i].getTelefono()
                        + "\nCorreo Electrónico: " + listaEmpleados[i].getCorreo();
            }
        }
        gui.print(s);
    }

    // Metodo para mostrar empleados inactivos
    public void mostrarInactivos() {
        String s = "Empleados Inactivos:";
        for (byte i = 0; i < listaEmpleados.length; i++) {
            if (listaEmpleados[i] != null && !listaEmpleados[i].isEstadoempleado()) {
                s += "\nNombre: " + listaEmpleados[i].getNombre()
                        + "\nApellidos: " + listaEmpleados[i].getApellidos()
                        + "\nCiudad: " + listaEmpleados[i].getCiudad()
                        + "\nDirección: " + listaEmpleados[i].getDireccion()
                        + "\nTeléfono: " + listaEmpleados[i].getTelefono()
                        + "\nCorreo Electrónico: " + listaEmpleados[i].getCorreo();
            }
        }
        gui.print(s);
    }

    // Metodo para inactivar un empleado
    public void inactivar() {
    gui.print("Empleados Activos: Por favor, elija el empleado que desea inactivar\n");
    mostrarActivos();
        byte opcion = Byte.parseByte(gui.input("Seleccione el ID: "));
        byte i;
        for (i = 0; i < listaEmpleados.length; i++) {
        if (listaEmpleados[i] != null && opcion == listaEmpleados[i].getId()) {
            if (listaEmpleados[i].isEstadoempleado()) {
                gui.print("Error: El empleado ya está inactivo, volviendo al menú");
            } else {
                listaEmpleados[i].setEstadoempleado(false);
                gui.print("Empleado #" + listaEmpleados[i].getId() + " ha sido inactivado con éxito");
            }
            return; // Sale del método después de inactivar al empleado
        }
    }
    gui.print("Empleado con ID " + opcion + " no encontrado");
}

    // Metodo para activar un empleado
    public void activar() {
        gui.print("Empleados Inactivos: Por favor, elija el empleado que desea activar\n");
        mostrarInactivos();
        byte opcion = Byte.parseByte(gui.input("Seleccione el ID: "));
        byte i;
        for (i = 0; i < listaEmpleados.length; i++) {
            if (listaEmpleados[i] != null && opcion == i + 1) {
                if (listaEmpleados[i].isEstadoempleado()) {
                    gui.print("Error: El empleado ya está activo, volviendo al menú");
                } else {
                    listaEmpleados[i].setEstadoempleado(true);
                    gui.print("Empleado #" + (i + 1) + " ha sido activado con éxito");
                }
                return; // Sale del método después de activar al empleado
            }
        }
        gui.print("Empleado con ID " + opcion + " no encontrado");
    }
    public void mostrar() {
    String s = "Total de Empleados:";
    for (byte i = 0; i < listaEmpleados.length; i++) {
        if (listaEmpleados[i] != null) {
            String estado = (listaEmpleados[i].isEstadoempleado()) ? "Activo" : "Inactivo";
            s += "\nNombre: " + listaEmpleados[i].getNombre()
                    + "\nApellidos: " + listaEmpleados[i].getApellidos()
                    + "\nCiudad: " + listaEmpleados[i].getCiudad()
                    + "\nDirección: " + listaEmpleados[i].getDireccion()
                    + "\nTeléfono: " + listaEmpleados[i].getTelefono()
                    + "\nCorreo Electrónico: " + listaEmpleados[i].getCorreo()
                    + "\nEstado: " + estado + "\n";
        }
    }
    gui.print(s);
}
    
 }