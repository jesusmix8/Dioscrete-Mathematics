import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.lang.Thread;

//Jesus Enrique Sanchez Martinez
// Andrea Alejandra Hernández Morales
// Nadia Hernández Cruz
// Equipo 2

public class App {
    public static void main(String[] args) {

    Scanner sn = new Scanner(System.in);
    boolean salir = false;
    int opcion; 

    System.out.println("Escribe el tamaño del primer arreglo");
    int n = sn.nextInt();

     //Creamos objeto de tipo Integer con la constructora Integer

    Integer[] arreglo1 = new Integer[n];
    for (int i = 0; i < arreglo1.length; i++) {
        System.out.println("Escribe el valor de la posicion " + (i+1));
        arreglo1[i] = sn.nextInt();
    }
    
    System.out.println("Escribe el tamaño del segundo arreglo");
    int u = sn.nextInt();
     //Creamos objeto de tipo Integer con la constructora Integer
    Integer[] arreglo2 = new Integer[u];
    for (int i = 0; i < arreglo2.length; i++) {
        System.out.println("Escribe el valor de la posicion " + (i+1));
        arreglo2[i] = sn.nextInt();
    }
    System.out.println("Los arreglos son:" +  Arrays.toString(arreglo1) + " y " +   Arrays.toString(arreglo2));
        

    //Array.asList este método toma la array que se le da como para parmetro y lo convierte en un dato lista.
    //se usa para devolver una lista de tamaño fijo respaldada y rellenada por los datos del array pasado como parametro.
    //Y se guarda en un List de tipo Integer
    //Se utiliza un objeto de tipo List para almacenar los elementos de la lista
    
    
   
    List<Integer> list1 = Arrays.asList(arreglo1);
    List<Integer> list2 = Arrays.asList(arreglo2); 

    while(!salir){       
    System.out.println("1. Opcion 1 -----> Union");
    System.out.println("2. Opcion 2 -----> Interseccion");
    System.out.println("3. Opcion 3-----> Diferencia");
    System.out.println("4. Opcion 4-----> Complemento");
    System.out.println("5. Finalizar programa");

            
    System.out.println("Escribe una de las opciones");
    opcion = sn.nextInt();
            
           switch(opcion){
               case 1:
                   System.out.println("Has seleccionado la opcion 1");
                     

                        try {
                        //Metodo union
                        //Se crea un objeto de tipo HashSet que es una implementación de la interfaz Set
                        //
                        //es una colección que implementa la interfaz Set y utiliza una tabla hash para almacenar y administrar elementos enteros sin duplicados. En otras palabras, es una colección que no mantiene
                        // un orden específico de los elementos y no permite elementos duplicados.
                        
                        HashSet<Integer> union = new HashSet<Integer>();

                        for (int i = 0; i < arreglo1.length; i++) {
                            union.add(arreglo1[i]);
                            union.add(arreglo2[i]);
                        }
                        System.out.println("El resultado de la union es:" + union);


                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                   break;
               case 2:
                   System.out.println("Has seleccionado la opcion 2");
                         //Metodo interseccion
                        try{

                            HashSet<Integer> interseccion = new HashSet<Integer>();

                            //Se usa el método retainAll para agregar todos los elementos de la lista 1 y 2 que sean iguales
                            interseccion.addAll(list1);
                            interseccion.retainAll(list2);
                            //Se imprime el resultado
                            System.out.println("El resultado de la interseccion:" + interseccion);
                            Thread.sleep(5000);
                        }catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                       
                   break;
                case 3:

                    try {
                        System.out.println("Has seleccionado la opcion 3");        
                        //Metodo diferencia
                        HashSet<Integer> diferenciaLista1 = new HashSet<Integer>();
                        //Se usa el método removeAll para agregar todos los elementos de la lista 1 y 2 que sean diferentes
                        diferenciaLista1.addAll(list1);
                        diferenciaLista1.removeAll(list2);
                        //Se imprime el resultado
                        System.out.println("El resultado de la operacion diferencia A-B:"+diferenciaLista1);
    
    
                        HashSet<Integer> diferenciaLista2 = new HashSet<Integer>();
                        diferenciaLista2.addAll(list2);
                        diferenciaLista2.removeAll(list1);
                        System.out.println("El resultado de la operacion diferencia B-A:"+diferenciaLista2);
                        Thread.sleep(5000);
                    } catch (Exception e) {
                    }
                  

                   break;
                case 4:

                try {
                    System.out.println("Has seleccionado la opcion 4");
                    HashSet<Integer> complementoA = new HashSet<Integer>();
                    complementoA.addAll(list2);
                    complementoA.removeAll(list1);
            
                    System.out.println("El resultado de la operacion complemento A"+complementoA);
            
            
                    HashSet<Integer> complementoB = new HashSet<Integer>();
                    complementoB.addAll(list1);
                    complementoB.removeAll(list2);
            
                    System.out.println("El resultado de la operacion complemento B"+complementoB);
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
                   break;
                case 5:
                     System.out.println("Finalizando programa");
                     System.exit(0);
                     break;
                default:
                   System.out.println("Solo números entre 1 y 5");
           }  
    }
}
}
