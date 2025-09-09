package JsonFileOperation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadingValueFromJsonFile {
	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("src/JsonFileOperation/jsonFile.json");

		try {
			// Read as tree first so that we can check is it array or a single value
			JsonNode rootNode = objectMapper.readTree(file);

			if (rootNode.isArray()) {
				// if JSON is an array
				List<Person> persons = objectMapper.readValue(file, new TypeReference<List<Person>>() {
				});

				for (Person person : persons) {
					System.out.println("ID is: " + person.getId());
					System.out.println("Name is: " + person.getName());
					System.out.println("Phone is: " + person.getPhone());
					System.out.println("--------------------");
				}

			} else if (rootNode.isObject()) {
				// JSON is a single object
				Person person = objectMapper.treeToValue(rootNode, Person.class);

				// Person person = objectMapper.readValue(file, Person.class);

				System.out.println("ID is: " + person.getId());
				System.out.println("Name is: " + person.getName());
				System.out.println("Phone is: " + person.getPhone());
			} else {
				System.out.println("Unexpected JSON format!");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
