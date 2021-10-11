package bjorge.lecture.week41;

public class Main {
    public static void main(String[] args) {
        // CircularBuffer
        CircularBuffer buffer = new CircularBuffer(6);
        char[] values = "ABCDEFGHIJKLMNOPQRST".toCharArray();

        for (int i = 0; i < values.length; ) {

            for (int j = 0; j < 6; ++j) {
                if (values.length > i+j) {
                    buffer.pushBack(values[i+j]);
                }
            }
            // Ta ut alt fra bufferet
            while (buffer.count() > 0) {
                System.out.print(buffer.popFront());
            }
            System.out.println();
            i = i+7;
        }
    }


}
