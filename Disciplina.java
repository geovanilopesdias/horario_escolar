package horarioescolar;

/**
 * @author      Geovani Lopes Dias <geovani.phy.dias @ gmail.com>
 * @version     1.0
 * @since       1.0
 * @abstraction Turma com suas disciplinas, turno e professores.
 * <p>
 * ...
 */
public class Disciplina {
    String nome, codigo;
    Professor prof;
    int numPeriodos;

    public Disciplina(String nome, Professor prof, int numPeriodos) {
        this.nome = nome;
        this.prof = prof;
        this.numPeriodos = numPeriodos;
    }
    
    

}

