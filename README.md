## The project

The Kotlin Multiplatform (KMP) project was created with Android Studio, Kotlin Multiplatform App template. It's then added iOS 
native dependencies to iOS target (see [build.gradle.kts](https://github.com/baole/KmpSample/blob/master/shared/build.gradle.kts#L23)).

```kotlin
    pod("AFNetworking") {
        version = "~> 4.0.0"
    }

    pod("AgoraRtcEngine_iOS") {

    }
```

`AFNetworking` is used to demonstrate how KMP manages iOS/Cocoapods dependencies for iOS target

## What happens?
- AFNetworking classes are recognized by Android Studio/Kotlin (see [Platform.kt](https://github.com/baole/KmpSample/blob/master/shared/src/iosMain/kotlin/com/github/kmp/sample/Platform.kt#L4))
- Agora classes aren't recognized by Android Studio, Gradle throws an error while building the project instead (see [the issue](https://github.com/baole/KmpSample#the-issue)).

## What we expect?
Agora classes are recognized by Android Studio/Kotlin. 

## The issue
Gradle failed to build the project with an error 

```java
> Task :shared:cinteropAgoraRtcEngine_iOSIosArm64
Exception in thread "main" java.lang.Error: /var/folders/3j/8k6z66l50dq_d1sjfxl8cphh0000gn/T/9716947415720857815.m:1:9: fatal error: module 'AgoraRtcEngine_iOS' not found
	at org.jetbrains.kotlin.native.interop.indexer.UtilsKt.ensureNoCompileErrors(Utils.kt:274)
	at org.jetbrains.kotlin.native.interop.indexer.ModuleSupportKt.getModulesASTFiles(ModuleSupport.kt:75)
	at org.jetbrains.kotlin.native.interop.indexer.ModuleSupportKt.getModulesInfo(ModuleSupport.kt:14)
```

See [full log file](gradle_sync.log)

## Some other debug information:
1. This gradle error seems to be similar to [a known error](https://kotlinlang.org/docs/native-cocoapods.html#possible-issues-and-solutions),
but applying the workaround didn't work.

2. After importing the project into Android Studio, if you look at the folder `shared/build/cocoapods/synthetic/IOS/Pods`, 
Gradle generates header files (in C language style) for `AFNetworking`. It successfully downloaded 
but didn't manage to generate header files for `AgoraRtcEngine_iOS` iOS SDK.

KMP uses header files to create a "bridge" to iOS native code.


