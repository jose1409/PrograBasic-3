package bussiness;

import domain.Atracciones;
import domain.Clientes;
import domain.Empleados;
import presentation.Gui;

public class Facturacion {

    //Inicializacion de Variables
    private int codigo;
    private String fecha;
    private int precioTotal;
    private Atracciones atraccion;
    private Clientes cliente;
    private Empleados empleado;
    private boolean estado;
    private Facturacion listaFacturas[] = new Facturacion[10];
    private Atracciones atraccionesCompra[] = new Atracciones[10];
    Gui gui;

    //Constructor
    public Facturacion(Atracciones atraccion, Clientes cliente, Empleados empleado) {
        this.empleado = empleado;
        this.cliente = cliente;
        this.atraccion = atraccion;
        this.fecha = "";
        this.codigo = 0;
        this.precioTotal = 0;
        this.estado = true;
        gui = new Gui();
    }

    public Facturacion() {
        gui = new Gui();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Atracciones getAtraccion() {
        return atraccion;
    }

    public void setAtraccion(Atracciones atraccion) {
        this.atraccion = atraccion;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Facturacion[] getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(Facturacion[] listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public void crearFactura() {
        Clientes clienteTemp = null;
        Empleados empleadoTemp = null;
        for (int i = 0; i < listaFacturas.length; i++) {
            if (listaFacturas[i] == null) {
                Facturacion c = new Facturacion();
                c.setCodigo((byte) (i + 1));
                c.setFecha(gui.input("Ingresa la fecha"));

                //Se selecciona el cliente
                clienteTemp = cliente.comboBox();
                c.setCliente(clienteTemp);

                //Se selecciona el empleado
                empleadoTemp = empleado.comboBox();
                c.setEmpleado(empleadoTemp);

                //Se seleccionan las atracciones a comprar
                boolean temp = true;
                while (temp) {
                    int caso = Integer.parseInt(gui.input("1: comprar boletos\n2: Terminar"));
                    switch (caso) {
                        case 1:
                            AgregarCompra(atraccion.comboBox());
                            break;
                        case 2:
                            calcularPrecio(c);
                            temp = false;
                            break;
                        default:
                            gui.errorMesage("Opcion incorrecta");
                            break;
                    }
                }

                i = listaFacturas.length;
                agregarFactura(c);
            }

        }
    }

    public void anularFactura() {
        byte i;
        try {
            int opcion = Integer.parseInt(gui.input("Seleccion el ID del usuario que desea activar\n"
                    + "hola"));
        }catch (NumberFormatException e) {
            gui.errorMesage("Tiene que digitar un ID, volviendo al Submenu");
        }
    }

    private void AgregarCompra(Atracciones atraccion) {
        for (int i = 0; i < atraccionesCompra.length; i++) {
            if (atraccionesCompra[i] == null) {
                atraccionesCompra[i] = atraccion;
                i = atraccionesCompra.length;
            }
        }
    }

    private void calcularPrecio(Facturacion c) {
        for (int i = 0; i < atraccionesCompra.length; i++) {
            if (atraccionesCompra[i] != null) {
                c.setPrecioTotal(c.getPrecioTotal() + atraccionesCompra[i].getPrecio());
            } else {
                i = atraccionesCompra.length;
            }
        }
    }

    private void agregarFactura(Facturacion c) {
        for (int i = 0; i < listaFacturas.length; i++) {
            if (listaFacturas[i] == null) {
                listaFacturas[i] = c;
                i = listaFacturas.length;
            }
        }
    }

    public void mostrarFacturas() {
        String s = "";
        for (int i = 0; i < listaFacturas.length; i++) {
            if (listaFacturas[i] != null) {
                s += "No Factura: " + listaFacturas[i].getCodigo()
                        + "\nFacturado por: " + listaFacturas[i].getEmpleado().getNombre() + " " + listaFacturas[i].getEmpleado().getApellidos()
                        + "\nFecha: " + listaFacturas[i].getFecha()
                        + "\nAtracciones:\n" + atraccioncontar()
                        + "\nA nombre de: " + listaFacturas[i].getCliente().getNombre() + " " + listaFacturas[i].getCliente().getApellido()
                        + "\nPrecio a pagar: " + listaFacturas[i].getPrecioTotal() + "\n";
            }
        }
        gui.print(s);
    }

    public String atraccioncontar() {
        String s = "";
            for (int i = 0; i < atraccionesCompra.length; i++) {
                // Verificar si la atracción actual no es null antes de acceder a sus métodos
                if (atraccionesCompra[i] != null) {
                    s += atraccionesCompra[i].getNombre() + " - $" + atraccionesCompra[i].getPrecio() + "\n";
                }
            }
        return s;
    }
}
