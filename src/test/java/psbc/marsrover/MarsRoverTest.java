package psbc.marsrover;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 单元测试
 */
public class MarsRoverTest {

    /**
     * 测出初始化
     */
    @Test
    public void testGetPostationOverRange(){
        Area area = new Area(10, 10);
        Rovers rovers = new Rovers();
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("不能初始化在区域外");
        rovers.land(area, 11, 11, "E");
    }

    /**
     * 获取当前位置
     */
    @Test
    public void testGetPostation(){
        Area area = new Area(10, 10);
        Rovers rovers = new Rovers();
        rovers.land(area, 5, 5, "E");
        String a = rovers.getPostation();
        Assert.assertEquals("55E", a);
    }

    /**
     * X轴方向移动
     */
    @Test
    public void testMoveX(){
        Area area = new Area(10, 10);
        Rovers rovers = new Rovers();
        rovers.land(area, 5, 5, "E");
        rovers.moveX();
        String a = rovers.getPostation();
        Assert.assertEquals("65E", a);
    }

    /**
     *
     * Y轴方向移动
     */
    @Test
    public void testMoveY(){
        Area area = new Area(10, 10);
        Rovers rovers = new Rovers();
        rovers.land(area, 5, 5, "E");
        rovers.moveY();
        String a = rovers.getPostation();
        Assert.assertEquals("56E", a);
    }

    /**
     * 异常
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * 向X方向移动超过范围，提示
     */
    @Test
    public void testMoveXOverRang(){
        Area area = new Area(10, 10);
        Rovers rovers = new Rovers();
        rovers.land(area, 10, 5, "E");
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("已超出范围，不能再继续移动");
        rovers.moveX();
    }

    /**
     * 向Y方向移动超过范围，提示
     */
    @Test
    public void testMoveYOverRang(){
        Area area = new Area(10, 10);
        Rovers rovers = new Rovers();
        rovers.land(area, 10, 10, "E");
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("已超出范围，不能再继续移动");
        rovers.moveY();
    }

    /**
     * 左转
     */
    @Test
    public void testTurnLeft(){
        Area area = new Area(10, 10);
        Rovers rovers = new Rovers();
        rovers.land(area, 5, 5, "E");
        rovers.turnLeft();
        String a = rovers.getPostation();
        Assert.assertEquals("55N", a);
    }

}
