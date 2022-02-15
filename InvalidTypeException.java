package horarioescolar;

/**
 *
 * @author Geovane
 */
public class InvalidTypeException extends RuntimeException{
    public InvalidTypeException(String str) {super (str);}
}

class InvalidDiscipline extends InvalidTypeException{
    public InvalidDiscipline(){super ("Insira um código válido de disciplina.");}
}

class HomonymSchoolclass extends InvalidTypeException{
    public HomonymSchoolclass(){super ("Turmas cadastradas com o mesmo número");}
}
