package graphicalUserInterface.customerPage;

import DOM.Parser;
import dataStructures.Client;
import dataStructures.ComandaEfectuata;

import java.util.ArrayList;

public class ComenzileMele {
    private Client client;
    private static ArrayList<ComandaEfectuata> comandaDeAfisat;
    public ComenzileMele(Client client) {
        this.client = client;
        comandaDeAfisat = Parser.getEfectuate();
        if(comandaDeAfisat != null){
            for(ComandaEfectuata tmp: comandaDeAfisat){
                if(tmp.getClient().equals(client))
                    System.out.println(tmp);}
        }
    }
}
