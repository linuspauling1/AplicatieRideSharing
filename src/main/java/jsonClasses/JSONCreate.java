package jsonClasses;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSONCreate {
    public static void createCustomerFile() {
        JSONObject obj1 = new JSONObject();
        obj1.put("username", "catalin");
        obj1.put("password", JSONFile.encrypt("botean"));
        obj1.put("CNP","1234567891012");
        obj1.put("Adresa","Lugoj");
        obj1.put("Telefon","0712345678");
        JSONObject obj6 = new JSONObject();
        obj6.put("customer :",obj1);

        JSONObject obj2 = new JSONObject();
        obj2.put("username", "paul");
        obj2.put("password", JSONFile.encrypt("banu"));
        obj2.put("CNP","1244567891012");
        obj2.put("Adresa","Timisoara");
        obj2.put("Telefon","0722345678");
        JSONObject obj7 = new JSONObject();
        obj7.put("customer :",obj2);

        JSONObject obj3 = new JSONObject();
        obj3.put("username", "lidia");
        obj3.put("password", JSONFile.encrypt("szm"));
        obj3.put("CNP","1235567891012");
        obj3.put("Adresa","Lugoj");
        obj3.put("Telefon","0713345678");
        JSONObject obj8 = new JSONObject();
        obj8.put("customer :",obj3);

        JSONObject obj4 = new JSONObject();
        obj4.put("username", "cosmin");
        obj4.put("password", JSONFile.encrypt("marsavina"));
        obj4.put("CNP","1236567891012");
        obj4.put("Adresa","Timisoara");
        obj4.put("Telefon","0715345678");
        JSONObject obj9 = new JSONObject();
        obj9.put("customer :",obj4);

        JSONObject obj5 = new JSONObject();
        obj5.put("username", "dana");
        obj5.put("password", JSONFile.encrypt("bosoanca"));
        obj5.put("CNP","1334567891012");
        obj5.put("Adresa","Orsova");
        obj5.put("Telefon","0792345678");
        JSONObject obj10 = new JSONObject();
        obj10.put("customer :",obj5);

        JSONArray list = new JSONArray();
        list.add(obj6);
        list.add(obj7);
        list.add(obj8);
        list.add(obj9);
        list.add(obj10);
        try {
            FileWriter file = new FileWriter("src/main/resources/customers.json");
            file.write(list.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void createDriverFile() {
        JSONObject obj1 = new JSONObject();
        obj1.put("username", "alex");
        obj1.put("password", JSONFile.encrypt("borza"));
        obj1.put("CNP","1234577891012");
        obj1.put("NumarInmatriculare","TM10ABC");
        obj1.put("Masina", "Audi");
        JSONObject obj6 = new JSONObject();
        obj6.put("customer :",obj1);

        JSONObject obj2 = new JSONObject();
        obj2.put("username", "andreea");
        obj2.put("password", JSONFile.encrypt("mihaela"));
        obj2.put("CNP","1234567881012");
        obj2.put("NumarInmatriculare","TM11ABC");
        obj2.put("Masina", "BMW");
        JSONObject obj7 = new JSONObject();
        obj7.put("customer :",obj2);

        JSONObject obj3 = new JSONObject();
        obj3.put("username", "ion");
        obj3.put("password", JSONFile.encrypt("popescu"));
        obj3.put("CNP","1234567999012");
        obj3.put("NumarInmatriculare","TM12ABC");
        obj3.put("Masina", "Opel");
        JSONObject obj8 = new JSONObject();
        obj8.put("customer :",obj3);

        JSONObject obj4 = new JSONObject();
        obj4.put("username", "adi");
        obj4.put("password", JSONFile.encrypt("brisan"));
        obj4.put("CNP","1234567791012");
        obj4.put("NumarInmatriculare","TM13ABC");
        obj4.put("Masina", "Mercedes");
        JSONObject obj9 = new JSONObject();
        obj9.put("customer :",obj4);


        JSONArray list = new JSONArray();
        list.add(obj6);
        list.add(obj7);
        list.add(obj8);
        list.add(obj9);
        try {
            FileWriter file = new FileWriter("src/main/resources/drivers.json");
            file.write(list.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public static void main(String args[]) throws Exception {
        new JSONFile();
        createCustomerFile();
        createDriverFile();
    }*/
}
