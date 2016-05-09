package com.esgi.person.repository;

import org.springframework.test.context.jdbc.Sql;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Sql(
        statements = {
                "INSERT INTO Person (idperson, name, birthday, picture, linkbo, nationality) VALUES ('105060', 'nico walson', NOW(), 'http://image.fr/image.png','http://linkbo.fr/nico', 'français')",
                "INSERT INTO Person (idperson, name, birthday, picture, linkbo, nationality) VALUES ('105065', 'nico walson', NOW(), 'http://image.fr/image.png','http://linkbo.fr/nico', 'français')",
                "INSERT INTO Person (idperson, name, birthday, picture, linkbo, nationality) VALUES ('105070', 'nico walson', NOW(), 'http://image.fr/image.png','http://linkbo.fr/nico', 'français')"
        },
        executionPhase = BEFORE_TEST_METHOD
)
@Sql(
        statements = {
                "DELETE FROM Person"
        },
        executionPhase = AFTER_TEST_METHOD
)
public @interface SqlDataPerson {
}
