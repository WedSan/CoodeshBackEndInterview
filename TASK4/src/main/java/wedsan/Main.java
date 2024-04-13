package wedsan;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        FetcherAPI fetcherAPI = new FetcherAPI();
        String response = null;

        try {
            response = fetcherAPI.sendHttpGetRequest("https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda");
        } catch (IOException e) {
            throw new RuntimeException("Error to call api: "+e.getMessage(), e);
        }

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Employee>>(){}.getType();
        List<Employee> employees = gson.fromJson(response, listType);

        GenderCounter gc = new GenderCounter();

        GenderCounterRecord genderCounterRecord =  gc.countGenders(employees);

        TextFileGenerator tfg = new TextFileGenerator();

        File jsonFile = tfg.generateFile(gson.toJson(genderCounterRecord), "count_employees_gender_record.json");

        S3StorageHandler s3StorageHandler = new S3StorageHandler();

        s3StorageHandler.uploadFile("interview-digiage","count_employees_gender_record",jsonFile);
        System.out.println("Item uploaded successfully");
    }
}
