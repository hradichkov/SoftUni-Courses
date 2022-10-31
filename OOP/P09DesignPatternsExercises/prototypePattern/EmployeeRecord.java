package P09DesignPatternsExercises.prototypePattern;

class EmployeeRecord implements Prototype {
    private int id;
    private String name;
    private String designation;
    private double salary;
    private String address;

    public EmployeeRecord() {
        System.out.println("Files of the employees of the Ministry of Interior Sofia: ");
        System.out.println("---------------------------------------------------------");
        System.out.println("Id" + "\t" + "Name" + "\t" + "Designation" + "\t\t" + "Salary" + "\t\t" + "Address");
    }

    public EmployeeRecord(int id, String name, String designation, double salary, String address) {
        this();
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    public void showRecord() {
        System.out.println(this);
        //System.out.println(toString());
    }

    @Override
    public String toString() {
        return "EmployeeRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public Prototype getClone() {
        return new EmployeeRecord(this.id, this.name, this.designation, this.salary, this.address);
    }
}