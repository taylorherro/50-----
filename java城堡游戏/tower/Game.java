package tower;

import java.util.*;

public class Game {
    private Room currentRoom;//创建一个Room对象，用于保存当前房间
    //创建一个HashMap对象，用于保存所有的命令处理器
    private HashMap<String, Handler> handlers = new HashMap<String, Handler>();

    public Game()//构造函数
    {
        //将字符串和命令处理器对应
        handlers.put("go",new HandlerGo(this));//把game对象作为参数传入HandlerGo类，让HandlerGo能管理game
        handlers.put("help",new HandlerHelp(this));
        handlers.put("bye",new HandlerBye(this));
        creatRooms();//创建房间
    }

    private void creatRooms()//创建一个房间
    {
        Room outside, lobby,pub,study,bedroom;//创建5种房间

        // 制造5种房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");

        // 初始化房间的出口
        outside.setExits("east", lobby);
        outside.setExits("south", study);
        outside.setExits("west", pub);
        lobby.setExits("west", outside);
        pub.setExits("east", outside);
        study.setExits("north", outside);
        study.setExits("east", bedroom);
        bedroom.setExits("west", study);
        //现在当我们想增加出口方向，很简单
        lobby.setExits("up", pub);
        pub.setExits("down", lobby);

        currentRoom = outside; //从城堡门外开始
    }


    private void printWelcome()//输出欢迎信息
    {
        System.out.println();
        System.out.println("欢迎来到城堡!");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入'help'");
        System.out.println();
        showPrompt();
    }

    //  以下为用户命令

    /*private void printHelp()//帮助菜单
    {
        System.out.println("迷路了吗？你可以做的命令有：go bye help");
        System.out.println("如：\tgo east");
    }*/

    public void goRoom(String direction)
    {
        Room nextRoom = currentRoom.getExit(direction);//创建一个Room对象，用于保存下一个房间
        // 如果找到了下一个房间，则进入下一个房间
        if(nextRoom == null){
            System.out.println("那里没有门！");
        }
        else{
            currentRoom = nextRoom;//让当前房间等于下一个房间
            // 输出当前房间的描述
            showPrompt();
        }
    }

    public void showPrompt()
    {
        // 输出当前房间的描述
        System.out.println("你在"+ currentRoom);
        //调用房间的getExitString()方法，输出当前房间的出口
        System.out.println(currentRoom.getExitDesc());
    }

    public void play(){//游戏开始
        Scanner in = new Scanner(System.in);
        while (true)//进入游戏主体，游戏结束时退出循环
        {
            String line = in.nextLine();//控制台输入一行
            String[] words = line.split(" ");//以空格为分隔符，把用户输入的字符串分割成字符串数组
            Handler handler = handlers.get(words[0]);//获取用户输入的命令,从HashMap中获取对应的子类对象,让handler管理这个对象
            String value = "";//保存命令的字符串
            if(words.length > 1)//判断是不是bye命令
            {
                value = words[1];//获取参数
            }
            if(handler != null){//如果命令存在
                handler.doCmd(value);//调用命令处理器
                if ( handler.isBye() ) {//如果命令处理器返回true，则退出游戏
                    System.out.println("感谢您的光临。再见！");
                    break;
                }
            }
        }
        in.close();//关闭Scanner
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);*/
        //通过new Scanner(System.in)创建一个Scanner，控制台会一直等待输入，直到敲回车键结束，把所输入的内容传给Scanner，作为扫描对象。
        Game game = new Game();
        game.printWelcome();//输出欢迎信息
        game.play();
        /*while (true)//进入游戏主体，游戏结束时退出循环
        {
            String line = in.nextLine();//控制台输入一行
            String[] words = line.split(" ");//以空格为分隔符，把用户输入的字符串分割成字符串数组
            //判断是go还是help
            if ( words[0].equals("help")){
                game.printHelp();//输出帮助信息
            }else if ( words[0].equals("go")){
                game.goRoom(words[1]);//将用户输入的方向传给goRoom方法
            }else if ( words[0].equals("bye")){
                break;//如果用户数据为bye，则退出游戏
            }
        }*/
        //System.out.println("感谢您的光临。再见！");
        //in.close();//关闭Scanner
    }
}