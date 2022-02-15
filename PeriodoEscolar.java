package horarioescolar;

/**
 * @author      Geovani Lopes Dias <geovani.phy.dias @ gmail.com>
 * @version     1.0
 * @since       1.0
 * @abstracts Um período escolar, com seu turno, ordenação e horário de início.
 * <p>
 * 
 */
public class PeriodoEscolar {
    String turno;
    int ordem, diaSemana; int[] horaInicio;
    
    //Construtores, getters, setters e toString:
    
    // Construtor simples: para atributo disponibilidade da classe Professor.
    public PeriodoEscolar(String turno, int diaSemana, int[]horaInicio) {
        boolean turnoEstaOK = MatrizesDeControle.testeTurno(turno);
        if (turnoEstaOK) {this.turno = turno;}
        if (diaSemana > 1 && diaSemana < 7){this.diaSemana = diaSemana;}
        else {throw new InvalidTypeException("Dia da semana deve estar entre 1 e 7");}
        this.horaInicio = horaInicio;}
    
    // Construtor completo: para atributo horarioSemanal da classe Turma.
    public PeriodoEscolar(String turno, int ordem, int diaSemana, int[]horaInicio) {
        boolean turnoEstaOK = MatrizesDeControle.testeTurno(turno);
        if (turnoEstaOK) {this.turno = turno;}
        if (diaSemana > 1 && diaSemana < 7){this.diaSemana = diaSemana;}
        else {throw new InvalidTypeException("Dia da semana deve estar entre 1 e 7");}
        this.ordem = ordem;
        this.horaInicio = horaInicio;
    }

    public String getTurno() {return turno;}
    public void setTurno(String turno) {
        boolean turnoEstaOK = MatrizesDeControle.testeTurno(turno);
        if (turnoEstaOK) {this.turno = turno;}}

    public int getOrdem() {return ordem;}
    public void setOrdem(int ordem){
        if (ordem > 1) {this.ordem = ordem;}
        else {throw new InvalidTypeException("A série de uma turma deve ser um valor maior que 0");}}

    public int[] getHoraInicio() {return horaInicio;}
    public void setHoraInicio(int[] horaInicio) {this.horaInicio = horaInicio;}

    public int getDiaSemana() {return diaSemana;}
    public void setDiaSemana(int diaSemana) {
        if (diaSemana > 1 && diaSemana < 7){this.diaSemana = diaSemana;}
        else {throw new InvalidTypeException("Dia da semana deve estar entre 1 e 7");}}
    
    @Override
    public String toString() {
        String fim;
        if (horaInicio[1] == 0){fim = "0";} else{fim = "";}
        return ordem+"º período da "+turno+
                " inicia às "+horaInicio[0]+":"+horaInicio[1]+fim;}
    
    
    
}
