package wedsan;

import com.google.gson.annotations.SerializedName;

/**
 * Class representing an employee.
 */
public class Employee {
    @SerializedName("emp_no")
    private String empNo;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("gender")
    private EmployeeGender employeeGender;

    public Employee() {
    }

    public Employee(String empNo, String firstName, String lastName) {
        this.empNo = empNo;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeGender getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(EmployeeGender employeeGender) {
        this.employeeGender = employeeGender;
    }
}
