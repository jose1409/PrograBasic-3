package domain;

public class Atracciones {

    private String torre;
    private String pulpo;
    private String martillo;
    private String Conchas;

    public Atracciones() {

        this.martillo = "";
        this.pulpo = "";
        this.torre = "";
        this.Conchas = "";
    }

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }

    public String getPulpo() {
        return pulpo;
    }

    public void setPulpo(String pulpo) {
        this.pulpo = pulpo;
    }

    public String getMartillo() {
        return martillo;
    }

    public void setMartillo(String martillo) {
        this.martillo = martillo;
    }

    public String getConchas() {
        return Conchas;
    }

    public void setConchas(String Conchas) {
        this.Conchas = Conchas;
    }
}
