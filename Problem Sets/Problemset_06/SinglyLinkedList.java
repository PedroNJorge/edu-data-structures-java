// -----------------------------------------------------------
// Estruturas de Dados 2025/2026 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2526/
// -----------------------------------------------------------
// Lista ligada simples
// -----------------------------------------------------------

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

   public T get(int pos) {
        if (pos < 0 || pos >= size) return null;

        Node<T> cur = first;
        for (int i = 0; i < pos; i++) {
            cur = cur.getNext();
        }
        return cur.getValue();
   }

   public T remove(int pos) {
        if (pos < 0 || pos >= size) return null;

        T result;
        if (pos == 0) {
            result = first.getValue();
            first = first.getNext();
        } else {
            Node<T> prev = first, cur;
            for (int i = 0; i < pos - 1; i++) {
                prev = prev.getNext();
            }
            cur = prev.getNext();
            result = cur.getValue();
            prev.setNext(cur.getNext());
        }
        size--;
        return result;
   }

   public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copy = new SinglyLinkedList<>();
        copy.addFirst(first.getValue());
        for (int i = 1; i < size; i++) {
            copy.addLast(this.get(i));
        }
        return copy;
   }

   public void duplicate() {
       if (size == 0) return;
       Node<T> cur = first;
       while (cur != null) {
           Node<T> newNode = new Node<>(cur.getValue(), cur.getNext());
           cur.setNext(newNode);
           size++;
           cur = cur.getNext().getNext();
       }
   }

   public int count(T value) {
        int c = 0;
        Node<T> cur = first;
        while (cur != null) {
            if (value.equals(cur.getValue())) c++;
            cur = cur.getNext();
        }
        return c;
   }

   public void removeAll(T value) {
        while (first != null && value.equals(first.getValue())) {
            first = first.getNext();
            size--;
        }
        if (size == 0) return;
        Node<T> prev = first, cur;
        cur = prev.getNext();
        while (cur != null) {
            if (value.equals(cur.getValue())) {
                prev.setNext(cur.getNext());
                size--;
            } else prev = prev.getNext();
            cur = cur.getNext();
        }
   }
}
