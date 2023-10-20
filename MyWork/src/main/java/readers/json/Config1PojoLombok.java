package readers.json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Config1PojoLombok extends MyJsonPojo{
    //lombok annotationslar kullanılarak getter, setter, toString ve error islemlerinde kolaylik saglar
    //Plain Old Java Objects
    private String url;
    private String username;
    private String password;


}
