package dominio;

import dominio.modelo.personas.Usuario;
import excepciones.AnimalException;
import java.io.File;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
        Usuario usuario1 = new Usuario("nombre1", "apellido1", 
                "email1@mail.com", "password1");
        Usuario usuario2 = new Usuario("nombre2", "apellido2", 
                "email2@mail.com", "password2");
        assertTrue(usuarios.contains(usuario1));
        assertTrue(usuarios.contains(usuario2));
        assertEquals(2, usuarios.size());
    }
    
    @Test(expected = excepciones.AnimalException.class)
    public void loadUsersTestInexistentFile() throws AnimalException{
        ArrayList<Usuario> usuarios = new ArrayList<>();
        LogInController lc = new LogInController();
        String filePath = new File("").getAbsolutePath();
        String csvFile = filePath + "/UsuariosTests.csv";
        usuarios = lc.LoadUsers(csvFile);
    }
    
}
