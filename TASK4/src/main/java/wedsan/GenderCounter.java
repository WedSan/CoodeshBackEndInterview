package wedsan;


import java.util.List;
/**
 * Class that counts the quantity of employees for each gender.
 */
public class GenderCounter {

    public GenderCounter() {
    }
    /**
     * Counts the quantity of employees for each gender.
     *
     * @param employees List of employees
     * @return GenderCounterRecord object containing the count of male and female employees
     */
    public GenderCounterRecord countGenders(List<Employee> employees) {

        int maleCounter = 0;
        int femaleCounter = 0;

        for(Employee employee : employees) {
            if(employee.getEmployeeGender().equals(EmployeeGender.M)) {
                maleCounter++;
            }
            else{
                femaleCounter++;
            }
        }

        return new GenderCounterRecord(maleCounter, femaleCounter);
    }
}
