import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class FileManagerTest {
    @Test
    public void createNewFileTest() {
        FileManager fileManager = new FileManager();
        fileManager.createNewFile("test.txt");
        
        // Verificar si el archivo se creó exitosamente
        // y realizar las aserciones correspondientes
        
        // Ejemplo de aserción: Verificar si el archivo existe
        File file = new File("test.txt");
        assertTrue(file.exists());
        
        // Ejemplo de aserción: Verificar si el nombre del archivo es correcto
        assertEquals("test.txt", file.getName());
        
        // Ejemplo de aserción: Verificar si el contenido del archivo es vacío
        assertEquals("", file.getContent());
        
        // Ejemplo de aserción: Verificar si la fecha de creación es no nula
        assertNotNull(file.getCreationDate());
    }
}
