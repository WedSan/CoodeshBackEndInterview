package wedsan;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ListRandom listRandom = new ListRandom();
        ArrayList<String> stringList = listRandom.createRandomStringList();

        Set<String> stringSet = new HashSet<>(stringList);

        System.out.println("Number of the elements in the random list: "+stringList.size());
        System.out.println("Number of distinct elements in the random list: "+stringSet.size());
    }

}