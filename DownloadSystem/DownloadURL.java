import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class DownloadURL {
    public static void main(String[] args) throws IOException {
        String page = "https://ce.ieu.edu.tr/tr/syllabus/type/read/id/SE+302/";
        Connection conn = Jsoup.connect(page);
        Document doc = conn.get();
        String courseName = doc.body().text();
        String courseCode = doc.body().text();
        String termDate = doc.body().text();
        String result = doc.body().text();
        System.out.println(result);
}
}