import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LandingFrame extends JFrame {
    private JPanel panel;
    private JButton addANewOneButton;
    private JButton showAllEmailsButton;
    private List<EmailPerson> emailPeople;

    LandingFrame(List<EmailPerson> emailPeople) {
        this.emailPeople = emailPeople;
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setContentPane(panel);
        frame.setTitle("Email Directory");
        frame.setVisible(true);
        showAllEmailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainFrame(emailPeople);
            }
        });
        addANewOneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new addAndSearchFrame(emailPeople);
            }
        });
    }
}
