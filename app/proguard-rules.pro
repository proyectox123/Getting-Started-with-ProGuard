# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-dontwarn org.slf4j.**
-dontwarn sun.misc.**

#In order to keep org.jbox2d
-keep class org.jbox2d.** { *; }

#Ignore the animal_sniffer warnings
-dontwarn javax.xml.stream.**
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

#Keep sections that use reflection
-keep class * implements org.simpleframework.xml.core.Parameter { public *; }
-keep class kotlin.reflect.jvm.internal.** { *; }
-keep class kotlin.Metadata { *; }

#Keep reference of an annotated class
-keepclassmembers class * { @org.simpleframework.xml.* *; }