public class Comparator implements java.util.Comparator<LegoSet> {

    // Compare on Name
    @Override
    public int compare(LegoSet set1, LegoSet set2) {
        // Make both names lowercase to ensure correct comparison
        String setOneName = set1.getName().toLowerCase();
        String setTwoName = set2.getName().toLowerCase();

        if (setOneName.compareTo(setTwoName) == 0) {
            return 0;
        }
        if (setOneName.compareTo(setTwoName) > 0) {
            return 1;
        }

        return -1;


    }
}
