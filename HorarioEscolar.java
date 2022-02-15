package horarioescolar;

/**
 * @author      Geovani Lopes Dias <geovani.phy.dias@gmail.com>
 * @version     1.0
 * @since       1.0
 */
public class HorarioEscolar {

    public static void main(String[] args) {
        
    // Construção das turmas para teste
        String tipo = "ensino médio regular";
        Turma t111 = new Turma("1", tipo, "111", "noite");
        Turma t112 = new Turma("1", tipo, "112", "noite");
        Turma t211 = new Turma("2", tipo, "211", "noite");
        Turma t311 = new Turma("3", tipo, "311", "noite");
        Turma t312 = new Turma("3", tipo, "312", "noite");
        Turma[] turmasNoturno = {t111, t112, t211, t311, t312};
        MatrizesDeControle.testeTurmas(turmasNoturno);
        Professor[] professores = MatrizesDeControle.defineCorpoDocente();
        for (Professor p: professores) {System.out.println(p.toString());}
        //Construção dos docentes para teste:
    }
    
}
