package com.afrakhteh.ticku.util

interface DomainDataMapper <I,O>{
    fun convertDomainToData(domain: I): O
    fun convertDataToDomain(data: O): I
}