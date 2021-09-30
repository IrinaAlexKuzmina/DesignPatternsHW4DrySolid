import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static void initialize() {
        new Catalog("Молоко", 100.45, TypeProduct.MILK_PRODUCTS, WeightUnit.LITER);
        new Catalog("Масло", 89.99, TypeProduct.MILK_PRODUCTS, WeightUnit.PIECE);
        new Catalog("Ряженка", 45.00, TypeProduct.MILK_PRODUCTS, WeightUnit.PIECE);
        new Catalog("Кефир", 110.20, TypeProduct.MILK_PRODUCTS, WeightUnit.PIECE);
        new Catalog("Молоко отборное", 150.90, TypeProduct.MILK_PRODUCTS, WeightUnit.PIECE);
        new Catalog("Батон", 100.90, TypeProduct.BREAD, WeightUnit.PIECE);
        new Catalog("Черный хлеб", 50.90, TypeProduct.BREAD, WeightUnit.PIECE);
        new Catalog("Маковая булочка", 25.99, TypeProduct.BREAD, WeightUnit.PIECE);
        new Catalog("Березовый сок", 100.99, TypeProduct.JUICE, WeightUnit.LITER);
        new Catalog("Апельсиновый сок", 150.99, TypeProduct.JUICE, WeightUnit.PIECE);
        new Catalog("Огурцы", 89.99, TypeProduct.VEGETABLES, WeightUnit.KILOGRAM);
        new Catalog("Помидоры", 100.99, TypeProduct.VEGETABLES, WeightUnit.KILOGRAM);
        new Catalog("Яблоки", 100.99, TypeProduct.FRUITS, WeightUnit.KILOGRAM);
        new Catalog("Апельсины", 150.00, TypeProduct.FRUITS, WeightUnit.KILOGRAM);
    }

    static void printRes(ArrayList<Basket> myBasket) {
        System.out.println("Ваша корзина");
        myBasket.forEach(System.out::println);
        System.out.println("Общая сумма: " + Basket.getResultSumSum());
    }

    public static void main(String[] args) {

        initialize();
        ArrayList<Basket> myBasket = new ArrayList<>();

        Catalog.printCatalog();

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Выберите товар (его идентификатор) и количество (через пробел) и нажмите enter или введите 'end'");

            String string = scanner.nextLine();
            if (string.equals("end")) break;

            String[] splitArr = string.split(" ");
            try {
                Integer identifier = Integer.parseInt(splitArr[0]);
                double count = Double.parseDouble(splitArr[1]);
                myBasket.add(new Basket(count, Catalog.get(identifier)));
                printRes(myBasket);
            } catch (Exception exception) {
                System.out.println("Недопустимый ввод. Попробуйте еще раз.");
            }
        }

        printRes(myBasket);
    }
}

