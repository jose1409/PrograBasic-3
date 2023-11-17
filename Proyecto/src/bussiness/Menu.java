package bussiness;

import presentation.Gui;
import data.Logic;
import domain.Clientes;

public class Menu {

    //Inicializacion de variables
    String option;
    Gui gui;
    Logic logic;
    Clientes ac = new Clientes();

    //Constructor
    public Menu() {
        gui = new Gui();
        logic = new Logic();
        option = "";
        start();
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
                    + "4. Facturas\n"
                    + "5. Salir\n"
            );
            if (logic.verifyInt(option)) {
                int option2 = Integer.parseInt(option);
                switch (option2) {
                    case 1:
                        subClientes();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        gui.print("Gracias por preferirnos, vuelva pronto");
                        test = false;
                        break;
                    case 6:
                        break;
                    default:
                        gui.print("Error: Digita un numero del 1 al 5");
                }

            } else {
                gui.print("Error: Tiene que digitar un numero valido");
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
                        gui.print("Error: Digita un numero del 1 al 4");

                }
            } else {
                gui.print("Error: Tiene que digitar un numero valido");
            }
        }
    }
}
