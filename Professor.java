package horarioescolar;

/**
 * @author      Geovani Lopes Dias <geovani.phy.dias @ gmail.com>
 * @version     1.0
 * @since       1.0
 * @abstraction Professor com suas disciplinas e restrições de horário.
 * <p>
 * ...
 */
public class Professor {
    private String nome, cpf;
    private boolean distante;
    private int periodosSemanais, periodosLancados;
    private String[] disc;
    private PeriodoEscolar[] disponibilidade;
  
    // Construtor, getters, setters e toString:
    public Professor(String nome, boolean distante, int periodosSemanais, String[] disc, PeriodoEscolar[] disponibilidades) {
        this.nome = nome;
        this.distante = distante;
        this.periodosSemanais = periodosSemanais;
        this.disc = disc;
        this.disponibilidade = disponibilidades;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}

    public boolean isDistante() {return distante;}
    public void setDistante(boolean distante) {this.distante = distante;}

    public int getPeriodosSemanais() {return periodosSemanais;}
    public void setPeriodosSemanais(int periodosSemanais) {this.periodosSemanais = periodosSemanais;}

    public int getPeriodosLancados() {return periodosLancados;}
    public void setPeriodosLancados(int periodosLancados) {
        if (periodosLancados <= this.periodosSemanais) {this.periodosLancados = periodosLancados;}
        else {throw new InvalidTypeException("Períodos lançados para "+ this.nome +" excedem o valor cadastrado");}}

    public String[] getDisc() {return disc;}
    public void setDisc(String[] disc){
        for (String d: disc){
            boolean discOK = MatrizesDeControle.testeDisciplina(d);
            if (!discOK) {throw new InvalidTypeException("Disciplina inválida cadastrada para prof. "+this.nome);}}
        this.disc = disc;}

    public PeriodoEscolar[] getDisponibilidade() {return disponibilidade;}
    public void setDisponibilidade(PeriodoEscolar[] disponibilidade) {this.disponibilidade = disponibilidade;}

    @Override
    public String toString() {
        String situacao = "O(A) professor(a) " +this.nome+
                " leciona as disciplinas: ";
        for (String d: this.disc){
            for (String[] discCod: MatrizesDeControle.DISCIPLINAS){
                if (discCod[0].equals(d)) {situacao += (discCod[1]+", ");}}}
        situacao += "e tem disponível os horários de ";
        for (PeriodoEscolar d: this.disponibilidade)
            switch (d.getDiaSemana()){
                case 2: situacao += "segunda à "+d.getTurno()+", "; break;
                case 3: situacao += "terça à "+d.getTurno()+", "; break;
                case 4: situacao += "quarta à "+d.getTurno()+", "; break;
                case 5: situacao += "quinta à "+d.getTurno()+", "; break;
                case 6: situacao += "sexta à "+d.getTurno()+", "; break;}    
        return situacao;
    }
    
    
    
}
