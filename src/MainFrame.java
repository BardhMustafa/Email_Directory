import javax.management.remote.JMXConnectorFactory;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {
    private JPanel panel;
    private JTextField textField1;
    private List<EmailPerson> emailPersonList;

    MainFrame(List<EmailPerson> e) {
        emailPersonList = e;
        JFrame frame = new JFrame();
        String[] columns = new String[]{"Name", "Email"};
        Object[][] data = new Object[emailPersonList.size()][2];
        for (int i = 0; i < emailPersonList.size(); i++) {
            data[i][0] = emailPersonList.get(i).getName();
            data[i][1] = emailPersonList.get(i).getEmail();
        }
        JTable table = new JTable(data, columns);
//        table.setBounds(0, 50, 500, 400);
        JButton button = new JButton();
        button.setBounds(140, 250, 80, 30);
        button.setText("Go back");
        JButton button1 = new JButton();
        button1.setBounds(240, 250, 80, 30);
        button1.setText("Delete");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new LandingFrame(emailPersonList);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = table.getSelectedRow();
                if (i >= 0) {
                    emailPersonList.remove(i);
                    JOptionPane.showMessageDialog(null, "Email deleted");
                    frame.setVisible(false);
                    new MainFrame(emailPersonList);
                } else {
                    JOptionPane.showMessageDialog(null, "You should select a row!");
                }
            }
        });

        frame.add(button);
        frame.add(button1);
        frame.add(new JScrollPane(table));
        frame.setTitle("Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 400);
        frame.setVisible(true);

    }
}
