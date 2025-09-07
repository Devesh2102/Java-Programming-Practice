package JsonFileOperation;

import com.fasterxml.jackson.databind.ObjectMapper;

class Person {
	private int id;
	private String name;
	private long phone;

	public Person() {
		super();
	}

	public Person(int id, String name, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getPhone() {
		return phone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
}

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
