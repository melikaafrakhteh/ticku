package com.afrakhteh.ticku.di.modules

import com.afrakhteh.ticku.model.data.mapper.DomainDataMapperImpl
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.entities.Tasks
import com.afrakhteh.ticku.util.DomainDataMapper
import dagger.Binds
import dagger.Module

@Module
interface MapperModule {

    @Binds
    fun bindsMapper(mapperImpl: DomainDataMapperImpl): DomainDataMapper<TaskEntity, Tasks>
}