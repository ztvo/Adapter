import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PDFReportAdapter implements IReportGenerator {
    public void generateReport(String text) {
        System.out.println("Generating PDF report ...");
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("iText.pdf"));
            document.open();
            Chunk chunk = new Chunk(text);
            document.add(chunk);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}

