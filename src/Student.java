package wmadp201_assginment4_group.src;

public class Student {

    private StudentProfile sp;
    private Account account;


    public Student(StudentProfile sp, Account account) {
        this.sp = sp;
        this.account = account;
    }

    public String getUserName() {
        return this.account.getUserName();
    }

    public String getPassword() {
        return this.account.getPassword();
    }
}
