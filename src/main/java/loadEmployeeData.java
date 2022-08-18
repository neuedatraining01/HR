
import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.util.converter.IntegerStringConverter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import java.sql.Connection;
class LoadEmployeeData {

    //   private String fileLocation;
    //   FileInputStream inFile;
    private List<Employee> employees = new ArrayList<>();
    private Scanner sc;
    private HSSFWorkbook workbook = new HSSFWorkbook();
    private HSSFSheet sheet;
    private int badDataCount = 0;

    public LoadEmployeeData() throws FileNotFoundException {
//        System.out.println("In Constructor");
    }

    public void startLoad() throws IOException {
        readWorksheet();
        validateDataAndLoadTable();
    }

    private void readWorksheet() throws IOException {
        //    Class.forName("com.mysql.cj.jdbc.Driver");
        //sc = new Scanner(new File("C:\\Users\\Administrator\\employees.csv"));
        String line = "";
        String splitBy = ",";
        Employee employee = new Employee();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\employees.csv"));
        if (br.readLine() == null) {  //get rid of header line
            return;
        }
        //sc.useDelimiter(",");
        //int linecnt=0;
        // while (linecnt++ < 3 && (line = br.readLine()) != null) {
        while ((line = br.readLine()) != null) {
            employee = new Employee();
            String[] empl = line.split(splitBy);
            //          System.out.println(empl[0] + empl[1] + empl[2] + empl[3] + empl[4] + empl[5] + empl[6]);
            //employee.setEmployeeID((Integer empl[0]);
            employee.setEmployeeID(empl[0]);
            employee.setTitle(empl[1]);
            employee.setfName(empl[2]);
            employee.setsName(empl[3]);
            employee.setManagerEmployeeID(empl[4]);
            employee.setStartDate(LocalDate.parse(empl[5]));
            employee.setSalary(Double.parseDouble(empl[6]));
            employees.add(employee);
            System.out.println(employee.toString());
        }
        System.out.println(employees.size());

        for (Employee e : employees) {
            System.out.println(e);
        }
        System.out.println(employees.size());

    }


    private void createErrorLogFileHeader()    {
        sheet = workbook.createSheet("Invalid Data Log");
        HSSFRow header = sheet.createRow(0);
        HSSFCell employeeId = header.createCell(0);
        HSSFCell title = header.createCell(1);
        HSSFCell firstName = header.createCell(2);
        HSSFCell surName = header.createCell(3);
        HSSFCell managerEmployeeId = header.createCell(4);
        HSSFCell startDate = header.createCell(5);
        HSSFCell salary = header.createCell(6);
        employeeId.setCellValue("Employee ID");
        title.setCellValue("Title");
        firstName.setCellValue("First Name");
        surName.setCellValue("SurName");
        managerEmployeeId.setCellValue("Manager EmployeeID");
        startDate.setCellValue("StartDate");
        salary.setCellValue("Salary");
    }

    private void logBadDataRecord(Employee e) {
        HSSFRow row = sheet.createRow(++badDataCount);
        HSSFCell employeeId = row.createCell(0);
        HSSFCell title = row.createCell(1);
        HSSFCell firstName = row.createCell(2);
        HSSFCell surName = row.createCell(3);
        HSSFCell managerEmployeeId = row.createCell(4);
        HSSFCell startDate = row.createCell(5);
        HSSFCell salary = row.createCell(6);
        employeeId.setCellValue(e.getEmployeeID());
        title.setCellValue(e.getTitle());
        firstName.setCellValue(e.getfName());
        surName.setCellValue(e.getsName());
        managerEmployeeId.setCellValue(e.getManagerEmployeeID());
        startDate.setCellValue(e.getStartDate());
        salary.setCellValue(e.getSalary());
    }

private void writeDataSheetToExcel(){
        try {
            workbook.write(new FileOutputStream("C:\\Users\\Administrator\\badDataLog.csv"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            workbook.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void insertData(Employee e) {

    }

    private void validateDataAndLoadTable() {

        createErrorLogFileHeader();
        for (Employee e : employees) {
            if ((e.getfName().isEmpty() || e.getsName().isEmpty() || (e.getSalary() <= 0))) {
                logBadDataRecord(e);
            }
            else insertData(e);
        }
        writeDataSheetToExcel();
    }

}