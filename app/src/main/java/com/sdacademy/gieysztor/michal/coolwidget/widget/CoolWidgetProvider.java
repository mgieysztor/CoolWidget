package com.sdacademy.gieysztor.michal.coolwidget.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import com.sdacademy.gieysztor.michal.coolwidget.R;

import java.util.Random;

/**
 * Created by Michał on 15-02-2017.
 */

public class CoolWidgetProvider extends AppWidgetProvider {


    public static final String TAG = CoolWidgetProvider.class.getSimpleName();

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.i(TAG, "onUpdate");


        ComponentName thisWidget = new ComponentName(context, CoolWidgetProvider.class);

        int[] widgetsIds = appWidgetManager.getAppWidgetIds(thisWidget);

        for (int widgetId : widgetsIds) {
            int random = new Random().nextInt(1000);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

            remoteViews.setTextViewText(R.id.randomText, String.valueOf(random));

            Intent intent = new Intent(context, CoolWidgetProvider.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                    0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.randomText, pendingIntent);

            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.i(TAG, "onReceive");
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        Log.i(TAG, "onAppWidgetOptionsChanged");
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.i(TAG, "onDeleted");
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.i(TAG, "onEnabled");
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.i(TAG, "onDisabled");
    }

    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        super.onRestored(context, oldWidgetIds, newWidgetIds);
        Log.i(TAG, "onRestored");
    }
}
