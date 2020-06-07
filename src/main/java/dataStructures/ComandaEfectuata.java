package dataStructures;

public class ComandaEfectuata extends ComandaNepreluata {
    private int pret;
    private int distanta;
    private Sofer sofer;

    public ComandaEfectuata(Client client, int an, int luna, int zi, int ora, int minut,int secunda,String locatie,String destinatie,Sofer sofer,int pret,int distanta) {
        super(client, an, luna, zi, ora, minut,secunda,locatie,destinatie);
        this.sofer = sofer;
        setPret(pret);
        setDistanta(distanta);
    }

    public int getPret() {
        return pret;
    }

    private void setPret(int pret) {
        this.pret = pret;
    }

    public int getDistanta() {
        return distanta;
    }

    private void setDistanta(int distanta) {
        this.distanta = distanta;
    }

    public String getUsernameSofer() {
        if(sofer == null)
            return "";
        return sofer.getUsername();
    }

    public String getCNPSofer() {
        return sofer.getCNP();
    }

    public String getNumarInmatriculare() {
        return sofer.getNumarInmatriculare();
    }

    public String getMasina() {
        return sofer.getMasina();
    }

}
