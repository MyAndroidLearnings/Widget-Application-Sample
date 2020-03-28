# Simple Widget App Kotlin

### Configuration:

####Create App's Widget:

1. File -> New -> Widget -> AppWidget.

Now widget file has been created, also it will add the receiver configuration to the 
        AndroidManifest file as per below.
        
    ```
    <receiver android:name=".MyAppWidget">
                <intent-filter>
                    <action android:name="android.appwidget.action.APPWIDGET_UPDATE" />
                    <action android:name="com.app.example.MyWidget.ACTION_WIDGET_CLICK_RECEIVER"/>
                </intent-filter>
    
                <meta-data
                    android:name="android.appwidget.provider"
                    android:resource="@xml/my_app_widget_info" />
            </receiver>
    ```

----------------------------------------------------------------------------------------------------

### Coding Part:

Add the following code in Widget class inside onUpdate override method to set app widgets's title 
and widget's description and set intent for the imagebutton click to navigate main Page of our app. 

```
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
```
 

----------------------------------------------------------------------------------------------------

#### Test Flow:

1. 	Go to Widgets in your device -> click our app widget ->  click the button in widget layout.
        now it will redirect into the main page of our application.