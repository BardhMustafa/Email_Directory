import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class addAndSearchFrame extends JFrame {
    private JPanel panel1;
    private JTextField nameS;
    private JButton searchButtonEmail;
    private JButton searchButtonName;
    private JButton addNewEmailButton;
    private JTextField email;
    private JTextField name;
    private JTextField emailS;
    private JButton goBackButton;
    private JButton showAllButton;
    private List<EmailPerson> emailPeople;

    addAndSearchFrame(List<EmailPerson> emailPeople) {
        FunctionHandler functionHandler = new FunctionHandler(emailPeople);
        this.emailPeople = emailPeople;
        JFrame frame = new JFrame();
        frame.setSize(450, 400);
        frame.setContentPane(panel1);
        frame.setVisible(true);
        addNewEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameT = name.getText();
                String emailT = email.getText();
                if (nameT.length() > 0 && emailT.contains("@")) {
                    if (functionHandler.insertEmailPerson(new EmailPerson(nameT, emailT))) {
                        JOptionPane.showMessageDialog(null, "Email added successfully");
                        functionHandler.showAll();
                        name.setText("");
                        email.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Email exists");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Mistakes on typing");
                }
            }
        });
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainFrame(emailPeople);
            }
        });
        searchButtonName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmailPerson emailPerson = functionHandler.findByName(nameS.getText());
                if (emailPerson == null) {
                    JOptionPane.showMessageDialog(null, "Email doesn't exist");
                } else {
                    JOptionPane.showMessageDialog(null, "Name: " + emailPerson.getName() + "\n " + "Email: " + emailPerson.getEmail());
                }

            }
        });
        searchButtonEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmailPerson emailPerson = functionHandler.findByEmail(emailS.getText());
                if (emailPerson == null) {
                    JOptionPane.showMessageDialog(null, "Email doesn't exist");
                } else {
                    JOptionPane.showMessageDialog(null, "Name: " + emailPerson.getName() + "\n " + "Email: " + emailPerson.getEmail());
                }
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new LandingFrame(emailPeople);
            }
        });
    }
}
