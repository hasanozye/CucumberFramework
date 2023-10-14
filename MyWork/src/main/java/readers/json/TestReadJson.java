package readers.json;

import com.mongodb.util.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestReadJson {

    @Test
    public void readConfig1() throws Exception {

        //okunacak json dosyası
        String file = "src/test/resources/datafiles/Config1.json";

        // Config1.json JSONObject olarak okunuyor.
//        JSONObject object = (JSONObject) JSONValue.parse(new FileReader(file));
        JSONObject object = (JSONObject) new JSONParser().parse(new FileReader(file));
        System.out.println(object);
        System.out.println("-".repeat(25));
        System.out.println(object.get("url"));
        System.out.println(object.get("username"));
        System.out.println(object.get("password"));

    }

    @Test
    public void readConfig2() throws Exception {
        String file = "src/test/resources/datafiles/Config2.json";
        JSONObject json2 = (JSONObject) new JSONParser().parse(new FileReader(file));
        JSONObject json = (JSONObject) new JSONParser().parse(new FileReader(file));
        System.out.println(json.get("types"));

        // array olan type değerini JSONArray'a atıyorum
        JSONArray types = (JSONArray) json.get("types");
        for (var type : types) {
            System.out.println(type);
        }

        System.out.println("-".repeat(32));
        JSONArray users = (JSONArray) json.get("users");



        for (Object user : users) {
            JSONObject userObj = (JSONObject) user;
            System.out.println(userObj.get("username"));
        }

    }
}
