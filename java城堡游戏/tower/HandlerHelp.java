package tower;

public class HandlerHelp extends Handler {
    public HandlerHelp(Game game) {
    super(game);
}
    @Override
    public void doCmd(String word)
    {
        System.out.println("你迷路了吗 你可以做的 go by help");
        System.out.println("如：\tgo east");

    }
}
