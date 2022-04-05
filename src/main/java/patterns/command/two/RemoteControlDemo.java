package patterns.command.two;

import patterns.command.two.four.CeilingFan;
import patterns.command.two.four.CeilingFanHighOnComannd;
import patterns.command.two.four.CeilingFanLowOnComannd;
import patterns.command.two.four.CeilingFanOffOnComannd;
import patterns.command.two.one.Light;
import patterns.command.two.one.LightOffCommand;
import patterns.command.two.one.LightOnCommand;
import patterns.command.two.three.Stereo;
import patterns.command.two.three.StereoOffWithCDCommand;
import patterns.command.two.three.StereoOnWithCDCommand;
import patterns.command.two.two.GarageDoor;
import patterns.command.two.two.GarageDoorOffCommand;
import patterns.command.two.two.GarageDoorOnCommand;

/**
 * @Auther d
 * @Date 2022/4/4 10:59
 * @Describe 命令设计模式，一个遥控器，三组开关(每组有开关两个按钮)，分别控制三个电器，使用命令设计模式操作
 **/
public class RemoteControlDemo {
    public static void main(String[] args) {
        //电灯
        Light light=new Light();
        LightOnCommand lightOnCommand=new LightOnCommand(light);
        LightOffCommand lightOffCommand=new LightOffCommand(light);
        //车库
        GarageDoor garageDoor=new GarageDoor();
        GarageDoorOnCommand garageDoorOnCommand=new GarageDoorOnCommand(garageDoor);
        GarageDoorOffCommand garageDoorOffCommand= new GarageDoorOffCommand(garageDoor);
        //音响
        Stereo stereo=new Stereo();
        StereoOnWithCDCommand stereoOnWithCDCommand=new StereoOnWithCDCommand(stereo);
        StereoOffWithCDCommand stereoOffWithCDCommand= new StereoOffWithCDCommand(stereo);
        //吊扇
        CeilingFan ceilingFan=new CeilingFan("liveing  room");
        CeilingFanHighOnComannd ceilingFanHighOnComannd=new CeilingFanHighOnComannd(ceilingFan);
        CeilingFanOffOnComannd ceilingFanOffOnComannd=new CeilingFanOffOnComannd(ceilingFan);

        CeilingFanLowOnComannd ceilingFanLowOnComannd=new CeilingFanLowOnComannd(ceilingFan);

        //遥控器
        RemoteControl remoteControl=new RemoteControl();
        System.out.println(remoteControl);

        //为每个卡槽指定对应的命令
        remoteControl.setCommand(0,lightOnCommand,lightOffCommand);
        remoteControl.setCommand(1,garageDoorOnCommand,garageDoorOffCommand);
        remoteControl.setCommand(2,stereoOnWithCDCommand,stereoOffWithCDCommand);
        remoteControl.setCommand(3,ceilingFanHighOnComannd,ceilingFanOffOnComannd);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPressed(0);
        remoteControl.offButtonWasPressed(0);

        remoteControl.onButtonWasPressed(1);
        remoteControl.offButtonWasPressed(1);

        remoteControl.onButtonWasPressed(2);
        remoteControl.offButtonWasPressed(2);

        remoteControl.onButtonWasPressed(3);
        remoteControl.offButtonWasPressed(3);

        //吊扇由高速到低速
//        remoteControl.setCommand(3,ceilingFanHighOnComannd,ceilingFanLowOnComannd);
//        remoteControl.onButtonWasPressed(3);
//        remoteControl.offButtonWasPressed(3);

        System.out.println(remoteControl);
        remoteControl.undoButtonWasPressed();
    }
}
