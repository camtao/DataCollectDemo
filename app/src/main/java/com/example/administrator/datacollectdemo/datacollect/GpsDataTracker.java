package com.example.administrator.datacollectdemo.datacollect;

/**
 * 创建人:hutao
 * 创建时间:2017/10/19
 */

public class GpsDataTracker {


    private GpsDataTracker() {

    }

    public void startTrack(){

    }

    public void stopTrack(){

    }

    interface OnGpsChangeListener{
        void onGpsChange(GpsEntity gpsEntity);
    }

    public static class GpsEntity{
        long timestamp;
        float longitude;
        float latitude;
    }

    static class Builder{
        OnGpsChangeListener onGpsChangeListener;
        int locationType;

        public Builder setOnGpsChangeListener(OnGpsChangeListener onGpsChangeListener) {
            this.onGpsChangeListener = onGpsChangeListener;
            return this;
        }

        public Builder setLocationType(int locationType) {
            this.locationType = locationType;
            return this;
        }

        public GpsDataTracker build(){
            GpsDataTracker gpsDataTracker = new GpsDataTracker();
            return gpsDataTracker;
        }
    }
}
