package bjorge.lecture.week41;

import java.util.IllegalFormatCodePointException;

public class CircularBuffer {
    char[] buffer;
    int size;
    int head; // Peker til starten av køen
    int tail; // Peker til slutten avklen
    int count;

    CircularBuffer(int size){
        this.buffer = new char[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    void pushBack(char value) { // Dette er det det heter i c++ / i Java heiter det offerBack, men det betyr det samme. Legger ellement bakerst
        if (count + 1 > size) {
            throw new IndexOutOfBoundsException();
        }
        buffer[tail] = value;
        tail = (tail + 1) % size;
        count = count + 1;
    }
    char popFront() {
        if (count <= 0) {
            throw new IndexOutOfBoundsException();
        }
        char retval = buffer[head];
        System.out.println(head);
        head = (head + 1) % size;
        count = count - 1;
        return retval;
    }
    int count(){
        return count;
    }

}
