import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class junitTesting {
private     Employee e;

    @Test
    public void testingFirstNameIsPresent() {
        //given the employee

        //when first name is missing
        e = new Employee("12345", "Ms.", "", "harte", "54321", LocalDate.parse("2018-08-20") ,22222.d);

        //then record is invalid
        assertEquals(new Boolean(true), e.getfName().length() >0);
    }

    @Test
    public void testForMissingFirstName() {
    //given the employee

    //when first name is missing
        e = new Employee("12345", "Ms.", "", "harte", "54321", LocalDate.parse("2018-08-20") ,22222.d);
        System.out.println(e.getfName().length());
    //then record is invalid
        assertEquals(new Boolean(true), e.getfName().length() <1);
    }

    @Test
    public void testForMissingSurName() {
        //given the employee
        Employee e;

        //when first name is missing
        e = new Employee("12345", "Ms.", "", "harte", "54321", LocalDate.parse("2018-08-20") ,22222.d);

        //then record is valid
        assertEquals(new String("harte"), e.getsName());
    }

    @Test
    public void testForValidSalaryAmount() {
        //given the employee
        Employee e;

        //when first name is missing
        e = new Employee("12345", "Ms.", "", "harte", "54321", LocalDate.parse("2018-08-20") ,0.d);

        //then record is invalid
        assertEquals(new Double(22222.d), e.getSalary());
        e.setSalary(22222.d);
        assertEquals(new Double(22222.d), e.getSalary());
        assertEquals(new Boolean(false), (e.getSalary() > 0.0) );
    }
}
