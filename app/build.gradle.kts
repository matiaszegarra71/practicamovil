    plugins {
        alias(libs.plugins.android.application)
    }

    android {
        namespace = "com.example.practicamovil"
        compileSdk = 34

        defaultConfig {
            applicationId = "com.example.practicamovil"
            minSdk = 24
            targetSdk = 34
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
        implementation("androidx.cardview:cardview:1.0.0") // CardView
        implementation("androidx.recyclerview:recyclerview:1.2.1") // RecyclerView
        testImplementation(libs.junit)
        androidTestImplementation(libs.ext.junit)
        androidTestImplementation(libs.espresso.core)
    }

