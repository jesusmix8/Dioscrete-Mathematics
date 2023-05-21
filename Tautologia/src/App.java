import java.util.Scanner;

public class App {
   
    public static void main(String[] args) throws Exception {
 
            Scanner in = new Scanner(System.in);
            boolean p, q, r, s;
        
            System.out.print("Ingrese la proposición compuesta: ");
            String proposicion = in.nextLine();
        
            // Convertir la proposición en una expresión booleana
            p = proposicion.contains("p");
            q = proposicion.contains("q");
            r = proposicion.contains("r");
            s = proposicion.contains("s");
        
            // Imprimir la tabla de verdad
            System.out.println("Tabla de verdad:");
            System.out.println("p\tq\tr\ts\tResultado");
            for (int i = 0; i < 16; i++) {
              // Establecer los valores de verdad de p, q, r y s para la fila actual
              p = (i & 8) != 0;
              q = (i & 4) != 0;
              r = (i & 2) != 0;
              s = (i & 1) != 0;
        
              // Evaluar la expresión booleana para la fila actual
              boolean resultado = evaluarExpresion(p, q, r, s, proposicion);
        
              // Imprimir la fila de la tabla de verdad
              System.out.println((p ? "T" : "F") + "\t" + (q ? "T" : "F") + "\t" + (r ? "T" : "F") + "\t" + (s ? "T" : "F") + "\t" + (resultado ? "T" : "F"));
            }
        
            // Determinar si la proposición es una tautología o contradicción
            boolean esTautologia = true;
            boolean esContradiccion = true;
            for (int i = 0; i < 16; i++) {
              // Establecer los valores de verdad de p, q, r y s para la fila actual
              p = (i & 8) != 0;
              q = (i & 4) != 0;
              r = (i & 2) != 0;
              s = (i & 1) != 0;
        
              // Evaluar la expresión booleana para la fila actual
              boolean resultado = evaluarExpresion(p, q, r, s, proposicion);
        
              // Verificar si la proposición es una tautología
              if (!resultado) {
                esTautologia = false;
              }
        
              // Verificar si la proposición es una contradicción
              if (resultado) {
                esContradiccion = false;
              }
            }
        
            // Imprimir el resultado final
            if (esTautologia) {
              System.out.println("La proposición es una tautología.");
            } else if (esContradiccion) {
              System.out.println("La proposición es una contradicción.");
            } else {
              System.out.println("La proposición no es ni una tautología ni una contradicción.");
            }
          
    }
        private static boolean evaluarExpresion(boolean p, boolean q, boolean r, boolean s, String proposicion) {
            boolean resultado = false;

            // Evaluar la expresión booleana
            switch (proposicion) {
              case "p":
                resultado = p;
                break;
              case "q":
                resultado = q;
                break;
              case "r":
                resultado = r;
                break;
              case "s":
                resultado = s;
                break;
              case "p y q":
                resultado = p && q;
                break;
              case "p o q":
                resultado = p || q;
                break;
              case "no p":
                resultado = !p;
                break;
              case "no q":
                resultado = !q;
                break;
              case "no r":
                resultado = !r;
                break;
              case "no s":
                resultado = !s;
                break;
              case "p xor q":
                resultado = p ^ q;
                break;
              case "p nand q":
                resultado = !(p && q);
                break;
              case "p nor q":
                resultado = !(p || q);
                break;
              case "p and not q":
                resultado = p && !q;
                break;
              case "not p and q":
                resultado = !p && q;
                break;
              case "p or not q":
                resultado = p || !q;
                break;
              case "not p or q":
                resultado = !p || q;
                break;
              case "p and q and r":
                resultado = p && q && r;
                break;
              case "p or q or r":
                resultado = p || q || r;
                break;
              case "p and q and r and s":
                resultado = p && q && r && s;
                break;
              case "p or q or r or s":
                resultado = p || q || r || s;
                break;
              default:
                System.out.println("Error: Proposición inválida.");
                break;
            }
        
            return resultado;
          }
        
        }

