package JsonFileOperation;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class ReadFromJsonFile {
	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			JsonNode rootNode = objectMapper.readTree(new File("src/JsonFileOperation/jsonFile.json"));
			System.out.println("Whole Data inside json: " + rootNode);

			System.out.println("accessing each data:");

			// If array then iterate
			if (rootNode.isArray()) {
				for (JsonNode node : rootNode) {
					System.out.println("Id: " + node.get("id").asInt());
					System.out.println("Name: " + node.get("name").asText());
					System.out.println("Email: " + node.get("phone").asText());
				}
			} else {
				// Single object
				System.out.println("Id: " + rootNode.get("id").asInt());
				System.out.println("Name: " + rootNode.get("name").asText());
				System.out.println("Email: " + rootNode.get("phone").asText());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
