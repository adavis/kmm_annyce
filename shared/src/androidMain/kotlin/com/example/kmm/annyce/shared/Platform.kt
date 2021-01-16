package com.example.kmm.annyce.shared

import co.touchlab.kermit.LogcatLogger
import co.touchlab.kermit.Logger

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getLogger(): Logger = LogcatLogger()
