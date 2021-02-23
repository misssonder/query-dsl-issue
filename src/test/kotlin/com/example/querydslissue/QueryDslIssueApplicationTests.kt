package com.example.querydslissue

import com.example.querydslissue.entity.QUser
import com.querydsl.jpa.impl.JPAQueryFactory
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class QueryDslIssueApplicationTests {
	@Autowired
	lateinit var queryFactory: JPAQueryFactory

	/**
	 * this is the insert bug
	 */
	@Test
	fun testQueryDslInsert() {
		val user = QUser.user
		queryFactory.insert(user)
			.set(user.userId,1)
			.set(user.username,"testUser")
			.execute()
	}


}
