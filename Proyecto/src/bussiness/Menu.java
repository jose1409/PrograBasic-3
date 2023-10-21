package bussiness;

import presentation.Gui;
import data.Logic;

public class Menu {

    //Inicializacion de variables
    int option;
    Gui gui;
    Logic logic;

    //Constructor
    public Menu() {
        gui = new Gui();
        logic = new Logic();
        option = 0;
        start();
    }

    //Menu
    public void start() {
        boolean test = true;
        while (test) {
            option = Integer.parseInt(gui.input("Menu de prueba\n"
                    + "1. Agregar Usuario\n"
                    + "2. Agregar Empleado\n"
                    + "3. Agregar Atraccion\n"
                    + "4.Consultar Usuario\n"
                    + "5.Consultar Empleado\n"
                    + "6.Consultar Atraccion"));
            if (logic.verifyInt(option)) {
                switch (option) {
                    case 1:
                        gui.print("hola");
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    default:
                        gui.print("Error: Digita un numero de los anteriores");
                }

            } else {
                gui.print("Error: Tiene que digitar un numero");
            }

        }
    }
}
