import javax.imageio.ImageIO;
import javax.swing.*; // GUI için Swing kütüphanesini tamamen ekledik.
import java.awt.*; // Okul logosu için.
import java.io.IOException;
import java.net.URL; // Okul logosu için.

public class Alpha {
    public static void main(String[] args) {
        JFrame Syllabus = new JFrame(); // Ana pencereyi oluşturuyoruz.
        JButton Download = new JButton("Download Course"); // Download butonunu oluşturuyoruz.
        Syllabus.setSize(300,300); // Ana pencerenin boyutlarını belirliyoruz.
        Download.setBounds(130,100,133, 35); // Download butonu için koordinatlar.
        Syllabus.setLayout(null); // Layout ayarlarını şimdilik boş bıraktık.

        JLabel FacultyListText = new JLabel("Select Faculty:"); //Ekrandaki yerini sonra belirleyeceğiz.
        String[] Faculty = { "CE","BME","EEE","IE","DFE","GBE","AE","CIE","ME","MCE","SE"};
        JList FacultyList = new JList(Faculty); //Listeyi oluşturuyoruz.
        FacultyList.setSelectedIndex(0); // Default olarak seçili değeri ayarlıyoruz, ben CE ayarladım.
        FacultyList.setBounds(50,50,70,188); // Listenin uzunluğunu test ederek gerekli şekilde ayarladık.

        JTextField CourseCode = new JTextField("Course Code"); // Ders kodunu gireceğimiz alanı oluşturduk.
        CourseCode.setEditable(true); // Düzenlenebilir yaptık.
        CourseCode.setBounds(130,50,133,35);
        FacultyListText.setBounds(50,20,133,35); // Uyarı yazısının bölgesini ve boyutunu yazıyoruz.

        Syllabus.add(FacultyListText); // Fakülte seçimi için uyarı yazısını ekledik.
        Syllabus.add(FacultyList); // Listeyi pencereye ekliyoruz.
        Syllabus.add(Download); // Butonu oluşturduk ancak şimdi pencereye eklememiz gerek.
        Syllabus.add(CourseCode); // Ders kodunu yazacağımız kutuyu ekliyoruz.

        Image ieuLogo = null;
        try {
            URL schLogo = new URL("http://www.ieu.edu.tr/images/logoyeni_tr.png"); // Okul logosunun adresi.
            ieuLogo = ImageIO.read(schLogo);
        } catch (IOException DD) { // URL'de hata olursa uygulama şimdilik çalışmıyor.
            DD.printStackTrace();
        }
        JLabel logoCentered = new JLabel(new ImageIcon(ieuLogo)); // Logo için gizli kutu ayarladık.
        logoCentered.setBounds(60,30,180,109); // Logonun hizası ve boyutu.
        Syllabus.add(logoCentered); // Logoyu ekledik.

        Download.addActionListener(pressDownloadButton -> {
            // Buraya Download butonuna tıklayınca çalışacak kodlar eklenecek. Büyük ihtimalle metod olarak.
        });
        Syllabus.setVisible(true); // Pencereyi görünür kıldık.
    }
}