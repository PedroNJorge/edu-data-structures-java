// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------
import java.util.*;

public class SinglyLinkedList<T> {
   private Node<T> first;    // Primeiro no da lista
   private int size;         // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }
   
   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first); 
      first = newNode;
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null); 
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);         
      }
      size++;
   }

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty()) return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();      
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         cur.setNext(cur.getNext().getNext());
      }
      size--;
   }
   
   // Converte a lista para uma String
   public String toString() {
      String str = "{";      
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null) str += ",";                     
      }      
      str += "}";
      return str;
   }

   public SinglyLinkedList<T> reverse() {
        SinglyLinkedList<T> result = new SinglyLinkedList<>();

        Node<T> curr = first;
        while (curr != null) {
            result.addFirst(curr.getValue());
            curr = curr.getNext();
        }
        return result;
   }

   public int[] occurrences(T elem) {
       int[] occ = new int[size];
       int occSize = 0, i = 0;
       Node<T> curr = first;

       while (curr != null) {
           if (curr.getValue().equals(elem)) occ[occSize++] = i;
           curr = curr.getNext();
           i++;
       }
       if (occSize == 0) return null;
       return Arrays.copyOf(occ, occSize);
   }

   public void remove(SinglyLinkedList<T> L) {
       Node<T> currL = L.first;
       while (currL != null) {
           T val = currL.getValue();
           while (this.first != null && this.first.getValue().equals(val)) {
                this.first = this.first.getNext();
                this.size--;
           }
           if (this.first == null) return;

           Node<T> prev = this.first;
           Node<T> currThis = prev.getNext();

           while (currThis != null) {
               if (currThis.getValue().equals(val)) {
                    prev.setNext(currThis.getNext());
                    currThis = currThis.getNext();
                    this.size--;
               }
                else {
                    prev = currThis;
                    currThis = currThis.getNext();
                }
           }

           currL = currL.getNext();
       }
   }

   public SinglyLinkedList<T> cut(int a, int b) {
        SinglyLinkedList<T> result = new SinglyLinkedList<>();
        Node<T> curr = first;
        for (int i = 0; i < a; i++) { curr = curr.getNext(); }
        for (int i = 0; i <= b - a; i++) { result.addLast(curr.getValue()); curr = curr.getNext(); }

        return result;
   }

   public void shift(int k) {
        Node<T> curr = first;
        while (curr.getNext() != null) { curr = curr.getNext(); }
        Node<T> last = curr;
        last.setNext(first);

        k = k % size;
        if (k < 0) k += size;

        for (int i = 0; i < size - k; i++) { last = last.getNext(); }
        first = last.getNext();
        last.setNext(null);
   }

   public void duplicate(int pos) {
       Node<T> curr = first;
       for (int i = 0; i < pos; i++) { curr = curr.getNext(); }
       Node<T> nNode = new Node<>(curr.getValue(), curr.getNext());
       curr.setNext(nNode);
       size++;
   }

    public SinglyLinkedList<T> remove(int[] pos) {
        SinglyLinkedList<T> result = new SinglyLinkedList<>();
        if (pos.length == 0) {
            Node<T> curr = first;
            while (curr != null) {
                result.addLast(curr.getValue());
                curr = curr.getNext();
            }
            return result;
        }

        int posIndex = 0, i = 0;
        Node<T> curr = first;
        Node<T> last = result.first;
        while (posIndex < pos.length) {
            if (i != pos[posIndex]) {
                // result.addLast(curr.getValue());
                Node<T> newNode = new Node<>(curr.getValue(), null);
                if (result.isEmpty()) result.first = last = newNode;
                else {
                    last.setNext(newNode);
                    last = newNode;
                }
                result.size++;
            }
            else posIndex++;
            i++; curr = curr.getNext();
        }
        while (curr != null) { result.addLast(curr.getValue()); curr = curr.getNext(); }
        return result;
    }
}
