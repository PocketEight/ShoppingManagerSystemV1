package pzf.entity;

public class Goods {
    int id;
    String goodsName;
    float goodsPrice;
    int goodsNum;

    public Goods(String goodsName, float goodsPrice, int goodsNum) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsNum = goodsNum;
    }

    public Goods(int id, String goodsName) {
        this.id = id;
        this.goodsName = goodsName;
    }

    public Goods(String goodsName) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }



}
