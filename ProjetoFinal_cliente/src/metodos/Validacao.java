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
package metodos;

public class Validacao {
    /**
     * Testa se o Sistema Operacional é Windows
     * @return True se for Windows
     */
    public static boolean isWindows() {

        String os = System.getProperty("os.name").toLowerCase();
        //windows
        return (os.indexOf("win") >= 0);

    }
    /**
     * Testa se o Sistema Operacional é Mac
     * @return True se for Mac
     */
    public static boolean isMac() {

        String os = System.getProperty("os.name").toLowerCase();
        //Mac
        return (os.indexOf("mac") >= 0);

    }
    
    /**
     * Testa se o Sistema Operacional é Unix/Linux
     * @return True se for Unix ou Linux
     */
    public static boolean isUnix() {

        String os = System.getProperty("os.name").toLowerCase();
        //linux or unix
        return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);

    }
}
