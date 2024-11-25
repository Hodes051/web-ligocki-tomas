package insuranceEvidence;

// Třída InsuredData slouží k reprezentaci jednoho pojištěného pomocí jeho dat.
public class InsuredData {
    private String name;
    private String surname;
    private String phoneNumber;
    private int age;

    // Konstruktor k inicializaci dat pojištěného.
    public InsuredData(String name, String surname, String phoneNumber, int age) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    // Getter pro jméno.
    public String getName() {
        return name;
    }

    // Getter pro příjmení.
    public String getSurname() {
        return surname;
    }

    // Metoda pro formátovaný výpis dat o pojištěném.
    @Override
    public String toString() {
        return name + "   " + surname + "   " + age + "   " + phoneNumber;
    }
}
