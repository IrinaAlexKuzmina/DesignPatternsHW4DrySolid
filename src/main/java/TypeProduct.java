public enum TypeProduct {
    JUICE("Сок"),
    BREAD("Хлеб"),
    MILK_PRODUCTS("Молочная продукция"),
    VEGETABLES("Овощи"),
    FRUITS("Фрукты");

    private final String description;

    TypeProduct(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
