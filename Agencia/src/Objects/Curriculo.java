package Objects;

import java.io.Serializable;
import java.util.Scanner;

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

    // metodo auxiliar para preencher o objeto
    public void preencherCampos() {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Qual o Nome?");
        this.setNome(keyboard.nextLine());

        System.out.println("Qual o contato?");
        this.setContato(keyboard.nextLine());

        System.out.println("Qual a area de interesse?");
        this.setArea(keyboard.nextLine());

        System.out.println("Qual a carga horaria?");
        this.setCargaHoraria(keyboard.nextInt());
        keyboard.nextLine();

        System.out.println("Qual o salario?");
        this.setSalario(keyboard.nextInt());
        keyboard.nextLine();

        keyboard.close();
    }

    // metodo auxiliar para imprimir o objeto
    public void print() {
        System.out.println("===========================================================");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Contato: " + this.getContato());
        System.out.println("area: " + this.getArea());
        System.out.println("Carga Horaria: " + this.getCargaHoraria());
        System.out.println("Salario" + this.getSalario());
        System.out.println("===========================================================");
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