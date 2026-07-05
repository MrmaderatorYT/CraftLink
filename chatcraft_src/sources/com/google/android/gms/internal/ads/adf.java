package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
final class adf implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final SensorManager f1862a;
    private final Display c;

    @GuardedBy("mSensorThreadLock")
    private float[] f;
    private Handler g;
    private adh h;
    private final float[] d = new float[9];
    private final float[] e = new float[9];

    /* renamed from: b, reason: collision with root package name */
    private final Object f1863b = new Object();

    adf(Context context) {
        this.f1862a = (SensorManager) context.getSystemService("sensor");
        this.c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    final void a() {
        if (this.g != null) {
            return;
        }
        Sensor defaultSensor = this.f1862a.getDefaultSensor(11);
        if (defaultSensor == null) {
            xe.c("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        this.g = new Handler(handlerThread.getLooper());
        if (this.f1862a.registerListener(this, defaultSensor, 0, this.g)) {
            return;
        }
        xe.c("SensorManager.registerListener failed.");
        b();
    }

    final void b() {
        if (this.g == null) {
            return;
        }
        this.f1862a.unregisterListener(this);
        this.g.post(new adg(this));
        this.g = null;
    }

    final void a(adh adhVar) {
        this.h = adhVar;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.f1863b) {
            if (this.f == null) {
                this.f = new float[9];
            }
        }
        SensorManager.getRotationMatrixFromVector(this.d, fArr);
        switch (this.c.getRotation()) {
            case 1:
                SensorManager.remapCoordinateSystem(this.d, 2, 129, this.e);
                break;
            case 2:
                SensorManager.remapCoordinateSystem(this.d, 129, 130, this.e);
                break;
            case 3:
                SensorManager.remapCoordinateSystem(this.d, 130, 1, this.e);
                break;
            default:
                System.arraycopy(this.d, 0, this.e, 0, 9);
                break;
        }
        a(1, 3);
        a(2, 6);
        a(5, 7);
        synchronized (this.f1863b) {
            System.arraycopy(this.e, 0, this.f, 0, 9);
        }
        if (this.h != null) {
            this.h.a();
        }
    }

    final boolean a(float[] fArr) {
        synchronized (this.f1863b) {
            if (this.f == null) {
                return false;
            }
            System.arraycopy(this.f, 0, fArr, 0, this.f.length);
            return true;
        }
    }

    private final void a(int i, int i2) {
        float f = this.e[i];
        this.e[i] = this.e[i2];
        this.e[i2] = f;
    }
}
