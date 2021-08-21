import java.util.ArrayList;

// Вывести таблицу умножения в один столбец и в 10 столбцов двумя методами
public class LambdaTask2 {
    public static void main(String args[]) {
        multiplicationTableInTenColumns();
    }
    public static void multiplicationTableInTenColumns() {
        ArrayList<String> multiplicationColumn = new ArrayList<String>();
        MultiplicationTable multiplicationTable;
        multiplicationTable = (x, y) -> {
            String result = "";
            if (x * y > 9) {
                result = String.format("%d * %d = %d | ", x, y, x * y);
            } else if (x * y > 99) {
                result = String.format("%d * %d = %d | ", x, y, x * y);
            } else if (x * y < 10) {
                result = String.format("%d * %d = %d   |   ", x, y, x * y);
            }
            return result;
        };
        for(int i = 1; i <= 10; i++) {
            String str = "";
            for(int j = 1; j <= 10; j++) {
                str += multiplicationTable.multiplication(i, j);
            }
            multiplicationColumn.add(str);
        }
        for(String item : multiplicationColumn){
            System.out.println(item);
        }
    }
    public static void multiplicationTableInOneColumn() {
        ArrayList<String> multiplicationColumn = new ArrayList<>();
        MultiplicationTable multiplicationTable;
        multiplicationTable = (x, y) -> {
            String result = String.format("%d * %d = %d", x, y, x * y);
            return result;
        };
        for(int i = 1; i <= 10; i++) {
            for(int j = 1; j <= 10; j++) {
                multiplicationColumn.add(multiplicationTable.multiplication(i, j));
            }
        }
        for(String item : multiplicationColumn){
            System.out.println(item);
        }
    }
    @FunctionalInterface
    interface MultiplicationTable {
        public String multiplication(int x, int y);
    }
}
