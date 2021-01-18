import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*; // GUI için Swing kütüphanesini tamamen ekledik.
import java.awt.*; // Okul logosu için.
import java.net.URL; // Okul logosu için.

public class Alpha {
    public static void main(String[] args) {
        JFrame Syllabus = new JFrame(); // Ana pencereyi oluşturuyoruz.
        JButton Download = new JButton("Download Course"); // Download butonunu oluşturuyoruz.
        JButton CourseDatabase = new JButton("Downloaded List"); // İndirilenleri görüntülemek için buton oluşturuyoruz.
        Syllabus.setSize(300,409); // Ana pencerenin boyutlarını belirliyoruz.
        Download.setBounds(130,245,133, 35); // Download butonu için koordinatlar.
        CourseDatabase.setBounds(130,288,133, 35); // İndirilenleri görüntülemek için koordinatlar.
        Syllabus.setLayout(null); // Layout ayarlarını şimdilik boş bıraktık.


        JLabel selectionText = new JLabel("Language:"); //Ekrandaki yerini sonra belirleyeceğiz.
        selectionText.setBounds(150,155,133,35); // Uyarı yazısının bölgesini ve boyutunu yazıyoruz.
        ButtonGroup languageSelection = new ButtonGroup();
        JRadioButton turkishLanguage = new JRadioButton("TR", true);
        turkishLanguage.setBounds(130,175,60,30);
        JRadioButton englishLanguage = new JRadioButton("EN", false);
        englishLanguage.setBounds(180,175,60,30);
        languageSelection.add(turkishLanguage);
        languageSelection.add(englishLanguage);


        JLabel FacultyListText = new JLabel("Select Faculty:"); //Ekrandaki yerini sonra belirleyeceğiz.
        FacultyListText.setBounds(45,135,133,35); // Uyarı yazısının bölgesini ve boyutunu yazıyoruz.

        String[] Faculty = { "CE","BME","EEE","IE","DFE","GBE","AE","CIE","ME","MCE","SE"};
        //Listeyi oluşturuyoruz.
        JList<String> FacultyList = new JList<>(Faculty);
        FacultyList.setSelectedIndex(0); // Default olarak seçili değeri ayarlıyoruz, ben CE ayarladım.
        FacultyList.setBounds(45,165,70,188); // Listenin uzunluğunu test ederek gerekli şekilde ayarladık.

        JTextField CourseName = new JTextField("SE"); // Ders kodunu gireceğimiz alanı oluşturduk.
        CourseName.setEditable(true); // Düzenlenebilir yaptık.
        CourseName.setBounds(130,205,55,35);

        JLabel PlusSign = new JLabel("+"); //Ekrandaki yerini sonra belirleyeceğiz.
        PlusSign.setBounds(190,215,10,10); // Uyarı yazısının bölgesini ve boyutunu yazıyoruz.

        JTextField CourseCode = new JTextField("302"); // Ders kodunu gireceğimiz alanı oluşturduk.
        CourseCode.setEditable(true); // Düzenlenebilir yaptık.
        CourseCode.setBounds(205,205,55,35);

        // Ekrana öğelerimizi ekliyoruz.
        Syllabus.add(FacultyListText); // Fakülte seçimi için uyarı yazısını ekledik.
        Syllabus.add(PlusSign); // Ders kodunu yazacağımız kutuyu ekliyoruz.
        Syllabus.add(FacultyList); // Listeyi pencereye ekliyoruz.
        Syllabus.add(Download); // Butonu oluşturduk ancak şimdi pencereye eklememiz gerek.
        Syllabus.add(CourseDatabase); // Butonu oluşturduk ancak şimdi pencereye eklememiz gerek.
        Syllabus.add(CourseCode); // Ders kodunu yazacağımız kutuyu ekliyoruz.
        Syllabus.add(CourseName); // Ders kodunu yazacağımız kutuyu ekliyoruz.
        Syllabus.add(turkishLanguage); // Türkçe dil seçeneği.
        Syllabus.add(englishLanguage); // İngilizce dil seçeneği.
        Syllabus.add(selectionText); // Dil seçimi uyarısı.

        Image ieuLogo = null;
        try {
            URL schLogo = new URL("http://www.ieu.edu.tr/images/logoyeni_tr.png"); // Okul logosunun adresi.
            ieuLogo = ImageIO.read(schLogo);
        } catch (IOException DD) { // URL'de hata olursa uygulama şimdilik çalışmıyor.
            DD.printStackTrace();
        }

        assert ieuLogo != null;
        JLabel logoCentered = new JLabel(new ImageIcon(ieuLogo)); // Logo için gizli kutu ayarladık.
        logoCentered.setBounds(60,15,180,109); // Logonun hizası ve boyutu.
        Syllabus.add(logoCentered); // Logoyu ekledik.

        Download.addActionListener(pressDownloadButton -> {
            String selectedFaculty = FacultyList.getSelectedValue();
            String prefLanguage = "tr"; // Varsayılan değerimiz Türkçe.
            if(turkishLanguage.isSelected()){
                prefLanguage = "tr";
            }
            if(englishLanguage.isSelected()){
                prefLanguage = "en";
            }
                String FirstBox = CourseName.getText();
            String SecondBox = CourseCode.getText();
            String selectedCourse = FirstBox + "+" + SecondBox; // Okulun sitesindeki format böyle.
            try {
                DownloadURL.main(selectedFaculty, selectedCourse, prefLanguage);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(Syllabus, "Something went wrong.");
            }
        });

        Syllabus.setVisible(true); // Pencereyi görünür kıldık.
    }
}