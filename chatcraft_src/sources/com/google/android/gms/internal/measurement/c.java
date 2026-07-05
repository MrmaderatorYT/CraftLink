package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.Map;

/* loaded from: classes.dex */
public final class c extends am implements a {
    c(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(com.google.android.gms.dynamic.a aVar, k kVar, long j) {
        Parcel parcelA = a();
        ao.a(parcelA, aVar);
        ao.a(parcelA, kVar);
        parcelA.writeLong(j);
        a(1, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        ao.a(parcelA, bundle);
        ao.a(parcelA, z);
        ao.a(parcelA, z2);
        parcelA.writeLong(j);
        a(2, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(String str, String str2, Bundle bundle, d dVar, long j) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        ao.a(parcelA, bundle);
        ao.a(parcelA, dVar);
        parcelA.writeLong(j);
        a(3, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(String str, String str2, com.google.android.gms.dynamic.a aVar, boolean z, long j) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        ao.a(parcelA, aVar);
        ao.a(parcelA, z);
        parcelA.writeLong(j);
        a(4, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(String str, String str2, boolean z, d dVar) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        ao.a(parcelA, z);
        ao.a(parcelA, dVar);
        a(5, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(String str, d dVar) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        ao.a(parcelA, dVar);
        a(6, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(String str, long j) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeLong(j);
        a(7, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(Bundle bundle, long j) {
        Parcel parcelA = a();
        ao.a(parcelA, bundle);
        parcelA.writeLong(j);
        a(8, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(String str, String str2, Bundle bundle) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        ao.a(parcelA, bundle);
        a(9, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(String str, String str2, d dVar) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeString(str2);
        ao.a(parcelA, dVar);
        a(10, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(boolean z, long j) {
        Parcel parcelA = a();
        ao.a(parcelA, z);
        parcelA.writeLong(j);
        a(11, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(long j) {
        Parcel parcelA = a();
        parcelA.writeLong(j);
        a(12, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void b(long j) {
        Parcel parcelA = a();
        parcelA.writeLong(j);
        a(13, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void c(long j) {
        Parcel parcelA = a();
        parcelA.writeLong(j);
        a(14, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(com.google.android.gms.dynamic.a aVar, String str, String str2, long j) {
        Parcel parcelA = a();
        ao.a(parcelA, aVar);
        parcelA.writeString(str);
        parcelA.writeString(str2);
        parcelA.writeLong(j);
        a(15, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(d dVar) {
        Parcel parcelA = a();
        ao.a(parcelA, dVar);
        a(16, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void b(d dVar) {
        Parcel parcelA = a();
        ao.a(parcelA, dVar);
        a(17, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(i iVar) {
        Parcel parcelA = a();
        ao.a(parcelA, iVar);
        a(18, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void c(d dVar) {
        Parcel parcelA = a();
        ao.a(parcelA, dVar);
        a(19, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void d(d dVar) {
        Parcel parcelA = a();
        ao.a(parcelA, dVar);
        a(20, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void e(d dVar) {
        Parcel parcelA = a();
        ao.a(parcelA, dVar);
        a(21, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void f(d dVar) {
        Parcel parcelA = a();
        ao.a(parcelA, dVar);
        a(22, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void b(String str, long j) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeLong(j);
        a(23, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void c(String str, long j) {
        Parcel parcelA = a();
        parcelA.writeString(str);
        parcelA.writeLong(j);
        a(24, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(com.google.android.gms.dynamic.a aVar, long j) {
        Parcel parcelA = a();
        ao.a(parcelA, aVar);
        parcelA.writeLong(j);
        a(25, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void b(com.google.android.gms.dynamic.a aVar, long j) {
        Parcel parcelA = a();
        ao.a(parcelA, aVar);
        parcelA.writeLong(j);
        a(26, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(com.google.android.gms.dynamic.a aVar, Bundle bundle, long j) {
        Parcel parcelA = a();
        ao.a(parcelA, aVar);
        ao.a(parcelA, bundle);
        parcelA.writeLong(j);
        a(27, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void c(com.google.android.gms.dynamic.a aVar, long j) {
        Parcel parcelA = a();
        ao.a(parcelA, aVar);
        parcelA.writeLong(j);
        a(28, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void d(com.google.android.gms.dynamic.a aVar, long j) {
        Parcel parcelA = a();
        ao.a(parcelA, aVar);
        parcelA.writeLong(j);
        a(29, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void e(com.google.android.gms.dynamic.a aVar, long j) {
        Parcel parcelA = a();
        ao.a(parcelA, aVar);
        parcelA.writeLong(j);
        a(30, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(com.google.android.gms.dynamic.a aVar, d dVar, long j) {
        Parcel parcelA = a();
        ao.a(parcelA, aVar);
        ao.a(parcelA, dVar);
        parcelA.writeLong(j);
        a(31, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(Bundle bundle, d dVar, long j) {
        Parcel parcelA = a();
        ao.a(parcelA, bundle);
        ao.a(parcelA, dVar);
        parcelA.writeLong(j);
        a(32, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(int i, String str, com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2, com.google.android.gms.dynamic.a aVar3) {
        Parcel parcelA = a();
        parcelA.writeInt(i);
        parcelA.writeString(str);
        ao.a(parcelA, aVar);
        ao.a(parcelA, aVar2);
        ao.a(parcelA, aVar3);
        a(33, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(g gVar) {
        Parcel parcelA = a();
        ao.a(parcelA, gVar);
        a(34, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void b(g gVar) {
        Parcel parcelA = a();
        ao.a(parcelA, gVar);
        a(35, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void c(g gVar) {
        Parcel parcelA = a();
        ao.a(parcelA, gVar);
        a(36, parcelA);
    }

    @Override // com.google.android.gms.internal.measurement.a
    public final void a(Map map) {
        Parcel parcelA = a();
        parcelA.writeMap(map);
        a(37, parcelA);
    }
}
