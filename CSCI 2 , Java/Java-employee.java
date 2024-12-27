
public class Employee 
{
    public static void main(String[] args)
    {
        
    Employee[] emps = new Employee[100];
    SalariedEmp e1 = new SalariedEmp();
    WeeklyEmp e2 = new WeeklyEmp();
    HourlyEmp e3 = new HourlyEmp();
    emps[0] = e1;
    emps[1] = e2;
    emps[2] = e3;
    
    for(Employee object: emps)
    {
        System.out.println("The earnings for the employee is:"+ object.earnings());
    }
    }

}
