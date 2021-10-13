package com.mikheev.homework.repositories;

public interface BookRepositoryCustom {

    void deleteByIdCascadeComments(String id);
}
