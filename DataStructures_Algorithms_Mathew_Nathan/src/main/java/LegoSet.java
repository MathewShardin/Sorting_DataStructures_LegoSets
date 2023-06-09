public class LegoSet implements Comparable<LegoSet> {
    private String name;
    private int yearOfRelease;
    private int num_of_parts;

    public LegoSet(String name, int yearOfRelease, int num_of_parts) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.num_of_parts = num_of_parts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getNum_of_parts() {
        return num_of_parts;
    }

    public void setNum_of_parts(int num_of_parts) {
        this.num_of_parts = num_of_parts;
    }


    // Compare on Names
    @Override
    public int compareTo(LegoSet set) {
        // Make both names lowercase to ensure correct comparison
        String setOneName = this.getName().toLowerCase();
        String setTwoName = set.getName().toLowerCase();

        if (setOneName.compareTo(setTwoName) == 0) {
            return 0;
        }
        if (setOneName.compareTo(setTwoName) > 0) {
            return 1;
        }

        return -1;
    }

}


