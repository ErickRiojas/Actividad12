import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean res = false;
        Addressbook addressbook = new Addressbook();
        addressbook.load();
        while (!res){
            System.out.println("\nBienvenido a la agenda de contactos, selecciona una opción:");
            System.out.println("1. Mostrar tu lista de contactos");
            System.out.println("2. Crear un contacto nuevo");
            System.out.println("3. Borrar un contacto");
            System.out.println("4. Guardar contactos y salir");
            switch(leer.nextInt()){
                case 1:
                    addressbook.list();
                    break;
                case 2:
                    System.out.println("Introduce el número: ");
                    String numero = leer.next();
                    System.out.println("Introduce el nombre: ");
                    String nombre = leer.next();
                    addressbook.create(numero, nombre);
                    break;
                case 3:
                    System.out.println("Introduce el número: ");
                    String contacto = leer.next();
                    addressbook.delete(contacto);
                    System.out.print(" se ha eliminado de tu agenda");
                    break;
                case 4:
                    System.out.println("Guardando contactos y saliendo");
                    addressbook.save();
                    res = true;
                    break;
                default:
                    System.out.println("Por favor, escribe una opción válida");
                    break;
            }
        }
    }
}
