package data;

public class Logic {

    //Verificaciones
    
    //Verificar existencia de dato String con booleanos (falta modificaciones)
    public boolean verifyString(String dato) {

        try {
            String.valueOf(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    //Verificar existencia de dato Int con booleanos
    public boolean verifyInt(int dato) {

        try {
            Integer.valueOf(dato);
            return true;
        } catch (Exception e) {
            return false;
        }

        
    }
}