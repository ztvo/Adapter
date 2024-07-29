import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int selection;
        boolean exit;
        System.out.println("Выберите формат для отчета:");
        System.out.println("-------------------------\n");
        System.out.println("1 - Pdf");
        System.out.println("2 - Excel");
        System.out.println("3 - Выход");
        exit = false;
        while (!exit) {
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();
            IReportGenerator report;
            switch (selection) {
                case 1:
                    report =  new PDFReportAdapter();
                    report.generateReport("Text для отчета в формате PDF");
                    break;
                case 2:
                    report =  new ExcelReportAdapter();
                    report.generateReport("Text для отчета в формате Excel");
                    break;
                case 3:
                    exit = true;
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Если хотите выйти из приложения - нажмите 3!");
            }
        }
    }
}

