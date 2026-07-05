package com.ccs.craftlink.theme;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import com.ccs.craftlink.widget.QuickConnectWidget;
import com.ccs.craftlink.widget.QuickConnectWidget2x2;
import com.ccs.craftlink.widget.QuickConnectWidget4x1;

public class ThemeUpdateReceiver {
    public static void updateWidgets(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        
        Class[] widgetClasses = {
            QuickConnectWidget.class,
            QuickConnectWidget2x2.class,
            QuickConnectWidget4x1.class
        };
        
        for (Class widgetClass : widgetClasses) {
            ComponentName name = new ComponentName(context, widgetClass);
            int[] ids = appWidgetManager.getAppWidgetIds(name);
            if (ids != null && ids.length > 0) {
                Intent intent = new Intent(context, widgetClass);
                intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
                intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
                context.sendBroadcast(intent);
            }
        }
    }
}
