package wmadp201_assginment4_group.src;

public class StudentProfile {

    private int studentId;
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String address;
    private String age;
    private String admission;

    public StudentProfile (String firstName, String lastName, String gender, String country, String address, String age, String admission) {
        this.firstName= firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.address = address;
        this.age = age;
        this.admission = admission;
        this.studentId = EducationalPortal.getNewStudentId();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    public String getAdmission() {
        return admission;
    }
}
