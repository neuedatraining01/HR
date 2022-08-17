import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();
LoadEmployeeData loadEmployeeData = new LoadEmployeeData();
loadEmployeeData.readWorksheet(employees);
        System.out.println(employees.toString());
    }
}
