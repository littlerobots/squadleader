# General rules for the Little Robots Squadleader library
# Keep annotations
-keepattributes *Annotation*
# Keep main annotations
-keep class nl.littlerobots.squadleader.Keep
-keep class nl.littlerobots.squadleader.KeepName
# Keep class and class name annotated with @Keep
-keep @nl.littlerobots.squadleader.Keep class * {*;}
# Keep class and class name annotated with @KeepName
-keepnames @nl.littlerobots.squadleader.KeepName class * {*;}
# Keep class members and names annoated with @Keep
-keepclassmembers class * { @nl.littlerobots.squadleader.Keep *;}
# Keep class members and names annoated with @KeepName
-keepclassmembernames class * { @nl.littlerobots.squadleader.KeepName *;}

# (Recommended) options to make an obfuscated stacktrace retracable
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable
