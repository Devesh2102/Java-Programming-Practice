package JsonFileOperation;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

class WriteObjectToJson {
	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		Person person2 = new Person(2, "test2", 1234);
		Person person3 = new Person(3, "test3", 1234);
		Person person4 = new Person(4, "test4", 1234);
		Person person5 = new Person(5, "test5", 1234);

//		List<Person> persons = new ArrayList<>();
//		persons.add(person2);
//		persons.add(person3);
//		persons.add(person4);
//		persons.add(person5);

		List<Person> persons = Arrays.asList(person2, person3, person4, person5);

		try {
			// writing single object to JSON file
			objectMapper.writeValue(new File("src/JsonFileOperation/jsonFile.json"), person2);
			System.out.println("Single object is written into json file for 10 sec.");

			Thread.sleep(10000);

			// writing multiple object to JSON file
			objectMapper.writeValue(new File("src/JsonFileOperation/jsonFile.json"), persons);
			System.out.println("multiple objects (objects are in array) are written into json file");
			
			Thread.sleep(10000);

			//writing multiple objects to JSON file without erasing previous data
			FileWriter fileWriter = new FileWriter("src/JsonFileOperation/jsonFile.json", true);
			for (Person person : persons) {
				String jsonString = objectMapper.writeValueAsString(person);
				fileWriter.write(jsonString);	//can use write() or append()
				fileWriter.append(System.lineSeparator());
			}
			
			fileWriter.close();
			System.out.println("multiple objects are written into json file without erasing previous data and without single array.");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
