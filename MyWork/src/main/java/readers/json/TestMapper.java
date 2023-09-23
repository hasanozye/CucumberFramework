package readers.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestMapper {

    @Test
    public void testMapConfig1() throws Exception {

        String file = "src/test/resources/datafiles/Config1.json";

        ObjectMapper mapper = new ObjectMapper();
        Config1Pojo config = mapper.readValue(new FileReader(file), Config1Pojo.class);

        System.out.println(config);
        System.out.println("-".repeat(30));
        System.out.println(config.getUrl());
        System.out.println(config.getUsername());
        System.out.println(config.getPassword());

    }

    @Test
    public void testMapConfig1LomBok() throws Exception {
        String file = "src/test/resources/datafiles/Config1.json";
        ObjectMapper mapper = new ObjectMapper();
        Config1PojoLombok config = mapper.readValue(new FileReader(file), Config1PojoLombok.class);
        System.out.println(config);
        System.out.println("-".repeat(30));
        System.out.println(config.getUrl());
        System.out.println(config.getUsername());
        System.out.println(config.getPassword());
    }

    @Test
    public void testMapConfig() throws Exception {
        String file = "src/test/resources/datafiles/configders.json";
        ObjectMapper mapper = new ObjectMapper();
        ConfigPojo config = mapper.readValue(new FileReader(file), ConfigPojo.class);
        System.out.println(config);
        System.out.println(config.getUsers().get(0).getPassword()  );
        System.out.println("-".repeat(30));
    }

    @Test
    public void testMapGeneral1(){
        String file = "src/test/resources/datafiles/configders.json";

        ObjectMapper mapper = new ObjectMapper();
        MyJsonPojo pojo = new Config1PojoLombok();

    }

    public Object getPojo(String file, MyJsonPojo pojo){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new FileReader(file),pojo.getClass());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
