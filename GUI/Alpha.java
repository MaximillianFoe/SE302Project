import javax.swing.*; // GUI için Swing kütüphanesini tamamen ekledik.
import java.awt.event.*; // Butonu ve bazı diğer şeyleri kullanmak için tetikleyici kütüphane.
import java.awt.*; // Yazı kutusu için ekledik, ileride belki başka şeyler için kullanırız.

public class Alpha {
    public static void main(String[] args) {
        JFrame Syllabus = new JFrame(); // Ana pencereyi oluşturuyoruz.
        JTextField CourseName = new JTextField(); // Ders kodunun yazılacağı yazı kutusunu oluşturuyoruz.
        JTextArea textArea = new JTextArea();
        CourseName = new JTextField(20);
        CourseName.addActionListener(this);

        super(new GridBagLayout());
        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        GridBagConstraints textCons = new GridBagConstraints();
        textCons.gridwidth = GridBagConstraints.REMAINDER;

        textCons.fill = GridBagConstraints.HORIZONTAL;
        CourseName.add(textCons);

        textCons.fill = GridBagConstraints.BOTH;
        textCons.weightx = 1.0;
        textCons.weighty = 1.0;
        scrollPane.add(textCons);

        JButton Download = new JButton("Download Course");
        Download.setBounds(130,100,133, 35); // Download butonu için koordinatlar.

        Syllabus.add(CourseName);
        Syllabus.add(scrollPane);
        Syllabus.add(textArea);

        JList FacultyList = new JList(); //Listeyi oluşturuyoruz.
        JLabel FacultyListText = new JLabel("Select Faculty:"); //Ekrandaki yerini sonra belirleyeceğiz.

        String Faculty[]= { "CE","BME","EEE","IE","DFE","GBE","AE","CIE","ME","MCE","SE"};
        FacultyList = new JList(Faculty); // Arraydeki verileri yeni listeye ekliyoruz.
        FacultyList.setSelectedIndex(0); // Default olarak seçili değeri ayarlıyoruz, ben CE ayarladım.
        FacultyList.setBounds(50,50,70,188); // Listenin uzunluğunu test ederek gerekli şekilde ayarladık.

        Syllabus.add(FacultyList); // Listeyi pencereye ekliyoruz.
        Syllabus.add(FacultyListText);

        Syllabus.add(Download); // Butonu oluşturduk ancak şimdi pencereye eklememiz gerek.

        Download.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent pressDownloadButton){
                // Buraya Download butonuna tıklayınca çalışacak kodlar eklenecek. Büyük ihtimalle metod olarak.
            }
        });

        Syllabus.setSize(500,450); // Ana pencerenin boyutlarını belirliyoruz.
        Syllabus.setLayout(null); // Layout ayarlarını şimdilik boş bıraktık.
        Syllabus.setVisible(true); // Pencereyi görünür kıldık.
    }
}