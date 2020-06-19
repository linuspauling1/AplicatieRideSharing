package jsonClasses;

import Exceptions.CNPException;
import dataStructures.Client;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class JSONClient {
    public static ArrayList<Client> getClient(){
        JSONArray list=JSONFile.readFromFiles("src/main/resources/customers.json");
        ArrayList<Client> clienti = new ArrayList<Client>();
        Iterator<JSONObject> it = list.iterator();
        while(it.hasNext()) {
            JSONObject obj = it.next();
            JSONObject objInt = (JSONObject) obj.get("customer :");
            Client c = new Client((String)objInt.get("username"),(String)objInt.get("password"));
            c.setAdresa((String)objInt.get("Adresa"));
            try {
                c.setCNP((String)objInt.get("CNP"));
            } catch (CNPException e) {
            }
            c.setTelefon((String)objInt.get("Telefon"));
            clienti.add(c);
        }
        return clienti;
    }
    public static Client findClient(String userClient){
        for(Client tmp:getClient())
            if(tmp.getUsername().equals(userClient))
                return tmp;
        return null;
    }
}
