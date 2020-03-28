package com.example.widgetapp

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class MyAppWidget : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {

        // initializing widget layout
        val remoteViews = RemoteViews(context.packageName, R.layout.widget_layout)

        // updating view with initial data
        remoteViews.setTextViewText(R.id.title, "Android Widget")
        remoteViews.setTextViewText(R.id.desc, "Click to open Activity")

        // creating intent to the MainActivity of our application
        var intent = Intent(context,MainActivity::class.java)
        var configPendingIntent:PendingIntent = PendingIntent.getActivity(context,0,intent,0)
        remoteViews.setOnClickPendingIntent(R.id.sync_img, configPendingIntent)
        appWidgetManager.updateAppWidget(appWidgetIds,remoteViews)
    }
}