import com.opencsv.exceptions.CsvValidationException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws CsvValidationException {
        LinkedList<LegoSet> listTest = new LinkedList<>();
        CustomArrayList<LegoSet> testSet = new CustomArrayList<>();
        LegoSet[] setTest = CSVParser.parseCSVtoLegoSet("src/main/resources/setsSmall.csv");
        for (LegoSet set : setTest) {
            listTest.insertLast(set);
            testSet.add(set);
        }

        for (int i = 0; i < listTest.size(); i++) {
            System.out.println(listTest.get(i).getName() + " ");
        }

        SortingTemp.partition(testSet,0,2);//Testing if crashes here
        SortingTemp.quickSort(testSet,0,2);//Testing if crashes here
        SortingTemp.sort(testSet);

        System.out.println("");
        System.out.println("");
        System.out.println("");

        for (int i = 0; i < testSet.size(); i++) {
            System.out.println(testSet.get(i).getName() + " ");
        }

//        String one = "test";
//        String two = "testtest";
//        String three = "testtesttest";
//        String four = "testtesttesttest";
//
//        listTest.insertLast(one);
//        listTest.insertLast(three);
//        listTest.insertLast(four);
//        listTest.insertLast(two);
//        for (int i = 0; i < listTest.size(); i++) {
//            System.out.print(listTest.getNodeAtLocation(i).data + " ");
//        }
//        System.out.println("");
//
//        LinkedList list = SortingTemp.bubbleSort(listTest);
//
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.getNodeAtLocation(i).data + " ");
//        }






    }
}
