public enum Enums {

    Open, ToDo, InProgress, Done, Verified;

    private static final Enums[] values = Enums.values();

    public Enums next() {
        return values[(this.ordinal() +1) % values.length];
    }
    public Enums previous() {
        return values[(this.ordinal() - 1 + values.length) % values.length];
    }

}

