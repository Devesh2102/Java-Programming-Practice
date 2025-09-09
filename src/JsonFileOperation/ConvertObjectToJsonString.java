package JsonFileOperation;

import com.fasterxml.jackson.databind.ObjectMapper;

class ConvertObjectToJsonString {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		Person person1 = new Person(1, "test1", 1234);

		try {
			String jsonString = mapper.writeValueAsString(person1);

			if (jsonString instanceof String) {
				System.out.println("Converted object to JSON string: " + jsonString);
			} else {
				System.out.println("Can not converted object as json String");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
