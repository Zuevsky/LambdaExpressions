import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaTask5 {
    public static void main(String[] args) {
        TV_Set LG = new TV_Set("South Korea", "MX7058", 2018, 55, 2500);
        TV_Set Benq = new TV_Set("South Korea", "JQ07995", 2019, 47, 2100);
        TV_Set Panasonic = new TV_Set("Japan", "PP9741", 2020, 50, 2350);
        TV_Set Philips = new TV_Set("Netherlands", "LQ70", 2017, 60, 3200);
        TV_Set Samsung = new TV_Set("South Korea", "CC6080", 2021, 60, 4800);
        TV_Set Sony = new TV_Set("Japan", "LOP50", 2018, 80, 9999);

        ArrayList<TV_Set> allTVs = new ArrayList<>();
        allTVs.add(LG);
        allTVs.add(Benq);
        allTVs.add(Panasonic);
        allTVs.add(Philips);
        allTVs.add(Samsung);
        allTVs.add(Sony);

        TVsWithSpecificDiagonal getTVsWithSpecificDiagonal, getTVsNewerThanSpecificYear;

        TVsFromASpecificManufacturer getTVsFromASpecificManufacturer;

        TVsInThePriceRange getTVsInThePriceRange;

        TVsSortedByPrice getTVsSortedByPriceAscending, getTVsSortedByPriceDescending;

        TVsSortedByDiagonal getTVsSortedDiagonallyAscending, getTVsSortedDiagonallyDescending;

        getTVsWithSpecificDiagonal = (int diagonal) -> {
            ArrayList<TV_Set> TVsWithSpecificDiagonal = new ArrayList<>();
            for(TV_Set TV : allTVs) {
                if(TV.getDiagonal() == diagonal) {
                    TVsWithSpecificDiagonal.add(TV);
                }
            }
            return TVsWithSpecificDiagonal;
        };

        getTVsFromASpecificManufacturer = (String manufacturer) -> {
            ArrayList<TV_Set> TVsFromASpecificManufacturer = new ArrayList<>();
            for(TV_Set TV : allTVs) {
                if(TV.getManufacturer().equals(manufacturer)) {
                    TVsFromASpecificManufacturer.add(TV);
                }
            }
            return TVsFromASpecificManufacturer;
        };

        getTVsNewerThanSpecificYear = (int yearOfIssue) -> {
            ArrayList<TV_Set> TVsNewerThanSpecificYear = new ArrayList<>();
            for(TV_Set TV : allTVs) {
                if(TV.getYearOfIssue() >= yearOfIssue) {
                    TVsNewerThanSpecificYear.add(TV);
                }
            }
            return TVsNewerThanSpecificYear;
        };

        getTVsInThePriceRange = (int lowerLimit, int upperLimit) -> {
            ArrayList<TV_Set> TVsInThePriceRange = new ArrayList<>();
            for(TV_Set TV : allTVs) {
                if(TV.getPrice() >= lowerLimit & TV.getPrice() <= upperLimit) {
                    TVsInThePriceRange.add(TV);
                }
            }
            return TVsInThePriceRange;
        };

        Comparator<TV_Set> maxPriceComparator = new MaxPriceTVComparator();

        getTVsSortedByPriceAscending = () -> {
            Collections.sort(allTVs, maxPriceComparator);
            return allTVs;
        };

        Comparator<TV_Set> minPriceComparator = new MinPriceTVComparator();

        getTVsSortedByPriceDescending = () -> {
            Collections.sort(allTVs, minPriceComparator);
            return allTVs;
        };

        Comparator<TV_Set> maxDiagonalComparator = new MaxDiagonalTVComparator();

        getTVsSortedDiagonallyAscending = () -> {
            Collections.sort(allTVs, maxDiagonalComparator);
            return allTVs;
        };

        Comparator<TV_Set> minDiagonalComparator = new MinDiagonalTVComparator();

        getTVsSortedDiagonallyDescending = () -> {
            Collections.sort(allTVs, minDiagonalComparator);
            return allTVs;
        };

        //System.out.println("Телевизоры с диагональю 60 дюймов:");
        //System.out.println(getTVsWithSpecificDiagonal.newList(60));

        //System.out.println("Телевизоры из Южной Кореи:");
        //System.out.println(getTVsFromASpecificManufacturer.newList("South Korea"));

        //System.out.println("Телевизоры от 2019 года выпуска:");
        //System.out.println(getTVsNewerThanSpecificYear.newList(2019));

        //System.out.println("Телевизоры в ценовом диапозоне от 2000 до 3000:");
        //System.out.println(getTVsInThePriceRange.newList(2000, 3000));

        //System.out.println("Телевизоры отсортированные по возрастанию цены:");
        //System.out.println(getTVsSortedByPriceAscending.newList());

        //System.out.println("Телевизоры отсортированные по убыванию цены:");
        //System.out.println(getTVsSortedByPriceDescending.newList());

        //System.out.println("Телевизоры отсортированные по возрастанию диагонали:");
        //System.out.println(getTVsSortedDiagonallyAscending.newList());

        System.out.println("Телевизоры отсортированные по убыванию диагонали:");
        System.out.println(getTVsSortedDiagonallyDescending.newList());
    }

    public static class TV_Set {
        private String manufacturer;
        private String name;
        private int yearOfIssue;
        private int diagonal;
        private int price;

        public TV_Set(String manufacturer, String name, int yearOfIssue, int diagonal, int price) {
            this.manufacturer = manufacturer;
            this.name = name;
            this.yearOfIssue = yearOfIssue;
            this.diagonal = diagonal;
            this.price = price;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public String getName() {
            return name;
        }

        public int getYearOfIssue() {
            return yearOfIssue;
        }

        public int getDiagonal() {
            return diagonal;
        }

        public int getPrice() {
            return price;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setYearOfIssue(int yearOfIssue) {
            this.yearOfIssue = yearOfIssue;
        }

        public void setDiagonal(int diagonal) {
            this.diagonal = diagonal;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String toString() {
            return "\nСерийный номер: " + name + "\nПроизводитель: " + manufacturer + "\nГод выпуска: " + yearOfIssue + "\nДиагональ: " +
                    diagonal + "\nЦена: " + price + "\n---------";
        }
    }

    public static class MaxPriceTVComparator implements Comparator<TV_Set> {

        @Override
        public int compare(TV_Set o1, TV_Set o2) {
            return o1.getPrice() - o2.getPrice();
        }
    }

    public static class MinPriceTVComparator implements Comparator<TV_Set> {

        @Override
        public int compare(TV_Set o1, TV_Set o2) {
            return o2.getPrice() - o1.getPrice();
        }
    }

    public static class MaxDiagonalTVComparator implements Comparator<TV_Set> {

        @Override
        public int compare(TV_Set o1, TV_Set o2) {
            return o1.getDiagonal() - o2.getDiagonal();
        }
    }

    public static class MinDiagonalTVComparator implements Comparator<TV_Set> {

        @Override
        public int compare(TV_Set o1, TV_Set o2) {
            return o2.getDiagonal() - o1.getDiagonal();
        }
    }

    @FunctionalInterface
    interface TVsWithSpecificDiagonal {
        ArrayList<TV_Set> newList(int diagonal);
    }

    @FunctionalInterface
    interface TVsFromASpecificManufacturer {
        ArrayList<TV_Set> newList(String manufacturer);
    }

    @FunctionalInterface
    interface TVsInThePriceRange {
        ArrayList<TV_Set> newList(int lowerLimit, int upperLimit);
    }

    @FunctionalInterface
    interface TVsSortedByPrice {
        ArrayList<TV_Set> newList();
    }

    @FunctionalInterface
    interface TVsSortedByDiagonal {
        ArrayList<TV_Set> newList();
    }
}
