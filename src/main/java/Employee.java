import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String employeeID;
    private String title;
    private String fName;
    private String sName;
    private String ManagerEmployeeID;
    private LocalDate StarteDate;
    private Double salary;

    public Employee(String employeeID, String title, String fName, String sName, String managerEmployeeID, LocalDate starteDate, Double salary) {
        this.employeeID = employeeID;
        this.title = title;
        this.fName = fName;
        this.sName = sName;
        ManagerEmployeeID = managerEmployeeID;
        StarteDate = starteDate;
        this.salary = salary;
    }

    public Employee() {

    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getManagerEmployeeID() {
        return ManagerEmployeeID;
    }

    public void setManagerEmployeeID(String managerEmployeeID) {
        ManagerEmployeeID = managerEmployeeID;
    }

    public LocalDate getStarteDate() {
        return StarteDate;
    }

    public void setStarteDate(LocalDate starteDate) {
        StarteDate = starteDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeID == employee.employeeID && ManagerEmployeeID == employee.ManagerEmployeeID && Objects.equals(title, employee.title) && Objects.equals(fName, employee.fName) && Objects.equals(sName, employee.sName) && Objects.equals(StarteDate, employee.StarteDate) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, title, fName, sName, ManagerEmployeeID, StarteDate, salary);
    }

    @Override
    public String
    toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", title='" + title + '\'' +
                ", fName='" + fName + '\'' +
                ", sName='" + sName + '\'' +
                ", ManagerEmployeeID=" + ManagerEmployeeID +
                ", StarteDate=" + StarteDate +
                ", salary=" + salary +
                '}';
    }
}
