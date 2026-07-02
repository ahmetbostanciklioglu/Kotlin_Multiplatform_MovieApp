<div align="center">

# 🎬 Kotlin Multiplatform Movie App

**A cross-platform movie browser for Android & iOS, powered by a shared Kotlin business layer and The Movie Database (TMDB).**

![Platform](https://img.shields.io/badge/Platform-Android%20%7C%20iOS-6E48AA?style=flat-square)
![Kotlin](https://img.shields.io/badge/Kotlin-Multiplatform-7F52FF?style=flat-square&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4776E6?style=flat-square&logo=jetpackcompose&logoColor=white)
![SwiftUI](https://img.shields.io/badge/SwiftUI-blue?style=flat-square&logo=swift&logoColor=white)
![Ktor](https://img.shields.io/badge/Ktor-Client-087CFA?style=flat-square&logo=ktor&logoColor=white)
[![Stars](https://img.shields.io/github/stars/ahmetbostanciklioglu/Kotlin_Multiplatform_MovieApp?style=flat-square&color=6E48AA)](https://github.com/ahmetbostanciklioglu/Kotlin_Multiplatform_MovieApp/stargazers)
![Last Commit](https://img.shields.io/github/last-commit/ahmetbostanciklioglu/Kotlin_Multiplatform_MovieApp?style=flat-square&color=4776E6)

</div>

## 📖 Overview

Kotlin Multiplatform Movie App is a Kotlin Multiplatform Mobile (KMM) project that shares one Kotlin business layer across native Android and iOS clients. The `shared` module holds the networking, models, and domain logic, while each platform ships its own UI — Jetpack Compose on Android and SwiftUI on iOS. The app fetches popular movies from The Movie Database (TMDB) REST API, lets you browse the feed, and opens a detail view for any title.

## ✨ Features

- **Shared Kotlin core** — networking, models, use cases, and the repository live once in the `shared` module and are consumed by both Android and iOS.
- **Popular movies feed** — loads popular titles from the TMDB API using the Ktor client with content negotiation and Kotlinx Serialization.
- **Infinite scroll & pull-to-refresh** — the home feed pages through results and appends more movies as you scroll.
- **Movie detail screen** — tap any movie to see its poster, title, release date, and overview.
- **Clean Architecture + MVVM** — separated data and domain layers with use cases, wired together through Koin dependency injection.
- **Native UI per platform** — Jetpack Compose with Coil image loading and Compose Navigation on Android, SwiftUI on iOS.

## 📸 Preview

<div align="center">

**iOS Simulator — iPhone 14 Pro**

https://github.com/ahmetbostanciklioglu/Kotlin_Multiplatform_MovieApp/assets/40151328/03a422cb-7387-4d0a-9a25-cfd555a6c33d

**Android Emulator — Pixel 3A**

https://github.com/ahmetbostanciklioglu/Kotlin_Multiplatform_MovieApp/assets/40151328/ca4a731f-7547-477e-88fe-c6f96b387ef7

</div>

## 🚀 Getting Started

```bash
git clone https://github.com/ahmetbostanciklioglu/Kotlin_Multiplatform_MovieApp.git
cd Kotlin_Multiplatform_MovieApp
```

**Android**

1. Open the project root in Android Studio.
2. Let the Gradle sync finish.
3. Select the `androidApp` run configuration and press Run.

**iOS**

1. Open `iosApp/iosApp.xcodeproj` in Xcode.
2. Select an iOS Simulator (e.g. iPhone 14 Pro).
3. Press `Cmd + R` to build and run.

> The shared Kotlin framework is built by Gradle when the iOS app compiles.

## 📋 Requirements

- **Android:** Android Studio, `minSdk` 24, `compileSdk` / `targetSdk` 33
- **iOS:** Xcode with iOS Simulator support
- **Toolchain:** Kotlin 1.8.21, Kotlin Multiplatform, Gradle (Kotlin DSL), JDK 8+

## 🧑‍💻 Author

**Ahmet Bostancıklıoğlu** — [@ahmetbostanciklioglu](https://github.com/ahmetbostanciklioglu) · ahmetbostancikli@gmail.com

> ⭐ If this helped you, consider giving the repo a star!
