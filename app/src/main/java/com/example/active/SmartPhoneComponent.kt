package com.example.active

import dagger.Component

@Component
interface SmartPhoneComponent  {
    fun getSmartPhone() : SmartPhone
}