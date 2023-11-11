package domain;

import presentation.Gui;

public class Clientes {

    private byte id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;
    private boolean estado;
    private Clientes listaClientes[] = new Clientes[10];
    Gui gui;

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

    public void agregarClientes() {
        fullList(listaClientes);
    }

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

    public void mostrar() {
        int i;
        String s = "Total de Clientes:";
        for (i = 0; i < listaClientes.length; i++) {
            if (listaClientes[i] != null) {
                s += "\nId: #" + listaClientes[i].getId()
                        + "\nNombre Completo: " + listaClientes[i].getNombre() + " " + listaClientes[i].apellido
                        + "\nUsuario: " + listaClientes[i].getUsuario()
                        + "\nContraseña: " + listaClientes[i].getContraseña();
            }
        }
        gui.print(s);
    }

    public void mostrarActivos() {
        int i;
        String s = "Total de Clientes:";
        for (i = 0; i < listaClientes.length; i++) {
            if (listaClientes[i] != null && listaClientes[i].isEstado()) {
                s += "\nId: #" + listaClientes[i].getId()
                        + "\nNombre Completo: " + listaClientes[i].getNombre() + " " + listaClientes[i].apellido
                        + "\nUsuario: " + listaClientes[i].getUsuario()
                        + "\nContraseña: " + listaClientes[i].getContraseña();
            }
        }
        gui.print(s);
    }

    public void inactivar() {
        gui.print("Aqui se mostraran los usuarios activos: Por favor digite el usuario que desea inactivar\n");
        mostrarActivos();
        byte opcion = Byte.parseByte(gui.input("Seleccione el ID:"));
        int i;
        for (i = 0; i < listaClientes.length; i++) {
            if (listaClientes[i] != null && opcion == listaClientes[i].getId()) {
                listaClientes[i].setEstado(false);
                gui.print("Usuario #" + listaClientes[i].getId() + " ha sido Inactivado con éxito");
                break; // Sale del bucle ya que se encontró y modificó el usuario
            }
        }

        if (i == listaClientes.length) {
            // Si el bucle se ejecutó completamente y no se encontró el usuario
            gui.print("Usuario con ID " + opcion + " no encontrado");
        }

    }
}
