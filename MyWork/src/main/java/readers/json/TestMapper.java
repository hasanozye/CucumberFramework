package readers.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static utils.Utils.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
        Config1PojoLombok config = mapper
                .readValue(new FileReader(file), Config1PojoLombok.class);
        System.out.println(config);
        System.out.println("-".repeat(30));
        System.out.println(config.getUrl());
        System.out.println(config.getUsername());
        System.out.println(config.getPassword());
    }

    @Test
    public void testMapConfig() throws Exception {
        String file = "src/test/resources/datafiles/config.json";
        ObjectMapper mapper = new ObjectMapper();
        ConfigPojo config = mapper.readValue(new FileReader(file), ConfigPojo.class);
        System.out.println(config);
        System.out.println(config.getUsers().get(0).getPassword());
        System.out.println("-".repeat(30));
    }

    @Test
    public void testMapGeneral1() {
        String file = "src/test/resources/datafiles/Config1.json";

        MyJsonPojo pojo = new Config1PojoLombok();
        Config1PojoLombok data = (Config1PojoLombok) getPojo(file, pojo);
        System.out.println(data.getUrl());
    }

    @Test
    public void testMapGeneral2() {
        String file = "src/test/resources/datafiles/config.json";

        MyJsonPojo pojo = new ConfigPojo();
        ConfigPojo data = (ConfigPojo) getPojo(file, pojo);
        System.out.println("data.getUsers().get(0).getAdress().getCity() = " + data
                .getUsers()
                .get(0)
                .getAdress()
                .getCity());
    }

    @Test
    public MyJsonPojo t1(String jsonFile, MyJsonPojo pojo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new FileReader(jsonFile), pojo.getClass());

    }


}
