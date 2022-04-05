package patterns.command.two.four;

import patterns.command.two.Command;

/**
 * @Auther d
 * @Date 2022/4/5 7:49
 * @Describe
 **/
public class CeilingFanOffOnComannd implements Command {
    CeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanOffOnComannd(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        }
        if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        }
        if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        }
        if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
