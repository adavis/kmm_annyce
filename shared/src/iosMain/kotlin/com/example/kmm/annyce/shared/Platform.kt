package com.example.kmm.annyce.shared

import co.touchlab.kermit.CommonLogger
import co.touchlab.kermit.Logger
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getLogger(): Logger = CommonLogger()
