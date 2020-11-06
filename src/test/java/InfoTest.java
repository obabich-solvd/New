import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InfoTest {

    @Test
    public void write() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Info info = new Info();
        info.setUuid("uuid");
        info.setPhone("phone");
        info.setEmail("email");
        String newInfo = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(info);

        Files.write(Paths.get("my-file.json"), newInfo.getBytes());
    }

    @Test
    public void read() throws FileNotFoundException, ParseException {
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader("my-file.json"));
        ObjectMapper mapper1 = new ObjectMapper();
        Info info = mapper1.convertValue(obj, Info.class);
        String email = info.getEmail();
        System.out.println(email);
    }
}
