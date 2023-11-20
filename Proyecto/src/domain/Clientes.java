package domain;

import presentation.Gui;

public class Clientes {
    
    //Inicializacion de Variables
    private byte id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;
    private boolean estado;
    private Clientes listaClientes[] = new Clientes[10];
    Gui gui;
    
    //Constructor
    public Clientes() {
        this.nombre = "";
        this.apellido = "";
        this.usuario = "";
        this.contraseña = "";
        this.id = 0;
        this.estado = false;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //Funcion conjunta para agregar clientes
    public void agregarClientes() {
        fullList(listaClientes);
    }
    
    //Funcion conjunta para agregar clientes
    public boolean fullList(Clientes clientes[]) {
        boolean test = false;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                Clientes c = new Clientes();
                c.setId((byte) (i + 1));
                c.setApellido(gui.input("Digite sus Apellidos Completos: "));
                c.setNombre(gui.input("Digite Su nombre: "));
                c.setUsuario(gui.input("Digite su nickname/usuario: "));
                c.setContraseña(gui.input("Digite su Contraseña: "));
                c.setEstado(true);
                listaClientes[i] = c;
                test = true;
                i = clientes.length;
            } else {
                if (clientes[9] != null) {
                    gui.print("La lista esta llena, debes eliminar algun usuario ya existente");
                    i = clientes.length;
                }
            }

        }
        return test;
    }
    
    //Funcion para mostrar todos los clientes existentes
    public void mostrar() {
        String s = "Total de Clientes:";
        for (byte i = 0; i < listaClientes.length; i++) {
            if (listaClientes[i] != null) {
                String estado;
                if (listaClientes[i].isEstado()) {estado = "Activo";} else {estado = "Inactivo";}
                s += "\nId: #" + listaClientes[i].getId()
                        + "\nNombre Completo: " + listaClientes[i].getNombre() + " " + listaClientes[i].apellido
                        + "\nUsuario: " + listaClientes[i].getUsuario()
                        + "\nContraseña: " + listaClientes[i].getContraseña()
                        + "\nEstado: " + estado + "\n";

            }
        }
        gui.print(s);
    }
    
    //Funcion conjunta con activar, muestra todos los clientes que se encuentran activos.
    public void mostrarActivos() {
        String s = "Total de Clientes:";
        for (byte i = 0; i < listaClientes.length; i++) {
            if (listaClientes[i] != null && listaClientes[i].isEstado()) {
                s += "\nId: #" + listaClientes[i].getId()
                        + "\nNombre Completo: " + listaClientes[i].getNombre() + " " + listaClientes[i].apellido
                        + "\nUsuario: " + listaClientes[i].getUsuario()
                        + "\nContraseña: " + listaClientes[i].getContraseña();
            }
        }
        gui.print(s);
    }
    
    //Funcion conjunta con Inactivar, muestra todos los clientes que se encuentran inactivos
    public void mostrarInactivos() {
        String s = "Total de Clientes:";
        for (byte i = 0; i < listaClientes.length; i++) {
            if (listaClientes[i] != null && listaClientes[i].isEstado() == false) {
                s += "\nId: #" + listaClientes[i].getId()
                        + "\nNombre Completo: " + listaClientes[i].getNombre() + " " + listaClientes[i].apellido
                        + "\nUsuario: " + listaClientes[i].getUsuario()
                        + "\nContraseña: " + listaClientes[i].getContraseña();
            }
        }
        gui.print(s);
    }
    
    //Funcion Inactivar, sirve para inactivar usuarios 
    public void inactivar() {
        gui.print("Aqui se mostraran los usuarios activos: Por favor digite el usuario que desea inactivar\n");
        mostrarActivos();
        byte opcion = Byte.parseByte(gui.input("Seleccione el ID: "));
        byte i;
        for (i = 0; i < listaClientes.length; i++) {
            if (listaClientes[i] != null && opcion == listaClientes[i].getId()) {
                if (listaClientes[i].isEstado() == false) {
                    gui.print("Error: El usuario ya esta Inactivo, volviendo al Submenu");
                    break;
                } else {
                    listaClientes[i].setEstado(false);
                    gui.print("Usuario #" + listaClientes[i].getId() + " ha sido Inactivado con éxito");
                    break; // Sale del bucle ya que se encontró y modificó el usuario
                }
            }
        }

        if (i == listaClientes.length) {
            // Si el bucle se ejecutó completamente y no se encontró el usuario
            gui.print("Usuario con ID " + opcion + " no encontrado");
        }

    }
    
    //Funcion activar, los usuarios que se hayan inactivado se podran volver a activar con esta funcion
    public void activar() {
        //Verificar si ya estan todos activos
        gui.print("Aqui se mostraran los usuarios Inactivos: Por favor digite el usuario que desea inactivar\n");
        mostrarInactivos();
        byte opcion = Byte.parseByte(gui.input("Seleccione el ID: "));
        byte i;
        for (i = 0; i < listaClientes.length; i++) {
            if (listaClientes[i] != null && opcion == listaClientes[i].getId()) {
                if (listaClientes[i].isEstado()) {
                    gui.print("Error: El usuario ya esta activado, volviendo al Submenu");
                    break;
                } else {
                    listaClientes[i].setEstado(true);
                    gui.print("Usuario #" + listaClientes[i].getId() + " ha sido Activado con éxito");
                    break; // Sale del bucle ya que se encontró y modificó el usuario
                }
            }
        }

        if (i == listaClientes.length) {
            // Si el bucle se ejecutó completamente y no se encontró el usuario
            gui.print("Usuario con ID " + opcion + " no encontrado");
        }
    }
}
