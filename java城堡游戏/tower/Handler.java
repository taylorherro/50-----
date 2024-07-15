package tower;

public class Handler {
    protected Game game;

    public Handler(Game game) {
        this.game = game;//两个game管理者共同管理一个game对象
    }

    public void doCmd(String word) {}
    public boolean isBye(){return false;}
}
