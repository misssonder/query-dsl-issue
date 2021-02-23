package com.example.querydslissue.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "test_user")
data class User(
    @Id
    @Column(columnDefinition = "INT NOT NULL COMMENT '用户ID'")
    var userId: Int = 0,

    @Column(columnDefinition = "VARCHAR(64) NOT NULL COMMENT '用户名'")
    var username: String = "",
)