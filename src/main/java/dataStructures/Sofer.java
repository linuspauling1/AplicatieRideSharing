package dataStructures;

public class Sofer extends User{
    private String numarInmatriculare;
    private String masina;
    public Sofer(String username, String password){
        super(username,password);
    }

    public String getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public void setNumarInmatriculare(String numarInmatriculare) {
        this.numarInmatriculare = numarInmatriculare;
    }

    public String getMasina() {
        return masina;
    }

    public void setMasina(String masina) {
        this.masina = masina;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Sofer){
            Sofer aux=(Sofer)o;
            return aux.getUsername().equals(this.getUsername());
        }
        return false;
    }
    @Override
    public String toString() {
        return "Sofer{" +
                "numarInmatriculare='" + numarInmatriculare + '\'' +
                ", masina='" + masina + '\'' +
                '}';
    }
}
