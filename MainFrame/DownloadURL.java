import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;

public class DownloadURL{
    public static void main(String[] args, String Faculty, String courseCode) throws IOException {
        String courseSite = "https://" + Faculty + ".ieu.edu.tr/tr/syllabus/type/read/id/" + courseCode; // Sitenin adresi belirli; facultyName ve courseCode kısmını kullanıcı belirliyor.
        Connection connectionToCourse = Jsoup.connect(courseSite); // Sayfaya bağlanmam için JSoup komutu.
        Document sitePart = connectionToCourse.get(); // Siteden verileri çekiyoruz.

        JFrame messageWindow = new JFrame(); // Ana pencereyi oluşturuyoruz.

        // Gerekli bütün veri yapımızı burada oluşturacağız.
        String courseName = null;
        String termDate = null;
        String theoryTime = null;
        String labTime = null;
        String localCredits = null;
        String ectsCredits = null;
        String preRequisites = null;
        String courseLanguage = null;
        String courseType = null;
        String courseLevel = null;
        String courseCoordinator = null;
        String courseLecturer = null;
        String courseOutcomes = null;

        try {
            courseName = sitePart.getElementById("course_name").text();
            termDate = sitePart.getElementById("semester").text();
            theoryTime = sitePart.getElementById("weekly_hours").text();
            labTime = sitePart.getElementById("app_hours").text();
            localCredits = sitePart.getElementById("ieu_credit").text();
            ectsCredits = sitePart.getElementById("ects_credit").text();
            preRequisites = sitePart.getElementById("pre_requisites").text();
            courseLanguage = sitePart.getElementById("course_lang").text();
            courseType = sitePart.getElementById("course_type").text();
            courseLevel = sitePart.getElementById("course_level").text();
            courseCoordinator = sitePart.getElementById("coordinator_list").text();
            courseLecturer = sitePart.getElementById("lecturer_list").text();
            courseOutcomes = sitePart.getElementById("outcome").text();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(messageWindow, "Something went wrong. But your file maybe created.");
        }

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

        String projectNumber = sitePart.getElementById("project_no").text();
        String projectPer = sitePart.getElementById("project_per").text();

        String seminarNumber = sitePart.getElementById("seminar_no").text();
        String seminarPer = sitePart.getElementById("seminar_per").text();

        String portNumber = sitePart.getElementById("portfolios__no").text();
        String portPer = sitePart.getElementById("portfolios_per").text();

        String midtermNumber = sitePart.getElementById("midterm_no").text();
        String midtermPer = sitePart.getElementById("midterm_per").text();

        String finalNumber = sitePart.getElementById("final_no").text();
        String finalPer = sitePart.getElementById("final_per").text();

        String totalNumber = sitePart.getElementById("ara_total_no").text();
        String totalPer = sitePart.getElementById("ara_total_per").text();

        // AKTS tablosu için veri yapısı oluşturuyoruz. aşağı yukarı 11x3 bir tablo olması gerekiyor.
        String courseHourNumber = sitePart.getElementById("course_hour_number").text();
        String courseHourDuration = sitePart.getElementById("course_hour_duration").text();
        String courseHourWLoad = sitePart.getElementById("course_hour_total_workload").text();

        String labHourNumber = sitePart.getElementById("lab_number").text();
        String labHourDuration = sitePart.getElementById("lab_duration").text();
        String labHourWLoad = sitePart.getElementById("lab_total_workload").text();

        String outHourNumber = sitePart.getElementById("out_hour_number").text();
        String outHourDuration = sitePart.getElementById("out_hour_duration").text();
        String outHourWLoad = sitePart.getElementById("out_hour_total_workload").text();

        String fieldworkHourNumber = sitePart.getElementById("fieldwork_number").text();
        String fieldworkHourDuration = sitePart.getElementById("fieldwork_duration").text();
        String fieldworkHourWLoad = sitePart.getElementById("fieldwork_total_number").text();

        String quizHourNumber = sitePart.getElementById("quizess_number").text();
        String quizHourDuration = sitePart.getElementById("quizess_duration").text();
        String quizHourWLoad = sitePart.getElementById("quizess_total_workload").text();

        String hWorkHourNumber = sitePart.getElementById("homework_number").text();
        String hWorkHourDuration = sitePart.getElementById("homework_duration").text();
        String hWorkHourWLoad = sitePart.getElementById("homework_total_workload").text();

        String presentHourNumber = sitePart.getElementById("presentation_number").text();
        String presentHourDuration = sitePart.getElementById("presentation_duration").text();
        String presentHourWLoad = sitePart.getElementById("presentation_total_workload").text();

        String projectHourNumber = sitePart.getElementById("project_number").text();
        String projectHourDuration = sitePart.getElementById("project_duration").text();
        String projectHourWLoad = sitePart.getElementById("project_total_workload").text();

        String seminarHourNumber = sitePart.getElementById("seminar_number").text();
        String seminarHourDuration = sitePart.getElementById("seminar_duration").text();
        String seminarHourWLoad = sitePart.getElementById("seminar_total_workload").text();

        String portHourNumber = sitePart.getElementById("portfolios_number").text();
        String portHourDuration = sitePart.getElementById("portfolios_duration").text();
        String portHourWLoad = sitePart.getElementById("portfolios_total_workload").text();

        String midtermHourNumber = sitePart.getElementById("midterm_number").text();
        String midtermHourDuration = sitePart.getElementById("midterm_duration").text();
        String midtermHourWLoad = sitePart.getElementById("midterm_total_workload").text();

        String finalHourNumber = sitePart.getElementById("final_number").text();
        String finalHourDuration = sitePart.getElementById("final_duration").text();
        String finalHourWLoad = sitePart.getElementById("final_total_workload").text();

        // Toplam yükü belirlemek için bütün yapıyı integer'e çevirmemiz gerekiyor.
        int iCH=Integer.parseInt(courseHourWLoad);
        int iLH=Integer.parseInt(labHourWLoad);
        int iOH=Integer.parseInt(outHourWLoad);
        int iFH=Integer.parseInt(fieldworkHourWLoad);
        int iQH=Integer.parseInt(quizHourWLoad);
        int iHH=Integer.parseInt(hWorkHourWLoad);
        int iPH=Integer.parseInt(presentHourWLoad);
        int iPJH=Integer.parseInt(projectHourWLoad);
        int iPOH=Integer.parseInt(portHourWLoad);
        int iMH=Integer.parseInt(midtermHourWLoad);
        int iFIH=Integer.parseInt(finalHourWLoad);

        // Sonra hepsini topluyoruz, mükemmel şekilde çalışıyor!
        int totalWLoad = iCH + iLH + iOH + iFH + iQH + iHH + iPH + iPJH + iPOH + iMH + iFIH;

        try {
            String downloadedCourseName = courseCode + ".xls";
            HSSFWorkbook downloadedCourseFile = new HSSFWorkbook();
            HSSFSheet sheet = downloadedCourseFile.createSheet(courseCode);

            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue(courseName);

            FileOutputStream fileOut = new FileOutputStream(downloadedCourseName);
            downloadedCourseFile.write(fileOut);
            fileOut.close();
            downloadedCourseFile.close();
            System.out.println("Your excel file has been generated!");

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
