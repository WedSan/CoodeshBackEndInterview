# Coodesh Back-end Solution

Solution project for **coodesh back-end challenge.**

## Technologies used
![java](https://camo.githubusercontent.com/b0648ef7a9b6980ea27c1caaeb06d5c8503dbb4f9b4d9d7ca1df60a5edc14340/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465)   **Java**  - The programming language used for this project.  
  ![Spring Framework](https://camo.githubusercontent.com/c2a58428fe9b38967494da3b0a098f1d28f9cc395e3bbf123cbc14fb36bc1b07/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e672d2532333644423333462e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67266c6f676f436f6c6f723d7768697465)  **Spring Framework**   -  Framework for developing Java applications that facilitates the configuration and execution of applications.  
 ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white) **Docker**  - Tool to transform the application into containers.


## Apresentation Video
[Link Video](https://youtu.be/M6iMgBBIZHM)
  ## Graph Analysis

  
Memory and CPU usage:
![](https://images2.imgbox.com/3b/e9/kJaXLnz6_o.png)
Based on the graph, over a 6-hour period, the analyzed machine had an average memory usage of less than 10%, indicating that the machine is operating with a lot of leeway, except around 1:20 PM, when memory usage peaks at between 26% and 28%. This suggests a sudden increase in demand for processing power, likely due to a surge in requests. Another observation is that starting at 12:00 PM, CPU and memory usage gradually increase compared to the levels before noon. This trend aligns with typical usage patterns observed in many workplaces, where system activity tends to pick up during regular business hours.

## SQL TASK
1. Query that returns the number of employees by gender.
````sql   
SELECT gender , count(*) as number_of_employees  
FROM employees  
GROUP BY gender; 
````
2. Query that returns the number of employees distinct by gender, hire date and birth date.
````sql
SELECT gender,  
  YEAR(birth_date),  
  YEAR(hire_date),  
  COUNT(DISTINCT emp_no) AS number_of_employess  
FROM employees  
GROUP BY gender, YEAR(birth_date), hire_date;  
````
3.   query that returns the average, minimum and max salary.
````sql
select avg(salary) as average_salary,  
  min(salary) as min_salary,  
  max(salary) as max_salary  
from salaries;
````

 ## How to run the _Java TASKS_


**Steps for TASK 1-4:**

1.  Navigate to the Java project directory using the `cd` command.
2.  Compile the Java code using the `mvn compile` command.
3.  Execute: ``
sh
mvn exec:java -Dexec.mainClass="wedsan.main" -Dexec.classpathScope=runtime
`` to run the Java application


**Steps for TASK 5:**

1.  Navigate to the Java project directory using the `cd` command.
2. Use `docker-compose up -d` command.


## JAVA TASK 1 - Solution

### Problem
-  Implement a function that says if a given string is palindrome.
### My Solution: 
- Take the input, reverse it, and compare the reversed value with the input to differentiate them.
### Implementation: 

- This class provides methods to check if a given string is a palindrome.
```java
public class PalindromeChecker {

    public PalindromeChecker() {
    }

    /**
     * Checks if given string is a palindrome.
     *
     * @param stringToCheck The input to be checked.
     * @return True if the value is a palindrome, false otherwise.
     */
    public boolean isPalindrome(String stringToCheck) {
        stringToCheck = stringToCheck.toLowerCase();

        String stringReversed = reverseString(stringToCheck);

        if(stringReversed.equals(stringToCheck)){
            return true;
        }

        return false;
    }

    /**
     * This method reverses a given input string.
     *
     * @param inputString The string to be reversed.
     * @return The reversed string.
     */
    private String reverseString(String inputString) {
        char[] characters = inputString.toCharArray();

        String reversedString = "";
        for(int i= characters.length -1; i>=0; i--){
           reversedString += characters[i];
        }

        return reversedString;
    }
}
```
### Testing and Validation
Here i used JUnit Framework for testing the class PalindromeChecker. 

```Java
public class PalindromeCheckerTest {  
  
   @Test  
  public void testIsPalindrome() {  
	PalindromeChecker checker = new PalindromeChecker();  

	// Testing palindromes  
	assertTrue(checker.isPalindrome("madam"));  
	assertTrue(checker.isPalindrome("racecar"));  
	assertTrue(checker.isPalindrome("level"));  

	// Testing non-palindromes  
	assertFalse(checker.isPalindrome("hello"));  
	assertFalse(checker.isPalindrome("world"));  
	assertFalse(checker.isPalindrome("java"));  
  }  
  
}
````
The first test checks the words that are palindromes and expects the method to return true.
````java
assertTrue(checker.isPalindrome("madam"));  
assertTrue(checker.isPalindrome("racecar"));  
assertTrue(checker.isPalindrome("level"));   
````
The second test verify the words that are non-palindromes and expectes the method return false.
````java
assertFalse(checker.isPalindrome("hello"));  
assertFalse(checker.isPalindrome("world"));  
assertFalse(checker.isPalindrome("java"));  
````


## JAVA TASK 2 - Solution

### Problem
-  Write a list Each element must know the element before and after it. 
- Print out your list and then remove the element in the middle of the list. Print out again.
### My Solution: 
- In my initial idea, I considered writing a class to represent a 'node.' Each node would have two fields: one storing the index position of its previous value, and the other storing the index position of its next value. But in some point, i decided instead to storage the index position of the value, the node could storage the reference to previously value and the next value, creating a linked list, where each element points to another element and vice-versa. 

- The second step, was to create a class in which your responsibility is manage the elements, like when add elements to the list, the class will take the responsibility to put the element as the last element and reference the old value that was in its position.  This class will have too a method to print all elements. In which this method will iterate through all elements using a loop, where this loop will start from the first element of the list and go until the last element based on the reference to the next value of the node and the next nodes.

- To remove the middle element, the class will iterate through all elements using a loop and count each element with a counter to determine the size of the list. Next, it will find the middle element by calculating the median of the list. Then, the class will set the next value of the previous element of the removed element to the next value of the removed element if it's not null. Additionally, if the next value of the removed element is not null, the class will set the previous value of the next element to the previous value of the removed element, establishing the connection between the surrounding elements.
<br>
$$ 
(n+1)/2
$$

Using this formula, where 'n' represents the size of the list, I can obtain the index of the middle element of the list. **An important thing here is i just considered a list that has the number of elements being odd.**

### Implementation: 
- This class represents a node in a double linked list:
```java
public class Node {  
  
  private String dataValue;  
  
    private Node prev;  
  
    private Node Next;  
  
    public Node() {  
 }  
  public String getDataValue() {  
  return dataValue;  
    }  
  
  public void setDataValue(String dataValue) {  
  this.dataValue = dataValue;  
    }  
  
  public Node (String dataValue){  
  this.dataValue = dataValue;  
    }  
  
  public Node getPrev() {  
  return prev;  
    }  
  
  public void setPrev(Node prev) {  
  this.prev = prev;  
    }  
  
  public Node getNext() {  
  return Next;  
    }  
  
  public void setNext(Node next) {  
  Next = next;  
    }  
}
```

 - This class represents a double linked list data structure. 
```java
/**  
 * . */
 public class DoubleLinkedList {  
  private Node firstElement;  
  
    private Node lastElement;  
  
    private int size;  
  
    public DoubleLinkedList() {  
  this.firstElement = null;  
        this.lastElement = null;  
        size = 0;  
    }  
  
  /**  
 * Adds a new node to the linked list. * * @param newNode The node to be added to the list.  
 */  public void addElement(Node newNode){  
  
  if(firstElement == null){  
  firstElement = newNode;  
            lastElement = newNode;  
        }  
  else{  
  lastElement.setNext(newNode);  
            newNode.setPrev(lastElement);  
            lastElement = newNode;  
        }  
  
  size++;  
    }  
  
  /**  
 * Removes the middle element from the linked list. * * @throws MiddleElementNotFoundException If the list is empty or not odd, indicating no middle element.  
 */  public void removeMiddleElement() throws MiddleElementNotFoundException{  
  if(firstElement == null){  
  throw new MiddleElementNotFoundException("The list is empty");  
        }  
  if(size%2 == 0){  
  throw new MiddleElementNotFoundException("The list is not odd");  
        }  
  
  int middleElementIndex = (size+1)/2;  
  
        Node currentElement = firstElement;  
  
        for(int i = 0; i <= middleElementIndex -2; i++){  
  currentElement = currentElement.getNext();  
        }  
  
  currentElement.getPrev().setNext(currentElement.getNext());  
        currentElement.getNext().setPrev(currentElement.getPrev());  
  
        size--;  
    }  
  
  /**  
 * Removes the element at the specified index from the linked list. * * @param index The index of the element to be removed.  
 */  public void removeElement(int index){  
  
  if(index == 0){  
  firstElement = null;  
            size--;  
            return;  
        }  
  if(index == size -1){  
  lastElement = null;  
            size--;  
            return;  
        }  
  
  Node element = findElement(index);  
  
        element.getPrev().setNext(element.getNext());  
        element.getNext().setPrev(element.getPrev());  
  
        size--;  
  
    }  
  
  /**  
 * Finds and returns the node at the specified index in the linked list. * * @param index The index of the node to be found.  
 * @return The node at the specified index.  
 * @throws IndexOutOfBoundsException If the index is out of bounds or the list is empty.  
 */  public Node findElement(int index){  
  if(firstElement == null){  
  throw new IndexOutOfBoundsException("The list is empty");  
        }  
  if(index < 0 || index >= size){  
  throw new IndexOutOfBoundsException();  
        }  
  Node currentElement = firstElement;  
  
        for(int i = 0; i < index; i++){  
  currentElement = currentElement.getNext();  
        }  
  
  return currentElement;  
    }  
  
  /**  
 * Method to print the elements of the linked list. * @throws IndexOutOfBoundsException if the list is empty.  
 */  public void printElements(){  
  if (firstElement == null){  
  throw new IndexOutOfBoundsException("The list is empty");  
        }  
  
  Node currentElement = firstElement;  
  
        for(int i = 0; i <= size -1; i++){  
  System.out.println(currentElement.getDataValue());  
           if(currentElement.getNext() != null){  
  currentElement = currentElement.getNext();  
           }  
  }  
  }  
  
  public Node getFirstElement() {  
  return firstElement;  
    }  
  
  public Node getLastElement() {  
  return lastElement;  
    }  
  
  public int getSize() {  
  return size;  
    }  
  
}
```
Implementation in the main class for task 2
```java
```java
public class Main {  
    // Main method
    public static void main(String[] args) {  
  
        // Creating nodes with data
        Node node1 = new Node("batman");  
        Node node2 = new Node("joker");  
        Node node3 = new Node("penguin");  
  
        // Creating a double linked list object
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();  
  
        // Adding nodes to the double linked list
        doubleLinkedList.addElement(node1);  
        doubleLinkedList.addElement(node2);  
        doubleLinkedList.addElement(node3);  
  
        // Printing the list before removing the middle element
        System.out.println("-- List before removing the middle element");  
        doubleLinkedList.printElements();  
  
        try {  
            // Removing the middle element from the list
            doubleLinkedList.removeMiddleElement();  
        } catch (MiddleElementNotFoundException ex) {  
            // Handling exception if middle element not found
            System.out.println(ex.getMessage());  
        }  

        // Printing the list after removing the middle element
        System.out.println("-- List after removing middle element --");  
        doubleLinkedList.printElements();  
    }  
}
```
### Testing and Validation
**1. Testing addElement:** Test to check if the element will be added to the list correctly.
````java
@Test  
public void testAddElement() {  
  Node node1 = new Node("batman");  
  Node node2 = new Node("joker");  
  
  doubleLinkedList.addElement(node1);  
  doubleLinkedList.addElement(node2);  
  
  Assertions.assertEquals(node1, doubleLinkedList.getFirstElement());  
  Assertions.assertEquals(node2, doubleLinkedList.getLastElement());  
  Assertions.assertEquals(2, doubleLinkedList.getSize());  
}
````
2. **Testing removeMiddleElement():** Test to check if the method will remove the middle element correctly.
````java
@Test  
public void testRemoveMiddleElement() throws MiddleElementNotFoundException {  
  Node node1 = new Node("batman");  
  Node node2 = new Node("joker");  
  Node node3 = new Node("penguin");  
  
  doubleLinkedList.addElement(node1);  
  doubleLinkedList.addElement(node2);  
  doubleLinkedList.addElement(node3);  
  doubleLinkedList.removeMiddleElement();  
  
  Assertions.assertEquals(node1, doubleLinkedList.getFirstElement());  
  Assertions.assertEquals(node3, doubleLinkedList.getLastElement());  
  Assertions.assertEquals(2, doubleLinkedList.getSize());  
}
````
3.**Testing throwing exception:** Test to check if the `MiddleElementNotFoundException` will be thrown, when the client tries to remove the middle element with the list being odd.

````java
@Test  
public void testThrowException(){  
  DoubleLinkedList evenList = new DoubleLinkedList();  
  
  Node node1 = new Node("batman");  
  Node node2 = new Node("joker");  
  
  evenList.addElement(node1);  
  evenList.addElement(node2);  
  Assertions.assertThrows(MiddleElementNotFoundException.class, ()-> evenList.removeMiddleElement());  
}
````
4. **Testing findElement method:** Test to check if the `findElement` method will return the respective value given from the method arguments.
````java
@Test  
public void testFindElement() {  
  Node node1 = new Node("batman");  
  Node node2 = new Node("joker");  
  Node node3 = new Node("penguin");  
  doubleLinkedList.addElement(node1);  
  doubleLinkedList.addElement(node2);  
  doubleLinkedList.addElement(node3);  
  
  Node foundNode = doubleLinkedList.findElement(2);  
  Assertions.assertEquals("penguin", foundNode.getDataValue());  
  
  foundNode = doubleLinkedList.findElement(1);  
  Assertions.assertEquals("joker", foundNode.getDataValue());  
  
  
  foundNode = doubleLinkedList.findElement(0);  
  Assertions.assertEquals("batman", foundNode.getDataValue());  
}
````
5.**Testing removeElement method:** Test to check if `removeElement` method will remove the respective value given from the method arguments.
````java
@Test  
public void testRemoveElement() {  
  Node node1 = new Node("batman");  
  Node node2 = new Node("joker");  
  Node node3 = new Node("penguin");  
  doubleLinkedList.addElement(node1);  
  doubleLinkedList.addElement(node2);  
  doubleLinkedList.addElement(node3);  
  
  doubleLinkedList.removeElement(2);  
  Assertions.assertNull(doubleLinkedList.getLastElement());  
  Assertions.assertEquals(2, doubleLinkedList.getSize());  
  
  doubleLinkedList.removeElement(0);  
  Assertions.assertNull(doubleLinkedList.getFirstElement());  
  Assertions.assertEquals(1, doubleLinkedList.getSize());  
  
  doubleLinkedList.removeElement(0);  
  Assertions.assertNull(doubleLinkedList.getFirstElement());  
  Assertions.assertNull(doubleLinkedList.getLastElement());  
  Assertions.assertEquals(0, doubleLinkedList.getSize());  
}
````
## JAVA TASK 3 - Solution

### Problem
-  Write a list and add an aleatory number of Strings.
-  In the end, print out how many distinct items exists on the list.
### My Solution: 
- Create a class that is responsible for generating a list with a random number of items, each consisting of 2 characters in length to increase the chances of repetition. Next, iterate over this list using a SET data structure to remove duplicate elements. Finally, check the size of the SET to determine the number of distinct elements
### Implementation: 
This class generates a random list of strings;
````java
public class ListRandom {  
  
  public ListRandom() {  
 }  
  /**  
 * Generates a list of random strings with a length of 2 characters each. * The list size will be a random number between 200 and 500. * * @return An ArrayList containing the randomly generated strings.  
 */  public ArrayList<String> createRandomStringList(){  
  ArrayList<String> stringList = new ArrayList<String>();  
  
  int randomNumberOfElements = (int) (Math.random() * (500 - 200 + 1)) + 200;  
  
  for(int i = 0; i < randomNumberOfElements; i++){  
  stringList.add(generateRandomString());  
 }  
  return stringList;  
 }  
  /**  
 * Generates a random string of length 2 containing only lowercase letters (a-z). * * @return A random string of length 2.  
 */  private String generateRandomString(){  
  
  String randomString = "";  
  
  for(int i = 0; i <= 1; i++){  
  char character = (char)  ('a' + Math.random() * ('z' - 'a' +1 ));  
  randomString += character;  
 }  return randomString.toString();  
 }}
````
Implementation in the main class
```java
public class Main {  
  public static void main(String[] args) {  
  ListRandom listRandom = new ListRandom();  
		
        ArrayList<String> stringList = listRandom.createRandomStringList();  
  
        Set<String> stringSet = new HashSet<>(stringList);  
  
        System.out.println("Number of the elements in the random list: "+stringList.size());  
        System.out.println("Number of distinct elements in the random list: "+stringSet.size());  
    }  
  
}
```
### Testing and Validation
1. Tests if the `createRandomStringList` method generates a list with a size between 200 and 500 elements.
````java
@Test  
public void testCreateRandomStringList_ListSize() {  
  ListRandom listRandom = new ListRandom();  
  List<String> randomList = listRandom.createRandomStringList();  
  
  // Test if the list size is between the expected range (200-500 elements)  
  assertTrue(randomList.size() >= 200 && randomList.size() <= 500,  
  "List size should be between 200 and 500 elements");  
}
````
2. Tests if the `createRandomStringList` method generates a list where each element has a length of 2 characters and only contains lowercase letters (a-z).
````java
@Test  
public void testCreateRandomStringList_ListContent() {  
  ListRandom listRandom = new ListRandom();  
  List<String> randomList = listRandom.createRandomStringList();  
  
  // Test if each element in the list has a length of 2 characters  
  for (String element : randomList) {  
  assertEquals(2, element.length(), "Each element should have a length of 2 characters");  
 }  
  // Test if each element only contains lowercase letters (a-z)  
  for (String element : randomList) {  
  assertTrue(element.matches("[a-z]+"), "Each element should only contain lowercase letters");  
 }}
````
## JAVA TASK 4 - Solution

### Problem

 - Create an implementation of a Rest API client.
 - Prints out how many records exists for each gender and save this file to AWS S3 bucket

### My Solution: 
- Create a class to handle requests to the specified endpoint. Next, perform a GET request using this class to fetch the data and utilize a library to transform this data into Java objects. Subsequently, add each object to a list. The next step would be to iterate over this list and determine the gender of each employee, incrementing a counter for each gender found. Finally, store the collected count data in a .json file and create a class responsible for sending these files to the S3 bucket.


### Implementation: 
Class representing an employee data.
````java
public class Employee {  
  @SerializedName("emp_no")  
  private String empNo;  
  @SerializedName("first_name")  
  private String firstName;  
  @SerializedName("last_name")  
  private String lastName;  
  @SerializedName("gender")  
  private EmployeeGender employeeGender;  
  
  //Constructors, getter and setters....
}
````
Enumeration representing the gender of an employee.
````java
public enum EmployeeGender {  
  /**  
 * Male gender. */  M,  
  /**  
 * Female gender. */  F  
}
````
Class responsible for fetching data from an API.
````java
public class FetcherAPI {  
  
  public FetcherAPI() {  
 }  
 
 /**  
 * Sends an HTTP GET request to the specified URL and returns the response body as a string. * * @param url The URL to which the GET request will be sent  
 * @return The response body as a string  
 * @throws IOException If an IO exception occurs while sending the request or processing the response  
 */  
	 public String sendHttpGetRequest(String url) throws IOException {  
  CloseableHttpClient httpclient = HttpClientBuilder.create().build();  
  
  HttpGet httpget = new HttpGet(url);  
  CloseableHttpResponse response = httpclient.execute(httpget);  
  
  return EntityUtils.toString(response.getEntity());  
  
 }}
````
Class that counts the quantity of employees for each gender.
````java
public class GenderCounter {  
  
  public GenderCounter() {  
 }  
/**  
 * Counts the quantity of employees for each gender. * * @param employees List of employees  
 * @return GenderCounterRecord object containing the count of male and female employees  
 */  
 public GenderCounterRecord countGenders(List<Employee> employees) {  
  
  int maleCounter = 0;  
  int femaleCounter = 0;  
  
  for(Employee employee : employees) {  
  if(employee.getEmployeeGender().equals(EmployeeGender.M)) {  
  maleCounter++;  
}  
 else{  
  femaleCounter++;  
	 } 
 }  
  return new GenderCounterRecord(maleCounter, femaleCounter);  
 }}
````
Class representing the result of counting employee genders.
````java
public class GenderCounterRecord {  
  
  @SerializedName("employees_male")  
  private int employeesMale;  
  
  @SerializedName("employees_female")  
  private int employeesFemale;  
  
  //Contructor, getter and setters...
}
````
Factory class for creating AWS credentials provider for accessing the Amazon S3 service.
````java
public class S3CredentialsProviderFactory {  
  
  private static final String accessKeyId = System.getenv("S3_ACCESS_KEY_ID");  
  
  private static final String secretAccessKey = System.getenv("S3_SECRET_KEY");  
  
  /**  
 * Creates an AWS credentials provider for accessing the Amazon S3 service. * @return The AWS credentials provider.  
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
 }  if(secretAccessKey == null){  
  throw new S3CredentialsNotFoundException("The secret key was not found");  
 } }}
````
Exception class thrown when Amazon S3 credentials are not found.
````java
public class S3CredentialsNotFoundException extends RuntimeException {  
  
  public S3CredentialsNotFoundException() {  
 }  
  public S3CredentialsNotFoundException(String message) {  
  super(message);  
 }}
````
This class handle interaction with Amazon S3 storage.
````java
public class S3StorageHandler {  
  
  AmazonS3 s3Client;  
  
  public S3StorageHandler() {  
  this.s3Client = AmazonS3ClientBuilder.standard()  
 .withCredentials(S3CredentialsProviderFactory.createS3CredentialsProvider())  
 .withRegion("us-west-2")  
 .build();  
 }  
 
  /**  
 * Creates a new bucket with specified name. * * @param bucketName the name of the bucket to create  
 * @return the created Bucket object  
 * @throws AmazonS3Exception if an erros occurs while communicating with Amazon S3  
 * @throws IllegalBucketNameException if the provided bucket name already exists in the Amazon S3  
 */  
 public Bucket createBucket(String bucketName) throws AmazonS3Exception, IllegalBucketNameException {  
  if(!isValidBucketName(bucketName)){  
  return s3Client.createBucket(bucketName);  
  
 }  else{  
  throw new IllegalBucketNameException("Invalid bucket name: "+ bucketName);  
 }  
 }  
 
  /**  
 * Retrieves the object from the specified bucket with the given object key. * * @param bucketname the name of the bucket you want to storage  
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
 * Uploads a file to specified bucket with the given key name. * * @param bucketName the name of the bucket  
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
 * Checks if the specified bucket name already exists in the Amazon S3. * * @param bucketName the name of the bucket to check  
 * @return true if the bucket exists, false otherwise  
 */  
 private boolean isValidBucketName(String bucketName) {  
  return s3Client.doesBucketExistV2(bucketName);  
 }}
````
A class responsible for generating text files with specified content.
````java
public class TextFileGenerator {  
  
  public File generateFile(String text, String fileName){  
  File file = new File(fileName);  
  
  try{  
  FileWriter fl = new FileWriter(file);  
  fl.write(text);  
  fl.close();  
 } catch (IOException e) {  
  throw new RuntimeException("Error to save json in file: "+e.getMessage(), e);  
 }  return file;  
 }}
````
Implementation in the main class
````java
public class Main {

    public static void main(String[] args) {
        // Create an instance of FetcherAPI to fetch data from a remote API
        FetcherAPI fetcherAPI = new FetcherAPI();
        String response = null;

        try {
            // Send an HTTP GET request to fetch employee data
            response = fetcherAPI.sendHttpGetRequest("https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda");
        } catch (IOException e) {
            // Handle IOException by throwing a RuntimeException
            throw new RuntimeException("Error to call api: " + e.getMessage(), e);
        }

        // Use Gson to parse the JSON response into a list of Employee objects
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Employee>>(){}.getType();
        List<Employee> employees = gson.fromJson(response, listType);

        // Create a GenderCounter to count the genders of the employees
        GenderCounter gc = new GenderCounter();
        GenderCounterRecord genderCounterRecord = gc.countGenders(employees);

        // Use TextFileGenerator to create a JSON file with the gender count
        TextFileGenerator tfg = new TextFileGenerator();
        File jsonFile = tfg.generateFile(gson.toJson(genderCounterRecord), "count_employees_gender_record.json");

        // Use S3StorageHandler to upload the JSON file to an S3 bucket
        S3StorageHandler s3StorageHandler = new S3StorageHandler();
        s3StorageHandler.uploadFile("interview-digiage", "count_employees_gender_record", jsonFile);

        System.out.println("Item uploaded successfully");
    }
}
````

## JAVA TASK 5 - Solution

### Problem
- Create an implementation of a Rest API .
### API Overview: 
- An API application for managing medical appointment scheduling for patients.
### Endpoints: 

#### Register a New Doctor

<details>
 <summary><code>POST</code> <code><b>/doctor</b></code></summary>

##### JSON BODY


>| name           | type      | data type               | required  |
>|----------------|-----------|-------------------------|-----------|
>| id             | required  | integer                 | Not       |
>| name           | required  | string                  | Yes       |
>| email          | required  | string (Email format)                 | Yes       |
>| phone          | required  | string                  | Yes       |
>| medicDocument  | required  | string                  | Yes       |
>| specialty      | required  | string                  | Yes       |
>| address        | required  | object                  | Yes       |
>| address.street | required  | string                  | Yes       |
>| address.city   | required  | string                  | Yes       |
>| address.state  | required  | string                  | Yes       |
>| address.zipCode| required  | string                  | Yes       |


##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `201`         |`application/json`          | `{ "id": "integer", "name": "string", "email": "string", "phone": "string", "medicDocument": "string", "specialty": "string", "address": { "street": "string", "city": "string", "state": "string", "zipCode": "string" } }`                                |
> | `400`         | `application/json`                | `{"code":"400","message":"Validation Error"}`                          |


##### Example cURL

> ```javascript
>  curl -X POST -H "Content-Type: application/json" --data @post.json http://localhost:8080/doctor
> ```
</details>

#### Get all doctors from the system

<details>
 <summary><code>GET</code> <code><b>/doctor</b></code></summary>
 
 ##### JSON BODY
 > None
##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `200`         | `application/json`        | `{"content":[{"id":"integer","name":"string","email":"string","phone":"string","medicDocument":"string","specialty":"string","address.street":"string","address.city":"string","address.state":"string","address.zipCode":"string"}],"pageable":{"sort":{"sorted":false,"unsorted":true,"empty":true},"pageSize":20,"pageNumber":0,"offset":0,"unpaged":false,"paged":true},"totalPages":1,"totalElements":1,"last":true,"size":20,"number":0,"sort":{"sorted":false,"unsorted":true,"empty":true},"numberOfElements":1,"first":true,"empty":false}`                                                      |

##### Example cURL

> ```javascript
>  curl -X GET -H "Content-Type: application/json" http://localhost:8080/doctor
> ```
</details>

#### Update doctor data

<details>
 <summary><code>PATCH</code> <code><b>/doctor/{id}</b></code> <code>(update doctor data from id)</code></summary>
 
 ##### JSON BODY
>| name           | type      | data type               | required  |
>|----------------|-----------|-------------------------|-----------|
>| name            | required  | integer                 | Not       |
>| phone           | required  | string                  | Not       |
>| address        | required  | object                  | Not       |
>| address.street | required  | string                  | Not       |
>| address.city   | required  | string                  | Not       |
>| address.state  | required  | string                  | Not       |
>| address.zipCode| required  | string                  | Not       |
##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `201`         |`application/json`          | `{ "id": "integer", "name": "string", "email": "string", "phone": "string", "medicDocument": "string", "specialty": "string", "address": { "street": "string", "city": "string", "state": "string", "zipCode": "string" } }`                                |
> | `404`         | `application/json`                | `{"code":"404","message":"Entity Not Found"}`                          |                                        |

##### Example cURL

> ````javascript
>  curl -X PATCH -H "Content-Type: application/json" --data @patch.json http://localhost:8080/doctor/1
</details>

#### Delete doctor data

<details>
 <summary><code>DELETE</code> <code><b>/doctor/{id}</b></code> <code>(remove doctor from  id)</code></summary>
 
 ##### JSON BODY
 > None
##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `204`                                     |None					|None		
> | `404`         | `application/json`                | `{"code":"404","message":"Entity Not Found"}`                          |                                        |

##### Example cURL

> ````javascript
>  curl -X DELETE http://localhost:8080/doctor/1
</details>

#### Find doctor data by id

<details>
 <summary><code>GET</code> <code><b>/doctor/{id}</b></code> <code>(get doctor from  id)</code></summary>
 
 ##### JSON BODY
 > None
##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `204`                                     |``application/json``				|`{"id": "integer", "name": "string", "email": "string", "medicalDocument": "string", "phone": "string", "medicalSpecialty": "string", "address": {"street": "string", "city": "string", "state": "string", "zipCode": "string"}}`
> | `404`         | `application/json`                | `{"code":"404","message":"Entity Not Found"}`                          |                                        |

##### Example cURL

> ````javascript
>  curl -X GET -H "Content-Type: application/json" http://localhost:8080/doctor/1
</details>

#### Register a New Patient

<details>
 <summary><code>POST</code> <code><b>/patients</b></code></summary>

##### JSON BODY



| Field          | Required  | Data Type               | Required |
|----------------|-----------|-------------------------|-----------|
| name           | Yes       | String                  | Yes       |
| email          | Yes       | String (Email format)   | Yes       |
| phone          | Yes       | String                  | Yes       |
| document       | Yes       | String  | Yes       |
| address        | Yes       | Object                  | Yes       |
| address.street | Yes       | String                  | Yes       |
| address.city   | Yes       | String                  | Yes       |
| address.state  | Yes       | String                  | Yes       |
| address.zipCode| Yes       | String                  | Yes       |



##### Responses



> | HTTP Code      | Content-Type         | Response Body                                                                                                    |
> |----------------|----------------------|------------------------------------------------------------------------------------------------------------------|
> | `201`          | `application/json`   | `{ "id": "integer", "name": "string", "email": "string", "document": "string", "phone": "string", "address": { "street": "string", "city": "string", "state": "string", "zipCode": "string" } }` |
> | `400`          | `application/json`   | `{"code": "400", "message": "Validation Error"}`                                                                  |



##### Example cURL

> ```javascript
>  curl -X POST -H "Content-Type: application/json" --data @post.json http://localhost:8080/patients
</details>

#### Get all patients from the system

<details>
 <summary><code>GET</code> <code><b>/patients</b></code></summary>
 
 ##### JSON BODY
 > None
##### Responses

> | HTTP Code      | Content-Type         | Response Body                                                                                                                                                                                                                                                                                                    |
> |----------------|----------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
> | `200`          | `application/json`   | `{ "content": [ { "id": "integer", "name": "string", "email": "string", "phone": "string", "medicDocument": "string", "specialty": "string", "address.street": "string", "address.city": "string", "address.state": "string", "address.zipCode": "string" } ], "pageable": { "sort": { "sorted": false, "unsorted": true, "empty": true }, "pageSize": 20, "pageNumber": 0, "offset": 0, "unpaged": false, "paged": true }, "totalPages": 1, "totalElements": 1, "last": true, "size": 20, "number": 0, "sort": { "sorted": false, "unsorted": true, "empty": true }, "numberOfElements": 1, "first": true, "empty": false }` |
                                               

##### Example cURL

> ```javascript
>  curl -X GET -H "Content-Type: application/json" http://localhost:8080/patients
> ```
</details>

#### Update patient data

<details>
 <summary><code>PATCH</code> <code><b>/patients/{id}</b></code> <code>(update patient data from id)</code></summary>
 
 ##### JSON BODY
>| name           | type      | data type               | required  |
>|----------------|-----------|-------------------------|-----------|
>| name            | required  | integer                 | Not       |
>| phone           | required  | string                  | Not       |
>| address        | required  | object                  | Not       |
>| address.street | required  | string                  | Not       |
>| address.city   | required  | string                  | Not       |
>| address.state  | required  | string                  | Not       |
>| address.zipCode| required  | string                  | Not       |
##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `201`         |`application/json`          | {"name": "string", "phone": "string", "address": {"street": "string", "city": "string", "state": "string", "zipCode": "string"}
> | `404`         | `application/json`                | `{"code":"404","message":"Entity Not Found"}`                          |                                        |

##### Example cURL

> ````javascript
>  curl -X PATCH -H "Content-Type: application/json" --data @patch.json http://localhost:8080/patients/1
</details>

#### Delete patient data

<details>
 <summary><code>DELETE</code> <code><b>/patients/{id}</b></code> <code>(remove patient from id)</code></summary>
 
 ##### JSON BODY
 > None
##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `204`                                     |None					|None		
> | `404`         | `application/json`                | `{"code":"404","message":"Entity Not Found"}`                          |                                        |

##### Example cURL

> ````javascript
>  curl -X DELETE http://localhost:8080/patients/1
</details>

#### Find patient data by id

<details>
 <summary><code>GET</code> <code><b>/patients/{id}</b></code> <code>(get patient from  id)</code></summary>
 
 ##### JSON BODY
 > None
##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `204`                                     |`application/json`				|`{"id": "integer", "name": "string", "email": "string", "medicalDocument": "string", "phone": "string", "medicalSpecialty": "string", "address": {"street": "string", "city": "string", "state": "string", "zipCode": "string"}}`
> | `404`         | `application/json`                | `{"code":"404","message":"Entity Not Found"}`                          |                                        |

##### Example cURL

> ````javascript
>  curl -X GET -H "Content-Type: application/json" http://localhost:8080/patients/1
</details>

#### Schedule medical appointment

<details>
 <summary><code>POST</code> <code><b>/medical_appointment </b></code></summary>

##### JSON BODY




| Field            | Required  | Data Type               | Required  |
|------------------|-----------|-------------------------|-----------|
| idDoctor         | Yes       | Long                    | Yes       |
| idPatient        | Yes       | Long                    | Yes       |
| date             | Yes       | LocalDateTime           | Yes       |
| medicalSpecialty | Yes       | MedicalSpecialty        | Yes       |



##### Responses



> | HTTP Code      | Content-Type         | Response Body                                                                                                    |
> |----------------|----------------------|------------------------------------------------------------------------------------------------------------------|
> | `200`          | `application/json`   | `{"id": "integer", "idDoctor": "integer", "idPatient": "integer", "date": "string"}`
> | `400`          | `application/json`   | `{"code": "400", "message": "Validation Error"}`                                                                  |



##### Example cURL	

> ```javascript
>  curl -X POST -H "Content-Type: application/json" --data @post.json http://localhost:8080/medical_appointment
</details>

 #### Cancel medical appointment

<details>
 <summary><code>DELETE</code> <code><b>/medical_appointment/{id}</b></code> <code>(cancel medical appointment from id)</code></summary>
 
 ##### JSON BODY
 > None
##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `204`                                     |None					|None		
> | `404`         | `application/json`                | `{"code":"404","message":"Entity Not Found"}`                          |                                        |

##### Example cURL

> ````javascript
>  curl -X DELETE http://localhost:8080/medical_appointment/1
</details>
