
package Class;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CreateUser {
    
    public String User(){
        System.out.println("Hello");
        Path source1 = Paths.get("db\\patients.txt");
     Path source = Paths.get("db\\temp.txt");

  try{

    // rename a file in the same directory
    
    Files.move(source1, source1.resolveSibling("patientsold.txt"));
    Files.move(source, source.resolveSibling("patients.txt"));

  } catch (IOException e) {
    e.printStackTrace();
  }
    
    return null;
    }
    
    
}
