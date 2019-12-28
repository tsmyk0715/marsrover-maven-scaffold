package psbc.marsRover;

public class Rovers {

    /**
     * 初始化区域
     */
    private Area area;

    /**
    * X轴的位置
    */
    private int positionX;

    /**
     * Y轴的位置
     */
    private int positionY;

    /**
     * 朝向
     */
    private String direction;

    /**
     * @param area      地区
     * @param positionX 位置 X
     * @param positionY 位置 Y
     * @param direction 朝向
     */
    public void land(Area area, int positionX, int positionY, String direction) {
        if (positionX > area.getX() || positionY > area.getY()) {
            throw new RuntimeException("不能初始化在区域外");
        }
        this.area = area;
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
    }

    /**
     * 获取当前位置
     * @return 当前位置
     */
    public String getPostation() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.positionX);
        sb.append(this.positionY);
        sb.append(this.direction);
        return sb.toString();
    }

    /**
     * 向左移动
     * @return
     */
    public String moveX() {
        if (this.positionX + 1 > area.getX()) {
            throw new RuntimeException("已超出范围，不能再继续移动");
        }
        this.positionX += 1;
        return getPostation();
    }

    /**
     * 向右移动
     * @return
     */
    public String moveY() {
        if (this.positionY + 1 > area.getY()) {
            throw new RuntimeException("已超出范围，不能再继续移动");
        }
        this.positionY += 1;
        return getPostation();
    }

    /**
     * 左转
     * @return 朝向
     */
    public String turnLeft() {
        switch (direction) {
            case "N":
                this.direction = "W";
                break;
            case "S":
                this.direction = "E";
                break;
            case "E":
                this.direction = "N";
                break;
            case "W":
                this.direction = "S";
                break;
        }
        return getPostation();
    }

    /**
     * 右转
     * @return 朝向
     */
    public String turnRighe() {
        switch (direction) {
            case "N":
                this.direction = "E";
                break;
            case "S":
                this.direction = "W";
                break;
            case "E":
                this.direction = "S";
                break;
            case "W":
                this.direction = "N";
                break;
        }
        return getPostation();
    }
}
