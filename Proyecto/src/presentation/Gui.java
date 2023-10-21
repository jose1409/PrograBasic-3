package presentation;

import domain.Atracciones;
import domain.Empleados;
import domain.Clientes;
import javax.swing.JOptionPane;

public class Gui {

    public void print(String tex) {
        JOptionPane.showMessageDialog(null, tex);
    }

    public String input(String tex){
        return JOptionPane.showInputDialog(null,tex);
    }

}
