package com.mikheev.homework.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class NotFoundException : RuntimeException {

    constructor() : super()
    constructor(message: String?) : super(message)
}
