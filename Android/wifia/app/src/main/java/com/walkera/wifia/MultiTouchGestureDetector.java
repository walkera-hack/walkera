package com.walkera.wifia;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.List;

public class MultiTouchGestureDetector {
    static int LONGPRESS_TIMEOUT = 0;
    private static final int LONG_PRESS = 2;
    private static final int SHOW_PRESS = 1;
    static int TAP_TIMEOUT;
    static GestureHandler mHandler;
    static boolean mIsLongpressEnabled;
    static MultiTouchGestureListener mListener;
    static int mMaximumFlingVelocity;
    static int mMinimumFlingVelocity;
    static int mTouchSlopSquare;
    static VelocityTracker mVelocityTracker;
    static List<EventInfo> sEventInfos;

    public class EventInfo {
        private boolean mAlwaysInTapRegion;
        MultiMotionEvent mCurrentDownEvent;
        boolean mInLongPress;
        private float mLastMotionX;
        private float mLastMotionY;
        MultiMotionEvent mPreviousUpEvent;
        private long timestamp;

        private EventInfo(MultiTouchGestureDetector multiTouchGestureDetector, MotionEvent e) {
            this(new MultiMotionEvent(e, 0));
        }

        private EventInfo(MultiMotionEvent current) {
            this.timestamp = 0;
            this.mCurrentDownEvent = current;
            this.mInLongPress = false;
            this.mAlwaysInTapRegion = true;
        }

        public void recycle() {
            if (this.mCurrentDownEvent != null) {
                this.mCurrentDownEvent.recycle();
                this.mCurrentDownEvent = null;
            }
            if (this.mPreviousUpEvent != null) {
                this.mPreviousUpEvent.recycle();
                this.mPreviousUpEvent = null;
            }
        }

        public long getTimeStamp() {
            return this.timestamp;
        }

        public void finalize() {
            recycle();
        }
    }

    private class GestureHandler extends Handler {
        GestureHandler() {
        }

        public void handleMessage(Message msg) {
            int idx = ((Integer) msg.obj).intValue();
            EventInfo info;
            switch (msg.what) {
                case MultiTouchGestureDetector.SHOW_PRESS /*1*/:
                    if (idx < MultiTouchGestureDetector.sEventInfos.size()) {
                        info = (EventInfo) MultiTouchGestureDetector.sEventInfos.get(idx);
                        if (info != null) {
                            MultiTouchGestureDetector.mListener.onShowPress(info.mCurrentDownEvent);
                        }
                    }
                case MultiTouchGestureDetector.LONG_PRESS /*2*/:
                    if (idx < MultiTouchGestureDetector.sEventInfos.size()) {
                        info = (EventInfo) MultiTouchGestureDetector.sEventInfos.get(idx);
                        if (info != null) {
                            info.mInLongPress = true;
                            MultiTouchGestureDetector.mListener.onLongPress(info.mCurrentDownEvent);
                        }
                    }
                default:
                    throw new RuntimeException("Unknown message " + msg);
            }
        }
    }

    public class MultiMotionEvent {
        boolean left;
        private MotionEvent mEvent;
        private boolean mInLongPress;
        private int mIndex;
        boolean right;

        private MultiMotionEvent(MotionEvent e) {
            this.left = false;
            this.right = false;
            this.mInLongPress = false;
            this.mEvent = e;
            this.mIndex = (e.getAction() & 65280) >> 8;
        }

        private MultiMotionEvent(MotionEvent e, int idx) {
            this.left = false;
            this.right = false;
            this.mInLongPress = false;
            this.mEvent = e;
            this.mIndex = idx;
        }

        public int getAction() {
            int action = this.mEvent.getAction() & 255;
            switch (action) {
                case Constant.RUN /*5*/:
                    return 0;
                case Constant.OVER /*6*/:
                    return MultiTouchGestureDetector.SHOW_PRESS;
                default:
                    return action;
            }
        }

        public void setLongPress() {
            this.mInLongPress = true;
        }

        public boolean getLongPress() {
            return this.mInLongPress;
        }

        public float getX() {
            return (this.mEvent.getX(this.mIndex) + this.mEvent.getRawX()) - this.mEvent.getX();
        }

        public float getY() {
            return (this.mEvent.getY(this.mIndex) + this.mEvent.getRawY()) - this.mEvent.getY();
        }

        public long getEventTime() {
            return this.mEvent.getEventTime();
        }

        public int getIndex() {
            return this.mIndex;
        }

        public int getId() {
            return this.mEvent.getPointerId(this.mIndex);
        }

        public void recycle() {
            if (this.mEvent != null) {
                this.mEvent.recycle();
                this.mEvent = null;
            }
        }
    }

