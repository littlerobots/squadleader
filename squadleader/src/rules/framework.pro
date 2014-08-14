# Rules for keeping Android framework stuff

# Keep declared Javascript interfaces
-keep class ** {
    @android.webkit.JavascriptInterface *;
}