package com.example.littleprince;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnMorning, btnDay, btnEvening, btnNight;
    private ImageView imgMorning, imgDay, imgEvening, imgNight;
    private ConstraintLayout layoutMorning;
    private NotificationManager notificationManager;
    private static final int NOTIFY_ID = 1;
    private static final String CHANNEL_ID = "CHANNEL_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // поиск кнопок по id
        btnMorning = findViewById(R.id.btnMorning);
        btnDay = findViewById(R.id.btnDay);
        btnEvening = findViewById(R.id.btnEvening);
        btnNight = findViewById(R.id.btnNight);

        // поиск картинок по id
        imgMorning = findViewById(R.id.imageMorning);
        imgDay = findViewById(R.id.imageDay);
        imgEvening = findViewById(R.id.imageEvening);
        imgNight = findViewById(R.id.imageNight);

        // поиск утренней локации
        layoutMorning = findViewById(R.id.layoutMorning);

        // создание менеджера уведомлений
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // создание канала уведомлений
        createChannelIfNeeded(notificationManager);

        // запрос разрешения на уведомления в Android 13+
        if (Build.VERSION.SDK_INT >= 33) {
            if (checkSelfPermission(
                    android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(
                        new String[]{
                                android.Manifest.permission.POST_NOTIFICATIONS
                        },
                        100
                );
            }
        }
    }

    // утро
    public void btnMorningClick(View view) {
        layoutMorning.setVisibility(View.VISIBLE);
        imgDay.setVisibility(View.INVISIBLE);
        imgEvening.setVisibility(View.INVISIBLE);
        imgNight.setVisibility(View.INVISIBLE);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK
                        | Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(
                        getApplicationContext(), CHANNEL_ID)
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.cleaningg)
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .setContentTitle("Утро")
                        .setContentText(
                                "Привести в порядок свою планету")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setVisibility(
                                NotificationCompat.VISIBILITY_PUBLIC);

        notificationManager.notify(
                NOTIFY_ID, notificationBuilder.build());
    }
    // день
    public void btnDayClick(View view) {
        layoutMorning.setVisibility(View.INVISIBLE);
        imgDay.setVisibility(View.VISIBLE);
        imgEvening.setVisibility(View.INVISIBLE);
        imgNight.setVisibility(View.INVISIBLE);

        notificationManager=(NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(
                        getApplicationContext(), CHANNEL_ID)
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.rosee)
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .setContentTitle("День")
                        .setContentText("Полить розу")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setVisibility(
                                NotificationCompat.VISIBILITY_PUBLIC);

        notificationManager.notify(NOTIFY_ID, notificationBuilder.build());
    }
    // вечер
    public void btnEveningClick(View view) {
        layoutMorning.setVisibility(View.INVISIBLE);
        imgDay.setVisibility(View.INVISIBLE);
        imgEvening.setVisibility(View.VISIBLE);
        imgNight.setVisibility(View.INVISIBLE);

        notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent = new Intent(
                getApplicationContext(), MainActivity.class);

        intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK
                        | Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
                        | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(
                        getApplicationContext(), CHANNEL_ID)
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.homee)
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .setContentTitle("Вечер")
                        .setContentText("Закрыть розу ширмой")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setVisibility(
                                NotificationCompat.VISIBILITY_PUBLIC);

        notificationManager.notify(
                NOTIFY_ID, notificationBuilder.build());
    }
    // ночь
    public void btnNightClick(View view) {
        layoutMorning.setVisibility(View.INVISIBLE);
        imgDay.setVisibility(View.INVISIBLE);
        imgEvening.setVisibility(View.INVISIBLE);
        imgNight.setVisibility(View.VISIBLE);

        notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent = new Intent(
                getApplicationContext(), MainActivity.class);

        intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK
                        | Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
                        | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(
                        getApplicationContext(), CHANNEL_ID)
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.sunsett)
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .setContentTitle("Ночь")
                        .setContentText("Полюбоваться звездами")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setVisibility(
                                NotificationCompat.VISIBILITY_PUBLIC);

        notificationManager.notify(
                NOTIFY_ID, notificationBuilder.build());
    }

    // Создание канала уведомлений
    public static void createChannelIfNeeded(NotificationManager manager) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel(
                            CHANNEL_ID,
                            CHANNEL_ID,
                            NotificationManager.IMPORTANCE_DEFAULT);

            manager.createNotificationChannel(notificationChannel);
        }
    }
    // Маленький принц
    public void onPrinceClick(View view) {
        Toast toast = Toast.makeText(
                getApplicationContext(),
                "Маленький принц",
                Toast.LENGTH_LONG);

        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    // Планета
    public void onPlanetClick(View view) {
        Toast toast = Toast.makeText(
                getApplicationContext(),
                "Астероид Б-612, планета на которой живет Маленький принц",
                Toast.LENGTH_LONG);

        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    // Потухший вулкан
    public void onVolcanoClick(View view) {
        Toast toast = Toast.makeText(
                getApplicationContext(),
                "Потухший вулкан. О нем нужно заботиться",
                Toast.LENGTH_LONG);

        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    // Роза
    public void onRoseClick(View view) {
        Toast toast = Toast.makeText(
                getApplicationContext(),
                "Её нужно поливать, а на ночь укрывать ширмой и колпаком",
                Toast.LENGTH_LONG);

        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    // Завтрак на действующем вулкане
    public void onBreakfastClick(View view) {
        Toast toast = Toast.makeText(
                getApplicationContext(),
                "Действующий вулкан, на нем удобно разогревать завтрак",
                Toast.LENGTH_LONG);

        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }
}