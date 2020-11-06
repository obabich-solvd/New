import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

//just creating a Jason object

public class Main {

    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        object.put("name", "mkyong.com");
        object.put("age", new Integer(100));

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        object.put("messages", list);

        try {
            FileWriter file = new FileWriter("test.json");
            file.write(object.toJSONString());
            file.flush();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("test.json"));

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            System.out.println("name" + name);

            Integer age = (Integer) jsonObject.get("age");
            System.out.println("age" + age);
            JSONArray msg = (JSONArray) jsonObject.get("messages");

            Iterator<Object> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}

