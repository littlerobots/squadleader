# Rules for EventBus https://github.com/greenrobot/EventBus
-keepclassmembers class ** {
    public void onEvent*(**);
}