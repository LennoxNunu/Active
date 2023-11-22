package com.example.active

import dagger.Component

@Component(modules = [MemoryCardModule::class])
interface SmartPhoneComponent  {
    fun getSmartPhone() : SmartPhone
}