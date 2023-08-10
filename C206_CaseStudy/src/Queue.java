public class Queue {
	// Task 1
    private String queueId;
    private String stallName; // The name of the stall associated with the queue

 

// Constructor to create a new Queue object with the given ID and stall name
    public Queue(String queueId, String stallName) {
        this.queueId = queueId;
        this.stallName = stallName;
    }

 

    public String getQueueId() {
        return queueId;
    }

 

    public String getStallName() {
        return stallName;
    }
}