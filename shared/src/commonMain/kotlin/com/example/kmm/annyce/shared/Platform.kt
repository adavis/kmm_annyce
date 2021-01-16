package com.example.kmm.annyce.shared

import co.touchlab.kermit.Logger

expect class Platform() {
    val platform: String

}

expect fun getLogger(): Logger
