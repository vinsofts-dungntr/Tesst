package com.viewtype.tridung.viewtyperecyclerview;

public class Model {
    private String tittle;
    private int type;
    private boolean check;
    public static final int ONE_TYPE = 1;
    public static final int TWO_TYPE = 2;

    public Model(String tittle, int type) {
        this.tittle = tittle;
        this.type = type;

    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
