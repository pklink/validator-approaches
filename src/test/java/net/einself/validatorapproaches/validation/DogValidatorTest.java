package net.einself.validatorapproaches.validation;

import net.einself.validatorapproaches.model.Dog;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DogValidatorTest {

    private final DogValidator underTest = new DogValidator();

    @Test
    void givenNull_shouldReturn1Error() {
        // act
        final var result = underTest.validate(null);

        // assert
        assertThat(result.isValid()).isFalse();
        assertThat(result.getErrors()).hasSize(1);
        assertThat(result.getErrors().get(0)).isEqualTo("not be null");
    }

    @Test
    void givenInvalidName_shouldReturn1Error() {
        // arrange
        final var dog = new Dog("kitty");

        // act
        final var result = underTest.validate(dog);

        // assert
        assertThat(result.isValid()).isFalse();
        assertThat(result.getErrors()).hasSize(1);
        assertThat(result.getErrors().get(0)).isEqualTo("invalid name");
    }

    @Test
    void givenValidInstance_shouldBeValid() {
        // arrange
        final var dog = new Dog("bernie");

        // act
        final var result = underTest.validate(dog);

        // assert
        assertThat(result.isValid()).isTrue();
        assertThat(result.getErrors()).hasSize(0);
    }
}