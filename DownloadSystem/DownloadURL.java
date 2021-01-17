import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class DownloadURL {
    public static void main(String[] args) throws IOException {
        String courseCode = "SE+302";
        String Faculty = "ce";
        String courseSite = "https://" + Faculty + ".ieu.edu.tr/tr/syllabus/type/read/id/" + courseCode; // Sitenin adresi belirli; facultyName ve courseCode kısmını kullanıcı belirliyor.
        Connection connectionToCourse = Jsoup.connect(courseSite); // Sayfaya bağlanmam için JSoup komutu.
        Document sitePart = connectionToCourse.get(); // Siteden verileri çekiyoruz.

        // Gerekli bütün veri yapımızı burada oluşturacağız.
        String courseName = sitePart.getElementById("course_name").text();
        String termDate = sitePart.getElementById("semester").text();
        String theoryTime = sitePart.getElementById("weekly_hours").text();
        String labTime = sitePart.getElementById("app_hours").text();
        String localCredits = sitePart.getElementById("ieu_credit").text();
        String ectsCredits = sitePart.getElementById("ects_credit").text();
        String preRequisites = sitePart.getElementById("pre_requisites").text();
        String courseLanguage = sitePart.getElementById("course_lang").text();
        String courseType = sitePart.getElementById("course_type").text();
        String courseLevel = sitePart.getElementById("course_level").text();
        String courseCoordinator = sitePart.getElementById("coordinator_list").text();
        String courseLecturer = sitePart.getElementById("lecturer_list").text();
        String courseOutcomes = sitePart.getElementById("outcome").text();

        String []courseWeeks = new String[17]; // Index dışında çıkmaması için 17 tane ayarlamak zorunda kaldım.
        for (int haftaSayisi = 1; haftaSayisi <= 16; haftaSayisi++){ // Hafta sayımız belli olduğu için rahatlıkla for döngüsü yaratabildik.
            courseWeeks[haftaSayisi] = sitePart.getElementById("hafta_" + haftaSayisi).text();
        }

    }
}
