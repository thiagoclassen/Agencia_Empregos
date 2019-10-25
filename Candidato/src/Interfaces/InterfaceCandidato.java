package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Objects.Curriculo;
import Objects.Vaga;

public interface InterfaceCandidato extends Remote {
    // cadastra um novo curriculo
    public void cadastroCurriculo(InterfaceCli referenciaCli, Curriculo curriculo) throws RemoteException;

    // consuta na lista de vagas
    public ArrayList<Vaga> consultaVagas(InterfaceCli referenciaCli, Vaga vaga) throws RemoteException;

    // registra como subscriber para novas vagas
    public void registrarInteresseVagas(InterfaceCli referenciaCli, String areaInteresse) throws RemoteException;

}