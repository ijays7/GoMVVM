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
    const val kotlin = "1.3.70"
    const val coroutines = "1.3.5"

    const val koin = "2.1.5"
    const val koinFragment = "2.1.0-alpha-8"

    const val retrofit = "2.8.1"

    const val ktx = "1.2.0"
    const val activityKtx = "1.2.0-alpha06"
    const val liveDataKtx = "2.2.0"
    const val appCompat = "1.2.0-alpha01"
    const val constraintLayout = "2.0.0-rc1"

    const val room = "2.2.3"

    const val epoxy = "4.0.0-beta4"

    const val hilt = "2.28.3-alpha"
    const val hiltViewModelVersion = "1.0.0-alpha02"

    const val doraemonKit = "3.1.2"
}

/**
 * Android libs we import
 */
object Androidx {
    //    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveDataKtx}"
    const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.liveDataKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomAnnotationProcessor = "androidx.room:room-compiler:${Versions.room}"

    // optional - Kotlin Extensions and Coroutines support for Room
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomTesting = "androidx.room:room-testing:${Versions.room}"


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

    const val koinFragment = "org.koin:koin-androidx-fragment:${Versions.koinFragment}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val loggineInterceptor = "com.squareup.okhttp3:logging-interceptor:4.0.0"

    const val epoxy = "com.airbnb.android:epoxy:${Versions.epoxy}"
    const val epoxyAnnotateProcessor = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"
}
