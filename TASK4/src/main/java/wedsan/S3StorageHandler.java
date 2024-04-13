package wedsan;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

import java.io.File;

/**
 * This class handle interaction with Amazon S3 storage.
 */
public class S3StorageHandler {

    AmazonS3 s3Client;

    public S3StorageHandler() {
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(S3CredentialsProviderFactory.createS3CredentialsProvider())
                .withRegion("us-west-2")
                .build();
    }

    /**
     * Creates a new bucket with specified name.
     *
     * @param bucketName the name of the bucket to create
     * @return the created Bucket object
     * @throws AmazonS3Exception if an erros occurs while communicating with Amazon S3
     * @throws IllegalBucketNameException if the provided bucket name already exists in the Amazon S3
     */
    public Bucket createBucket(String bucketName) throws AmazonS3Exception, IllegalBucketNameException {
        if(!isValidBucketName(bucketName)){
            throw new IllegalBucketNameException("Invalid bucket name: "+ bucketName);
        }

        return s3Client.createBucket(bucketName);
    }

    /**
     * Retrieves the object from the specified bucket with the given object key.
     *
     * @param bucketname the name of the bucket you want to storage
     * @param objectKey the key of the object to retrieve
     * @return the S3Object representing the retrieved object
     * @throws AmazonS3Exception if an erros occurs while communicating with Amazon S3
     * @throws IllegalBucketNameException if the provided bucket name doesn't exist in the Amazon S3
     */
    public S3Object getBucketObject(String bucketname, String objectKey) throws AmazonS3Exception, IllegalBucketNameException{
        if(!isValidBucketName(bucketname)){
            throw new IllegalBucketNameException("Cannot found a bucket name: "+bucketname);
        }

        return s3Client.getObject(new GetObjectRequest(bucketname, objectKey));
    }

    /**
     * Uploads a file to specified bucket with the given key name.
     *
     * @param bucketName the name of the bucket
     * @param keyName the key name under which to store the file in the bucket
     * @param file the file object to upload
     * @throws AmazonS3Exception
     */
    public void uploadFile(String bucketName, String keyName, File file) throws AmazonS3Exception{
        try{
            this.createBucket(bucketName);
        }catch(IllegalBucketNameException e){
            return;
        }

        s3Client.putObject(bucketName, keyName, file);
    }

    /**
     * Checks if the specified bucket name already exists in the Amazon S3.
     *
     * @param bucketName the name of the bucket to check
     * @return true if the bucket exists, false otherwise
     */
    private boolean isValidBucketName(String bucketName) {
        return s3Client.doesBucketExistV2(bucketName);
    }
}

