
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;


public class Addressbook {
        HashMap<String, String> addressBook = new HashMap<>();
        File file = new File("C:\\Users\\Erick Mtz\\Documents\\Adressbook.txt");

        public void load(){
            try{
                if(file.exists()){
                    BufferedReader loadedFile = new BufferedReader(new FileReader(file));
                    String cargar;
                    while((cargar = loadedFile.readLine())!=null){
                        String[]contacto = cargar.split(",");
                        addressBook.put(contacto[0], contacto[1]);
                    }
                    loadedFile.close();
                }
            } catch (Exception e){
                System.out.println("Problemas con el metodo load(): " + e.getMessage());
            }
        }
        public void save(){
        String numero;
        String nombre;
        String contactos="";
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            if(!addressBook.entrySet().isEmpty()){
                for(Map.Entry<String,String> entry:addressBook.entrySet()){
                    numero = entry.getKey();
                    nombre = entry.getValue();
                    contactos+= numero+","+nombre+"\r\n";
                }
            }
            BufferedWriter fileToSave = new BufferedWriter(
                    new OutputStreamWriter
                            (new FileOutputStream(file, false)));
            fileToSave.write(contactos);
            fileToSave.close();

        } catch(Exception e){
            System.out.println("Problemas con el metodo save(): " + e.getMessage());
        }
    }
        public void list(){
            if(addressBook.entrySet().isEmpty()){
                System.out.println("No tienes contactos agregados");
            } else {
                System.out.println("Contactos: ");
                for(Map.Entry<String,String> entry:addressBook.entrySet()){
                    System.out.printf("%s%s%s", entry.getKey(),
                            ": ",entry.getValue() +"\n");
                }
            }
        }
        public void create(String numero, String nombre){
        if (!addressBook.containsKey(numero)){
            addressBook.put(numero, nombre);
            System.out.printf(nombre," Fue agregado exitosamente a tus contactos");
        } else {
            System.out.println("Este contacto ya existe");
        }
    }
        public void delete(String numero){
            if(addressBook.containsKey(numero)){
                System.out.printf(addressBook.get(numero), "Fue eliminado de tu agenda de contactos");
                addressBook.remove(numero);
            } else if (addressBook.entrySet().isEmpty()){
                System.out.println("No tienes contactos agregados");
            } else {
                System.out.println("Ese número no está en tus contactos");
            }
        }
}