    public interface MultiTouchGestureListener {
        boolean onDown(MultiMotionEvent multiMotionEvent);

        boolean onFling(MultiMotionEvent multiMotionEvent, MultiMotionEvent multiMotionEvent2, float f, float f2);

        boolean onLongPress(MultiMotionEvent multiMotionEvent);

        boolean onScroll(MultiMotionEvent multiMotionEvent, MultiMotionEvent multiMotionEvent2, float f, float f2);

        boolean onShowPress(MultiMotionEvent multiMotionEvent);

        boolean onSingleTapUp(MultiMotionEvent multiMotionEvent);

        boolean onUp(MultiMotionEvent multiMotionEvent);
    }

    static {
        sEventInfos = new ArrayList(6);
        TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout() - TAP_TIMEOUT;
    }

    private void init(Context context) {
        int touchSlop;
        mIsLongpressEnabled = true;
        if (context == null) {
            touchSlop = ViewConfiguration.getTouchSlop();
            mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            ViewConfiguration configuration = ViewConfiguration.get(context);
            touchSlop = configuration.getScaledTouchSlop();
            mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
            mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity();
        }
        touchSlop /= 4;
        if (Helicopter.screenWidth > 640 && Helicopter.screenWidth <= 1280) {
            mTouchSlopSquare = 144;
        } else if (Helicopter.screenWidth > 320 && Helicopter.screenWidth <= 640) {
            mTouchSlopSquare = 81;
        }
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        for (int i = 0; i < sEventInfos.size(); i += SHOW_PRESS) {
            sEventInfos.set(i, null);
        }
    }

    public MultiTouchGestureDetector(Context context, MultiTouchGestureListener Listener) {
        mListener = Listener;
        mHandler = new GestureHandler();
        init(context);
    }

    public void setIsLongpressEnabled(boolean isLongpressEnabled) {
        mIsLongpressEnabled = isLongpressEnabled;
    }

    public boolean isLongpressEnabled() {
        return mIsLongpressEnabled;
    }

    private void addEventIntoList(EventInfo info) {
        int id = info.mCurrentDownEvent.getId();
        if (id < sEventInfos.size()) {
            sEventInfos.set(id, null);
            sEventInfos.set(id, info);
        } else if (id == sEventInfos.size()) {
            sEventInfos.add(info);
        }
    }

    private void removeEventFromList(int id) {
        if (id <= sEventInfos.size() && id >= 0) {
            sEventInfos.set(id, null);
        }
    }

