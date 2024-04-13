package wedsan;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

/**
 * Factory class for creating AWS credentials provider for accessing the Amazon S3 service.
 */
public class S3CredentialsProviderFactory {

    private static final String accessKeyId = System.getenv("S3_ACCESS_KEY_ID");

    private static final String secretAccessKey = System.getenv("S3_SECRET_KEY");

    /**
     * Creates an AWS credentials provider for accessing the Amazon S3 service.
     * @return The AWS credentials provider.
     * @throws S3CredentialsNotFoundException If the access key id or secret key is not found in the environment variables.
     */
    public static AWSCredentialsProvider createS3CredentialsProvider(){
        validateCredentials();
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
        return new AWSStaticCredentialsProvider(awsCredentials);
    }

    private static void validateCredentials(){
        if(accessKeyId == null){
            throw new S3CredentialsNotFoundException("The access key id was not found");
        }
        if(secretAccessKey == null){
            throw new S3CredentialsNotFoundException("The secret key was not found");
        }
    }
}
