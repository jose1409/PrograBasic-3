package domain;

import javax.swing.JOptionPane;
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
    private Atracciones atraccion = null;
    private boolean ocupado;
    private Empleados listaEmpleados[] = new Empleados[10];
    Gui gui;

    public Empleados() {
        this.id = 0;
        this.nombre = "";
        this.apellidos = "";
        this.ciudad = "";
        this.direccion = "";
        this.telefono = "";
        this.correo = "";
        this.estadoempleado = true; //el empleado se crea activo u
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

    public Atracciones getAtraccion() {
        return atraccion;
    }

    public void setAtraccion(Atracciones atraccion) {
        this.atraccion = atraccion;
    }

    public void inactivarEmpleado() {
        this.estadoempleado = false;
    }
    //Agregar empleado

    public void agregarEmpleado() {
        fullList(listaEmpleados);
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
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
        String atraccion;
        for (byte i = 0; i < listaEmpleados.length; i++) {
            if (listaEmpleados[i] != null) {
                if (listaEmpleados[i].getAtraccion() == null) {
                    atraccion = "Atraccion no asignada";
                } else {
                    atraccion = listaEmpleados[i].getAtraccion().getNombre();
                }
                if (listaEmpleados[i].isEstadoempleado()) {
                    s += "\nNombre: " + listaEmpleados[i].getNombre()
                            + "\nApellidos: " + listaEmpleados[i].getApellidos()
                            + "\nCiudad: " + listaEmpleados[i].getCiudad()
                            + "\nDirección: " + listaEmpleados[i].getDireccion()
                            + "\nTeléfono: " + listaEmpleados[i].getTelefono()
                            + "\nCorreo Electrónico: " + listaEmpleados[i].getCorreo()
                            + "\nAtraccion a Cargo: " + atraccion;
                }
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

    public void enlazar(Atracciones atraccion) {
        boolean test = true;
        Atracciones atraccion2 = null;
        String opciones[] = new String[atraccion.contarNulos()];
        atraccion.llenaNombres(opciones);

        while (test) {
            String op = (String) JOptionPane.showInputDialog(null, "Eliga la Atraccion: ", "Atracciones", JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            atraccion = atraccion.buscarAtraccion(op);
            if (atraccion.isOcupado()) {
                gui.errorMesage("La atraccion ya posee un trabajador");
            } else {
                test = false;
            }
        }

        test = true;
        Empleados empleado = null;
        String opciones2[] = new String[contarNulos()];
        llenaNombres(opciones2);

        while (test) {
            String op2 = (String) JOptionPane.showInputDialog(null, "Eliga el Empleado: ", "Empleados", JOptionPane.INFORMATION_MESSAGE, null, opciones2, opciones2[0]);
            empleado = buscarEmpleado(op2);
            if(empleado.isOcupado()){
                gui.errorMesage("El trabajador ya posee una atraccion");
            } else{
                test=false;
            }
        }

        atraccion.setEmpleado(empleado);
        atraccion.setOcupado(true);
        empleado.setAtraccion(atraccion);
        empleado.setOcupado(true);

        gui.print("El empleado " + empleado.getNombre() + " ah sido asignado exitosamente a la atraccion " + atraccion.getNombre());
    }

    public void llenaNombres(String... datos) {
        for (int i = 0; i < listaEmpleados.length; i++) {
            if (listaEmpleados[i] != null) {
                datos[i] = listaEmpleados[i].nombre;
            }
        }
    }

    public int contarNulos() {
        int cont = 0;
        for (int i = 0; i < listaEmpleados.length; i++) {
            if (listaEmpleados[i] != null) {
                cont++;
            }
        }
        return cont;
    }

    public Empleados buscarEmpleado(String nombre) {
        Empleados empleado = null;
        for (int i = 0; i < listaEmpleados.length; i++) {
            if (listaEmpleados[i] != null) {
                if (listaEmpleados[i].getNombre().equals(nombre)) {
                    empleado = listaEmpleados[i];
                    i = listaEmpleados.length;
                }
            }
        }
        return empleado;
    }
    
    public Empleados comboBox(){
        Empleados empleadoTemp = null;
        String opciones2[] = new String[contarNulos()];
        llenaNombres(opciones2);
        String op2 = (String) JOptionPane.showInputDialog(null, "Eliga el Empleado: ", "Empleados", JOptionPane.INFORMATION_MESSAGE, null, opciones2, opciones2[0]);
        empleadoTemp = buscarEmpleado(op2);
        return empleadoTemp;
    }
}
