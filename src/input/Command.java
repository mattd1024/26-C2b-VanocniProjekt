package input;

public interface Command {
    public enum Result {
        END_GAME,
        END_TURN,
        CONTINUE
    }

    Result execute();
}
