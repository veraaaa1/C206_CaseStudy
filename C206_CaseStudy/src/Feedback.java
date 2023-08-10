
public class Feedback {

	private String name;
	private int rating;
	private String comments;

	public Feedback(String name, int rating, String comments) {
		this.name = name;
		this.rating = rating;
		this.comments = comments;
	}

	public String getName() {
		return name;
	}

	public int getRating() {
		return rating;
	}

	public String getComments() {
		return comments;
	}

	public String toString() {
		return String.format("Name: %s%n" + "Rating: %d%n" + "Comments: %s", name, rating, comments);

	}

}

