package edu.cninfo.basic.day10;

public class Chops {
    /*编号*/
    private int num;
    /*是否被使用*/
    private boolean isUsed;

    @Override
    public String toString() {
        return "Chops{" +
                "num=" + num +
                ", isUsed=" + isUsed +
                '}';
    }

    private Chops(int num, boolean isUsed) {
        this.num = num;
        this.isUsed = isUsed;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public int getNum() {
        return num;
    }

    public boolean isUsed() {
        return isUsed;
    }

    static class Builder {
        private int name;
        private boolean isUsed;

        public Builder() {
        }

        public Builder name(int name) {
            this.name = name;
            return this;
        }

        public Builder isUsed(boolean isUsed) {
            this.isUsed = isUsed;
            return this;
        }

        public Chops build() {
            Chops chops = new Chops(this.name, this.isUsed);
            return chops;
        }
    }
}