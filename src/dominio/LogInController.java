package dominio;

import dominio.modelo.usuarios.Usuario;
import excepciones.AnimalException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LogInController {

    public ArrayList<Usuario> LoadUsers(String ruta) throws AnimalException {
        String line;
        String cvsSplitBy = ",";
        ArrayList<Usuario> users = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            while ((line = br.readLine()) != null) {
                String[] country = line.split(cvsSplitBy);
                Usuario user = new Usuario(country[0], country[1], country[2]);
                users.add(user);
            }
        } catch (Exception e) {
            throw new AnimalException("Error leyendo el archivo Usuarios.csv");
        }
        return users;
    }

}
