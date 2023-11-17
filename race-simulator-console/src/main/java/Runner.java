public class Runner {
    private String firstName;
    private String lastName;
    private char gender;
    private int bibNumber;

    public Runner(String firstName, String lastName, char gender, int bibNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.bibNumber = bibNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public int getBibNumber() {
        return bibNumber;
    }

    @Override
    public String toString() {
        String s = "Runner # " + bibNumber +
                "\n" + firstName + ", " + lastName +
                "\n" + (gender == 'F' ? "Female" : "Male");
        return s;
    }

    public String singleLineString() {
        String s = bibNumber + "\t" + firstName + "\t" + lastName + "\t" + gender;
        return s;
    }
}
