package com.github.steveice10.mc.auth.service;

import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.auth.exception.profile.ProfileNotFoundException;
import com.github.steveice10.mc.auth.exception.request.RequestException;
import com.github.steveice10.mc.auth.util.HTTP;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public class ProfileService {
    private static final String BASE_URL = "https://api.mojang.com/profiles/";
    private static final int DELAY_BETWEEN_FAILURES = 750;
    private static final int DELAY_BETWEEN_PAGES = 100;
    private static final int MAX_FAIL_COUNT = 3;
    private static final int PROFILES_PER_REQUEST = 100;
    private static final String SEARCH_URL = "https://api.mojang.com/profiles/minecraft";
    private Proxy proxy;

    public interface ProfileLookupCallback {
        void onProfileLookupFailed(GameProfile gameProfile, Exception exc);

        void onProfileLookupSucceeded(GameProfile gameProfile);
    }

    public ProfileService() {
        this(Proxy.NO_PROXY);
    }

    public ProfileService(Proxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException("Proxy cannot be null.");
        }
        this.proxy = proxy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set<Set<String>> partition(Set<String> set, int i) {
        ArrayList arrayList = new ArrayList(set);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        while (i2 < arrayList.size()) {
            HashSet hashSet2 = new HashSet();
            int i3 = i2 + i;
            hashSet2.addAll(arrayList.subList(i2, Math.min(i3, arrayList.size())));
            hashSet.add(hashSet2);
            i2 = i3;
        }
        return hashSet;
    }

    public void findProfilesByName(String[] strArr, ProfileLookupCallback profileLookupCallback) {
        findProfilesByName(strArr, profileLookupCallback, false);
    }

    public void findProfilesByName(String[] strArr, final ProfileLookupCallback profileLookupCallback, boolean z) {
        final HashSet hashSet = new HashSet();
        for (String str : strArr) {
            if (str != null && !str.isEmpty()) {
                hashSet.add(str.toLowerCase());
            }
        }
        Runnable runnable = new Runnable() { // from class: com.github.steveice10.mc.auth.service.ProfileService.1
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                int i;
                RequestException e;
                GameProfile[] gameProfileArr;
                for (Set set : ProfileService.partition(hashSet, 100)) {
                    int i2 = 0;
                    boolean z2 = true;
                    while (i2 < 3 && z2) {
                        try {
                            gameProfileArr = (GameProfile[]) HTTP.makeRequest(ProfileService.this.proxy, ProfileService.SEARCH_URL, set, GameProfile[].class);
                        } catch (RequestException e2) {
                            i = i2;
                            e = e2;
                        }
                        try {
                            HashSet hashSet2 = new HashSet(set);
                            for (GameProfile gameProfile : gameProfileArr) {
                                hashSet2.remove(gameProfile.getName().toLowerCase());
                                profileLookupCallback.onProfileLookupSucceeded(gameProfile);
                            }
                            Iterator it = hashSet2.iterator();
                            while (it.hasNext()) {
                                profileLookupCallback.onProfileLookupFailed(new GameProfile((UUID) null, (String) it.next()), new ProfileNotFoundException("Server could not find the requested profile."));
                            }
                            try {
                                Thread.sleep(100L);
                            } catch (InterruptedException unused) {
                            }
                            i2 = 0;
                            z2 = false;
                        } catch (RequestException e3) {
                            e = e3;
                            i = 0;
                            int i3 = i + 1;
                            if (i3 >= 3) {
                                Iterator it2 = set.iterator();
                                while (it2.hasNext()) {
                                    profileLookupCallback.onProfileLookupFailed(new GameProfile((UUID) null, (String) it2.next()), e);
                                }
                                z2 = false;
                            } else {
                                try {
                                    Thread.sleep(750L);
                                } catch (InterruptedException unused2) {
                                }
                                z2 = true;
                            }
                            i2 = i3;
                        }
                    }
                }
            }
        };
        if (z) {
            new Thread(runnable, "ProfileLookupThread").start();
        } else {
            runnable.run();
        }
    }
}
