import javax.swing.*; // GUI için Swing kütüphanesini tamamen ekledik.
public class Alpha {
    public static void main(String[] args) {
        JFrame Syllabus = new JFrame(); // Ana pencereyi oluşturuyoruz.

        JButton Download = new JButton("Download");
        Download.setBounds(130,100,100, 40); // Download butonu için koordinatlar.

        Syllabus.add(Download); // Butonu oluşturduk ancak şimdi pencereye eklememiz gerek.

        Syllabus.setSize(800,600); // Ana pencerenin boyutlarını belirliyoruz.
        Syllabus.setLayout(null); // Layout ayarlarını şimdilik boş bıraktık.
        Syllabus.setVisible(true); // Pencereyi görünür kıldık.
    }
}