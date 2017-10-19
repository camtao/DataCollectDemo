package com.example.administrator.datacollectdemo.datacollect;

/**
 * 创建人:hutao
 * 创建时间:2017/10/19
 */

public class DataTracker implements GpsDataTracker.OnGpsChangeListener, SennorTracker.OnSennorChangeListener {



    private DataWriter mWriter;
    private GpsDataTracker mGpsDataTracker;
    private SennorTracker mSennorTracker;

    private CollectorSetting collectorSetting;

    public DataTracker(CollectorSetting collectorSetting) {
        this.collectorSetting = collectorSetting;
    }

    public void startTrack(){

        GpsDataTracker gpsDataTracker = new GpsDataTracker.Builder()
                .setLocationType(collectorSetting.locationType)
                .setOnGpsChangeListener(this)
                .build();

        mGpsDataTracker.startTrack();


        SennorTracker sennorTracker = new SennorTracker.Builder()
                .setOnSennorChangeListener(this)
                .setSensorDataType(collectorSetting.sensorDataType)
                .build();
        sennorTracker.startTrack();

        mWriter = new DataWriter();

    }

    public void stopTrack(){
        mGpsDataTracker.stopTrack();
        mSennorTracker.stopTrack();
        mWriter.stop();
    }

    @Override
    public void onGpsChange(GpsDataTracker.GpsEntity gpsEntity) {
        mWriter.write();
    }

    @Override
    public void onSennorChange(SennorTracker.SennorEntity sennorEntity) {
        mWriter.write();
    }
}
