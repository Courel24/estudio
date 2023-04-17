package co.edu.unisabana.usuario.clan;

public class Employee {
    /**
     * Variables Estaticas
     * Variables de clase
     * constructores
     * Metodos publicos
     * Metodos privados
     */
    private String name;
    private Boolean longer;

    public Employee(String name, Boolean longer) {
        this.name = name;
        this.longer = longer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isLonger() {
        return longer;
    }

    public void setLonger(Boolean longer) {
        this.longer = longer;
    }
}
