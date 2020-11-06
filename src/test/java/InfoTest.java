import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.testng.annotations.Test;

import javax.xml.transform.Result;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InfoTest {
    Gson gson = new Gson();
    ObjectMapper mapper = new ObjectMapper();
    Info info = new Info();

    @Test
    public void write() throws IOException {
         info.setUuid("uuid");
        info.setPhone("phone");
        info.setEmail("email");
        String newInfo = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(info);

        Files.write(Paths.get("my-file.json"), newInfo.getBytes());
    }

    @Test
    public void readFromString()  {
        String rs = "{\"uuid\":\"uuid33\",\"email\":\"email33\",\"phone\" :\"phone33\"}";
        Info info = gson.fromJson(rs, Info.class);
        System.out.println("uuid" +"  "+ info.getUuid());
        System.out.println("email" +"  "+info.getEmail());
        System.out.println("phone" +"  "+info.getPhone());
    }

    @Test
    public void readFromFile() throws FileNotFoundException {
        Info info = gson.fromJson(new FileReader("my-file.json"), Info.class);
        System.out.println("uuid" + "  " + info.getUuid());
        System.out.println("email" + "  " + info.getEmail());
        System.out.println("phone" + "  " + info.getPhone());
    }
}
