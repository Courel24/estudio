package co.edu.unisabana.usuario.service;

import co.edu.unisabana.usuario.Book;
import co.edu.unisabana.usuario.ClaseCliente;

//snake_case
//CamelCase
public class ClasePrueba {

    private ClaseCliente cliente;

    public ClasePrueba(ClaseCliente cliente) {
        this.cliente = cliente;
    }

    public String generarSaludo() {
        return cliente.obtenerSaludo();
    }

    public int sumar(int num1, int num2) {
        return num1 + num2;
    }

    public String obtenerMensaje(int numero) {
        if (numero % 2 == 0) {
            return "hola";
        } else {
            return "chao";
        }
    }

    public boolean esMayorDe5(int numero) {
        return numero > 5;
    }


    public int registrarLibro(Book book) {
        if ("Violencia".equals(book.getCategory())) {
            return 0;
        } else {
            //regitramos......bla bla
            return 1;
        }
    }

    public int suma(int numero1, int numero2) {
        System.out.println("Voy a sumar " + numero1);
        return numero1 + numero2;

    }

    public int restar(int numero1, int numero2) {
        return numero1 - numero2;
    }


}
