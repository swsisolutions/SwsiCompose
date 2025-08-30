plugins {
    id("com.android.library") version "8.9.3"
    id("org.jetbrains.kotlin.android") version "2.1.0"
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.0"
    id("maven-publish")
}

android {
    namespace = "com.swasi.composeuikit"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(platform("androidx.compose:compose-bom:2025.08.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview") // For @Preview
    implementation("androidx.compose.material3:material3") // Material Design 3
    implementation("androidx.compose.animation:animation")
    implementation("androidx.compose.foundation:foundation")
    // For debugging and tooling (development only)
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest") // Required for tooling and some tests

    // For UI tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    implementation("androidx.activity:activity-compose")

    // ViewModel integration
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose")

    // LiveData observation
    implementation("androidx.compose.runtime:runtime-livedata")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.swasi"
                artifactId = "composeuikit"
                version = "1.0.0"
            }
        }
    }
}
