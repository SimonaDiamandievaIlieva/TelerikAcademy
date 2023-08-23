package comtelerikacademy_BoardR;

public enum Status {

    OPEN, TODO, IN_PROGRESS, DONE, VERIFIED;

    public String toString() {
        switch (this) {
            case OPEN:
                return "Open";
            case TODO:
                return "To Do";
            case IN_PROGRESS:
                return "In Progress";
            case DONE:
                return "Done";
            case VERIFIED:
                return "Verified";
        }
        return "UNKNOWN";
    }

    private static final Status[] values = Status.values();

    public Status next() {
        return values[(this.ordinal() +1) % values.length];
    }
    public Status previous() {
        return values[(this.ordinal() - 1 + values.length) % values.length];
    }

}

