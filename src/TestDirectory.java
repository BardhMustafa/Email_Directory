import java.util.ArrayList;
import java.util.List;

public class TestDirectory {
    public static void main(String[] args) {
//        new LandingFrame();
        List<EmailPerson> emailPersonList = new ArrayList<>();
        FunctionHandler functionsClass = new FunctionHandler(emailPersonList);
        EmailPerson emailPerson1 = new EmailPerson("bardhi1", "bardhi1@gmail.com");
        EmailPerson emailPerson2 = new EmailPerson("bardhi2", "bardhi2@gmail.com");
        EmailPerson emailPerson3 = new EmailPerson("bardhi3", "bardhi3@gmail.com");
        EmailPerson emailPerson4 = new EmailPerson("bardhi4", "bardhi4@gmail.com");
    new LandingFrame(emailPersonList);

    }
}
