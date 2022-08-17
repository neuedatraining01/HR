
import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.util.converter.IntegerStringConverter;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

//import java.sql.Connection;
class LoadEmployeeData {

 //   private String fileLocation;
 //   FileInputStream inFile;

Scanner sc;

    public LoadEmployeeData() throws FileNotFoundException {
        System.out.println("In Constructor");
    }

    public void readWorksheet(List employees) throws ClassNotFoundException, IOException {
    //    Class.forName("com.mysql.cj.jdbc.Driver");
        //sc = new Scanner(new File("C:\\Users\\Administrator\\employees.csv"));
       String line = "";
       String splitBy = ",";
       Employee employee = new Employee();
       BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Administrator\\employees.csv"));
        //sc.useDelimiter(",");
        while ( (line = br.readLine() ) !=null) {

        String[] empl = line.split(splitBy);
            System.out.println(empl[0]+empl[1]+empl[2]+empl[3]+empl[4]+empl[5]+empl[6]);
            //employee.setEmployeeID((Integer    empl[0]);
            employee.setEmployeeID(empl[0]);
            employee.setTitle(empl[1]);
            employee.setfName(empl[2]);
            employee.setsName(empl[3]);
            employee.setManagerEmployeeID(empl[4]);
//            LocalDate localDate = LocalDate.parse(empl[5]);
//            Double salary = Double.parseDouble(empl[6]);
//            employee.setSalary(salary);
//            //.doubleValue(empl[6]);
            System.out.println(employee.getEmployeeID());
            System.out.println(employee.getTitle());
            System.out.println(employee.getfName());
            System.out.println(employee.getsName());
            System.out.println(employee.getManagerEmployeeID());
//            System.out.println(localDate);
//            System.out.println(employee.getSalary());
            employees.add(employee);
        }
        //sc.close();
    }
}


