package wmadp201_assginment4_group.src;

public class Student extends User {

    private int admissionYear;
    private int yearInUniversity;
    private GeneralTranscript gt;
    private CurrentSemesterTranscript cst;
    private StudentProfile sp;

    public Student(StudentProfile sp) {
        this.sp = sp;
    }
}
