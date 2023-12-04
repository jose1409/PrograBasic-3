package presentation;

import javax.swing.JOptionPane;

public class Gui {

    public void print(String tex) {
        JOptionPane.showMessageDialog(null, tex);
    }

    public String input(String tex) {
        return JOptionPane.showInputDialog(null, tex);
    }

}
