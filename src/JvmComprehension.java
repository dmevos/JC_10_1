//В Classlosder пападает информация о том, что необходимо попытаться загрузить информацию о системных классах: String, Object, Integer, System
// и еще о классе JvmComprehension.
// это все вскоре попадет в Metaspace.

public class JvmComprehension { // загрузка нового класса в ClassLoader, попадает в Metaspace.

    public static void main(String[] args) { // создается фрейм "main()" в стеке
        int i = 1;                      // 1 во фрейме "main()" создается информация о том, что переменная i = 1
        Object o = new Object();        // 2 В куче создается новый объект Object, затем в стеке "main()" появляется ссылка "o" на этот обект
        Integer ii = 2;                 // 3 В куче создается новый объект Integer cо значением = 2, затем в "main()" появляется ссылка "ii" на этот обект
        printAll(o, i, ii);             // 4 Создается новый фрейм "printAll()" в стеке. В нем появляется еще одна ссылка на Object o, int i и Integer ii.

        // Object o помечается для сборщика мусора как "можно удалить"
        System.out.println("finished"); // 7 В стэке создается еще один фрейм "println()" и ему передается ссылка на созданный в куче объект String со значением "finished".

        // В ходе работы программы работает сборщик мусора и периодически собирает объекты из памяти (кучи) которые больше не используются.
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700; // 5 В куче создается объект Integer со значением 700, во фрейме "printAll()" появляется ссылка uselessVar на этот объект.
        System.out.println(o.toString() + i + ii);  // 6 В стэке создается фрейм "println()", и туда передаются ссылки на Object o, int i и Integer ii. А еще в стэке созается фрейм "toString()".
    }
}