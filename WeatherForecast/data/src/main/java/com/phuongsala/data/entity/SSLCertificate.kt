package com.phuongsala.data.entity

import javax.inject.Inject

data class SSLCertificate @Inject constructor(
    val domain: String,
    val cert1: String,
    val cert2: String,
    val cert3: String
)