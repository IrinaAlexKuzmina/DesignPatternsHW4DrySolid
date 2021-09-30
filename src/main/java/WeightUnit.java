public enum WeightUnit {
    PIECE("шт"),
    KILOGRAM("кг"),
    LITER("литр");

    private final String description;

    WeightUnit(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}

