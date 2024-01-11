import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

val apiKeyPropertiesFile : File = rootProject.file("key.properties")
val apiKeyProperties = Properties()
 apiKeyProperties.load(FileInputStream(apiKeyPropertiesFile))

android {
    namespace = "mohsen.morma.digikala"
    compileSdk = 34

    defaultConfig {
        applicationId = "mohsen.morma.digikala"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String","X_API_KEY", apiKeyProperties["X_API_KEY"].toString())
        buildConfigField("String","BASE_URL", apiKeyProperties["BASE_URL"].toString())
        buildConfigField("String","key", apiKeyProperties["key"].toString())
        buildConfigField("String","iv", apiKeyProperties["iv"].toString())

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.12")

    //room
    implementation ("androidx.room:room-runtime:2.6.1")
    ksp ("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")

    //datastore
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    //hilt di
    implementation ("com.google.dagger:hilt-android:2.50")
    ksp ("com.google.dagger:hilt-compiler:2.50")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")

    //compose navigation
    implementation ("androidx.navigation:navigation-compose:2.7.6")

    //animation
    implementation ("com.airbnb.android:lottie-compose:6.3.0")

    //coil - load image from url
    implementation ("io.coil-kt:coil-compose:2.5.0")

    //swipe refresh
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.32.0")

    //system ui controller
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.32.0")

    //Accompanist-Pager
    implementation ("com.google.accompanist:accompanist-pager:0.32.0")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.32.0")

//    //Zarin-pal
//    implementation ("com.zarinpal:payment-provider-ktx:0.5.3")

    //Paging
    implementation("androidx.paging:paging-compose:3.2.1")



}