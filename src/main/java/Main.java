import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static Product[] getProductArr() {
        return new Product[]{new Product("Молоко", 100.45, TypeProduct.MILK_PRODUCTS, WeightUnit.LITER),
                new Product("Масло", 89.99, TypeProduct.MILK_PRODUCTS, WeightUnit.PIECE),
                new Product("Ряженка", 45.00, TypeProduct.MILK_PRODUCTS, WeightUnit.PIECE),
                new Product("Кефир", 110.20, TypeProduct.MILK_PRODUCTS, WeightUnit.PIECE),
                new Product("Молоко отборное", 150.90, TypeProduct.MILK_PRODUCTS, WeightUnit.PIECE),
                new Product("Батон", 100.90, TypeProduct.BREAD, WeightUnit.PIECE),
                new Product("Черный хлеб", 50.90, TypeProduct.BREAD, WeightUnit.PIECE),
                new Product("Маковая булочка", 25.99, TypeProduct.BREAD, WeightUnit.PIECE),
                new Product("Березовый сок", 100.99, TypeProduct.JUICE, WeightUnit.LITER),
                new Product("Апельсиновый сок", 150.99, TypeProduct.JUICE, WeightUnit.PIECE),
                new Product("Огурцы", 89.99, TypeProduct.VEGETABLES, WeightUnit.KILOGRAM),
                new Product("Помидоры", 100.99, TypeProduct.VEGETABLES, WeightUnit.KILOGRAM),
                new Product("Яблоки", 100.99, TypeProduct.FRUITS, WeightUnit.KILOGRAM),
                new Product("Апельсины", 150.00, TypeProduct.FRUITS, WeightUnit.KILOGRAM)};
    }

    static void printRes(ArrayList<Basket> myBasket){
        System.out.println("Ваша корзина");
        myBasket.forEach(System.out::println);
        System.out.println("Общая сумма: " + Basket.getResultSumSum());
    }

    public static void main(String[] args) {

        Product[] productArr = getProductArr();

        HashMap<Integer, Product> catalog = new HashMap<>();
        Arrays.stream(productArr).forEach(x -> catalog.put(x.getIdentifier(), x));

        ArrayList<Basket> myBasket = new ArrayList<>();

        System.out.println("Список возможных товаров для покупки \t Цена");
        Arrays.stream(productArr).forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Выберите товар (его идентификатор) и количество (через пробел) и нажмите enter или введите 'end'");

            String string = scanner.nextLine();
            if (string.equals("end")) break;

            String[] splitArr = string.split(" ");
            try {
                Integer identifier = Integer.parseInt(splitArr[0]);
                double count = Double.parseDouble(splitArr[1]);
                myBasket.add(new Basket(count, catalog.get(identifier)));
                printRes(myBasket);
            } catch (Exception exception) {
                System.out.println("Недопустимый ввод. Попробуйте еще раз.");
            }
        }

        printRes(myBasket);
    }
}

