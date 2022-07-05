package com.github.kmp.sample

import platform.UIKit.UIDevice
import cocoapods.AFNetworking.*
//import cocoapods.AgoraRtcEngine

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}