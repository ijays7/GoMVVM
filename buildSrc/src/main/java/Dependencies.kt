/**
 * Created by ijays on 2020/4/2.
 */
object ApplicationId {
    const val id = "com.ijays.gomvvm"
}

/**
 * Versions of libraries
 */
object Versions {
    const val androidGradlePlugin = "4.0.1"
    const val kotlin = "1.4.10"
    const val ktLint = "9.3.0"

    const val coroutines = "1.3.5"

    const val retrofit = "2.8.1"

    const val ktx = "1.2.0"
    const val activityKtx = "1.2.0-alpha06"
    const val liveDataKtx = "2.2.0"
    const val appCompat = "1.2.0-alpha01"
    const val constraintLayout = "2.0.0-rc1"
    const val googleMaterial = "1.2.0"

    const val room = "2.2.3"

    const val epoxy = "4.0.0-beta4"

    const val paging3Version = "3.0.0-alpha04"
    const val hilt = "2.28.3-alpha"
    const val hiltViewModelVersion = "1.0.0-alpha02"
}

/**
 * Android libs we import
 */
object Androidx {
    const val androidKtx = "androidx.core:core-ktx:${Versions.ktx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveDataKtx}"
    const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.liveDataKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomAnnotationProcessor = "androidx.room:room-compiler:${Versions.room}"

    const val material = "com.google.android.material:material:${Versions.googleMaterial}"

    // optional - Kotlin Extensions and Coroutines support for Room
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomTesting = "androidx.room:room-testing:${Versions.room}"

    // paging3
    const val paging3 = "androidx.paging:paging-runtime:${Versions.paging3Version}"

    // hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltViewModel =
        "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModelVersion}"
    const val hiltViewModelCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltViewModelVersion}"
}

/**
 * Third party libs we import
 */
object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val kotlinxSerializationConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.7.0"
    const val loggineInterceptor = "com.squareup.okhttp3:logging-interceptor:4.0.0"

    const val epoxy = "com.airbnb.android:epoxy:${Versions.epoxy}"
    const val epoxyAnnotateProcessor = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"
}
