package horarioescolar;

/**
 * @author      Geovani Lopes Dias <geovani.phy.dias @ gmail.com>
 * @version     1.0
 * @since       1.0
 * @abstraction Turma com suas disciplinas, turno e professores.
 * <p>
 * ...
 */
public class Turma {
    String serie, tipo, numero, turno;
    Disciplina[] quadroCurricular;
    int periodosDiarios;
    PeriodoEscolar[] horarioSemanal;
    
    //Construtores, getters e setters:
    public Turma(String tipo, String serie, String numero, String turno) {
        boolean tipoEstaOK = MatrizesDeControle.testeTipoTurma(tipo);
        boolean turnoEstaOK = MatrizesDeControle.testeTurno(turno);
        this.serie = serie;
        this.numero = numero;
        if (turnoEstaOK) {this.turno = turno;}
        if (tipoEstaOK) {this.tipo = tipo;}
    }

    public String getSerie() {return serie;}
    public void setSerie(String serie) {this.serie = serie;}

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getNumero() {return numero;}
    public void setNumero(String numero) {this.numero = numero;}

    public String getTurno() {return turno;}
    public void setTurno(String turno) {
        boolean turnoEstaOK = MatrizesDeControle.testeTurno(turno);
        if (turnoEstaOK) {this.turno = turno;}
    }

    public Disciplina[] getQuadroCurricular() {return quadroCurricular;}
    public void setQuadroCurricular(Disciplina[] quadroCurricular) {this.quadroCurricular = quadroCurricular;}

    public int getPeriodosDiarios() {return periodosDiarios;}
    public void setPeriodosDiarios(int periodosDiarios) {this.periodosDiarios = periodosDiarios;}

    public PeriodoEscolar[] getHorarioSemanal() {return horarioSemanal;}
    public void setHorarioSemanal(PeriodoEscolar[] horarioSemanal) {
        for (PeriodoEscolar p: horarioSemanal){
            if (!p.getTurno().equals(this.turno))
                {throw new InvalidTypeException("Turno do período deve coincidir com turno da turma");}}
        if (horarioSemanal.length == (5*this.periodosDiarios))
            {this.horarioSemanal = horarioSemanal;}
        else {throw new InvalidTypeException("O número de períodos semanais deve ser coerente com o número de períodos diários");}}
    
    

}