    public void cancel() {
        mHandler.removeMessages(SHOW_PRESS);
        mHandler.removeMessages(LONG_PRESS);
        mHandler = null;
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
        sEventInfos.clear();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r28) {
        /*
        r27 = this;
        r21 = mVelocityTracker;
        r0 = r21;
        r1 = r28;
        r0.addMovement(r1);
        r4 = r28.getAction();
        r21 = r28.getActionIndex();
        r0 = r28;
        r1 = r21;
        r11 = r0.getPointerId(r1);
        r12 = 0;
        r0 = r4 & 255;
        r21 = r0;
        switch(r21) {
            case 0: goto L_0x0024;
            case 1: goto L_0x00b2;
            case 2: goto L_0x016d;
            case 3: goto L_0x02bc;
            case 4: goto L_0x0021;
            case 5: goto L_0x0024;
            case 6: goto L_0x00b2;
            default: goto L_0x0021;
        };
    L_0x0021:
        r21 = 1;
        return r21;
    L_0x0024:
        r12 = new com.walkera.wifia.MultiTouchGestureDetector$EventInfo;
        r21 = android.view.MotionEvent.obtain(r28);
        r22 = 0;
        r0 = r27;
        r1 = r21;
        r2 = r22;
        r12.<init>(r1, r2);
        r0 = r27;
        r0.addEventIntoList(r12);
        r0 = r12.mCurrentDownEvent;
        r21 = r0;
        r21 = r21.getX();
        r0 = r21;
        r12.mLastMotionX = r0;
        r0 = r12.mCurrentDownEvent;
        r21 = r0;
        r21 = r21.getY();
        r0 = r21;
        r12.mLastMotionY = r0;
        r21 = mListener;
        r0 = r12.mCurrentDownEvent;
        r22 = r0;
        r21.onDown(r22);
        r21 = mIsLongpressEnabled;
        if (r21 == 0) goto L_0x008e;
    L_0x0061:
        r21 = mHandler;
        r22 = 2;
        r23 = java.lang.Integer.valueOf(r11);
        r21.removeMessages(r22, r23);
        r21 = mHandler;
        r22 = mHandler;
        r23 = 2;
        r24 = java.lang.Integer.valueOf(r11);
        r22 = r22.obtainMessage(r23, r24);
        r0 = r12.mCurrentDownEvent;
        r23 = r0;
        r23 = r23.getEventTime();
        r25 = LONGPRESS_TIMEOUT;
        r0 = r25;
        r0 = (long) r0;
        r25 = r0;
        r23 = r23 + r25;
        r21.sendMessageAtTime(r22, r23);
    L_0x008e:
        r21 = mHandler;
        r22 = mHandler;
        r23 = 1;
        r24 = java.lang.Integer.valueOf(r11);
        r22 = r22.obtainMessage(r23, r24);
        r0 = r12.mCurrentDownEvent;
        r23 = r0;
        r23 = r23.getEventTime();
        r25 = TAP_TIMEOUT;
        r0 = r25;
        r0 = (long) r0;
        r25 = r0;
        r23 = r23 + r25;
        r21.sendMessageAtTime(r22, r23);
        goto L_0x0021;
    L_0x00b2:
        r5 = new com.walkera.wifia.MultiTouchGestureDetector$MultiMotionEvent;
        r21 = 0;
        r0 = r27;
        r1 = r28;
        r2 = r21;
        r5.<init>(r1, r2);
        r21 = sEventInfos;
        r21 = r21.size();
        r0 = r21;
        if (r11 >= r0) goto L_0x0021;
    L_0x00c9:
        r21 = sEventInfos;
        r0 = r21;
        r12 = r0.get(r11);
        r12 = (com.walkera.wifia.MultiTouchGestureDetector.EventInfo) r12;
        if (r12 == 0) goto L_0x0021;
    L_0x00d5:
        r0 = r12.mInLongPress;
        r21 = r0;
        if (r21 == 0) goto L_0x010e;
    L_0x00db:
        r21 = 0;
        r0 = r21;
        r12.mInLongPress = r0;
    L_0x00e1:
        r21 = 1;
        r0 = r21;
        r12.mAlwaysInTapRegion = r0;
        r21 = mListener;
        r0 = r12.mCurrentDownEvent;
        r22 = r0;
        r21.onUp(r22);
        r21 = mHandler;
        r22 = 1;
        r23 = java.lang.Integer.valueOf(r11);
        r21.removeMessages(r22, r23);
        r21 = mHandler;
        r22 = 2;
        r23 = java.lang.Integer.valueOf(r11);
        r21.removeMessages(r22, r23);
        r0 = r27;
        r0.removeEventFromList(r11);
        goto L_0x0021;
    L_0x010e:
        r21 = r12.mAlwaysInTapRegion;
        if (r21 == 0) goto L_0x011c;
    L_0x0114:
        r21 = mListener;
        r0 = r21;
        r0.onSingleTapUp(r5);
        goto L_0x00e1;
    L_0x011c:
        r16 = mVelocityTracker;
        r21 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r22 = mMaximumFlingVelocity;
        r0 = r22;
        r0 = (float) r0;
        r22 = r0;
        r0 = r16;
        r1 = r21;
        r2 = r22;
        r0.computeCurrentVelocity(r1, r2);
        r0 = r16;
        r17 = r0.getXVelocity(r11);
        r0 = r16;
        r18 = r0.getYVelocity(r11);
        r21 = java.lang.Math.abs(r18);
        r22 = mMinimumFlingVelocity;
        r0 = r22;
        r0 = (float) r0;
        r22 = r0;
        r21 = (r21 > r22 ? 1 : (r21 == r22 ? 0 : -1));
        if (r21 > 0) goto L_0x015a;
    L_0x014b:
        r21 = java.lang.Math.abs(r17);
        r22 = mMinimumFlingVelocity;
        r0 = r22;
        r0 = (float) r0;
        r22 = r0;
        r21 = (r21 > r22 ? 1 : (r21 == r22 ? 0 : -1));
        if (r21 <= 0) goto L_0x00e1;
    L_0x015a:
        r21 = mListener;
        r0 = r12.mCurrentDownEvent;
        r22 = r0;
        r0 = r21;
        r1 = r22;
        r2 = r17;
        r3 = r18;
        r0.onFling(r1, r5, r2, r3);
        goto L_0x00e1;
    L_0x016d:
        r13 = 0;
    L_0x016e:
        r21 = r28.getPointerCount();
        r0 = r21;
        if (r13 >= r0) goto L_0x0021;
    L_0x0176:
        r9 = new com.walkera.wifia.MultiTouchGestureDetector$MultiMotionEvent;
        r21 = 0;
        r0 = r27;
        r1 = r28;
        r2 = r21;
        r9.<init>(r1, r13, r2);
        r21 = r9.getId();
        r22 = sEventInfos;
        r22 = r22.size();
        r0 = r21;
        r1 = r22;
        if (r0 >= r1) goto L_0x0021;
    L_0x0193:
        r21 = sEventInfos;
        r22 = r9.getId();
        r12 = r21.get(r22);
        r12 = (com.walkera.wifia.MultiTouchGestureDetector.EventInfo) r12;
        if (r12 != 0) goto L_0x01a4;
    L_0x01a1:
        r13 = r13 + 1;
        goto L_0x016e;
    L_0x01a4:
        r19 = r9.getX();
        r20 = r9.getY();
        r21 = r12.mLastMotionX;
        r14 = r19 - r21;
        r21 = r12.mLastMotionY;
        r15 = r20 - r21;
        r0 = r12.mInLongPress;
        r21 = r0;
        if (r21 != 0) goto L_0x023d;
    L_0x01be:
        r21 = r12.mAlwaysInTapRegion;
        if (r21 == 0) goto L_0x0224;
    L_0x01c4:
        r0 = r12.mCurrentDownEvent;
        r21 = r0;
        r21 = r21.getX();
        r21 = r19 - r21;
        r0 = r21;
        r6 = (int) r0;
        r0 = r12.mCurrentDownEvent;
        r21 = r0;
        r21 = r21.getY();
        r21 = r20 - r21;
        r0 = r21;
        r7 = (int) r0;
        r21 = r6 * r6;
        r22 = r7 * r7;
        r8 = r21 + r22;
        r21 = mTouchSlopSquare;
        r0 = r21;
        if (r8 <= r0) goto L_0x01a1;
    L_0x01ea:
        r21 = mListener;
        r0 = r12.mCurrentDownEvent;
        r22 = r0;
        r0 = r21;
        r1 = r22;
        r0.onScroll(r1, r9, r14, r15);
        r0 = r19;
        r12.mLastMotionX = r0;
        r0 = r20;
        r12.mLastMotionY = r0;
        r21 = 0;
        r0 = r21;
        r12.mAlwaysInTapRegion = r0;
        r10 = r9.getId();
        r21 = mHandler;
        r22 = 1;
        r23 = java.lang.Integer.valueOf(r10);
        r21.removeMessages(r22, r23);
        r21 = mHandler;
        r22 = 2;
        r23 = java.lang.Integer.valueOf(r10);
        r21.removeMessages(r22, r23);
        goto L_0x01a1;
    L_0x0224:
        r21 = mListener;
        r0 = r12.mCurrentDownEvent;
        r22 = r0;
        r0 = r21;
        r1 = r22;
        r0.onScroll(r1, r9, r14, r15);
        r0 = r19;
        r12.mLastMotionX = r0;
        r0 = r20;
        r12.mLastMotionY = r0;
        goto L_0x01a1;
    L_0x023d:
        r21 = r12.mAlwaysInTapRegion;
        if (r21 == 0) goto L_0x02a3;
    L_0x0243:
        r0 = r12.mCurrentDownEvent;
        r21 = r0;
        r21 = r21.getX();
        r21 = r19 - r21;
        r0 = r21;
        r6 = (int) r0;
        r0 = r12.mCurrentDownEvent;
        r21 = r0;
        r21 = r21.getY();
        r21 = r20 - r21;
        r0 = r21;
        r7 = (int) r0;
        r21 = r6 * r6;
        r22 = r7 * r7;
        r8 = r21 + r22;
        r21 = mTouchSlopSquare;
        r0 = r21;
        if (r8 <= r0) goto L_0x01a1;
    L_0x0269:
        r21 = mListener;
        r0 = r12.mCurrentDownEvent;
        r22 = r0;
        r0 = r21;
        r1 = r22;
        r0.onScroll(r1, r9, r14, r15);
        r0 = r19;
        r12.mLastMotionX = r0;
        r0 = r20;
        r12.mLastMotionY = r0;
        r21 = 0;
        r0 = r21;
        r12.mAlwaysInTapRegion = r0;
        r10 = r9.getId();
        r21 = mHandler;
        r22 = 1;
        r23 = java.lang.Integer.valueOf(r10);
        r21.removeMessages(r22, r23);
        r21 = mHandler;
        r22 = 2;
        r23 = java.lang.Integer.valueOf(r10);
        r21.removeMessages(r22, r23);
        goto L_0x01a1;
    L_0x02a3:
        r21 = mListener;
        r0 = r12.mCurrentDownEvent;
        r22 = r0;
        r0 = r21;
        r1 = r22;
        r0.onScroll(r1, r9, r14, r15);
        r0 = r19;
        r12.mLastMotionX = r0;
        r0 = r20;
        r12.mLastMotionY = r0;
        goto L_0x01a1;
    L_0x02bc:
        r27.cancel();
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.walkera.wifia.MultiTouchGestureDetector.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
