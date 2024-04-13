package wedsan;

/**
 * Exception thrown when Amazon S3 credentials are not found.
 * This can occur when the environment variables for Amazon S3 credentials are not properly configured
 * or when the provided credentials are invalid.
 */
public class S3CredentialsNotFoundException extends RuntimeException {

    public S3CredentialsNotFoundException() {
    }

    public S3CredentialsNotFoundException(String message) {
        super(message);
    }
}
