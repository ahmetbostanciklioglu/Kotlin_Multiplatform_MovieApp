# Kotlin_Multiplatform_MovieApp


You can download and examine the project on your desktop.

Android Emulator Screenshots: (Home and detail pages )
![Screenshot_20230805_182531](https://github.com/ahmetbostanciklioglu/Kotlin_Multiplatform_MovieApp/assets/40151328/74bf30ec-ba3f-4230-91c6-5bc474f82650)
![Screenshot_20230805_182552](https://github.com/ahmetbostanciklioglu/Kotlin_Multiplatform_MovieApp/assets/40151328/e0f6c80c-a107-46fb-8920-8908c82d6f65)


Firstly Add needed dependencies to build.gradles.kts of shared file:

Add below serilazition code to plugins in build.gradles.kts file:
'''
plugins {

  //Kotlinx Serialization
    kotlin("plugin.serialization") version "1.8.0"
}
'''

Add below dependencies to commonMain:
'''
val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                //Use api so that the android app can use it as well
                api("io.insert-koin:koin-core:$koinVersion")
            }
}
'''

Add below dependencies to androidMain:
'''
val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktorVersion")

                api("io.insert-koin:koin-android:$koinVersion")
            }
}
'''

Add below dependencies to iosMain:
'''
val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
            }
}
'''

Later on click Sync Now button.

Add codes to  shared > commonMain which are used with both platforms. When you finish common platform codes, design android Ui from AndroidMain file, and design iOSApp from iOSApp. 

Open iOSApp: 
'''
iOSApp > iOSApp.xcodeproj right click and Open In Xcode 
'''
And then modify needed according to github codes in your project.


Congratulations! You develop a kotlin multiplatform app for Android and iOS devies.
