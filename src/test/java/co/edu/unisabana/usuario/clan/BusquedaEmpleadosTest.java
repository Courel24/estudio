package co.edu.unisabana.usuario.clan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BusquedaEmpleadosTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private BusquedaEmpleados busquedaEmpleados;

    /**
     * La preparación de la data -> Opcional, solo si es necesario
     * ¿Que estoy probando? (que estoy invocando )
     * Assertions / Verify
     */
    @Test
    void Given_name_is_not_null_When_invoke_search_Then_return_Employee() {
        String employeeName = "Juan David";
        Mockito.when(employeeRepository.searchEmployee(employeeName)).thenReturn("Saavedra");

        Employee juan = busquedaEmpleados.getEmployeeByName(employeeName);

        Assertions.assertEquals(true, juan.isLonger());
        //Adicional a los asserts, utilizamos verify para verificar si un llamado fue hecho o no
        Mockito.verify(employeeRepository).searchEmployee(employeeName);

    }
}