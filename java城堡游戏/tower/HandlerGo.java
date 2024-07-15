package tower;

import tower.Game;

public class HandlerGo extends Handler {
    public HandlerGo(Game game) {
        super(game);//现在HandlerGo能管理game对象了
    }
    //help和bye都与game无关，但go需要调用goRoom方法，所以需要拿到game对象的管理者
    public void doCmd(String word) {
        game.goRoom(word);//调用game的goRoom方法
    }

}