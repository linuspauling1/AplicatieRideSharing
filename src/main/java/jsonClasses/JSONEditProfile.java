package jsonClasses;

import dataStructures.Sofer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class JSONEditProfile {
    public static void writeDriver(String filename, ArrayList<Sofer> soferi){
        JSONArray list = new JSONArray();
        Iterator<Sofer> it=soferi.iterator();
        while(it.hasNext()){
            Sofer aux=it.next();
            JSONObject obj = new JSONObject();
            obj.put("username",aux.getUsername());
            obj.put("password",aux.getPassword());
            obj.put("CNP",aux.getCNP());
            obj.put("NumarInmatriculare",aux.getNumarInmatriculare());
            obj.put("Masina", aux.getMasina());
            JSONObject obj1 = new JSONObject();
            obj1.put("customer :",obj);
            list.add(obj1);
        }
        try {
            FileWriter file = new FileWriter(filename);
            file.write(list.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Sofer> getDriver(){
        JSONArray list=JSONFile.readFromFiles("src/main/resources/drivers.json");
        ArrayList<Sofer> soferi=new ArrayList<Sofer>();
        Iterator<JSONObject> it=list.iterator();
        while(it.hasNext()) {
            JSONObject obj = it.next();
            JSONObject objInt = (JSONObject) obj.get("customer :");
            Sofer s=new Sofer((String)objInt.get("username"),(String)objInt.get("password"));
            s.setMasina((String)objInt.get("Masina"));

                s.setCNP((String)objInt.get("CNP"));

            s.setNumarInmatriculare((String)objInt.get("NumarInmatriculare"));
            soferi.add(s);
        }
        return soferi;
    }
    public static Sofer getSofer(String user){
        ArrayList<Sofer> listaSoferi = getDriver();
        for(Sofer tmp: listaSoferi)
            if(tmp.getUsername().equals(user))
                return tmp;
        return null;
    }

}

