package dataStructures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComandaEfectuata extends ComandaNepreluata {
    private int pret;
    private int distanta;
    private Sofer sofer;
    private String review;
    private String fullDate;
    private Date realDate;

    public final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

    public ComandaEfectuata(Client client, int an, int luna, int zi, int ora, int minut, int secunda, String locatie, String destinatie, Sofer sofer, int pret, int distanta) {
        super(client, an, luna, zi, ora, minut, secunda, locatie, destinatie);
        this.sofer = sofer;
        this.fullDate = an + "/" + luna + "/" + zi + "/" + ora + "/" + minut + "/" + secunda;
        setPret(pret);
        setDistanta(distanta);
        setReview("                    - ");
    }

    public ComandaEfectuata(Client client, int an, int luna, int zi, int ora, int minut, int secunda,
                            String locatie, String destinatie, Sofer sofer, int pret, int distanta,
                            String review) {
        super(client, an, luna, zi, ora, minut, secunda, locatie, destinatie);
        this.sofer = sofer;
        this.fullDate = an + "/" + luna + "/" + zi + "/" + ora + "/" + minut + "/" + secunda;
        setPret(pret);
        setDistanta(distanta);
        setReview(review);
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
        if (sofer == null)
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

    public void setReview(String review) {
        this.review = review;
    }

    public String getReview() {
        return review;
    }

    public String getFullDate() {
        return fullDate;
    }

    public Sofer getSofer() {
        return sofer;
    }

    public String addChar(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }//needed for the next method

    public Date parseDateTime(String dateStr) {
        try {
            return DATE_TIME_FORMAT.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

}
