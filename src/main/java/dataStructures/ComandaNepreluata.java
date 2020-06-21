package dataStructures;

public class ComandaNepreluata {

    protected Client client;
    protected int an;
    protected int luna;
    protected int zi;
    protected int ora;
    protected int minut;
    protected int secunda;
    protected String locatie;
    protected String destinatie;

    public ComandaNepreluata(Client client,int an,int luna,int zi,int ora,int minut,int secunda,String locatie,String destinatie) {
        this.client = client;
        setAn(an);
        setLuna(luna);
        setZi(zi);
        setOra(ora);
        setMinut(minut);
        setSecunda(secunda);
        setLocatie(locatie);
        setDestinatie(destinatie);
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


    public int getSecunda() {
        return secunda;
    }

    private void setSecunda(int secunda) {
        this.secunda = secunda;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public Client getClient(){
        return client;
    }

    public String toString(){
        return client.toString() + ", de la: " + locatie + ", pentru: " + destinatie;
    }

    public boolean equals(Object o){
        if(o instanceof  ComandaNepreluata){
            ComandaNepreluata cn = (ComandaNepreluata) o;
            if(this.toString().equals(cn.toString()))
                return true;
            return false;
        }
        else
            return false;
    }
}