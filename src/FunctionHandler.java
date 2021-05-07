import java.security.spec.RSAOtherPrimeInfo;
import java.util.List;

public class FunctionHandler {
    private List<EmailPerson> emailPersons;

    FunctionHandler(List<EmailPerson> emailPersons) {
        this.emailPersons = emailPersons;

    }

    public void showAll() {
        for (EmailPerson e :
                emailPersons) {
            System.out.println(e.getName() + " " + e.getEmail());
        }
    }

    public List<EmailPerson> getEmailPersons() {
        return emailPersons;
    }

    public void setEmailPersons(List<EmailPerson> emailPersons) {
        this.emailPersons = emailPersons;
    }

    public boolean checkIfExist(EmailPerson emailPerson) {
        boolean exist = false;
        for (EmailPerson emailPerson1 :
                emailPersons) {
            if (emailPerson.getName().equals(emailPerson1.getName()) || emailPerson.getEmail().equals(emailPerson1.getEmail())) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    public boolean insertEmailPerson(EmailPerson emailPerson) {
        boolean exist = true;
        if (!checkIfExist(emailPerson)) {
            emailPersons.add(emailPerson);
        } else {
            exist = false;
        }
        return exist;
    }

    public EmailPerson findByName(String name) {
        int index = getIndexByName(name);
        EmailPerson e;
        if (index >= 0) {
            e = emailPersons.get(getIndexByName(name));
        } else {
            e = null;
        }
        return e;
    }

    public EmailPerson findByEmail(String email) {
        int index = getIndexByEmail(email);
        EmailPerson e;
        if (index >= 0) {
            e = emailPersons.get(getIndexByEmail(email));
        } else {
            e = null;
        }
        return e;
    }

    public int getIndexByName(String name) {
        int index = -1;
        String name1;
        for (EmailPerson emailPerson1 : emailPersons) {
            name1 = emailPerson1.getName();
            if (name1.equals(name)) {
                index = emailPersons.indexOf(emailPerson1);
                break;
            }
        }
        return index;
    }

    public int getIndexByEmail(String email) {
        int index = -1;
        for (EmailPerson emailPerson1 : emailPersons) {
            if (emailPerson1.getEmail().equals(email)) {
                index = emailPersons.indexOf(emailPerson1);
                break;
            }
        }
        return index;
    }


}
