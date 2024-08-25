package com.EmployeePayrollSystem;


import java.util.ArrayList;

public abstract class Employee {
    private String name;
    private int id;
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employeee [name " + name+", id= "+id+", Salary: "+calculateSalary()+" ]";
    }
}

class FullTimeEmployee extends Employee{
    private double sal;

    public FullTimeEmployee(String name, int id, double sal) {
        super(name, id);
        this.sal = sal;
    }

    @Override
    public double calculateSalary() {
        return sal;
    }

}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private int daysWorked;

    public PartTimeEmployee(String name, int id, int hoursWorked, int daysWorked) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.daysWorked = daysWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked*daysWorked;
    }
}

class PayRollSystem{

    ArrayList<Employee> employeesList;
    public PayRollSystem(){
            employeesList=new ArrayList<>();
    }

    public void addEmployee(Employee E){
        employeesList.add(E);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for (Employee employee : employeesList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeesList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for (Employee emp : employeesList){
            System.out.println(emp);
        }
    }
}

class EmployeePayrollSystemMain
{
    public static void main(String[] args) {
        PayRollSystem payRollSystem=new PayRollSystem();
        FullTimeEmployee emp1= new FullTimeEmployee("Ayan Mirza",101,45000.0);
        PartTimeEmployee emp2=new PartTimeEmployee("Himanshu",102,450,25);
        FullTimeEmployee emp3= new FullTimeEmployee("Mohit",103,90000.0);
        FullTimeEmployee emp4= new FullTimeEmployee("Priyanshu",104,100000.0);
        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);
        payRollSystem.addEmployee(emp3);
        payRollSystem.addEmployee(emp4);

        System.out.println("--------Employees Details---------");
        payRollSystem.displayEmployees();
        payRollSystem.removeEmployee(emp3.getId());
        System.out.println("--------Employees Details---------");
        payRollSystem.displayEmployees();
    }
}

