package net.einself.validatorapproaches.validation;

public interface Validator<T> {

    default ValidationResult validate(T target) {
        throw new UnsupportedOperationException();
    }

    default ValidationResult validate(T target, ValidationContext context) {
        throw new UnsupportedOperationException();
    }

}
