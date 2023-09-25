package readers.json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ConfigPojo extends MyJsonPojo {
    private String url;
    private String username;
    private String password;
    private String takescreenshot;
    private String takescreenshotOn;
    private List<User> users;

    @Getter
    @Setter
    @ToString
    public static class User {
        private String type;
        private String valid;
        private String username;
        private String password;
    }
}
