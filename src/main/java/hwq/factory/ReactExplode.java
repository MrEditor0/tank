package hwq.factory;

import hwq.ResourceMgr;
import hwq.TankFrame;

import java.awt.*;

/**
 * @author haowq 2021/4/9 14:23
 */
public class ReactExplode extends BaseExplode {
    private int x = 200;
    private int y = 300;

    private TankFrame tf = null;
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int step = 0;

    public ReactExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tf = tankFrame;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void paint(Graphics g) {
        //g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        g.drawRect(x,y,WIDTH,HEIGHT);
        g.setColor(Color.red);
        g.fillRect(x,y,WIDTH,HEIGHT);

        //爆炸消失
        if(step > 2)
            tf.explodes.remove(this);
        step++;
//        if(step >= ResourceMgr.explodes.length)
//            tf.explodes.remove(this);
//        for(int i=0;i<ResourceMgr.explodes.length;i++){
//            g.drawImage(ResourceMgr.explodes[i], x, y, null);
//        }

    }

}
