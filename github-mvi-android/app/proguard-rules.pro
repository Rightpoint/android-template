# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/priyakarambelkar/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

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

# Dagger
-dontwarn com.google.errorprone.annotations.*

# Kotlin
-dontwarn kotlin.**
-dontnote kotlin.**

# Okio
-keep class sun.misc.Unsafe { *; }
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontnote okio.**

# OkHttp
-keepattributes Signature
-keepattributes *Annotation*
-dontnote okhttp3.**
-dontwarn okhttp3.**
-dontwarn javax.annotation.Nullable
-dontwarn javax.annotation.ParametersAreNonnullByDefault
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }

# RxJava
-dontnote io.reactivex.**
-dontwarn io.reactivex.**

# AutoDispose
-dontnote com.uber.autodispose.**
-keep class com.uber.autodispose.** { *; }