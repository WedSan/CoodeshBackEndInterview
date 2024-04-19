package wedsan.task5.model.userEntity.validators.creation;

import wedsan.task5.model.userEntity.UserEntity;

/**
 * Interface for validating user entity creation.
 * Implementations of this interface perform specific validation checks on user entities before creation.
 */
public interface UserEntityCreationValidator {

    /**
     * Validates the given user entity before creation.
     * @param entityToBeValidated The user entity to be validated.
     */
    void validate(UserEntity entityToBeValidated);
}
