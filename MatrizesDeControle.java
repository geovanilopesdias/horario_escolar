package horarioescolar;

import java.util.Arrays;

/**
 * @author      Geovani Lopes Dias <geovani.phy.dias @ gmail.com>
 * @version     1.0
 * @since       1.0
 * @use Matrizes e testes para segurança de setting.
 * <p>
 * ...
 */

public class MatrizesDeControle {
/**
 * Matriz 2D que cataloga as diferentes disciplinas e suas siglas.
 * <p>
 * Para restrições de modificações no atributo disciplinas.
 */
    public static final String[][] DISCIPLINAS = {
        {"AT", "artes"},
        {"BI", "biologia"},
        {"CI", "ciências"},
        {"EF", "educação física"},
        {"ER", "ensino religioso"},
        {"ES", "língua espanhola"},
        {"FC", "física"},
        {"FL", "filosofia"},
        {"GG", "geogragia"},
        {"HT", "história"},
        {"IN", "língua inglesa"},
        {"LT", "literatura"},
        {"MT", "matemática"},
        {"MS", "música"},
        {"PT", "língua portuguesa"},
        {"PV", "projetos de vida"},
        {"QM", "química"},
        {"RD", "redação"},
        {"RB", "robótica"},
        {"SL", "sociologia"},
        {"TT", "teatro"},
    };
    
    /**
    * Vetor que cataloga os diferentes tipos de turma.
    * <p>
    * Para restrições de cadastro do atributo tipo da classe Turma.
    */
    public static final String[] TIPO_TURMA = {
        "educação infantil",
        "ensino fundamental inicial regular",
        "ensino fundamental final regular",
        "ensino fundamental integral",
        "ensino médio regular",
        "ensino médio integral",
        "ensino médio técnico",
        "ensino técnico"
    };
    
    // Testes de validação de atributos:
    public static boolean testeDisciplina(String disciplinaDesejada){
        for (String[] d : MatrizesDeControle.DISCIPLINAS) {
            if (d[0].equals(disciplinaDesejada)) {return true;}}
        return false;}
    
    public static boolean testeTipoTurma(String tipoDesejado){
        for (String tipo: TIPO_TURMA)
            {if (tipo.equals(tipoDesejado)) {return true;}}
        return false;}
    
    public static boolean testeTurno(String turnoDesejado){
        String[] turnos = {"manhã", "tarde", "noite"};
        for (String turno: turnos)
            {if (turno.equals(turnoDesejado)) {return true;}}
         return false;}
    
    public static boolean boolStrBinSearch(String[] array, String item){
        Arrays.sort(array);
        int low = 0, high = array.length-1, mid;
        while (low <= high) {
            mid = (low+high)/2;
            if (array[mid].compareTo(item) < 0) {low = mid+1;}
            else if (array[mid].compareTo(item) > 0) {high = mid-1;}
            else {return true;}}
        return false;}
    
    public static void testeTurmas(Turma[] turmas){
        String[] numerosDasTurmas = new String[turmas.length-1];
        String numeroPrimeiraTurma = turmas[0].getNumero();
        for (int i = 0; i < turmas.length-1; i++)
            {numerosDasTurmas[i] = turmas[i+1].getNumero();}
        
        boolean testeOK = boolStrBinSearch(numerosDasTurmas, numeroPrimeiraTurma);
        if (!testeOK){} else {throw new HomonymSchoolclass();}}
    
    // Métodos de instanciamento para testes de funcionalidades da classe principal:
    
    /**
    * Define um conjunto de periodos para teste.
    * <p>
    * Para restrições de cadastro do atributo tipo da classe Turma.
    * @param t: turno desejado.
    * @param n: número de períodos no turno.
    * @param d: duração de cada período em minutos.
    * @return um vetor com um número de instâncias da classe PeriodoEscolar para teste.
    */
//    public static PeriodoEscolar[] defineHorarioTeste(String t, int n, int d){
//        if (d < 30 || d > 60) {throw new InvalidTypeException("Um período de teste deve estar entre 30 e 60 min");}
//        boolean turnoOK = testeTurno(t); if (turnoOK){} else{throw new InvalidTypeException("Turno inválido para instanciamento");}
//        
//        PeriodoEscolar[] periodos = new PeriodoEscolar[n];
//        int i = 1; int[] hInicio = new int[2]; String turno;
//        switch (t){
//            case "manhã": hInicio[0] = 7; hInicio[1] = 0; break;
//            case "tarde": hInicio[0] = 13; hInicio[1] = 30; break;
//            default: hInicio[0] = 18; hInicio[1] = 00;}
//        System.out.println("Teste de períodos:");
//        for (PeriodoEscolar p: periodos){
//            p = new PeriodoEscolar(t, i, hInicio);
//            System.out.println(p);
//            i++;
//            if (i != 4 && (hInicio[1] + d) < 60){hInicio[1] += d;}
//            else if (i != 4 && (hInicio[1] + d) >= 60) {hInicio[0]++; hInicio[1] += (d-60);}
//            else if (i == 4 && (hInicio[1] + d + 15) < 60) {hInicio[1] += (d+15);}
//            else {hInicio[0]++; hInicio[1] += (d+15-60);}}
//        return periodos;}
    
