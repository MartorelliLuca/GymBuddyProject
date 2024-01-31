package beans;


public class CuponsBean {
    private final int code;
    private final int pointsPrice;
    private final String name;
    private String description;
    private final boolean onlyForNewMembers;
    private final boolean isCumulative;

    private final String couponType;

    private final String couponValue;

    public CuponsBean(int code, int pointsPrice, String name, boolean onlyForNewMembers, boolean isCumulative, String couponType, String cuponValue) {
        this.code = code;
        this.pointsPrice = pointsPrice;
        this.name = name;
        this.onlyForNewMembers = onlyForNewMembers;
        this.isCumulative = isCumulative;
        this.couponType = couponType;
        this.couponValue = cuponValue;
        description = null;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public int getPointsPrice() {
        return pointsPrice;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isOnlyForNewMembers() {
        return onlyForNewMembers;
    }

    public boolean isCumulative() {
        return isCumulative;
    }

    public String getCouponType() {
        return couponType;
    }

    public String getCouponValue() {
        return couponValue;
    }
}
