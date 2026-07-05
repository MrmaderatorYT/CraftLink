package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import java.io.InputStream;

/* compiled from: ContactsPhotoRequestHandler.java */
/* loaded from: classes.dex */
class f extends y {

    /* renamed from: a, reason: collision with root package name */
    private static final UriMatcher f4121a = new UriMatcher(-1);

    /* renamed from: b, reason: collision with root package name */
    private final Context f4122b;

    static {
        f4121a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f4121a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f4121a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f4121a.addURI("com.android.contacts", "contacts/#", 3);
        f4121a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    f(Context context) {
        this.f4122b = context;
    }

    @Override // com.squareup.picasso.y
    public boolean a(w wVar) {
        Uri uri = wVar.d;
        return "content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f4121a.match(wVar.d) != -1;
    }

    @Override // com.squareup.picasso.y
    public y.a a(w wVar, int i) {
        InputStream inputStreamB = b(wVar);
        if (inputStreamB == null) {
            return null;
        }
        return new y.a(b.l.a(inputStreamB), t.d.DISK);
    }

    private InputStream b(w wVar) {
        ContentResolver contentResolver = this.f4122b.getContentResolver();
        Uri uriLookupContact = wVar.d;
        switch (f4121a.match(uriLookupContact)) {
            case 1:
                uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uriLookupContact);
                if (uriLookupContact == null) {
                    return null;
                }
                break;
            case 2:
            case 4:
                return contentResolver.openInputStream(uriLookupContact);
            case 3:
                break;
            default:
                throw new IllegalStateException("Invalid uri: " + uriLookupContact);
        }
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uriLookupContact, true);
    }
}
