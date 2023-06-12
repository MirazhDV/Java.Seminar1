import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int i = random();
        int n = bit(i);
        System.out.println("Рандомное число: " + i);
        System.out.println("Номер старшего значащего бита: " + n);
        short[] m1 = kratnoe(i, Short.MAX_VALUE, n);
        short[] m2 = neKratnoe(Short.MIN_VALUE, i, n);
        System.out.println("Массив m1: ");
        for (short num : m1) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Массив m2: ");
        for (short num : m2) {
            System.out.print(num + " ");
        }
    }

    //Метод генерации рандом числа
    public static int random(){
        Random random = new Random();
        return random.nextInt(2000);
    }
    //Метод поиска старшего бита
    public static int bit(int i) {
        int n = 0;
        while (i > 0) {
            i >>= 1; // Сдвиг числа вправо на 1 бит
            n++;
        }
        return n;
    }
    //Метод поиска кратных биту
    public static short[] kratnoe(int start, int end, int n) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i % n == 0) {
                count++;
            }
        }
        short[] multiples = new short[count];
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (i % n == 0) {
                multiples[index++] = (short) i;
            }
        }
        return multiples;
    }
    //Метод поиска некратных биту
    public static short[] neKratnoe(int start, int end, int n) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i % n != 0) {
                count++;
            }
        }
        short[] nonMultiples = new short[count];
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (i % n != 0) {
                nonMultiples[index++] = (short) i;
            }
        }
        return nonMultiples;
    }

}
