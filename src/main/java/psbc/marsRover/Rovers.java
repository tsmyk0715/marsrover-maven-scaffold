package psbc.marsRover;

public class Rovers {

    private Area area;

    private int positionX;

    private int positionY;

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

    public String getPostation() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.positionX);
        sb.append(this.positionY);
        sb.append(this.direction);
        return sb.toString();
    }

    public String moveX() {
        if (this.positionX + 1 > area.getX()) {
            throw new RuntimeException("已超出范围，不能再继续往左移动");
        }
        this.positionX += 1;
        return getPostation();
    }

    public String moveY() {
        if (this.positionY + 1 > area.getY()) {
            throw new RuntimeException("已超出范围，不能再继续往左移动");
        }
        this.positionY += 1;
        return getPostation();
    }

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
}
