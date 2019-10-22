package Objects;

import java.io.Serializable;

public class Vaga implements Serializable {

    private static final long serialVersionUID = 1L;

    private String empresa;
    private String contato;
    private String area;
    private int cargaHoraria;
    private int salario;

    public Vaga() {
    }

    public Vaga(String empresa, String contato, String area, int cargaHoraria, int salario) {
        this.empresa = empresa;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    // #endregion

}