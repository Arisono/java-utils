package model;


/**
 * Note:
 * ��FosVideo region is divided into 10*10 sub areasideo region is divided into 10*10
 * sub areas
 * ��The min unit of schedule is half an hour, scheduleN value range
 * 2N -1(N[0-48])
 */
public class MotionDetectConfig1 {
    /**
     * amba移动侦测类型参数
     */
    public int cfgType = 0;

    /**
     * Is enable motion detect alarm
     */
    public int enable;
    /**
     * Motion alarm linkage( bit3 | bit2 | bit1 | bit0 )
     * bit0:Ring
     * bit1:Send mail
     * bit2:Snap picture
     * bit3:Record
     */
    public int moveAlarmEnable;

    public int pirAlarmEnable;

    public int linkage;
    /**
     * The interval time to snap picture again
     */
    public int snapInterval;
    /**
     * The time of which motion detect alaram can
     * trigger again when a motion detection has happened.
     */
    public int triggerInterval;
    /**
     * The motion alaram schedule of one week,
     * N = 0(Monday) ~6(Sunday)
     * For detail, see *1 bellow
     */
    public long[] schedule;

    public AreaInfo[] area;


    public static class AreaInfo {
        public int x;
        public int y;
        public int width;
        public int height;
        /**
         * Motion detect sensitivity
         * 0 : Low
         * 1: Normal
         * 2: High
         * 3: Lower
         * 4: Lowest
         */
        public int sensitivity;
        public int enable;
    }



}
