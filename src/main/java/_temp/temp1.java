package _temp;

import readers.property.PropertyReader;

import java.util.List;

public class temp1 {
    public static void main(String[] args) {
        String list = "--start-maximized, --remote-allow-origins=*, --headless";

        String[] split = list.split(",");
        for (String s : split) {
            System.out.println(s.trim() );
        }

        PropertyReader pr = new PropertyReader("config");
        pr.get("vhrome.options");

        PropertyReader pr1 = PropertyReader.propertyReader("config");
        pr1.get("chrome.options");

    }
}
