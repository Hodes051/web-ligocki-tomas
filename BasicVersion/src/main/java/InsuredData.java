public class InsuredData {
    private String name;
    private String surname;
    private String phoneNumber;
    private int age;

    public InsuredData(String name, String surname, String phoneNumber, int age) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return name + "   " + surname + "   " + age + "      " +  phoneNumber;
    }
}
