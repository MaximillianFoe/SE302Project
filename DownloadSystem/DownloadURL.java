import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class DownloadURL {
    public static void main(String[] args) throws IOException {
        String courseSite = "https://ce.ieu.edu.tr/tr/syllabus/type/read/id/SE+302";
        Connection connectionToCourse = Jsoup.connect(courseSite);
        Document sitePart = connectionToCourse.get();
        String courseName = sitePart.body().text();
        String courseCode = sitePart.body().text();
        String termDate = sitePart.body().text();
        String result = sitePart.body().text();
        System.out.println(result);
}
}
