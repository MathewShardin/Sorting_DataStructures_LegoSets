import com.opencsv.exceptions.CsvValidationException;

public class Main {
    public static void main(String[] args) throws CsvValidationException {
        LinkedList<LegoSet> listTest = new LinkedList<>();
        LegoSet[] setTest = CSVParser.parseCSVtoLegoSet("src/main/resources/setsSmall.csv");
        for (LegoSet set : setTest) {
            listTest.insertLast(set);
        }
        LinkedList<LegoSet> list = SortingTemp.bubbleSort(listTest);
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + " ");
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
