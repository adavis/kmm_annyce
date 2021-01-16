package com.example.kmm.annyce.shared.di

import co.touchlab.kermit.Kermit
import com.example.kmm.annyce.shared.TodosApi
import com.example.kmm.annyce.shared.TodosApiReal
import com.example.kmm.annyce.shared.TodosRepository
import com.example.kmm.annyce.shared.getLogger
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule)
}

// called by iOS
@Suppress("unused")
fun initKoin() = initKoin{}

val commonModule = module {
    single<TodosApi> { TodosApiReal() }
    single { Kermit(getLogger()) }
    single { TodosRepository() }
}
