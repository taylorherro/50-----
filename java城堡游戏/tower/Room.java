package tower;

import java.util.HashMap;

public class Room {
    //描述
    private String description;
    //用HashMap来保存这个房间连接着的四个房间
    private HashMap<String, Room> exits = new HashMap<String, Room>();

    public Room(String description)//初始化房间名
    {
        this.description = description;
    }

    public void setExits(String direction, Room room) {
        exits.put(direction, room);//将出口方向和连接的房间放进容器中
    }

    @Override
    public String toString() {
        return description;//输出房间名
    }

    public String getExitDesc() {
        //返回一个字符串，来表达房间的出口
        //一般我们不使用String去做拼接，因为每次加都会产生一个新的String类型的对象，系统开销会很大，而是使用StringBuilder
        StringBuilder builder = new StringBuilder("出口有：");
        for (String direction : exits.keySet()) {
            builder.append(direction);
            builder.append(" ");
        }
        return builder.toString();
    }

    public Room getExit(String direction) {
        //返回指定方向的连接房间
        return exits.get(direction);//直接从HashMap中获取房间，如果没有容器会自动返回null
    }
}