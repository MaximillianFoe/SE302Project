import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.Scanner;
import org.jsoup.select.Elements;

public class DownloadURL {
    public static void main(String[] args) throws IOException {
        String courseCode = "SE+302";
        String Faculty = "ce";
        String courseSite = "https://" + Faculty + ".ieu.edu.tr/tr/syllabus/type/read/id/" + courseCode; // Sitenin adresi belirli; facultyName ve courseCode kısmını kullanıcı belirliyor.
        Connection connectionToCourse = Jsoup.connect(courseSite); // Sayfaya bağlanmam için JSoup komutu.
        Document sitePart = connectionToCourse.get(); // Siteden verileri çekiyoruz.

        String courseName = sitePart.getElementById("course_name").text(); // ID kısmını sayfa kaynağını inceleyerek alıyoruz.
        String termDate = sitePart.getElementById("semester").text();
        System.out.println(courseName + termDate);
}
}
