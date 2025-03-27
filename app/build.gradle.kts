plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.gestiondeempleados"
    compileSdk = 35  // Actualizado a 35

    defaultConfig {
        applicationId = "com.example.gestiondeempleados"
        minSdk = 24
        targetSdk = 34  // Puedes dejarlo en 34 si no quieres cambios en el comportamiento
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
