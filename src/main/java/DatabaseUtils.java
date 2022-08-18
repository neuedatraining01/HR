import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseUtils {

    private Connection connection;
private int rowCount= 0;
    public DatabaseUtils() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/humanresources","root", "c0nygre");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 public void saveToSQLDatabase (Employee employee) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

            try {
                Statement statement = connection.createStatement();
                String command = "INSERT INTO employee (id, employeeId, title, firstName, surName, managerEmployeeId, startDate, salary) VALUES (" +
                        ++rowCount + ",\"" +employee.getEmployeeID() + "\"," +
                        "\"" +employee.getTitle() + "\"," +
                        "\"" +employee.getfName() + "\"," +
                        "\"" +employee.getsName() + "\"," +
                        "\"" +employee.getManagerEmployeeID() + "\"," +
                        "\"" +employee.getStartDate() + "\"," +
                        (new Double(employee.getSalary())) +")";
                System.out.println(command);
                statement.execute(command);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public String toString() {
        return "DatabaseUtils{}";
    }

}