    public static Professor[] defineCorpoDocente(){
        // Definição dos horários:
        int[] inicioNoite = {19,0};
        PeriodoEscolar segNoite = new PeriodoEscolar("noite", 2, inicioNoite);
        PeriodoEscolar terNoite = new PeriodoEscolar("noite", 3, inicioNoite);
        PeriodoEscolar quaNoite = new PeriodoEscolar("noite", 4, inicioNoite);
        PeriodoEscolar quiNoite = new PeriodoEscolar("noite", 5, inicioNoite);
        PeriodoEscolar sexNoite = new PeriodoEscolar("noite", 6, inicioNoite);
        
        // Disciplinas por formação
        String[] bio = {"BI", "CI", "ER", "PV"}, qui = {"QM", "FC"}, mat = {"MT", "ER"},
            por = {"PT", "LT"}, ing = {"PT", "LT", "IN"}, esp = {"PT", "LT", "ES"},
            edf = {"EF"}, hum = {"FL", "GG", "HT", "SL"};
        PeriodoEscolar[] qq = {segNoite, terNoite, quaNoite, quiNoite, sexNoite};
        
        PeriodoEscolar[] d1 = {segNoite, sexNoite};
        Professor p1 = new Professor("Alessandra E. Pilger Weschenfelder", false, 16, bio, d1);
        PeriodoEscolar[] d2 = {terNoite, quaNoite};
        Professor p2 = new Professor("Andréa Cristina Scherer", false, 16, hum, d2);
        PeriodoEscolar[] d3 = {segNoite, quaNoite, quiNoite, sexNoite};
        Professor p3 = new Professor("Cristiani G. Lins Kerber", false, 16, ing, d3);
        PeriodoEscolar[] d4 = {terNoite, quaNoite, quiNoite};
        Professor p4 = new Professor("Geovani Lopes Dias", false, 16, qui, d4);
        PeriodoEscolar[] d5 = {segNoite, sexNoite};
        Professor p5 = new Professor("Luciano Henrique Shcerer", false, 32, por, d5);
        PeriodoEscolar[] d6 = {terNoite, quaNoite, quiNoite, sexNoite};
        Professor p6 = new Professor("Maria Eunice Hansen", false, 32, bio, d6);
        PeriodoEscolar[] d7 = {segNoite, sexNoite};
        Professor p7 = new Professor("Márcia Maria Etzberger", false, 24, esp, d7);
        PeriodoEscolar[] d8 = qq.clone();
        Professor p8 = new Professor("Márcia Maria Etzberger", false, 16, edf, d8);
        PeriodoEscolar[] d9 = {terNoite, quiNoite};
        Professor p9 = new Professor("Marilene Emerelse Rhoden", true, 16, esp, d9);
        PeriodoEscolar[] d10 = qq.clone();
        Professor p10 = new Professor("Marili Closs Musskopf", false, 16, hum, d10);
        PeriodoEscolar[] d11 = {terNoite, quaNoite, quiNoite};
        Professor p11 = new Professor("Marriete Lucas Marques", false, 16, mat, d11);
        PeriodoEscolar[] d12 = {segNoite, quaNoite};
        Professor p12 = new Professor("Patrícia F. Mossmann", false, 16, mat, d12);
        PeriodoEscolar[] d13 = {segNoite, quaNoite};
        Professor p13 = new Professor("Rutia Ivania Muller", false, 24, ing, d13);
        PeriodoEscolar[] d14 = {quiNoite};
        Professor p14 = new Professor("Samuel Pletsch", false, 3, qui, d14);
        
        Professor[] profs = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
            p11, p12, p13, p14};
        return profs;
    }
 }
