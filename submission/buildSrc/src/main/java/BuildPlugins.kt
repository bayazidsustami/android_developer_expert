object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradle}" }
    val kotlin by lazy {"org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"}
    val saveArgs by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}" }
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
}