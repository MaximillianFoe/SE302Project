import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class CoursesList {
    public static void main(String[] args) {
        JFrame courseList = new JFrame();
        JFrame messageWindow = new JFrame();
        courseList.setSize(400,510);
        courseList.setLayout(null);
        DefaultListModel<String> myCourseList = new DefaultListModel<>();

        try {
            File courseFolder = new File("./");
            FilenameFilter filter = (f, name) -> name.endsWith(".html");
            File[] files = courseFolder.listFiles(filter);
            assert files != null;
            for (File file : files) {
                String tempName = file.getName().replace(".html", ""); // Mükemmel bir dönüşüm yaptık burada.
                myCourseList.addElement(tempName);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(messageWindow, "Something went wrong! Error Code: " + e);
        }
        JList<String> finalShownList = new JList<>(myCourseList);
        finalShownList.setBounds(0,0, 400,510);

        finalShownList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                String HTMLPath = finalShownList.getSelectedValue() + ".html";
                File openHTML = new java.io.File(HTMLPath);
                if (evt.getClickCount() == 2) {
                    try {
                        Desktop.getDesktop().open(openHTML);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(messageWindow, "Couldn't Open File! Error Code: " + e);
                    }
                }
            }
        });

        courseList.add(finalShownList);
        courseList.setTitle("Syllabus Agent v1.0 - Downloaded List");
        courseList.setLocation(800, 600);
        courseList.setVisible(true);
    }
}