package com.example.querydslissue

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import javax.persistence.EntityManager

@SpringBootApplication
class QueryDslIssueApplication{

	@Bean
	fun jpaQuery(entityManager: EntityManager): JPAQueryFactory {
		return JPAQueryFactory(entityManager)
	}
}

fun main(args: Array<String>) {
	runApplication<QueryDslIssueApplication>(*args)
}
