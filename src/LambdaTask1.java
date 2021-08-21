import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
// Реализовать метод возвращающий Map, где key - название аргумента, value - значение аргумента
// Реализовать метод конвертирующий Map с аргументами и их значениями в массив строк
public class LambdaTask1 {
    public static void main(String args[]) {
        String[] arr = {"-i", "in.txt", "--limit", "40", "-d", "1", "-o", "out.txt"};
        System.out.println("Первоначальный массив строк:\n" + toString(arr));
        System.out.println();
        HashMap<String, String> mapFromArr = new HashMap<String, String>(newMap(arr));
        System.out.println("Создание объекта Map из массива строк:\n");
        for(Map.Entry<String, String> item : mapFromArr.entrySet()){
            System.out.println(toString(item));
        }
        System.out.println();
        System.out.println("Создание массива строк из объекта Map:\n");
        System.out.println(toString(mapToString(mapFromArr)));
    }
    public static HashMap newMap(String[] stringArgs) {
        MapCreate newMapFunction;
        newMapFunction = (String[] arr) -> {
            HashMap<String, String> newMap = new HashMap<String, String>();
            for(int i = 0; i < arr.length; i++) {
                if(i == 1 | (i % 2) != 0) {
                    newMap.put(arr[i-1], arr[i]);
                }
            }
            return newMap;
        };
        return newMapFunction.createNewMap(stringArgs);
    }
    public static String[] mapToString(HashMap map) {
        String[] mapToStringArray = new String[map.size()*2];
        Set<String> allKeys = new HashSet<String>(map.keySet());
        String[] allKeysStrings = allKeys.toArray(new String[allKeys.size()]);
        Collection<String> allValues = new ArrayList<String>(map.values());
        String[] allValuesStrings = allValues.toArray(new String[allValues.size()]);
        int counter = 0;
        for(int i = 0; i < map.size(); i++) {
            mapToStringArray[counter] = allKeysStrings[i];
            counter++;
            mapToStringArray[counter] = allValuesStrings[i];
            counter++;
        }
        return mapToStringArray;
    }
    public static String toString(String[] arr) {
        String result = "";
        for(String item : arr) {
            result += item + ", ";
        }
        return result;
    }
    public static String toString(Map.Entry<String, String> object){
        return "Key = " + object.getKey() + "; Value = " + object.getValue() + ";";
    }
    @FunctionalInterface
    interface MapCreate {
        HashMap createNewMap(String[] stringArgs);
    }
}
