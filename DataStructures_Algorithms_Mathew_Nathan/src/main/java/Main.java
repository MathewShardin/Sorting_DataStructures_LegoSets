import com.opencsv.exceptions.CsvValidationException;

public class Main {
    public static void main(String[] args) throws CsvValidationException {
        CSVParser.parseCSVtoLegoSet("src/main/resources/sets.csv");
    }
}
