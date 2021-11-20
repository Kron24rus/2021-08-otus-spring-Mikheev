package com.mikheev.homework.repositories;

import reactor.core.publisher.Mono;

public interface BookCustomRepository {

    Mono<Void> deleteByIdCascadeComments(String id);
}
