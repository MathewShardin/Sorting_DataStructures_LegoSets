public class Comparator implements java.util.Comparator<LegoSet> {

    // Compare on Num of Parts
    @Override
    public int compare(LegoSet set1, LegoSet set2) {
        // Make both names lowercase to ensure correct comparison
        int setOneParts = set1.getNum_of_parts();
        int setTwoParts = set2.getNum_of_parts();

        if (setOneParts == setTwoParts) {
            return 0;
        }
        if (setOneParts > setTwoParts) {
            return 1;
        }

        return -1;


    }
}
