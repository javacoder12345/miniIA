import java.util.HashMap;
import java.util.Scanner;

public class MiniIA {
    private HashMap<String, String> conocimiento;
    
    public MiniIA() {
        conocimiento = new HashMap<>();
        conocimiento.put("hola", "¡Hola! ¿Cómo estás?");
        conocimiento.put("adiós", "¡Hasta luego! Que tengas un buen día.");
    }
    
    public String respond(String input) {
        input = input.toLowerCase();
        if (conocimiento.containsKey(input)) {
            return conocimiento.get(input);
        } else {
            return "No sé la respuesta. ¿Me enseñas? (Escribe la respuesta o 'no' para ignorar)";
        }
    }

    public void learn(String pregunta, String respuesta) {
        conocimiento.put(pregunta.toLowerCase(), respuesta);
    }

    public static void main(String[] args) {
        MiniIA chatbot = new MiniIA();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("MiniIA: ¡Hola! Pregunta algo.");
        
        while (true) {
            System.out.print("Tú: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("salir")) {
                System.out.println("MiniIA: ¡Adiós!");
                break;
            }
            
            String response = chatbot.respond(input);
            System.out.println("MiniIA: " + response);
            
            if (response.startsWith("No sé la respuesta")) {
                System.out.print("Tú: ");
                String newAnswer = scanner.nextLine().trim();
                if (!newAnswer.equalsIgnoreCase("no")) {
                    chatbot.learn(input, newAnswer);
                    System.out.println("MiniIA: ¡Gracias! Ahora lo recordaré.");
                }
            }
        }
        
        scanner.close();
    }
}

