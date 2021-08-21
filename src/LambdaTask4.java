import java.util.ArrayList;

public class LambdaTask4 {
    public static void main(String[] args) {
        String[] cities = {"Лондон", "Москва", "Минск", "Минск", "Рим", "Рим", "Киев", "Прага", "Берлин", "Нью-Йорк"};
        GetCertainCities uniqueCities, namesOfCitiesLongerThanSixChars, namesOfCitiesStartingWithCertainChar;

        uniqueCities = (String[] cityNames) -> {
            ArrayList<String> uniqueCitiesList = new ArrayList<>();
            for(String cityName : cityNames) {
                if(!uniqueCitiesList.contains(cityName)) {
                    uniqueCitiesList.add(cityName);
                }
            }
            return uniqueCitiesList;
        };

        namesOfCitiesLongerThanSixChars = (String[] cityNames) -> {
            ArrayList<String> citiesLongerThanSixChars = new ArrayList<>();
            for(String cityName : cityNames) {
                if(cityName.toCharArray().length > 6 & !citiesLongerThanSixChars.contains(cityName)) {
                    citiesLongerThanSixChars.add(cityName);
                }
            }
            return citiesLongerThanSixChars;
        };

        namesOfCitiesStartingWithCertainChar = (String[] cityNames) -> {
            ArrayList<String> citiesStartingWithCertainChar = new ArrayList<>();
            for(String cityName : cityNames) {
                char[] charsOfCityName = cityName.toCharArray();
                if(charsOfCityName[0] == 'М' & !citiesStartingWithCertainChar.contains(cityName)) {
                    citiesStartingWithCertainChar.add(cityName);
                }
            }
            return citiesStartingWithCertainChar;
        };

        System.out.println("Уникальные города из списка: ");
        System.out.println(uniqueCities.getCertainCities(cities));
        System.out.println();

        System.out.println("Города из списка, названия которых больше 6 символов: ");
        System.out.println(namesOfCitiesLongerThanSixChars.getCertainCities(cities));
        System.out.println();

        System.out.println("Города из списка, названия которых начинаются с символа \"М\": ");
        System.out.println(namesOfCitiesStartingWithCertainChar.getCertainCities(cities));
        System.out.println();
    }

    @FunctionalInterface
    interface GetCertainCities {
        ArrayList<String> getCertainCities(String[] array);
    }
}
