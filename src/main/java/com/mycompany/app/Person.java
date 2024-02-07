package com.mycompany.app;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;

        return new EqualsBuilder().
                append(firstName, person.firstName).
                append(lastName, person.lastName).
                append(age, person.age).
                isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(20, 50)
                .append(firstName)
                .append(lastName)
                .append(age)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(firstName)
                .append(lastName)
                .append(age)
                .toString();
    }
}
