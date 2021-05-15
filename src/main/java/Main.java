import hwq.*;

/**
 * @author haowq 2021/4/19 15:23
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame f  = new TankFrame();
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

        for(int i = 0;i<initTankCount;i++){
            f.getBadTanks().add(new Tank(f.x + i * 60, f.y - 100, Dir.DOWN, Group.BAD, f));
        }
        while (true){
            Thread.sleep(50);
            //重画画布
            f.repaint();
        }
    }

}
