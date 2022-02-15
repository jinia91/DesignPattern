package factorymethod;

public enum ActionType {
    PURCHASE("매매"),
    RENT("임대차");

    private final String description;

    ActionType(String description) {
        this.description = description;
    }
}
