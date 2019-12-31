package edu.cninfo.basic.day07.future;

public class FutureData implements Data {
    private Data realData;

    private volatile boolean isReady = false;

    @Override
    public String getRequest() {
        while (!isReady) {
        }

        return realData.getRequest();
    }

    public void setRealData(RealData realData) {
        if(isReady){
            return;
        }
        this.realData = realData;
        this.isReady = true;
    }
}
