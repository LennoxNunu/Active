package com.example.active

import dagger.Module
import dagger.Provides

@Module
class NCBatteryModule {
    @Provides
    fun providesNCBattery(nickelCadmiumBattery:NickelCadmiumBattery):Battery{
        return nickelCadmiumBattery
    }
}