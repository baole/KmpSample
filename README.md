## The project

The project was created with Android Studio, Kotlin Multiplatform App template. It's then add iOS 
native dependencies to iOS target

```kotlin
    pod("AFNetworking") {
        version = "~> 4.0.0"
    }

    pod("AgoraRtcEngine_iOS") {

    }
```

## What happens?
AFNetworking classes are recognized by Android Studio/Kotlin
Agora classes aren't recognized by Android Studio

## What we expect?
Agora classes are recognized by Android Studio/Kotlin


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

This gradle error seems to be similar to [a known error](https://kotlinlang.org/docs/native-cocoapods.html#possible-issues-and-solutions),
but applying the workaround didn't work.



