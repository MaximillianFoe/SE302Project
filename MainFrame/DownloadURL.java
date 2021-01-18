import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File; // HTML dosyası yaratmak için en basit özelliği kullanıyoruz.

public class DownloadURL{
    public static void main(String Faculty, String courseCode, String prefLanguage) throws IOException {
        String courseSite = "https://" + Faculty + ".ieu.edu.tr/" + prefLanguage + "/syllabus/type/read/id/" + courseCode; // Sitenin adresi belirli; facultyName ve courseCode kısmını kullanıcı belirliyor.
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
            File downloadedFile = new File(courseCode + ".html");
            FileWriter downloadedWriter = new FileWriter(courseCode + ".html");
            downloadedWriter.write("<p style=\"text-align: center;\"><strong>Izmir University of Economics Course Outline Form</strong></p>\n" +
                    "<table style=\"width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 100%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"height: 35px; width: 100%; border-collapse: collapse; background-color: #ffa500; margin-left: auto; margin-right: auto;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 100%; height: 18px;\"><strong>1. General Information</strong></td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"height: 18px; width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 100%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"border-collapse: collapse; width: 100%; height: 18px;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 50%; height: 18px;\"><strong>Course Name</strong></td>\n" +
                    "<td style=\"width: 50%; height: 18px;\">" + courseName + "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"height: 18px; width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 100%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"border-collapse: collapse; width: 100%; height: 36px;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 16.6667%; height: 18px;\"><strong>Code</strong></td>\n" +
                    "<td style=\"width: 16.6667%; height: 18px;\"><strong>Term</strong></td>\n" +
                    "<td style=\"width: 16.6667%; height: 18px;\"><strong>Theory</strong></td>\n" +
                    "<td style=\"width: 16.6667%; height: 18px;\"><strong>Application/Lab</strong></td>\n" +
                    "<td style=\"width: 16.6667%; height: 18px;\"><strong>Local Credits</strong></td>\n" +
                    "<td style=\"width: 16.6667%; height: 18px;\"><strong>ECTS</strong></td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 16.6667%; height: 18px;\">" + courseCode + "</td>\n" +
                    "<td style=\"width: 16.6667%; height: 18px;\">" + termDate + "</td>\n" +
                    "<td style=\"width: 16.6667%; height: 18px;\">" + theoryTime + "</td>\n" +
                    "<td style=\"width: 16.6667%; height: 18px;\">" + labTime + "</td>\n" +
                    "<td style=\"width: 16.6667%; height: 18px;\">" + localCredits + "</td>\n" +
                    "<td style=\"width: 16.6667%; height: 18px;\">" + ectsCredits + "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 100%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"border-collapse: collapse; width: 100%; height: 72px;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 50%; height: 18px;\"><strong>Prerequisites</strong></td>\n" +
                    "<td style=\"width: 50%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 50%; height: 18px;\"><strong>Course Language</strong></td>\n" +
                    "<td style=\"width: 50%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 50%; height: 18px;\"><strong>Course Type</strong></td>\n" +
                    "<td style=\"width: 50%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 50%; height: 18px;\"><strong>Course Level</strong></td>\n" +
                    "<td style=\"width: 50%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 100%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"border-collapse: collapse; width: 100%;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 50%;\"><strong>Course Coordinator</strong></td>\n" +
                    "<td style=\"width: 50%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 50%;\"><strong>Course Lecturer(s)</strong></td>\n" +
                    "<td style=\"width: 50%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 50%;\"><strong>Assistant(s)</strong></td>\n" +
                    "<td style=\"width: 50%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 100%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"border-collapse: collapse; width: 100%;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 50%;\"><strong>Course Objectives</strong></td>\n" +
                    "<td style=\"width: 50%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 50%;\"><strong>Learning Outcomes</strong></td>\n" +
                    "<td style=\"width: 50%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 50%;\"><strong>Course Description</strong></td>\n" +
                    "<td style=\"width: 50%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 100%;\">\n" +
                    "<table style=\"width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 100%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"height: 35px; width: 100%; border-collapse: collapse; background-color: #ffa500;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 100%; height: 18px;\"><strong>2. Weekly Subjects and Required Materials</strong></td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 100%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"border-collapse: collapse; width: 100%; height: 288px;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>Week</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\"><strong>Subjects</strong></td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\"><strong>Required Materials</strong></td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>1</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>2</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>3</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>4</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>5</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>6</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>7</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>8</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>9</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>10</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>11</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>12</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>13</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>14</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 10.523%; height: 18px;\"><strong>15</strong></td>\n" +
                    "<td style=\"width: 38.9903%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 10.523%;\"><strong>16</strong></td>\n" +
                    "<td style=\"width: 38.9903%;\">&nbsp;</td>\n" +
                    "<td style=\"width: 50.4866%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 100%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"border-collapse: collapse; width: 100%;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 37.7737%;\"><strong>Course Notes/Textbooks</strong></td>\n" +
                    "<td style=\"width: 62.2263%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 37.7737%;\"><strong>Suggested Readings/Materials</strong></td>\n" +
                    "<td style=\"width: 62.2263%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 100%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"height: 18px; width: 100%; border-collapse: collapse; background-color: #ffa500;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 100%; height: 18px;\">\n" +
                    "<p><strong>3. Assesment</strong></p>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 100%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"border-collapse: collapse; width: 100%; height: 234px;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 29.3187%; height: 18px;\"><strong>Semester Activities</strong></td>\n" +
                    "<td class=\"td1\" style=\"width: 16.2409%; height: 18px;\" valign=\"top\">\n" +
                    "<p class=\"p1\"><strong>Number<span class=\"Apple-converted-space\">&nbsp;</span></strong></p>\n" +
                    "</td>\n" +
                    "<td class=\"td1\" style=\"width: 54.3796%; height: 18px;\" valign=\"top\">\n" +
                    "<p class=\"p1\"><strong>Weigthing<span class=\"Apple-converted-space\">&nbsp;</span></strong></p>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 29.3187%; height: 18px;\">Participation</td>\n" +
                    "<td style=\"width: 16.2409%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 54.3796%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 29.3187%; height: 18px;\">Laboratory/Application</td>\n" +
                    "<td style=\"width: 16.2409%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 54.3796%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 29.3187%; height: 18px;\">Field Work</td>\n" +
                    "<td style=\"width: 16.2409%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 54.3796%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 29.3187%; height: 18px;\">Quiz/Studio Critique</td>\n" +
                    "<td style=\"width: 16.2409%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 54.3796%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 29.3187%; height: 18px;\">Homework/Assignment</td>\n" +
                    "<td style=\"width: 16.2409%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 54.3796%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 29.3187%; height: 18px;\">Presentation/Jury</td>\n" +
                    "<td style=\"width: 16.2409%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 54.3796%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 29.3187%; height: 18px;\">Project</td>\n" +
                    "<td style=\"width: 16.2409%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 54.3796%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 29.3187%; height: 18px;\">Seminar/Workshop</td>\n" +
                    "<td style=\"width: 16.2409%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 54.3796%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 29.3187%; height: 18px;\">Oral Exam</td>\n" +
                    "<td style=\"width: 16.2409%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 54.3796%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 29.3187%; height: 18px;\">Midterm</td>\n" +
                    "<td style=\"width: 16.2409%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 54.3796%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 29.3187%; height: 18px;\">Final Exam</td>\n" +
                    "<td style=\"width: 16.2409%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 54.3796%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 29.3187%; height: 18px;\">Total</td>\n" +
                    "<td style=\"width: 16.2409%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 54.3796%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 100%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"width: 100%; border-collapse: collapse; background-color: #ffa500;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 100%;\">\n" +
                    "<p><strong>4. ECTS / Workload Table</strong></p>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"width: 100%; border-collapse: collapse; border-style: hidden;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 100%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>\n" +
                    "<table style=\"border-collapse: collapse; width: 100%; height: 198px;\" border=\"1\">\n" +
                    "<tbody>\n" +
                    "<tr style=\"height: 36px;\">\n" +
                    "<td style=\"width: 43.2481%; height: 36px;\"><strong>Semester Activities</strong></td>\n" +
                    "<td style=\"width: 13.5037%; height: 36px;\"><strong>Number</strong></td>\n" +
                    "<td style=\"width: 13.5036%; height: 36px;\"><strong>Duration</strong></td>\n" +
                    "<td class=\"td1\" style=\"width: 29.5621%; height: 36px;\" valign=\"top\">\n" +
                    "<p class=\"p1\"><strong>Workload<span class=\"Apple-converted-space\">&nbsp;</span></strong></p>\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 43.2481%; height: 18px;\">Course Hours</td>\n" +
                    "<td style=\"width: 13.5037%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 13.5036%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 29.5621%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 43.2481%; height: 18px;\">Laboratory/Application Hours</td>\n" +
                    "<td style=\"width: 13.5037%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 13.5036%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 29.5621%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 43.2481%; height: 18px;\">Study Hours out of Class</td>\n" +
                    "<td style=\"width: 13.5037%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 13.5036%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 29.5621%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 43.2481%; height: 18px;\">Field Work</td>\n" +
                    "<td style=\"width: 13.5037%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 13.5036%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 29.5621%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 43.2481%; height: 18px;\">Quiz/Studio Critique</td>\n" +
                    "<td style=\"width: 13.5037%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 13.5036%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 29.5621%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 43.2481%; height: 18px;\">Homework/Assignments</td>\n" +
                    "<td style=\"width: 13.5037%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 13.5036%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 29.5621%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 43.2481%; height: 18px;\">Presentation/Jury</td>\n" +
                    "<td style=\"width: 13.5037%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 13.5036%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 29.5621%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 43.2481%; height: 18px;\">Project</td>\n" +
                    "<td style=\"width: 13.5037%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 13.5036%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 29.5621%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr style=\"height: 18px;\">\n" +
                    "<td style=\"width: 43.2481%; height: 18px;\">Seminar/Workshop</td>\n" +
                    "<td style=\"width: 13.5037%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 13.5036%; height: 18px;\">&nbsp;</td>\n" +
                    "<td style=\"width: 29.5621%; height: 18px;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 43.2481%;\">Oral Exam</td>\n" +
                    "<td style=\"width: 13.5037%;\">&nbsp;</td>\n" +
                    "<td style=\"width: 13.5036%;\">&nbsp;</td>\n" +
                    "<td style=\"width: 29.5621%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 43.2481%;\">Midterm</td>\n" +
                    "<td style=\"width: 13.5037%;\">&nbsp;</td>\n" +
                    "<td style=\"width: 13.5036%;\">&nbsp;</td>\n" +
                    "<td style=\"width: 29.5621%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 43.2481%;\">Final Exam</td>\n" +
                    "<td style=\"width: 13.5037%;\">&nbsp;</td>\n" +
                    "<td style=\"width: 13.5036%;\">&nbsp;</td>\n" +
                    "<td style=\"width: 29.5621%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td style=\"width: 43.2481%;\">&nbsp;</td>\n" +
                    "<td style=\"width: 13.5037%;\">&nbsp;</td>\n" +
                    "<td class=\"td1\" style=\"width: 13.5036%;\" valign=\"top\">\n" +
                    "<p class=\"p1\"><strong>Total<span class=\"Apple-converted-space\">&nbsp;</span></strong></p>\n" +
                    "</td>\n" +
                    "<td style=\"width: 29.5621%;\">&nbsp;</td>\n" +
                    "</tr>\n" +
                    "</tbody>\n" +
                    "</table>");
            downloadedWriter.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(messageWindow, "Something went wrong! Error Code:" + e);
        }
    }
}
