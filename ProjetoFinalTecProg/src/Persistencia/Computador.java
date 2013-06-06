/**
 * Universidade de Brasilia
 * Faculdade UnB - Campus Gama
 * Disciplina: Tecnicas de Programacao
 * Professor: Giovanni Almeida Santos
 * Projeto Final 
 * Alunos: - Marcos Ronaldo Pereira Junior
 *           Matricula: 09/0124511
 *         - Tiago Gomes Pereira
 *           Matricula: 09/0134222
 * 
 * @author Marcos Ronaldo Pereira Junior
 * @author Tiago Gomes Pereira
 * 
 */
package Persistencia;

import desligamentoremoto.Main;
import java.net.InetAddress;

public class Computador {

    private InetAddress ip;
    private String nome;
    private int horas;
    private int minutos;
    private int segundos;
    private boolean desligavel;

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public boolean isDesligavel() {
        return desligavel;
    }

    public void setDesligavel(boolean desligavel) {
        this.desligavel = desligavel;
    }

    /**
     * Construtor de Computador. Metodo que cria um computador com os parametros recebidos.
     * @param nome nome do computador
     * @param ip endereço ip v4 do computador
     * @param hora hora de desligamento obrigatorio do computador
     * @param minutos minutos de desligamento obrigatorio do computador
     * @param segundos segundos de desligamento obrigatorio do computador
     * @param desligavel indica se o computador pode ser desligado remotamente
     */
    public Computador(InetAddress ip, String nome, int horas, int minutos, int segundos, boolean desligavel) {
        this.ip = ip;
        this.nome = nome;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        this.desligavel = desligavel;
    }

    /**
     * Construtor padrao de computador, de forma a fazer o preenchimento dos atributos
     * depois.
     */
    public Computador() {
    }

    /**
     * Metodo sobrescrito da classe object, para escrever o objeto em forma de string.
     * @return String que representa o estado do objeto
     */
    @Override
    public String toString() {
        if (desligavel) {
            return nome + '\0' + horas + ':' + minutos + ':' + segundos + '\0' + Main.myResources.getString("maquinas.atributo.desligado") + '\n';
        } else {
            return nome + '\0' + horas + ':' + minutos + ':' + segundos + '\0' + Main.myResources.getString("maquinas.atributo.ndesligado")+ '\n';
        }
    }
}
