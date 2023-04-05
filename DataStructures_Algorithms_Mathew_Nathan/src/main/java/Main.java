import com.opencsv.exceptions.CsvValidationException;

public class Main {
    public static void main(String[] args) throws CsvValidationException {
        LinkedList listTest = new LinkedList();
        LegoSet[] setTest = CSVParser.parseCSVtoLegoSet("src/main/resources/sets.csv");
        for (LegoSet set : setTest) {
            System.out.println(set.getName());
            listTest.insertLast(set);
        }
        System.out.println(listTest.size());

    }
}
