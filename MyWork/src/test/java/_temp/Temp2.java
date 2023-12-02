package _temp;

import io.cucumber.java.sl.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Temp2 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        write(list1);

        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(6, 7, 8, 9));
        write(list2);


    }

    public static void write(List<Integer> list) {
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static void write(LinkedList<Integer> list) {
        for (Integer integer : list) {
            System.out.println(integer);

        }
    }

    public static void write(ArrayList<Integer> list) {
        for (Integer integer : list) {

            System.out.println(integer);
        }


    }
}
