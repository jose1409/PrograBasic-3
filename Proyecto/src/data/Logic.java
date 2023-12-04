package data;

public class Logic {

    //Verificar existencia de dato Int con booleanos
    public boolean verifyInt(String dato) {

        try {
            Integer.parseInt(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
