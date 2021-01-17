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

        // Değerlendirme ölçütleri için veri yapısı oluşturacağız, 12x2 = 24 tane olacak.

        String attendanceNumber = sitePart.getElementById("attendance_no").text();
        String attendancePer = sitePart.getElementById("attendance_per").text();

        String labNumber = sitePart.getElementById("lab_no").text();
        String labPer = sitePart.getElementById("lab_per").text();

        String fieldNumber = sitePart.getElementById("fieldwork_no").text();
        String fieldPer = sitePart.getElementById("fieldwork_per").text();

        String quizNumber = sitePart.getElementById("quiz_no").text();
        String quizPer = sitePart.getElementById("quiz_per").text();

        String hWorkNumber = sitePart.getElementById("homework_no").text();
        String hWorkPer = sitePart.getElementById("homework_per").text();

        String presentNumber = sitePart.getElementById("presentation_no").text();
        String presentPer = sitePart.getElementById("presentation_per").text();

        String projectnumber = sitePart.getElementById("project_no").text();
        String projectPer = sitePart.getElementById("project_per").text();

        String portNumber = sitePart.getElementById("portfolios__no").text();
        String portPer = sitePart.getElementById("portfolios_per").text();

        String midtermNumber = sitePart.getElementById("midterm_no").text();
        String midtermPer = sitePart.getElementById("midterm_per").text();

        String finalNumber = sitePart.getElementById("final_no").text();
        String finalPer = sitePart.getElementById("final_per").text();

        String totalNumber = sitePart.getElementById("ara_total_no").text();
        String totalPer = sitePart.getElementById("ara_total_per").text();

        // AKTS tablosu için veri yapısı oluşturuyoruz.
        // Normalde 12x3 olması gerekiyor ancak son tabloyu çarpım olarak yapacağım.





    }
}
