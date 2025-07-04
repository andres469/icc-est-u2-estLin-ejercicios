package main;

import java.util.*;

public class LogicaClasificacion {
     

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    
    public String invertirCadena(String texto) {
        Stack<Character> stack = new Stack<>();
        for (char c : texto.toCharArray()) {
            stack.push(c);
        }
        StringBuilder invertida = new StringBuilder();
        while (!stack.isEmpty()) {
            invertida.append(stack.pop());
        }
        return invertida.toString();
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pares = Map.of(
            ')', '(', 
            ']', '[', 
            '}', '{'
        );

        for (char c : expresion.toCharArray()) {
            if (pares.containsValue(c)) {
                stack.push(c);
            } else if (pares.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != pares.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> auxiliar = new Stack<>();

        while (!pila.isEmpty()) {
            int temp = pila.pop();
            while (!auxiliar.isEmpty() && auxiliar.peek() > temp) {
                pila.push(auxiliar.pop());
            }
            auxiliar.push(temp);
        }

        List<Integer> resultado = new ArrayList<>();
        while (!auxiliar.isEmpty()) {
            resultado.add(auxiliar.pop());
        }

        Collections.reverse(resultado); // Para que queden en orden ascendente
        return resultado;
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        LinkedList<Integer> pares = new LinkedList<>();
        LinkedList<Integer> impares = new LinkedList<>();

        for (int num : original) {
            if (num % 2 == 0) {
                pares.add(num);
            } else {
                impares.add(num);
            }
        }

        pares.addAll(impares);
        return pares;
    }
}
