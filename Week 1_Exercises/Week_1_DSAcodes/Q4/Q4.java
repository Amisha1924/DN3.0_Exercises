public class Q4 {
    
    // Employee class
    static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        // Constructor
        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        // Getters and Setters
        public int getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "employeeId=" + employeeId +
                    ", name='" + name + '\'' +
                    ", position='" + position + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    // EmployeeManagementSystem class
    private Employee[] employees;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    // Constructor
    public Q4() {
        employees = new Employee[INITIAL_CAPACITY];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size >= employees.length) {
            resize();
        }
        employees[size++] = employee;
    }

    // Search for an employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null; // Not found
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                // Shift elements to the left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null; // Clear the last element
                return true; // Successfully deleted
            }
        }
        return false; // Not found
    }

    // Resize array if needed
    private void resize() {
        int newCapacity = employees.length * 2;
        Employee[] newEmployees = new Employee[newCapacity];
        System.arraycopy(employees, 0, newEmployees, 0, employees.length);
        employees = newEmployees;
    }

    public static void main(String[] args) {
        Q4 ems = new Q4();

        // Add employees
        ems.addEmployee(new Employee(1, "John Doe", "Developer", 60000));
        ems.addEmployee(new Employee(2, "Jane Smith", "Manager", 75000));
        ems.addEmployee(new Employee(3, "Emily Johnson", "Analyst", 50000));

        // Traverse employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Search for an employee
        System.out.println("\nSearching for employee with ID 2:");
        Employee e = ems.searchEmployee(2);
        System.out.println(e != null ? e : "Employee not found");

        // Delete an employee
        System.out.println("\nDeleting employee with ID 2:");
        boolean deleted = ems.deleteEmployee(2);
        System.out.println(deleted ? "Employee deleted" : "Employee not found");

        // Traverse employees again
        System.out.println("\nAll Employees after deletion:");
        ems.traverseEmployees();
    }
}
