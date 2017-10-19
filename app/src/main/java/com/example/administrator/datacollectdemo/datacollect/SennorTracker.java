package com.example.administrator.datacollectdemo.datacollect;


/**
 * 创建人:hutao
 * 创建时间:2017/10/19
 */

public class SennorTracker {

    OnSennorChangeListener onSennorChangeListener;
    int[] sennorDataType;

    private SennorTracker() {
    }

    public void setOnSennorChangeListener(OnSennorChangeListener onSennorChangeListener) {
        this.onSennorChangeListener = onSennorChangeListener;
    }

    public void setSennorDataType(int[] sennorDataType) {
        this.sennorDataType = sennorDataType;
    }

    public void startTrack(){

    }

    public void stopTrack(){

    }

    interface OnSennorChangeListener{
        void onSennorChange(SennorEntity sennorEntity);
    }

    public static class SennorEntity{
        long timeStamp;
        float[] values;
    }

    static class Builder{

        int[] sensorDataType;
        OnSennorChangeListener onSennorChangeListener;

        public Builder setSensorDataType(int[] sensorDataType) {
            this.sensorDataType = sensorDataType;
            return this;
        }

        public Builder setOnSennorChangeListener(OnSennorChangeListener onSennorChangeListener) {
            this.onSennorChangeListener = onSennorChangeListener;
            return this;
        }

        public SennorTracker build(){
            SennorTracker sennorTracker = new SennorTracker();
            sennorTracker.setOnSennorChangeListener(onSennorChangeListener);
            sennorTracker.setSennorDataType(sensorDataType);
            return sennorTracker;
        }
    }

}
