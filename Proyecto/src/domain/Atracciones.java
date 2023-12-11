package domain;

import javax.swing.JOptionPane;
import presentation.Gui;

public class Atracciones {

    private byte id;
    private String nombre;
    private String catalogo;
    private String tiempoJuego;
    private int precio;
    private boolean estado;
    private Empleados empleado = null;
    private Atracciones listaAtracciones[] = new Atracciones[10];
    private boolean ocupado;
    Gui gui;

    public Atracciones() {
        this.id = 0;
        this.nombre = "";
        this.catalogo = "";
        this.tiempoJuego = "";
        this.precio = 0;
        this.estado = false;
        gui = new Gui();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public String getTiempoJuego() {
        return tiempoJuego;
    }

    public void setTiempoJuego(String tiempoJuego) {
        this.tiempoJuego = tiempoJuego;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    //Funcion que sirve para verificar que no se dejen espacios en blanco durante la creacion de atracciones
    public boolean verificarDatos(String... datos) {
        for (String dato : datos) {
            if (dato.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    //Funcion para seleccionar el catalogo correspondiente
    public String catalogo() {
        String opciones[] = {"Atracciones Adrenalina", "Atracciones Familiares", "Atracciones Infantiles"};
        String op = (String) JOptionPane.showInputDialog(null, "Elija uno de los catálogos: ", "Catálogos Disponibles", JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        return op;
    }

    public boolean verificarDobles(String name) {
        for (int i = 0; i < listaAtracciones.length; i++) {
            if (listaAtracciones[i] != null) {
                if (listaAtracciones[i].getNombre().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Funcion para agregar Atracciones
    public void agregarAtracciones() {
        boolean test = true;
        for (int i = 0; i < listaAtracciones.length; i++) {
            if (listaAtracciones[i] == null) {
                Atracciones c = new Atracciones();
                c.setId((byte) (i + 1));
                while (test) {
                    c.setNombre(gui.input("Digite el nombre de la Atraccion: "));
                    if (verificarDobles(c.getNombre())) {
                        gui.errorMesage("La atraccion ya existe, intente nuevamente");
                    } else {
                        test = false;
                    }
                }
                c.setCatalogo(catalogo());
                c.setTiempoJuego(gui.input("Digite el tiempo aproximado de uso del Juego: (hh/mm)"));
                c.setPrecio(Integer.parseInt(gui.input("Digite el precio por entrada de la atraccion: ")));
                c.setEstado(true);
                if (verificarDatos(c.getNombre(), c.getTiempoJuego(), c.getTiempoJuego(), String.valueOf(c.getPrecio()))) {
                    listaAtracciones[i] = c;
                    i = listaAtracciones.length;
                } else {
                    gui.errorMesage("Tiene que digitar todos los datos solicitados "
                            + "y no dejar datos en blanco, intentelo mas tarde");
                    i = listaAtracciones.length;
                }
            } else {
                if (listaAtracciones[9] != null) {
                    gui.print("La lista esta llena, debes eliminar alguna atraccion ya existente");
                    i = listaAtracciones.length;
                }
            }
        }
    }

    //Funcion para mostrar todas las atracciones existentes
    public void mostrar() {
        String s = "";
        for (byte i = 0; i < listaAtracciones.length; i++) {
            if (listaAtracciones[i] != null) {
                String status;
                String employer;
                if (listaAtracciones[i].getEmpleado() == null) {
                    employer = "No posee empleados a cargo";
                } else {
                    employer = listaAtracciones[i].getEmpleado().getNombre();
                }
                if (listaAtracciones[i].isEstado()) {
                    status = "Activo";
                } else {
                    status = "Inactivo";
                }
                s += "Id: #" + listaAtracciones[i].getId()
                        + "\nNombre: " + listaAtracciones[i].getNombre()
                        + "\nCatalogo: " + listaAtracciones[i].getCatalogo()
                        + "\nTiempo de Juego: " + listaAtracciones[i].getTiempoJuego() + "min"
                        + "\nEstado: " + status
                        + "\nPrecio de la Atraccion: " + listaAtracciones[i].getPrecio()
                        + "\nEmpleado a Cargo: " + employer + "\n\n";
            }
        }
        if (s.isEmpty()) {
            gui.errorMesage("No existen Usuarios Activos actualmente");
        } else {
            gui.print(s);
        }
    }

    //Funcion conjunta con activar, muestra todas las atracciones que se encuentran activos.
    public String mostrarActivos() {
        String s = "";
        for (byte i = 0; i < listaAtracciones.length; i++) {
            if (listaAtracciones[i] != null && listaAtracciones[i].isEstado()) {
                s += "Id: #" + listaAtracciones[i].getId()
                        + "\nNombre: " + listaAtracciones[i].getNombre()
                        + "\nCatalogo: " + listaAtracciones[i].getCatalogo()
                        + "\nTiempo de Juego: " + listaAtracciones[i].getTiempoJuego() + "\n";
            }
        }
        return s;
    }

    //Funcion conjunta con Inactivar, muestra todos los clientes que se encuentran inactivos
    public String mostrarInactivos() {
        String s = "";
        for (byte i = 0; i < listaAtracciones.length; i++) {
            if (listaAtracciones[i] != null && listaAtracciones[i].isEstado() == false) {
                s += "Id: #" + listaAtracciones[i].getId()
                        + "\nNombre: " + listaAtracciones[i].getNombre()
                        + "\nCatalogo: " + listaAtracciones[i].getCatalogo()
                        + "\nTiempo de Juego: " + listaAtracciones[i].getTiempoJuego();
            }
        }
        return s;
    }

    //Funcion Inactivar, sirve para inactivar la atraccion
    public void inactivar() {
        if (mostrarActivos().isEmpty()) {
            gui.errorMesage("No existen atracciones activas, volviendo al SubMenu");
        } else {
            byte i;
            try {
                int opcion = Integer.parseInt(gui.input("Seleccion el ID de la atraccion que desea inactivar\n"
                        + mostrarActivos()));
                for (i = 0; i < listaAtracciones.length; i++) {
                    if (listaAtracciones[i] != null && opcion == listaAtracciones[i].getId()) {
                        if (listaAtracciones[i].isEstado() == false) {
                            gui.print("Error: La atraccion ya esta inactiva, volviendo al Submenu");
                            break;
                        } else {

                            if (listaAtracciones[i].isOcupado()) {
                                gui.errorMesage("No se puede inactivar porque ya posee un empleado asignado");
                            } else {
                                listaAtracciones[i].setEstado(false);
                                gui.print("Atraccion #" + listaAtracciones[i].getId() + " ha sido Inactivada con éxito");
                            }
                            break;
                        }
                    }
                }

                if (i == listaAtracciones.length) {
                    // Si el bucle se ejecutó completamente y no se encontró la atraccion
                    gui.print("Atraccion con ID " + opcion + " no encontrado, volviendo al Submenu");
                }
            } catch (NumberFormatException e) {
                gui.errorMesage("Tiene que digitar un ID, volviendo al Submenu");
            }
        }
    }

    //Funcion activar, las atracciones que se hayan inactivado se podran volver a activar con esta funcion
    public void activar() {
        if (mostrarInactivos().isEmpty()) {
            gui.errorMesage("No existen atracciones inactivas, volviendo al SubMenu");
        } else {
            byte i = 0;
            try {
                int opcion = Integer.parseInt(gui.input("Seleccione el ID de la atraccion que desea inactivar\n"
                        + mostrarInactivos()));
                for (i = 0; i < listaAtracciones.length; i++) {
                    if (listaAtracciones[i] != null && opcion == listaAtracciones[i].getId()) {
                        if (listaAtracciones[i].isEstado()) {
                            gui.print("Error: La atraccion seleccionada ya esta activada, volviendo al Submenu");
                            break;
                        } else {
                            listaAtracciones[i].setEstado(true);
                            gui.print("Atraccion #" + listaAtracciones[i].getId() + " ha sido activada con éxito");
                            break;
                        }
                    }
                }
                if (i == listaAtracciones.length) {
                    // Si el bucle se ejecutó completamente y no se encontró la atraccion
                    gui.print("Atraccion con ID " + opcion + " no encontrado");
                }
            } catch (NumberFormatException e) {
                gui.errorMesage("Tiene que digitar un ID, volviendo al Submenu");
            }
        }
    }

    public void editar() {
        Atracciones atraccion = null;
        String opciones[] = new String[contarNulos()];
        llenaNombres(opciones);
        String op = (String) JOptionPane.showInputDialog(null, "Eliga la Atraccion: ", "Atracciones", JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        atraccion = buscarAtraccion(op);
        atraccion.setNombre(gui.edit("Editar nombre: ", atraccion.getNombre()));
        atraccion.setCatalogo(catalogo());
        atraccion.setTiempoJuego(gui.edit("Editar Tiempo de Juego: ", atraccion.getTiempoJuego()));
        atraccion.setPrecio(Integer.parseInt(gui.edit("Editar precio: ", String.valueOf(atraccion.getPrecio()))));

    }

    public void llenaNombres(String... datos) {
        for (int i = 0; i < listaAtracciones.length; i++) {
            if (listaAtracciones[i] != null) {
                datos[i] = listaAtracciones[i].nombre;
            }
        }
    }

    public int contarNulos() {
        int cont = 0;
        for (int i = 0; i < listaAtracciones.length; i++) {
            if (listaAtracciones[i] != null) {
                cont++;
            }
        }
        return cont;
    }

    public Atracciones buscarAtraccion(String nombre) {
        Atracciones atraccion = null;
        for (int i = 0; i < listaAtracciones.length; i++) {
            if (listaAtracciones[i] != null) {
                if (listaAtracciones[i].getNombre().equals(nombre)) {
                    atraccion = listaAtracciones[i];
                    i = listaAtracciones.length;
                }
            }
        }
        return atraccion;
    }
    
    public Atracciones comboBox(){
        Atracciones atraccionTemp = null;
        String opciones[] = new String[contarNulos()];
        llenaNombres(opciones);
        String op = (String) JOptionPane.showInputDialog(null, "Eliga la Atraccion: ", "Atracciones", JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        atraccionTemp = buscarAtraccion(op);
        return atraccionTemp;
    }
}
