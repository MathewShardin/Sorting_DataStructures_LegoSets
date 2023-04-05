import com.opencsv.exceptions.CsvValidationException;

public class Main {
    public static void main(String[] args) throws CsvValidationException {
        LinkedList listTest = new LinkedList();
//        LegoSet[] setTest = CSVParser.parseCSVtoLegoSet("src/main/resources/sets.csv");
//        for (LegoSet set : setTest) {
//            System.out.println(set.getName());
//            listTest.insertLast(set);
//        }
//        System.out.println(listTest.size());
        listTest.insertLast(1);
        listTest.insertLast(2);
        listTest.insertLast(3);
        listTest.insertLast(4);
        listTest.insertLast(5);

        listTest.swap(1,4);

        for (int i = 0; i < listTest.size(); i++) {
            System.out.print(listTest.getNodeAtLocation(i).data + " ");
        }

    }
}
