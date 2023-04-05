import com.opencsv.exceptions.CsvValidationException;

public class Main {
    public static void main(String[] args) throws CsvValidationException {
        LegoSet[] setTest = CSVParser.parseCSVtoLegoSet("src/main/resources/sets.csv");
        for (LegoSet set : setTest) {
            System.out.println(set.getName());

        }

    }
}
