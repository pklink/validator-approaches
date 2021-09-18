package net.einself.validatorapproaches.validation;

import net.einself.validatorapproaches.model.Dog;

import java.util.List;
import java.util.Optional;

public class DogValidator implements Validator<Dog> {

    private static final List<String> INVALID_NAMES = List.of("kitty");

    @Override
    public ValidationResult validate(Dog target) {
        final var validationResult = new ValidationResult();

        if (target == null) {
            validationResult.addError("not be null");
            return validationResult;
        }

        Optional.ofNullable(target.getName())
                .map(String::toLowerCase)
                .filter(INVALID_NAMES::contains)
                .ifPresent(name -> validationResult.addError("invalid name"));

        return validationResult;
    }

}
