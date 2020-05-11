package dataStructures;

public class ComandaNepreluata {

    protected Client client;
    protected int an;
    protected int luna;
    protected int zi;
    protected int ora;
    protected int minut;

    public ComandaNepreluata(Client client,int an,int luna,int zi,int ora,int minut) {
        this.client = client;
        setAn(an);
        setLuna(luna);
        setZi(zi);
        setOra(ora);
        setMinut(minut);
    }

    public String getAdresa() {
        return client.getAdresa();
    }

    public String getTelefon() {
        return client.getTelefon();
    }

    public String getUsernameClient() {
        return client.getUsername();
    }

    public String getCNPClient() {
        return client.getCNP();
    }

    public int getAn() {
        return an;
    }

    private void setAn(int an) {
        this.an = an;
    }

    public int getLuna() {
        return luna;
    }

    private void setLuna(int luna) {
        this.luna = luna;
    }

    public int getZi() {
        return zi;
    }

    private void setZi(int zi) {
        this.zi = zi;
    }

    public int getOra() {
        return ora;
    }

    private void setOra(int ora) {
        this.ora = ora;
    }

    public int getMinut() {
        return minut;
    }

    private void setMinut(int minut) {
        this.minut = minut;
    }

}

