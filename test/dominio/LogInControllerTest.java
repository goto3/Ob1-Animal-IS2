package dominio;

import dominio.modelo.personas.Usuario;
import excepciones.AnimalException;
import java.io.File;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LogInControllerTest {
    
    private LogInController logger;
    
    @Test
    public void loadUsersTestExistentFile() throws AnimalException{
        ArrayList<Usuario> usuarios = new ArrayList<>();
        LogInController lc = new LogInController();
        String filePath = new File("").getAbsolutePath();
        String csvFile = filePath + "/UsuariosTest.csv";
        usuarios = lc.LoadUsers(csvFile);
        assertEquals(2, usuarios.size());
    }
    
    @Test(expected = excepciones.AnimalException.class)
    public void loadUsersTestInexistentFile() throws AnimalException{
        ArrayList<Usuario> usuarios = new ArrayList<>();
        LogInController lc = new LogInController();
        String filePath = new File("").getAbsolutePath();
        String csvFile = filePath;
        usuarios = lc.LoadUsers(csvFile);
    }
}
