package _temp;

import readers.property.PropertyReader;

public class temp1 {
    public static void main(String[] args) {
        String list = "--start-maximized  , --remote-allow-origins=*  , --headless";

        String[] split = list.split(",");
        for (String s : split) {
            System.out.println(s.trim() );
        }

    }
}
