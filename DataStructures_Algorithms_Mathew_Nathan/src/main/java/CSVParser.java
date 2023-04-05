import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
//Object[]
//String filePathCSV = "src/main/resources/sets.csv"
public class CSVParser {
    public static LegoSet[] parseCSVtoLegoSet(String filepath) throws CsvValidationException {
        int csvLen = getCSVLength(filepath);
        LegoSet[] setOutput = new LegoSet[csvLen];
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            String[] nextLine;
            int insertCounter = 0;
            while ((nextLine = reader.readNext()) != null) {
                //Save all values from a line
                String[] fieldValuesTemp = new String[5]; //set_num, name, year, theme_id, num_parts
                int counterField = 0;
                for (String field : nextLine) {
                    counterField++;
                    fieldValuesTemp[counterField] = field;
                }
                LegoSet setTemp = new LegoSet(fieldValuesTemp[1], Integer.parseInt(fieldValuesTemp[2]), Integer.parseInt(fieldValuesTemp[4]));
                setOutput[insertCounter] = setTemp;
                insertCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return setOutput;
    }

    public static int getCSVLength(String filepath) throws CsvValidationException {
        int csvLen = 0;
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                csvLen++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvLen;
    }
}
