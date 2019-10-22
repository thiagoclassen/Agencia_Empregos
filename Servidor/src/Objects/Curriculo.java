package Objects;

import java.io.Serializable;

public class Curriculo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String contato;
    private String area;
    private int cargaHoraria;
    private int salario;

    public Curriculo() {
    }

    public Curriculo(String nome, String contato, String area, int cargaHoraria, int salario) {
        this.nome = nome;
        this.contato = contato;
        this.area = area;
        this.cargaHoraria = cargaHoraria;
        this.salario = salario;
    }

    // #region Getters and Setters
    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // #endregion

}