# Rules for Butterknife http://jakewharton.github.io/butterknife/
-dontwarn butterknife.internal.**
-keep class **$$ViewInjector { *; }
-keepnames class * { @butterknife.InjectView *;}