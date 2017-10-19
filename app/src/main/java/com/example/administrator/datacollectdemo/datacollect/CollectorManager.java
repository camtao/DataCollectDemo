package com.example.administrator.datacollectdemo.datacollect;

/**
 * 创建人:hutao
 * 创建时间:2017/10/19
 */

public class CollectorManager {

    private DataTracker mDataTracker;

    private CollectorManager() {
    }

    public static CollectorManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void start(){
        CollectorSetting collectorSetting = new CollectorSetting();
        mDataTracker = new DataTracker(collectorSetting);
        mDataTracker.startTrack();
    }
    public void stop(){
        mDataTracker.stopTrack();
    }

    private static class SingletonHolder {
        private static final CollectorManager INSTANCE = new CollectorManager();
    }
}
