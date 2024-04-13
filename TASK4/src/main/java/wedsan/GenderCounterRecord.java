package wedsan;

import com.google.gson.annotations.SerializedName;
/**
 * Class representing the result of counting employee genders.
 */
public class GenderCounterRecord {

    @SerializedName("employees_male")
    private int employeesMale;

    @SerializedName("employees_female")
    private int employeesFemale;

    public GenderCounterRecord(int male, int female) {
        this.employeesMale = male;
        this.employeesFemale = female;
    }

    public int getEmployeesMale() {
        return employeesMale;
    }

    public void setEmployeesMale(int employeesMale) {
        this.employeesMale = employeesMale;
    }

    public int getEmployeesFemale() {
        return employeesFemale;
    }

    public void setEmployeesFemale(int employeesFemale) {
        this.employeesFemale = employeesFemale;
    }
}
