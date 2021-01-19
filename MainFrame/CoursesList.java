import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;

public class CoursesList {
    public static void main(String[] args) {
        JFrame courseList = new JFrame();
        JFrame messageWindow = new JFrame();
        courseList.setSize(300,410);
        courseList.setLayout(null);
        DefaultListModel<String> myCourseList = new DefaultListModel<>();

        try {
            File courseFolder = new File("./");

            FilenameFilter filter = (f, name) -> {
                return name.endsWith(".html");
            };
            File[] files = courseFolder.listFiles(filter);
            assert files != null;
            for (File file : files) {
                myCourseList.addElement(file.getName());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(messageWindow, "Something went wrong! Error Code: " + e);
        }
        JList<String> finalShownList = new JList<>(myCourseList);
        finalShownList.setBounds(100,100, 75,75);
        courseList.add(finalShownList);
        courseList.setTitle("Syllabus Agent v1.0 - Downloaded List");
        courseList.setVisible(true);
    }
}