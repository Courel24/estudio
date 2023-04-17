package co.edu.unisabana.usuario.clan;

public class BusquedaEmpleados {

    private EmployeeRepository employeeRepository;

    //Inyección de dependencias (Patron de diseño)
    public BusquedaEmpleados(EmployeeRepository empleadoRepository) {
        this.employeeRepository = empleadoRepository;
    }

    //Siempre debemos tener categorización de errores
    public Employee getEmployeeByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Nombre vacio no esta permitidio");
        }
        String employee = employeeRepository.searchEmployee(name);
        boolean longer = employee.length() >= 5;
        return new Employee(employee, longer);
    }
}
