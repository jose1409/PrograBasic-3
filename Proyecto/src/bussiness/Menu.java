package bussiness;

import presentation.Gui;
import data.Logic;
import domain.Clientes;
import domain.Empleados;
import domain.Atracciones;
import javax.swing.JOptionPane;

public class Menu {

    //Inicializacion de variables
    String option;
    Gui gui;
    Logic logic;
    Clientes ac = new Clientes();
    Empleados Em = new Empleados();
    Atracciones at = new Atracciones();
    Facturacion fa = new Facturacion(at, ac, Em);

    //Constructor
    public Menu() {
        gui = new Gui();
        logic = new Logic();
        option = "";
        start();
    }
    
    //Sirve para verificacion de existencias a la hora de enlazar
    public void enlazado() {
        try {
            Em.enlazar(at);
        } catch (Exception E) {
            gui.errorMesage("No existen datos suficientes");
        }
    }

    //Menu
    public void start() {
        boolean test = true;
        while (test) {
            option = gui.input(
                    "Bienvenido al Parque de Atracciones\n"
                    + "1. Clientes\n"
                    + "2. Empleados\n"
                    + "3. Atracciones\n"
                    + "4. Asignar Atraccion\n"
                    + "5. Facturas\n"
                    + "6. Salir\n"
            );
            if (logic.verifyInt(option)) {
                int option2 = Integer.parseInt(option);
                switch (option2) {
                    case 1:
                        subClientes();
                        break;
                    case 2:
                        subEmpleados();
                        break;
                    case 3:
                        subAtracciones();
                        break;
                    case 4:
                        enlazado();
                        break;
                    case 5:
                        subFacturas();
                        break;
                    case 6:
                        gui.print("Gracias por preferirnos, vuelva pronto");
                        test = false;
                        break;
                    default:
                        gui.print("Error: Digita un numero del 1 al 5");
                }

            } else {
                gui.errorMesage("Tiene que digitar un numero valido");
            }

        }
    }

    //Submenu Clientes
    public void subClientes() {
        boolean test = true;
        while (test) {
            option = gui.input("¿Que desea realizar?"
                    + "\n1. Agregar"
                    + "\n2. Consultar"
                    + "\n3. Inactivar"
                    + "\n4. Activar"
                    + "\n5. Volver al Menu"
            );
            if (logic.verifyInt(option)) {
                int option2 = Integer.parseInt(option);
                switch (option2) {
                    case 1:
                        ac.agregarClientes();
                        break;
                    case 2:
                        ac.mostrar();
                        break;
                    case 3:
                        ac.inactivar();
                        break;
                    case 4:
                        ac.activar();
                        break;
                    case 5:
                        test = false;
                        break;
                    default:
                        gui.print("Error: Digita un numero del 1 al 5");

                }
            } else {
                gui.errorMesage("Tiene que digitar un numero valido");
            }
        }
    }

    //Submenu Clientes
    public void subAtracciones() {
        boolean test = true;
        while (test) {
            option = gui.input("¿Que desea realizar?"
                    + "\n1. Agregar"
                    + "\n2. Consultar"
                    + "\n3. Editar"
                    + "\n4. Inactivar"
                    + "\n5. Activar"
                    + "\n6. Volver al Menu"
            );
            if (logic.verifyInt(option)) {
                int option2 = Integer.parseInt(option);
                switch (option2) {
                    case 1:
                        at.agregarAtracciones();
                        break;
                    case 2:
                        at.mostrar();
                        break;
                    case 3:
                        at.editar();
                        break;
                    case 4:
                        at.inactivar();
                        break;
                    case 5:
                        at.activar();
                        break;
                    case 6:
                        test = false;
                        break;
                    default:
                        gui.print("Error: Digita un numero del 1 al 4");

                }
            } else {
                gui.errorMesage("Tiene que digitar un numero valido");
            }
        }
    }

    public void subEmpleados() {
        boolean test = true;
        while (test) {
            option = gui.input("¿Qué desea realizar?"
                    + "\n1. Agregar Empleado"
                    + "\n2. Mostrar Empleados"
                    + "\n3. Inactivar Empleado"
                    + "\n4. Activar Empleado"
                    + "\n5. Volver al Menú Principal"
            );
            if (logic.verifyInt(option)) {
                int option2 = Integer.parseInt(option);
                switch (option2) {
                    case 1:
                        Em.agregarEmpleado();
                        break;
                    case 2:
                        Em.mostrarActivos();
                        break;
                    case 3:
                        Em.inactivar();
                        break;
                    case 4:
                        Em.activar();
                        break;
                    case 5:
                        test = false;
                        break;
                    default:
                        gui.print("Error: Digite un número del 1 al 5");
                }
            } else {
                gui.print("Error: Tiene que digitar un número válido");
            }
        }
    }
    
    public void subFacturas(){
        boolean test = true;
        while (test) {
            option = gui.input("¿Que desea realizar?"
                    + "\n1. Agregar"
                    + "\n2. Consultar"
                    + "\n3. Inactivar"
                    + "\n4. Volver al Menu"
            );
            
            if (logic.verifyInt(option)) {
                int option2 = Integer.parseInt(option);
                switch (option2) {
                    case 1:
                        fa.crearFactura();
                        break;
                    case 2:
                        fa.mostrarFacturas();
                        break;
                    case 3:
                        fa.anularFactura();
                        break;
                    case 4:
                        test = false;
                        break;
                    default:
                        gui.print("Error: Digita un numero del 1 al 4");

                }
            } else {
                gui.errorMesage("Tiene que digitar un numero valido");
            }
        }
    }

}
