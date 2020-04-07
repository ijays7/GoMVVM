/**
 * Created by ijays on 2020/4/2.
 */
object ApplicationId {
    const val id = "com.ijays.gomvvm"
}

object Versions {
    const val kotlin = "1.3.70"
    const val coroutines = "1.3.5"

    const val koin = "2.1.5"
    const val koinFragment = "2.1.0-alpha-8"

    const val retrofit = "2.8.1"

    const val ktx = "1.2.0"
    const val liveDataKtx = "2.2.0"
}

object Androidx {
    //    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveDataKtx}"
    const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.liveDataKtx}"
}

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
}
