package dependencies

object Config {
    const val major = 1
    const val minor = 0
    const val patch = 0
    val build = System.getenv("CIRCLE_BUILD_NUM")
    val buildValue = if (build.isNullOrEmpty()) 0 else build.toInt()
    val isCiBuild = System.getenv("CI") == "true"

    const val minSdk = 23
    const val targetSdk = 28
    const val compileSdk = 28
    const val buildTools = "28.0.3"
    val code = (major * 1_000_000) + (minor * 10_000) + (patch * 100) + (buildValue)
    val name = "$major.$minor.$patch.$buildValue"
}

object Versions {
    const val androidLint = "26.4.1"
    const val autoDispose = "1.3.0"
    const val dagger = "2.23.1"
    const val espresso = "3.2.0"
    const val glide = "4.9.0"
    const val kotlin = "1.3.31"
    const val ktlint = "0.33.0"
    const val okhttp = "3.14.2"
    const val retrofit = "2.6.0"
    const val roboletric = "4.3"
    const val room = "2.1.0-rc01"
    const val coroutines = "1.1.1"
}

object Plugins {
    const val android = "com.android.tools.build:gradle:3.4.1"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val versioning = "com.github.ben-manes:gradle-versions-plugin:0.21.0"
}

object Libraries {
    // Kotlin
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val kotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
    const val kotlinTestJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"

    // Android
    const val androidxAnnotations = "androidx.annotation:annotation:1.1.0-rc01"
    const val androidxAppCompat = "androidx.appcompat:appcompat:1.0.2"
    const val androidxCardView = "androidx.cardview:cardview:1.0.0"
    const val androidxConstraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta1"
    const val androidxCore = "androidx.core:core-ktx:1.1.0-beta01"
    const val androidxFragment = "androidx.fragment:fragment-ktx:1.0.0"
    const val androidxLifecycleExt = "androidx.lifecycle:lifecycle-extensions:2.1.0-beta01"
    const val androidxViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0-beta01"
    const val androidxRecyclerView = "androidx.recyclerview:recyclerview:1.0.0"
    const val androidxRoom = "androidx.room:room-runtime:${Versions.room}"
    const val androidxRoomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val androidxRoomRxJava = "androidx.room:room-rxjava2:${Versions.room}"
    const val androidxRoomTest = "androidx.room:room-testing:${Versions.room}"
    const val androidxKtx = "androidx.room:room-ktx:${Versions.room}"
    const val androidxSqlite = "androidx.sqlite:sqlite-ktx:2.0.1"

    // Android Test
    const val androidxEspressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val androidxEspressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    const val androidxTest = "androidx.test:core-ktx:1.2.0"
    const val androidxTestRunner = "androidx.test:runner:1.2.0"
    const val androidxTestRules = "androidx.test:rules:1.2.0"
    const val androidxTestExtJUnit = "androidx.test.ext:junit-ktx:1.1.1"
    const val androidxTestExtTruth = "androidx.test.ext:truth:1.2.0"

    // Android Lint
    const val androidLintApi = "com.android.tools.lint:lint-api:${Versions.androidLint}"
    const val androidLintChecks = "com.android.tools.lint:lint-checks:${Versions.androidLint}"
    const val androidLintCore = "com.android.tools.lint:lint:${Versions.androidLint}"
    const val androidLintTest = "com.android.tools.lint:lint-tests:${Versions.androidLint}"
    const val androidLintTestUtils = "com.android.tools:testutils:${Versions.androidLint}"

    // Dagger
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerAndroidCompiler = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    // Google
    const val materialComponents = "com.google.android.material:material:1.1.0-alpha07"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Rx
    const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.9"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.3.0"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
    const val rxRelay = "com.jakewharton.rxrelay2:rxrelay:2.1.0"

    // AutoDispose
    const val autoDisposeBase = "com.uber.autodispose:autodispose:1.3.0"
    const val autoDisposeKtx = "com.uber.autodispose:autodispose-ktx:1.2.0"
    const val autoDisposeJetpack = "com.uber.autodispose:autodispose-android-archcomponents:1.3.0"
    const val autoDisposeJetpackKtx = "com.uber.autodispose:autodispose-android-archcomponents-ktx:1.2.0"

    // OkHttp
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitRxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    // Moshi
    const val moshi = "com.squareup.moshi:moshi:1.8.0"

    // Timber
    const val timber = "com.jakewharton.timber:timber:4.7.1"

    //Coroutines
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    const val junit = "junit:junit:4.12"

    const val robolectric = "org.robolectric:robolectric:${Versions.roboletric}"
}