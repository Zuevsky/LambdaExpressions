public class LambdaTask3 {
    public static void main(String[] args) {
        int[] newArray = createNewArray();
        System.out.println("Созданный массив со случайными целыми числами:");
        for(int i : newArray) {
            System.out.println(i);
        }
        // Подсчет количества четных чисел в массиве
        AmountOfNumbers newAmountOfEvenNumbers, newAmountOfOddNumbers, newAmountOfZeroNumbers;
        newAmountOfEvenNumbers = (int[] arr) -> {
            int amountOfEvenNumbers = 0;
            for(int i : arr) {
                if((i % 2) == 0) {
                    amountOfEvenNumbers++;
                }
            }
            return amountOfEvenNumbers;
        };
        System.out.println("Количество четных числе в массиве: " + newAmountOfEvenNumbers.getAmountOfNumbers(newArray));

        // Подсчет количества нечетных чисел в массиве
        newAmountOfOddNumbers = (int[] arr) -> {
            int amountOfOddNumbers = 0;
            for(int i : arr) {
                if((i % 2) != 0) {
                    amountOfOddNumbers++;
                }
            }
            return amountOfOddNumbers;
        };
        System.out.println("Количество нечетных числе в массиве: " + newAmountOfOddNumbers.getAmountOfNumbers(newArray));

        // Подсчет количества чисел в массиве равных нулю
        newAmountOfZeroNumbers = (int[] arr) -> {
            int amountOfZeroNumbers = 0;
            for(int i : arr) {
                if(i == 0) {
                    amountOfZeroNumbers++;
                }
            }
            return amountOfZeroNumbers;
        };
        System.out.println("Количество нулей в массиве: " + newAmountOfZeroNumbers.getAmountOfNumbers(newArray));
    }

    public static int[] createNewArray() {
        CreatingAnArray creatingAnArray;
        creatingAnArray = () -> {
            int[] newArray = new int[10];
            for(int i = 0; i < newArray.length; i++) {
                newArray[i] = (int) (Math.random() * 100);
            }
            return newArray;
        };
        return creatingAnArray.newArray();
    }

    @FunctionalInterface
    interface AmountOfNumbers {
        int getAmountOfNumbers(int[] array);
    }

    @FunctionalInterface
    interface CreatingAnArray {
        int[] newArray();
    }
}
